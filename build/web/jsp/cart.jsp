<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Online Bookshop</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <%@ page import="model.*" %>
        <%@ page import="java.util.*" %>
        <%@ page import="java.text.*" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <h1>The following items are in your shopping cart</h1>

    <c:choose>
        <c:when test="${not empty sessionScope.cart}">
            <form name="form1" method="post" action="./books">
                <input type="hidden" name="action" value="update_cart">
                <c:set var="totalCostOfOrder" value="0" />

                <table>
                    <thead>
                        <tr>
                            <th>ISBN</th>
                            <th>Title</th>
                            <th>Price/unit</th>
                            <th>Quantity</th>
                            <th>Subtotal</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.cart}" var="entry">
                        <c:set var="item" value="${entry.value}" />
                        <c:set var="book" value="${item.book}" />
                        <c:set var="totalCostOfOrder" value="${totalCostOfOrder + item.orderCost}" />
                        <tr>
                            <td>${book.isbn}</td>
                            <td>${book.title}</td>
                            <td>${book.dollarPrice}</td>
                            <td>
                                <input type="text" name="${book.isbn}" size="2" 
                                       value="${item.quantity}" maxlength="4">
                            </td>
                            <td>${item.dollarOrderCost}</td>
                            <td>
                                <div align="center">
                                    <input type="checkbox" name="remove" value="${book.isbn}">
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4">
                            <input type="submit" name="Submit" value="Update Cart">
                        </td>
                        <td colspan="2">
                            <div align="right">
                                <b>ORDER TOTAL $
                                    <fmt:formatNumber value="${totalCostOfOrder}" pattern="0.00"/>
                                </b>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </c:when>
        <c:otherwise>
            <p>Your cart is empty.</p>
        </c:otherwise>
    </c:choose>

    <div class="link-container">
        <p><a href="./books?action=continue">Continue Shopping</a></p>
        <p><a href="./books?action=checkout">Check Out</a></p>
    </div>
</body>
</html>