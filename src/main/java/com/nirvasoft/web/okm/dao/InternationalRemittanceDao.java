package com.nirvasoft.web.okm.dao;

import java.util.List;

import com.nirvasoft.web.okm.models.ComboData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("internationalRemittanceDao")
public class InternationalRemittanceDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InternationalRemittanceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ComboData> getAllTransactionPurposes() {
        return getDetails("'Purpose of Transaction'");
    }

    public List<ComboData> getAllPaymentMethods() {
        return getDetails("'Method of Payment'");
    }

    public List<ComboData> getAllCollectionMethods() {
        return getDetails("'Method of Collection'");
    }

    private List<ComboData> getDetails(String type) {
        final String sql = "select code,Description from lovdetails where hkey = ( select syskey from LOVHeader where Description like "
                + type + ")";

        return jdbcTemplate.query(sql, (rs, i) -> {
            ComboData data = new ComboData();
            data.setText(rs.getString("Description"));
            data.setValue(rs.getString("code"));
            return data;
        });
    }
}
