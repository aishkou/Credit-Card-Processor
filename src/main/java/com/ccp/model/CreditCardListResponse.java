/**
 *
 */
package com.ccp.model;

import java.util.List;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */

public class CreditCardListResponse {

    private List<CreditCardData> creditCards;

    private CreditCardError errors;

    public CreditCardError getErrors() {
        return errors;
    }

    public void setErrors(CreditCardError errors) {
        this.errors = errors;
    }

    public List<CreditCardData> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCardData> creditCards) {
        this.creditCards = creditCards;
    }

}
