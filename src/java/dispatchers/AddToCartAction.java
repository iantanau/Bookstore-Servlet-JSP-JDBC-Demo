/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import model.CartItem;

/**
 *
 * @author stude
 */
// Add book to cart and store in session
public class AddToCartAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // Retrieve the cart from the session
        HttpSession session = request.getSession();
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        String[] selectedBooks = request.getParameterValues("add");
        
        // Check if selectedBooks is null or empty
        if (selectedBooks == null || selectedBooks.length == 0) {
            return "/jsp/titles.jsp";
        }
        
        // If the cart is null, create a new cart and add selected books
        if (cart == null) {
            cart = new HashMap();
            session.setAttribute("cart", cart);
        }
        
        // Wpdate the quantities of selected books
        for (String isbn : selectedBooks) {
            int quantity = Integer.parseInt(request.getParameter(isbn));
            if (cart.containsKey(isbn)) {
                cart.get(isbn).setQuantity(quantity);
            } else {
                Book book = getBookFromList(isbn, session);
                CartItem item = new CartItem(book);
                item.setQuantity(quantity);
                cart.put(isbn, item);
            }
        }
        return "/jsp/titles.jsp";
    }

    // Retrive all books from session
    private Book getBookFromList(String isbn, HttpSession session) {
        List<Book> list = (List<Book>) session.getAttribute("books");
        if (list != null) {
            for (Book book : list) {
                if (isbn.equals(book.getIsbn())) {
                    return book;
                }
            }
        }
        return null;
    }

}
