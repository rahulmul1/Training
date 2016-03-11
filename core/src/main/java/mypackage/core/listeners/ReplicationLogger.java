package mypackage.core.listeners;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.replication.ReplicationAction;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Service
@Component(immediate = true)
@Property(name = "event.topics", value = ReplicationAction.EVENT_TOPIC)
public class ReplicationLogger implements EventHandler, JobConsumer {

	@Reference
	private ResourceResolverFactory resolverFactory;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReplicationLogger.class);
	
	ResourceResolver administrativeResourceResolver = null;
	
	@Override
	public JobConsumer.JobResult process(Job event) {
		LOGGER.info("********processing job");
		
		return JobConsumer.JobResult.OK;
	}

	@Override
	public void handleEvent(Event event) {
		String[] propertyNames = event.getPropertyNames();

		for (String propertyName : propertyNames) {
			LOGGER.info(propertyName+"="+event.getProperty(propertyName));
		}
		

		ReplicationAction replicationAction = ReplicationAction
				.fromEvent(event);
		try {
			administrativeResourceResolver = resolverFactory
					.getAdministrativeResourceResolver(null);

			LOGGER.info("Rep path - " + replicationAction.getPath()
					+ " , Rep type" + replicationAction.getType()+" , " +replicationAction.getType().getName());
			
			PageManager pm = administrativeResourceResolver.adaptTo(PageManager.class); 
			Page page = pm.getContainingPage(replicationAction.getPath());
			
			if(page!=null){
				LOGGER.info("title of page" + page.getTitle());
			}
			
			
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			LOGGER.error("ExceLoginExceptionption: " + e, e);
		}finally {

			if (administrativeResourceResolver != null && administrativeResourceResolver.isLive()) {
				administrativeResourceResolver.close();
			}
		}

	}

}
