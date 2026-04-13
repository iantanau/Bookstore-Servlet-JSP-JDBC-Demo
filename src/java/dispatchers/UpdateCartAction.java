/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartItem;

/**
 *
 * @author stude
 */

// Handle update cart activity when remove from cart page
public class UpdateCartAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");

        if (cart == null) {
            return "/jsp/titles.jsp";
        }

        String[] booksToRemove = request.getParameterValues("remove");
        if (booksToRemove != null) {
            for (String isbn : booksToRemove) {
                cart.remove(isbn);
            }
        }

        for (Map.Entry<String, CartItem> entry : cart.entrySet()) {
            String isbn = entry.getKey();
            int quantity = Integer.parseInt(request.getParameter(isbn));
            entry.getValue().updateQuantity(quantity);
        }

        return "/jsp/cart.jsp";
    }

}
