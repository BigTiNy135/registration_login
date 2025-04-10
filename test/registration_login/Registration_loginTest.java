/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package registration_login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
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
     * Test of ValidUsername method, of class Registration_login.
     */
    @Test
    public void testValidUsername() {
        System.out.println("ValidUsername");
        String username = "";
        boolean expResult = false;
        boolean result = Registration_login.ValidUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidPassword method, of class Registration_login.
     */
    @Test
    public void testValidPassword() {
        System.out.println("ValidPassword");
        String password = "";
        boolean expResult = false;
        boolean result = Registration_login.ValidPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidSouthAfricanPhoneNumber method, of class Registration_login.
     */
    @Test
    public void testValidSouthAfricanPhoneNumber() {
        System.out.println("ValidSouthAfricanPhoneNumber");
        String phoneNumber = "";
        boolean expResult = false;
        boolean result = Registration_login.ValidSouthAfricanPhoneNumber(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
    }
    
}
