package com.ccp.controller;

import com.ccp.constants.CreditCardDataConstants;
import com.ccp.model.CreditCardGenericResponse;
import com.ccp.model.CreditCardTransactionRequestModel;
import com.ccp.service.CreditCardProcessorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */

@RunWith(MockitoJUnitRunner.class)
public class CreditCardDataControllerTest {

    @Mock
    CreditCardProcessorService processorService;

    @InjectMocks
    CreditCardDataController creditCardDataController;

    @Test
    public void test_addCard() {
        CreditCardTransactionRequestModel CreditCardTransactionRequestModel = new CreditCardTransactionRequestModel();
        CreditCardTransactionRequestModel.setCardNumber("4111111111111121");
        CreditCardTransactionRequestModel.setName("Alex");

        CreditCardGenericResponse creditCardGenericResponse = creditCardDataController.addCard(CreditCardTransactionRequestModel);
        assertEquals(CreditCardDataConstants.CARD_NUMBER_ERROR, creditCardGenericResponse.getErrors().getMessage());
    }

    @Test
    public void test_add() {
        CreditCardTransactionRequestModel CreditCardTransactionRequestModel = new CreditCardTransactionRequestModel();
        CreditCardTransactionRequestModel.setCardNumber("4111111111111111");
        CreditCardTransactionRequestModel.setName("Alex");
        CreditCardGenericResponse creditCardGenericResponse = mock(CreditCardGenericResponse.class);
        when(processorService.addCard(Mockito.any())).thenReturn(creditCardGenericResponse);
        CreditCardGenericResponse response = creditCardDataController.addCard(CreditCardTransactionRequestModel);
        assertEquals(creditCardGenericResponse, response);

    }

   }
