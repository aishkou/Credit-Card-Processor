package com.ccp.utils;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */

@RunWith(MockitoJUnitRunner.class)
public class CreditCardProcessorValidatorTest {

    @Test
    public void test_luhnTest() throws Exception {
        String number = "4111111111111111";
        assertEquals(CreditCardProcessorValidator.luhnCheck(number), true);
    }

    @Test
    public void test_luhnTest_False() throws Exception {
        String number = "4111111111111121";
        assertEquals(CreditCardProcessorValidator.luhnCheck(number), false);
    }

}
