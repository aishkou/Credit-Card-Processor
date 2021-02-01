/**
 *
 */
package com.ccp.utils;

import com.ccp.constants.CreditCardDataConstants;
import com.ccp.model.CreditCardData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */

@RunWith(MockitoJUnitRunner.class)
public class CreditCardProcessorUtilsTest {

    @Test
    public void test_validateCardDetails() {
        CreditCardData creditCardData = mock(CreditCardData.class);
        when(creditCardData.getCardNumber()).thenReturn("4111111111111111");
        assertEquals(true, CreditCardProcessorUtils.validateCardDetails(creditCardData));
    }

    @Test
    public void test_validateCardDetails_AlphabeticCard() {
        CreditCardData creditCardData = mock(CreditCardData.class);
        when(creditCardData.getCardNumber()).thenReturn("abcd3243");
        assertEquals(false, CreditCardProcessorUtils.validateCardDetails(creditCardData));
    }

    @Test
    public void test_validateCardDetails_LengthFail() {
        CreditCardData creditCardData = mock(CreditCardData.class);
        when(creditCardData.getCardNumber()).thenReturn("4111111111111111111122");
        assertEquals(false, CreditCardProcessorUtils.validateCardDetails(creditCardData));
    }

    @Test
    public void test_validateCardDetails_negativeCard() {
        CreditCardData creditCardData = mock(CreditCardData.class);
        when(creditCardData.getCardNumber()).thenReturn("-4111111111111111");
        assertEquals(false, CreditCardProcessorUtils.validateCardDetails(creditCardData));
    }


    @Test
    public void test_formatAmount() {
        String amount = "20";
        assertEquals(CreditCardDataConstants.POUND + "20.00", CreditCardProcessorUtils.formatAmount(amount));
    }

    @Test
    public void test_formatAmount_negative() {
        String amount = "-20";
        assertEquals(CreditCardDataConstants.NEGATIVE_POUND + "20.00", CreditCardProcessorUtils.formatAmount(amount));
    }
}
