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

    /* Description of deposit/withdrawal:
       newBalance is given the customer's balance
       then the an amount is added or subtracted from it
       The customer's balance is then set to the amount found in newBalance*/
    
    public void deposit(Customer customer, double depositMoney) {
        newBalance = customer.getAccount().getCurrentBalance();
        newBalance += depositMoney;
        customer.getAccount().setCurrentBalance(newBalance);
    }

    public void withdraw(Customer customer, double withdrawel) throws IllelegalAmountException{
        newBalance = customer.getAccount().getCurrentBalance();
        
        //A condidtion was added in case the customer tried withdrawing
        // more than they had in their account
        
        if(withdrawel > customer.getAccount().getCurrentBalance()) {
            throw new IllelegalAmountException("Insuffecient Funds!!!!");
        }
        else{
        newBalance -= withdrawel;
        customer.getAccount().setCurrentBalance(newBalance);
        }
        
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public void setCutomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    // Nested class for verifying bank numbers and pins
    
    class Security {
        // Verifies which index of customers contain the client
        // that the bank number refers to
        public int verificationOfCustomer(String bankNumber) throws IllegalValidation{
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getbNumber().equals(bankNumber)) {
                    return i;
                }else if(i == customers.size()-1){
                    throw new IllegalValidation("This bank number can't be found!");
                }
            }
            return -1;
        }
        // Verifies pin after getting the index from verificationOfCustomer()
        public boolean validation(String bankNumber, String pinNum) throws IllegalValidation{
            int index = verificationOfCustomer(bankNumber);

            if (pinNum.equals(customers.get(index).getPinCode())) {
                return true;
            }
            return false;
        }
    }

    
    @Override
    public String toString() {
        return "New Balance: " + newBalance;
    }

}
