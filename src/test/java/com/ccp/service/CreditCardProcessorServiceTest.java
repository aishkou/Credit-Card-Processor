package com.ccp.service;

import com.ccp.constants.CreditCardDataConstants;
import com.ccp.model.CreditCardGenericResponse;
import com.ccp.repository.CreditCardProcessorDAO;
import com.ccp.model.CreditCardData;
import com.ccp.model.CreditCardListResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DuplicateKeyException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */


@RunWith(MockitoJUnitRunner.class)
public class CreditCardProcessorServiceTest {

    @Mock
    private CreditCardProcessorDAO creditCardProcessorDAO;

    @InjectMocks
    private CreditCardProcessorServiceImpl ccProcessServiceImpl;

    @Test
    public void test_addCard() {
        CreditCardData creditCardData = mock(CreditCardData.class);
        when(creditCardData.getCardNumber()).thenReturn("4111111111111111");
        CreditCardGenericResponse creditCardGenericResponse = ccProcessServiceImpl.addCard(creditCardData);
        assertNotNull(creditCardGenericResponse);
    }

    @Test
    public void test_addCard_duplicate() {
        CreditCardData creditCardData = mock(CreditCardData.class);
        when(creditCardData.getCardNumber()).thenReturn("5105105105105100");
        when(creditCardProcessorDAO.addCard(creditCardData)).thenThrow(DuplicateKeyException.class);
        CreditCardGenericResponse creditCardGenericResponse = ccProcessServiceImpl.addCard(creditCardData);
        assertEquals(CreditCardDataConstants.CARD_ALREADY_EXIST, creditCardGenericResponse.getErrors().getMessage());
    }

    @Test
    public void test_getAllCards() {
        CreditCardListResponse response = ccProcessServiceImpl.getAllCards();
        assertNull(response.getErrors());
    }

}
