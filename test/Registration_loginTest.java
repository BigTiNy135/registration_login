
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import registration_login.Registration_login;

/**
 *
 * @author tinyi
 */
public class Registration_loginTest {
    
    public Registration_loginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValidUsername method, of class Registration_login.
     */
    @Test
    public void testIsValidUsername() {
        System.out.println("isValidUsername");
        String username = "";
        boolean expResult = false;
        boolean result = Registration_login.isValidUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of isValidPassword method, of class Registration_login.
     */
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        String password = "Tinyiko#9";
        boolean expResult = false;
        boolean result = Registration_login.isValidPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of isValidSouthAfricanPhoneNumber method, of class Registration_login.
     */
    @Test
    public void testIsValidSouthAfricanPhoneNumber() {
        System.out.println("isValidSouthAfricanPhoneNumber");
        String phoneNumber = "";
        boolean expResult = false;
        boolean result = Registration_login.isValidSouthAfricanPhoneNumber(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDetails method, of class Registration_login.
     */
    @Test
    public void testIsValidDetails() {
        System.out.println("isValidDetails");
        String username = "";
        String password = "";
        String phoneNumber = "";
        boolean expResult = false;
        boolean result = Registration_login.isValidDetails(username, password, phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of main method, of class Registration_login.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Registration_login.main(args);
        // TODO review the generated test code and remove the default call to fail.
    
    }
    
}
