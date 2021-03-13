package com.nirvasoft.web.okm.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.nirvasoft.web.okm.models.AddressData;
import com.nirvasoft.web.okm.models.ComboData;
import com.nirvasoft.web.okm.models.CountryData;
import com.nirvasoft.web.okm.models.CustomerData;
import com.nirvasoft.web.okm.models.DocumentData;
import com.nirvasoft.web.okm.models.FilterRequest;
import com.nirvasoft.web.okm.models.NameTitleData;
import com.nirvasoft.web.utils.QueryUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("customerRegistrationDao")
public class CustomerRegistrationDao extends QueryUtil {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRegistrationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int registerCustomer(CustomerData data) {
        try {
            String keyNames = "CustomerId, CustomerType, Title, Name, AliasName, Sex, DateOfBirth, NrcNo, HouseNo, Street, Ward, BuildingName, Township, Division, Country, Phone, Email, Fax, PostalCode, Status, Occupation, FatherName, Universalid, MStatus, OldNrcNo, M1, M2, T2, BCNo, PassportNo, NationalityStatus, IsHasDoc, IsSameAddress, PHouseNo, PStreet, PWard, PTownship, PDivision, PCountry, PPostalCode, RegistrationDate, PPhone, PEmail, PFax, PBuildingName, RegisterType, T6";
            final String[] keys = keyNames.split(",");

            String sql = "INSERT INTO Customer (" + keyNames + ") VALUES (";
            for (int i = 0; i < keys.length; i++) {
                sql += "?";
                if (i != keys.length - 1) {
                    sql += ", ";
                }
            }
            sql += ")";

            long id = getNextId("Customer", "CustomerId", jdbcTemplate);

            int success = jdbcTemplate.update(sql,
                    new Object[] { id, data.getCustomerType(), data.getTitle(), data.getName(), data.getAliasName(),
                            data.getSex(), data.getDateOfBirth(), data.getNrcNo(), data.getHouseNo(), data.getStreet(),
                            data.getWard(), data.getBuildingName(), data.getTownship(), data.getDivision(),
                            data.getCountry(), data.getPhone(), data.getEmail(), ";;", data.getPostalCode(), "Save",
                            data.getOccupation(), data.getFatherName(), 999, data.getmStatus(), "", "::", "Buddhist",
                            data.getT2(), "BC", data.getPassportNo(), data.getNationalityStatus(), data.getIsHasDoc(),
                            1, data.getHouseNo(), data.getStreet(), data.getWard(), data.getTownship(),
                            data.getDivision(), data.getCountry(), data.getPostalCode(), data.getRegistrationDate(),
                            data.getPhone(), data.getEmail(), ";;", data.getBuildingName(), 1, 19000101 });

            if (success > 0) {
                sql = "INSERT INTO Customer_Doc (CustomerId, DocumentType, File_Path, File_Name) VALUES (?, ?, ?, ?)";

                byte[] decodedFile = Base64.getDecoder().decode(data.getPhoto().split(",")[1]);
                ;
                String filePath = "cache" + File.separator + "photos" + File.separator + "customer" + File.separator;
                FileOutputStream outputStream = new FileOutputStream(filePath + data.getFileName());
                outputStream.write(decodedFile);
                outputStream.close();

                ArrayList<Object> args = new ArrayList<>();
                args.add(id);
                args.add("Photo");
                args.add(filePath);
                args.add(data.getFileName());

                if (data.getDocuments().size() > 0) {
                    sql += ", ";
                }
                for (int i = 0; i < data.getDocuments().size(); i++) {
                    DocumentData doc = data.getDocuments().get(i);
                    decodedFile = Base64.getDecoder().decode(doc.getFile().split(",")[1]);
                    filePath = "cache" + File.separator + "document" + File.separator + "customer" + File.separator;
                    outputStream = new FileOutputStream(filePath + doc.getFileName());
                    outputStream.write(decodedFile);
                    outputStream.close();
                    sql += "(?, ?, ?, ?)";
                    if (i != data.getDocuments().size() - 1) {
                        sql += ", ";
                    }
                    args.add(id);
                    args.add("Document");
                    args.add(filePath);
                    args.add(doc.getFileName());
                }

                jdbcTemplate.update(sql, args.toArray());
            }
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public List<CustomerData> getAllCustomers() {
        final String sql = "SELECT CustomerId, Name, NrcNo, HouseNo, BuildingName, Township, Division, Phone, DateOfBirth, PassportNo, Ward, Street, Country, PostalCode, Email FROM Customer";

        return jdbcTemplate.query(sql, (rs, i) -> {
            CustomerData data = new CustomerData();
            data.setCustomerId(rs.getString("CustomerId"));
            data.setName(rs.getString("Name"));
            data.setNrcNo(rs.getString("NrcNo"));
            data.setHouseNo(rs.getString("HouseNo"));
            data.setBuildingName(rs.getString("BuildingName"));
            data.setTownship(rs.getString("Township"));
            data.setDivision(rs.getString("Division"));
            data.setPhone(rs.getString("Phone"));
            data.setDateOfBirth(rs.getString("DateOfBirth").split(" ")[0]);
            data.setPassportNo(rs.getString("PassportNo"));
            data.setWard(rs.getString("Ward"));
            data.setStreet(rs.getString("Street"));
            data.setCountry(rs.getString("Country"));
            data.setPostalCode(rs.getString("PostalCode"));
            data.setEmail(rs.getString("Email"));
            return data;
        });
    }

    public List<ComboData> getAllCustomerTypes(FilterRequest req) {
        final String sql = "SELECT CustomerType, Description FROM CustomerType WHERE CustomerType>=? AND CustomerType<=?";

        return jdbcTemplate.query(sql, (rs, i) -> {
            ComboData data = new ComboData();
            data.setText(rs.getString("Description"));
            data.setValue(rs.getString("CustomerType"));
            return data;
        }, new Object[] { req.getStart(), req.getEnd() });
    }

    public List<ComboData> getAllOccupation() {
        final String sql = "select code,Description from lovdetails where hkey = ( select syskey from LOVHeader where Description like 'Occupation')";

        return jdbcTemplate.query(sql, (rs, i) -> {
            ComboData data = new ComboData();
            data.setText(rs.getString("Description"));
            data.setValue(rs.getString("code"));
            return data;
        });
    }

    public List<NameTitleData> getAllNameTitle() {
        final String sql = "SELECT RefNo, Description, Sex FROM RefTitle";

        return jdbcTemplate.query(sql, (rs, i) -> {
            NameTitleData data = new NameTitleData();
            data.setRefNo(rs.getInt("RefNo"));
            data.setDescription(rs.getString("Description"));
            data.setSex(rs.getInt("Sex"));
            return data;
        });
    }

    public List<CountryData> getAllCountries() {
        final String sql = "select CountryName, CountryCode, Currency, StartingBranchCode from RefCountries";

        return jdbcTemplate.query(sql, (rs, i) -> {
            CountryData data = new CountryData();
            data.setCountryName(rs.getString("CountryName"));
            data.setCountryCode(rs.getString("CountryCode"));
            data.setCurrency(rs.getString("Currency"));
            data.setBranchCode(rs.getInt("StartingBranchCode"));
            return data;
        });
    }

    public List<AddressData> getAllAddress() {
        final String sql = "SELECT Code,DespMyan,DespEng,IsLocal FROM AddressRef WHERE SUBSTRING(Code,6,3)<>'000'";

        return jdbcTemplate.query(sql, (rs, i) -> {
            AddressData data = new AddressData();
            data.setCode(rs.getString("Code"));
            data.setDescMyan(rs.getString("DespMyan"));
            data.setDescEng(rs.getString("DespEng"));
            data.setLocal(rs.getBoolean("IsLocal"));
            return data;
        });
    }
}