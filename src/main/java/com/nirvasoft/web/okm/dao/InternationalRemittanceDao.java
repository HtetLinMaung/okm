package com.nirvasoft.web.okm.dao;

import java.util.List;

import com.nirvasoft.web.okm.models.ComboData;
import com.nirvasoft.web.okm.models.RemitOutData;
import com.nirvasoft.web.utils.QueryUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("internationalRemittanceDao")
public class InternationalRemittanceDao extends QueryUtil {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InternationalRemittanceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int sendMoney(RemitOutData data) {
        long id = getNextId("RemitOutCurrency_Self", "serialno", jdbcTemplate);
        if (id == 9990000000L) {
            id = 1;
        }
        final String keyNames = "serialno, t1, t4, t5, t6, t7, t8, n1, n2, n3, fromcountry, tocountry, savedate, amount, fromremark, fromname, fromnrcno, fromunit, frombuildingname, fromtownship, fromdivision, fromphoneno, fromdob, frompassportno, fromblock, fromstreet, sendercountry, frompostalcode, fromemail, toname, tonrc, tounit, tobuildingname, totownship, todivision, tophoneno, todob, topassportno, toblock, tostreet, receivercountry, topostalcode, toemail, fromcustomerid, tocustomerid, currencycode, tocurrencycode, syskey";
        final String[] keys = keyNames.split(",");
        String sql = "INSERT INTO RemitOutCurrency_Self (" + keyNames + ") VALUES (";

        for (int i = 0; i < keys.length; i++) {
            if (i != keys.length - 1) {
                sql += "?, ";
            } else {
                sql += "0";
            }
        }
        sql += ")";
        Object[] args = new Object[] { id, data.getT1(), data.getT4(), data.getT5(), data.getT6(), data.getT7(),
                data.getT8(), data.getN1(), data.getN2(), data.getN3(), data.getFromcountry(), data.getTocountry(),
                data.getSavedate(), data.getAmount(), data.getFromremark(), data.getFromname(), data.getFromnrcno(),
                data.getFromunit(), data.getFrombuildingname(), data.getFromtownship(), data.getFromdivision(),
                data.getFromphoneno(), data.getFromdob(), data.getFrompassportno(), data.getFromblock(),
                data.getFromstreet(), data.getSendercountry(), data.getFrompostalcode(), data.getFromemail(),
                data.getToname(), data.getTonrc(), data.getTounit(), data.getTobuildingname(), data.getTotownship(),
                data.getTodivision(), data.getTophoneno(), data.getTodob(), data.getTopassportno(), data.getToblock(),
                data.getTostreet(), data.getReceivercountry(), data.getTopostalcode(), data.getToemail(),
                data.getFromcustomerid(), data.getTocustomerid(), data.getCurrencycode(), data.getTocurrencycode() };
        System.out.println(args.length);
        return jdbcTemplate.update(sql, args);
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

    public List<ComboData> getAllWalletTypes() {
        return getDetails("'Wallet Type List'");
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
