package mypackage.core.listeners;

import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * The Class TitlePropertyListner.
 *
 * @author rahaggar
 * 
 * JCR observation
 * Adds listner which listens to any property change below the  
 * path /content/mytrainingprojecct. If the property changed is jcr:title 
 * it appends a "!" after the property value.
 */
@Component
public class TitlePropertyListner implements EventListener {

	/** The sling repository. */
	@Reference
	SlingRepository slingRepository;

	/** The observation manager. */
	ObservationManager observationManager = null;
	
	/** The admin session. */
	Session adminSession = null;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TitlePropertyListner.class);

	/**
	 * Activate.
	 *
	 * @param context the context
	 * @throws Exception the exception
	 */
	@SuppressWarnings("deprecation")
	protected void activate(ComponentContext context) throws Exception {
		adminSession = slingRepository.loginAdministrative(slingRepository
				.getDefaultWorkspace());

		observationManager = adminSession.getWorkspace()
				.getObservationManager();

		observationManager.addEventListener(this, Event.PROPERTY_ADDED
				| Event.PROPERTY_CHANGED, "/content/mytrainingprojecct", true,
				null, null, true);
		LOGGER.info("********added JCR event listener");
	}

	/* (non-Javadoc)
	 * @see javax.jcr.observation.EventListener#onEvent(javax.jcr.observation.EventIterator)
	 */
	@Override
	public void onEvent(EventIterator it) {
		while (it.hasNext()) {
			Event event = (Event) it.next();
			try {
				Property property = adminSession.getProperty(event.getPath());
				LOGGER.info("Following property added/changed------ " + event.getPath());
				
				String propertyName = property.getName();
				if (propertyName.equalsIgnoreCase("jcr:title")) {
					String propertyValue = property.getString();
					propertyValue += "!";
					property.setValue(propertyValue);
					adminSession.save();
				}

			} catch (ValueFormatException e) {
				LOGGER.error("********error adding !", e);
			} catch (PathNotFoundException e) {
				LOGGER.error("********error adding !", e);
			} catch (RepositoryException e) {
				LOGGER.error("********error adding !", e);
			}

		}

	}

	/**
	 * Deactivate.
	 *
	 * @param componentContext the component context
	 */
	protected void deactivate(ComponentContext componentContext) {
		try {
			if (observationManager != null) {
				observationManager.removeEventListener(this);
				LOGGER.info("********removed JCR event listener");
			}
		} catch (RepositoryException re) {
			LOGGER.error("********error removing the JCR event listener", re);
		} finally {
			if (adminSession != null) {
				adminSession.logout();
				adminSession = null;
			}
		}
	}

}
