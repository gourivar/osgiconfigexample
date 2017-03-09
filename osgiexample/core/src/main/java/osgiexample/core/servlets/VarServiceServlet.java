/*
@author Vardhan
Var servlet
This servlet is used to get the call service and get the config input from factory services.
 */
package osgiexample.core.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import osgiexample.core.services.VarService;

@SuppressWarnings("serial")
@SlingServlet(paths="/services/aemvardhan/callservice", methods="GET")
public class VarServiceServlet extends SlingAllMethodsServlet{

/** This Reference with target parameter will directly points to the service which has the service.label as MYSERVICE**/
	@Reference(target = "(service.label=MYSERVICE)")
    VarService varService;
	
	
/** doGet method to call the service and get the response back to the request **/
    @Override
    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) throws ServletException,
            IOException {
			response.getWriter().write(varService.getData());
    }

}