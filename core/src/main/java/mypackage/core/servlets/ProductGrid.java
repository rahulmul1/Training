package mypackage.core.servlets;

import java.io.IOException;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.jcr.api.SlingRepository;

import com.day.cq.commons.TidyJSONWriter;

@SlingServlet(paths = "/bin/dev/queryProducts", extensions = "json", methods = { "POST" })
public class ProductGrid extends SlingAllMethodsServlet {

	private static final long serialVersionUID = -7777595061911952675L;

	@Reference
	private SlingRepository repo;

	private static final String DEFAULT_PATH = "etc/commerce/products/geometrixx-outdoors/eq/eqsm";

	@Override
	protected void doPost(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws IOException {

		Session serviceSession = null;

		final TidyJSONWriter jw = new TidyJSONWriter(response.getWriter()); // create
																			// object
		response.setContentType("application/json"); // set content type
		response.setCharacterEncoding("utf-8"); // set encoding
		jw.setTidy("true".equals(request.getParameter("tidy")));

		try {
			serviceSession = repo
					.loginService(null, repo.getDefaultWorkspace());

			Node rootNode = serviceSession.getRootNode();
			Node tempNode = rootNode.getNode(DEFAULT_PATH);
			NodeIterator iterator = tempNode.getNodes();

			jw.object();
			jw.key("page").value(1);
			jw.key("total").value(iterator.getSize());
			jw.key("rows").array();

			while (iterator.hasNext()) {
				Node childNode = iterator.nextNode();
				PropertyIterator pIterator = childNode
						.getProperties("jcr:title | jcr:description | price");
				jw.object();
				jw.key("cell").array();
				while (pIterator.hasNext()) {
					Property prop = pIterator.nextProperty();
					if (!prop.getDefinition().isMultiple()) {

						jw.value(prop.getString());

					}
				}
				jw.endArray();
				jw.endObject();
			}

			// The endArray method must be called to mark the array's end.
			jw.endArray();

			jw.endObject();

		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
		}
	}
}
