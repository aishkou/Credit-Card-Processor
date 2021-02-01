/**
 *
 */
package com.ccp.model;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */
public class CreditCardTransactionRequestModel {

    private String cardNumber;

    private String name;

    private String creditLimit;

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

}
