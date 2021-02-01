/**
 *
 */
package com.ccp.repository;

import com.ccp.model.CreditCardData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author  aishkou
 * @project Credit-Card-Processor
 */

@Repository
public class CreditCardProcessorDAOImpl implements CreditCardProcessorDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Map<String, Object>> getAllCards() throws DataAccessException {
        return jdbcTemplate.queryForList("SELECT * FROM creditcardinfo");
    }

    public int addCard(CreditCardData creditCardData) throws DuplicateKeyException, DataAccessException {
        return jdbcTemplate.update("insert into creditcardinfo (ccnumber,credit_limit,name,balance) values (?,?,?,?)", new Object[]{
                creditCardData.getCardNumber(), creditCardData.getCreditLimit(),
                creditCardData.getName(), creditCardData.getBalance()
        });
    }

}
