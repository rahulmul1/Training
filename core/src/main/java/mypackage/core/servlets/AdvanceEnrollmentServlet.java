package mypackage.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletException;

import mypackage.core.ApplicationConstants;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.jackrabbit.api.security.user.Authorizable;
import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.security.user.UserProperties;
import com.adobe.granite.security.user.UserPropertiesManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AdvanceEnrollmentServlet.
 */
@SlingServlet(paths = "/bin/dev/advanceenrollment", extensions = "json", methods = { "GET" })
public class AdvanceEnrollmentServlet extends SlingSafeMethodsServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5243834709213719550L;
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdvanceEnrollmentServlet.class);
	
	/** The sling repository. */
	@Reference
	private SlingRepository slingRepository;

	/** The session. */
	Session session;
	
	/** The resource resolver. */
	ResourceResolver resourceResolver;
	
	/** The user manager. */
	UserManager userManager;
	
	/** The upm. */
	UserPropertiesManager upm;

	/* (non-Javadoc)
	 * @see org.apache.sling.api.servlets.SlingSafeMethodsServlet#doGet(org.apache.sling.api.SlingHttpServletRequest, org.apache.sling.api.SlingHttpServletResponse)
	 */
	@Override
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {

		try {
			resourceResolver = request.getResourceResolver();

			session = resourceResolver.adaptTo(Session.class);
			userManager = resourceResolver.adaptTo(UserManager.class);
			upm = resourceResolver.adaptTo(UserPropertiesManager.class);

			Authorizable auth = userManager
					.getAuthorizable(session.getUserID());

			UserProperties userProperties = upm.getUserProperties(auth,
					"profile");

			JSONObject jsonObj = new JSONObject();

			for (String propertyName : userProperties.getPropertyNames()) {

				jsonObj.put(propertyName,
						userProperties.getProperty(propertyName));
			}
			
			generateJSON(response, jsonObj.toString());

		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			LOGGER.error("RepositoryException: " + e, e);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (session != null && session.isLive()) {
				session.logout();
			}
		}

	}

	/**
	 * Generate json.
	 *
	 * @param response the response
	 * @param jsonString the json string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected final void generateJSON(final SlingHttpServletResponse response,
			final String jsonString) throws IOException {
		response.setCharacterEncoding(ApplicationConstants.UTF8.getValue());
		response.setContentType(ApplicationConstants.APPLICATION_JSON
				.getValue());
		final PrintWriter printWriter = response.getWriter();
		printWriter.write(jsonString);
	}

}
