package com.ccp.service;

import com.ccp.model.CreditCardGenericResponse;
import com.ccp.model.CreditCardData;
import com.ccp.model.CreditCardListResponse;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */

public interface CreditCardProcessorService {

    public CreditCardGenericResponse addCard(CreditCardData creditCardData);

    public CreditCardListResponse getAllCards();

}
