package mypackage.core.schedulers;

import java.util.Dictionary;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, metatype = true, label = "Cleanup Service")
@Service(value = Runnable.class)
@Properties({
@Property(name = "scheduler.expression", value = "0 15 20 * * ?"),
@Property(name = "scheduler.concurrent", label = "Concurrent Execution",
description = "Always leave this value to false. "
		+ "Two synchronization jobs must never run at the same time. ", boolValue = false,
		propertyPrivate = true)
})// Every day 8.15pm
public class CleanupServiceImpl implements Runnable {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CleanupServiceImpl.class);
	@Reference
	private SlingRepository repository;
	
	@Property(label = "Path", description = "Delete this path", value = "/tmp/mypath")
	public static final String CLEANUP_PATH = "cleanupPath";
	
	private String cleanupPath;

	protected void activate(ComponentContext componentContext) {
		configure(componentContext.getProperties());
	}

	protected void configure(Dictionary<?, ?> properties) {
		this.cleanupPath = (String.valueOf(properties.get(CLEANUP_PATH)) != null) ? String
				.valueOf(properties.get(CLEANUP_PATH)) : null;
		LOGGER.info("configure: cleanupPath='{}''", this.cleanupPath);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		LOGGER.info("running now-Cleanup path: " + this.cleanupPath);
		Session session = null;
		try {

			session = repository.loginAdministrative(null);
			//check for this - not working
			/*session = repository.loginService(null,
					repository.getDefaultWorkspace());*/
			// session = repository.login(new
			// SimpleCredentials("admin","admin".toCharArray()));

			LOGGER.info("Logged in with " + session.getUserID()
					+ " & Is session Live: " + session.isLive());

			if (session.itemExists(cleanupPath) == true) {
				session.removeItem(cleanupPath);
				LOGGER.info("node deleted");
				session.save();
			}
		} catch (RepositoryException e) {
			LOGGER.error("exception during cleanup", e);
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}
}