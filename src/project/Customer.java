/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author 2255525
 */
public class Customer{
    private String name;
    private String bNumber;
    private String pinCode;
    private Account account;

    public Customer(String name, String bNumber, String pinCode, Account account) {
        this.name = name;
        this.bNumber = bNumber;
        this.pinCode = pinCode;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbNumber() {
        return bNumber;
    }

    public void setbNumber(String bNumber) {
        this.bNumber = bNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", bNumber: " + bNumber + ", pinCode: " + pinCode + ", account: " + account;
    }
    
}
