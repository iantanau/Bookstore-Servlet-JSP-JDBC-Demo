package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.*;
import java.util.*;
import java.text.*;

public final class titles_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Online Bookshop</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        <h1>Items in your Shopping Cart</h1>\r\n");
      out.write("        <table>\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>Item</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                ");

                    Map items = (Map) session.getAttribute("cart");
                    if (items != null) {
                        Set entries = items.entrySet();
                        Iterator iter = entries.iterator();
                        double totalCostOfOrder = 0.00;
                        Book book = null;
                        CartItem item = null;

                        while (iter.hasNext()) {
                            Map.Entry entry = (Map.Entry) iter.next();
                            item = (CartItem) entry.getValue();
                            double cost = item.getOrderCost();
                            totalCostOfOrder += cost;
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print( item);
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                    } // end while
                    DecimalFormat dollars = new DecimalFormat("0.00");
                    String totalOrderInDollars = (dollars.format(totalCostOfOrder));

                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Order Total: $");
      out.print( totalOrderInDollars);
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                } else {
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>No Items in Cart</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                    } // end else
                
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <h2>Welcome to the Online Book Store</h2>\r\n");
      out.write("        <form name=\"form1\" method=\"post\" action=\"./books\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"add_to_cart\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>ISBN</th>\r\n");
      out.write("                        <th>Title</th>\r\n");
      out.write("                        <th>Author</th>\r\n");
      out.write("                        <th>Price</th>\r\n");
      out.write("                        <th>Quantity</th>\r\n");
      out.write("                        <th>Add</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    ");

                        List books = (List) session.getAttribute("books");
                        Iterator iter = books.iterator();
                        while (iter.hasNext()) {
                            Book book = (Book) iter.next();
                            String isbn = book.getIsbn();
                            String title = book.getTitle();
                            String author = book.getAuthor();
                            String price = book.getDollarPrice();
                    
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>");
      out.print( isbn);
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( title);
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( author);
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( price);
      out.write("</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <select name=\"");
      out.print( isbn);
      out.write("\" size=\"1\">\r\n");
      out.write("                                <option value=\"1\">1</option>\r\n");
      out.write("                                <option value=\"2\">2</option>\r\n");
      out.write("                                <option value=\"3\">3</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div align=\"center\">\r\n");
      out.write("                                <input type=\"checkbox\" name=\"add\" value=\"");
      out.print( isbn);
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
 } // end while 
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"6\">\r\n");
      out.write("                            <input type=\"submit\" name=\"Details\" value=\"Add to Cart\">\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("        <div class=\"link-container\">\r\n");
      out.write("            <p><a href=\"./books?action=view_cart\">View Shopping Cart</a></p>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
