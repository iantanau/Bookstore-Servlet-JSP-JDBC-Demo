package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import dispatchers.*;

/**
 * FrontController class to handle HTTP requests and responses.
 */
public class FrontController extends HttpServlet {

    private final HashMap actions = new HashMap();

    /**
     * Initialize global variables.
     *
     * @param config ServletConfig object
     * @throws ServletException if an error occurs during initialization
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        // Additional initialization code can be added here
//        actions.put("add_to_cart", new AddToCartAction());
//        actions.put("update_cart", new UpdateCartAction());
//        actions.put("view_cart", new ViewCartAction());
//        actions.put("Checkout", new CheckoutAction());
//        actions.put("Continue", new ContinueAction());
        // Default action(null) will be dealt separately
        
        // Get all initial variables from web.xml
        Enumeration<String> parameterNames = config.getInitParameterNames();
        
         while (parameterNames.hasMoreElements()) {
            String actionName = parameterNames.nextElement();
            String actionClassName = config.getInitParameter(actionName);
            
            try {
                // Use reflection to dynamically load actionClass
                Class<?> actionClass = Class.forName(actionClassName);
                
                // Create an instance for the actionClass
                IAction actionInstance = (IAction) actionClass.getDeclaredConstructor().newInstance();
                
                // Store in actions Map
                actions.put(actionName, actionInstance);
                System.out.println("Loaded Action: " + actionName + " -> " + actionClassName);
                
            } catch (Exception e) {
                System.err.println("Failed to load action: " + actionName);
                e.printStackTrace();
            }
         }
    }

    /**
     * Process the HTTP GET request.
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("doGet()");
        // Forward GET requests to doPost method
        doPost(request, response);
    }

    /**
     * Process the HTTP POST request.
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Get the requested action from the request parameters
        String requestedAction = request.getParameter("action");
        IAction action = (IAction) actions.get(requestedAction);
        String nextPage = "";

        // If no action is specified, fetch all books and display them
        if (action == null) {
            action = new GetAllBooksAction();
        }
        try {
            nextPage = action.execute(request, response);
        } catch (Exception e) {
            request.setAttribute("result", e.getMessage());
            nextPage = "/jsp/error.jsp";
        }
        dispatch(request, response, nextPage);
    }

/**
 * Forward the request to the specified page.
 *
 * @param request HttpServletRequest object
 * @param response HttpServletResponse object
 * @param page Page to forward to
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    /**
     * Get Servlet information.
     *
     * @return Servlet information
     */
    public String getServletInfo() {
        return "controller.FrontController Information";
    }
}
