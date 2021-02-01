package com.ccp.service;

import com.ccp.constants.CreditCardDataConstants;
import com.ccp.model.*;
import com.ccp.repository.CreditCardProcessorDAO;
import com.ccp.utils.CreditCardProcessorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */

@Service
public class CreditCardProcessorServiceImpl implements CreditCardProcessorService {

    @Autowired
    private CreditCardProcessorDAO creditCardProcessorDAO;

    @Override
    public CreditCardGenericResponse addCard(CreditCardData creditCardData) {
        CreditCardGenericResponse creditCardGenericResponse = new CreditCardGenericResponse();
        creditCardGenericResponse.setCardNumber(creditCardData.getCardNumber());
        creditCardGenericResponse.setCreditLimit(creditCardData.getCreditLimit());
        creditCardGenericResponse.setName(creditCardData.getName());
        creditCardGenericResponse.setBalance("0");
        creditCardData.setBalance("0");

        try {
            int response = creditCardProcessorDAO.addCard(creditCardData);
        } catch (DuplicateKeyException e) {
            CreditCardError errors = new CreditCardError();
            errors.setMessage(CreditCardDataConstants.CARD_ALREADY_EXIST);
            creditCardGenericResponse.setErrors(errors);
        } catch (DataAccessException e) {
            CreditCardError errors = new CreditCardError();
            errors.setMessage(CreditCardDataConstants.GENERIC_ERROR_MESSAGE);
            creditCardGenericResponse.setErrors(errors);
        }

        return creditCardGenericResponse;

    }

    public CreditCardListResponse getAllCards() {
        CreditCardListResponse cardList = new CreditCardListResponse();
        List<CreditCardData> creditCards = new ArrayList<CreditCardData>();
        try {
            List<Map<String, Object>> cards = creditCardProcessorDAO.getAllCards();

            for (Map<String, Object> row : cards) {
                CreditCardData cardData = new CreditCardData();
                cardData.setCardNumber((String) row.get("ccnumber"));
                cardData.setCreditLimit(CreditCardProcessorUtils.formatAmount((String) row.get("credit_limit")));
                cardData.setName((String) row.get("name"));
                cardData.setBalance(CreditCardProcessorUtils.formatAmount((String) row.get("balance")));

                creditCards.add(cardData);
            }
        } catch (DataAccessException | NumberFormatException e) {
            CreditCardError errors = new CreditCardError();
            errors.setMessage(CreditCardDataConstants.GENERIC_ERROR_MESSAGE);
            cardList.setErrors(errors);
        }

        if (!creditCards.isEmpty()) {
            cardList.setCreditCards(creditCards);
        }
        return cardList;
    }


}
