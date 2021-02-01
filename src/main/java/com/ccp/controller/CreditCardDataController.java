/**
 *
 */
package com.ccp.controller;

import com.ccp.constants.CreditCardDataConstants;
import com.ccp.model.*;
import com.ccp.service.CreditCardProcessorService;
import com.ccp.utils.CreditCardProcessorUtils;
import com.ccp.utils.CreditCardProcessorValidator;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */
@RestController
public class CreditCardDataController {

    @Autowired
    private CreditCardProcessorService processorService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ApiOperation("Add a new credit card")
    public CreditCardGenericResponse addCard(@RequestBody CreditCardTransactionRequestModel request) {

        CreditCardData creditCardData = new CreditCardData(request);
        CreditCardGenericResponse creditCardGenericResponse = new CreditCardGenericResponse();
        if (CreditCardProcessorValidator.luhnCheck(request.getCardNumber()) && CreditCardProcessorUtils.validateCardDetails(creditCardData)) {
            creditCardGenericResponse = processorService.addCard(creditCardData);
        } else {
            creditCardGenericResponse.setCardNumber(request.getCardNumber());
            CreditCardError errors = new CreditCardError();
            errors.setMessage(CreditCardDataConstants.CARD_NUMBER_ERROR);
            creditCardGenericResponse.setErrors(errors);
        }

        return creditCardGenericResponse;
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET , produces = "application/json")
    @ApiOperation("List all cards from the system")
    public CreditCardListResponse getCards() {
        return processorService.getAllCards();

    }

}
