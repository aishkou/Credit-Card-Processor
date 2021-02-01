/**
 *
 */
package com.ccp.model;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */
public class CreditCardGenericResponse {

    private String cardNumber;

    private String creditLimit;

    private String name;

    private String balance;

    private CreditCardError errors;

    public CreditCardError getErrors() {
        return errors;
    }

    public void setErrors(CreditCardError errors) {
        this.errors = errors;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
