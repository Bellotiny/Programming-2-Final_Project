/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2255525
 */
public class ATM implements MoneyMovement {

    private double newBalance;
    private ArrayList<Customer> customers;
    Security s = new Security();

    public ATM(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void deposit(String bankNumber, String pin, double depositMoney) {
        newBalance = customers.get(s.verificationOfCustomer(bankNumber)).getAccount().getCurrentBalance();
        newBalance += depositMoney;
        customers.get(s.verificationOfCustomer(bankNumber)).getAccount().setCurrentBalance(newBalance);
    }

    public void withdraw(String bankNumber, String pin, double withdrawel) {
        newBalance = customers.get(s.verificationOfCustomer(bankNumber)).getAccount().getCurrentBalance();
        if(withdrawel > customers.get(s.verificationOfCustomer(bankNumber)).getAccount().getCurrentBalance()) {
            throw new ArithmeticException("Insuffecient Funds!!");
        }
        else{
        newBalance -= withdrawel;
        customers.get(s.verificationOfCustomer(bankNumber)).getAccount().setCurrentBalance(newBalance);
        }
        
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public void setCutomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    class Security {

        public int verificationOfCustomer(String bankNumber) {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getbNumber().equals(bankNumber)) {
                    return i;
                }
            }
            return -1;
        }

        public boolean validation(String bankNumber, String pinNum) {
            int index = verificationOfCustomer(bankNumber);

            if (pinNum.equals(customers.get(index).getPinCode())) {
                return true;
            }
            return false;
        }
    }

    
    @Override
    public String toString() {
        return "NewBalance: " + newBalance;
    }

}
