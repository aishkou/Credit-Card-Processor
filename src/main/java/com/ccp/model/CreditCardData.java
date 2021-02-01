/**
 *
 */
package com.ccp.model;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */
public class CreditCardData {

    private String cardNumber;

    private String name;

    private String creditLimit;

    private String balance;

    public CreditCardData() {
        this.cardNumber = "";
        this.name = "";
        this.creditLimit = "";
        this.balance = "";
    }

    public CreditCardData(String cardNumber) {
        this.cardNumber = cardNumber;
        this.name = "";
        this.creditLimit = "";
        this.balance = "";
    }

    public CreditCardData(CreditCardTransactionRequestModel requestModel) {
        this.cardNumber = requestModel.getCardNumber();
        this.name = requestModel.getName();
        this.creditLimit = requestModel.getCreditLimit();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }



}
