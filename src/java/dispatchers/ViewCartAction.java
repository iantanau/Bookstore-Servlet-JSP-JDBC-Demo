/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stude
 */

// Validate and redirect to "titles.jsp" or "cart.jsp" when clicking "View Cart" button
public class ViewCartAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return (request.getSession().getAttribute("cart") == null) ? "/jsp/titles.jsp" : "/jsp/cart.jsp";
    }
}
