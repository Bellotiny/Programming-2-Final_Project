/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project;

/**
 *
 * @author 2255525
 */
public interface MoneyMovement {
    public void deposit(Customer customer,double depositMoney);
    public void withdraw(Customer customer,double withdrawel) throws IllelegalAmountException;
}
