# Simple Java EE Bookstore Application

A lightweight e-commerce web application built using **Java EE (Jakarta EE)** technologies. This project demonstrates the implementation of the **MVC (Model-View-Controller)** architecture using Servlets, JSPs, and JDBC.

## 🚀 Features
*   **Book Catalog**: Dynamically retrieves book data (ISBN, Title, Author, Price) from an Apache Derby database.
*   **Shopping Cart**: 
    *   Add books to the cart with specified quantities.
    *   Update quantities or remove items within the cart.
    *   Persistent cart storage using `HttpSession`.
*   **Front Controller Pattern**: All requests are routed through a single `FrontController` servlet for centralized logic handling.
*   **Database Integration**: Uses JDBC with the DAO (Data Access Object) pattern for clean separation of concerns.

## 🛠️ Tech Stack
*   **IDE**: NetBeans 8.0.2
*   **Backend**: Java (Java EE 7, Servlet 3.1)
*   **Frontend**: JSP, HTML/CSS
*   **Database**: Apache Derby (Java DB)
*   **Server**: GlassFish Server 4.1
*   **Architecture**: MVC Pattern

## 📂 Project Structure
```text
├── src/
│   ├── java/
│       ├── controller/      # FrontController.java (Request handling)
│       ├── model/           # Book.java, CartItem.java (Data objects)
│       ├── utility/         # AdmitBookStoreDAO.java (Database logic)
├── web/
│   ├── jsp/             # titles.jsp, cart.jsp, checkout.jsp, error.jsp
│   ├── css/             # Cascading Style Sheets for .jsp pages
│   ├── images/          # images for .jsp pages
│   └── WEB-INF/         # Configuration files
├── sql/
│   ├── TBOOKS.grab   # Table initialization script
│   └── Books.sql     # Sample data insert script
└── README.md
```

## ⚙️ Setup & Installation

### 1. Database Configuration
Since the database files are not included in the repository, you must create the table manually:
1.  Start your **Apache Derby** network server.
2.  Create BooksotreDB_Pool in JDBC Connection Pools and BookstoreDB in JDBC Resources under Glassfish Server
3.  Connect to `jdbc:derby://localhost:1527/BookstoreDB`
4.  Create table and insert sample data from sql folder

### 2. IDE Setup
1.  Clone the repository:
    ```bash
    git clone https://github.com/iantanau/Bookstore-Servlet-JSP-JDBC-Demo.git
    ```
2.  Open the project in **NetBeans 8.0.2**.
4.  Configure your **GlassFish** within the IDE.

### 3. Running the App
1.  Clean and Build the project.
2.  Deploy the project to the server.
3.  Access the application by running "FrontController.java"

## Screenshot
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/108f08ec-8056-4a55-bf61-45eafef81255" />

## 📝 License
This project is for educational purposes as part of a Java EE course assignment.
