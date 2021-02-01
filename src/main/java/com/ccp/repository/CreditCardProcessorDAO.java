/**
 *
 */
package com.ccp.repository;

import com.ccp.model.CreditCardData;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Map;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */


public interface CreditCardProcessorDAO {

    public List<Map<String, Object>> getAllCards() throws DataAccessException;

    public int addCard(CreditCardData creditCardData) throws DuplicateKeyException, DataAccessException;

}
