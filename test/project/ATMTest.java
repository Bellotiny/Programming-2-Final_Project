/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author musit
 */
public class ATMTest extends TestCase{
    
    public ATMTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of deposit method, of class ATM.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        Chequing account1 = new Chequing(0);
        Customer client1 = new Customer("Sen", "123", "123", account1);
        ArrayList<Customer> customers = new ArrayList();
        customers.add(client1);
        String bankNumber = "123";
        String pin = "123";
        double depositMoney = 10.0;
        ATM instance = new ATM(customers);
        instance.deposit(bankNumber, pin, depositMoney);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
