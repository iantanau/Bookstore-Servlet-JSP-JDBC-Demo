package utility;

import java.util.*;
import java.sql.*;
import model.Tbooks;
import javax.persistence.*;

/**
 * The {@code AdmitBookStoreDAO} class provides data access methods for retrieving book information from a database.
 */
public class AdmitBookStoreDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Constructs a new {@code AdmitBookStoreDAO} and establishes a connection to the database.
     */
    public AdmitBookStoreDAO() {
        emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();
    }

    /**
     * Retrieves all books from the database.
     *
     * @return a list of all books in the database
     * @throws SQLException if a database access error occurs
     */
    public List<Tbooks> getAllBooks() throws SQLException {
        
        return em.createNamedQuery("Tbooks.findAll", Tbooks.class)
                 .getResultList();
    }
}