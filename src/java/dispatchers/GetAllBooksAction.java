/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import utility.AdmitBookStoreDAO;

/**
 *
 * @author stude
 */

// Get all books from database through DAO and store in session
public class GetAllBooksAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdmitBookStoreDAO dao = new AdmitBookStoreDAO();
        try {
            List<Book> books = dao.getAllBooks();
            request.getSession().setAttribute("books", books);
            return "/jsp/titles.jsp";
        } catch (Exception ex) {
            request.setAttribute("result", ex.getMessage());
            return "/jsp/error.jsp";
        }
    }
}
