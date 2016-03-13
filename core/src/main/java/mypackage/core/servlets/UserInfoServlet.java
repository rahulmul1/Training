/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  org.apache.sling.api.SlingHttpServletRequest
 *  org.apache.sling.api.SlingHttpServletResponse
 *  org.apache.sling.api.resource.Resource
 *  org.apache.sling.api.resource.ResourceResolver
 *  org.apache.sling.api.resource.ResourceResolverFactory
 *  org.apache.sling.api.resource.ValueMap
 *  org.apache.sling.api.servlets.SlingAllMethodsServlet
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package mypackage.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import mypackage.core.models.UserInfo;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// TODO: Auto-generated Javadoc

/**
 * The Class UserInfoServlet.
 */
@SlingServlet(paths="/bin/slingmodel", methods="GET")
public class UserInfoServlet extends SlingAllMethodsServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1;
	
	/** The logger. */
	Logger logger;
	
	/** The resource resolver factory. */
	@Reference
	ResourceResolverFactory resourceResolverFactory;
	
	/** The resource resolver. */
	ResourceResolver resourceResolver;

	/**
	 * Instantiates a new user info servlet.
	 */
	public UserInfoServlet() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}

	/* (non-Javadoc)
	 * @see org.apache.sling.api.servlets.SlingSafeMethodsServlet#doGet(org.apache.sling.api.SlingHttpServletRequest, org.apache.sling.api.SlingHttpServletResponse)
	 */
	public void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		this.logger.info("inside sling model test servlet");
		response.setContentType("text/html");
		try {
			this.resourceResolver = this.resourceResolverFactory
					.getAdministrativeResourceResolver(null);
			Resource resource = this.resourceResolver
					.getResource("/content/testsling/slingmodel");
			ValueMap valueMap = (ValueMap) resource
					.adaptTo((Class) ValueMap.class);
			response.getWriter().write(
					"Output from ValueMap is First Name: "
							+ valueMap.get((Object) "firstName").toString()
							+ " Last Name: "
							+ valueMap.get((Object) "lastName").toString()
							+ " Technology: "
							+ valueMap.get((Object) "technology").toString()
							+ "");
			this.logger.info("About to use USERINFO");
			UserInfo userInfo = (UserInfo) resource
					.adaptTo((Class) UserInfo.class);
			response.getWriter().write(
					"Output from Sling Model is First Name: "
							+ userInfo.getFirstName() + " Last Name: "
							+ userInfo.getLastName() + " Technology: "
							+ userInfo.getTechnology());
		} catch (Exception e) {
			this.logger.error("THE AEM ERROR IS " + e.getMessage());
		} finally {
			if (this.resourceResolver.isLive()) {
				this.resourceResolver.close();
			}
		}
	}

	/**
	 * Bind resource resolver factory.
	 *
	 * @param resourceResolverFactory the resource resolver factory
	 */
	protected void bindResourceResolverFactory(
			ResourceResolverFactory resourceResolverFactory) {
		this.resourceResolverFactory = resourceResolverFactory;
	}

	/**
	 * Unbind resource resolver factory.
	 *
	 * @param resourceResolverFactory the resource resolver factory
	 */
	protected void unbindResourceResolverFactory(
			ResourceResolverFactory resourceResolverFactory) {
		if (this.resourceResolverFactory == resourceResolverFactory) {
			this.resourceResolverFactory = null;
		}
	}
}
