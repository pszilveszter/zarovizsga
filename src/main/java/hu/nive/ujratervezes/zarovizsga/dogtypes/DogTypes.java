package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DogTypes {


    private DataSource ds;


    public DogTypes(DataSource ds) {
        this.ds = ds;
    }


    public List<String> getDogsByCountry(String country) {
        try (Connection con = ds.getConnection();
             PreparedStatement sql = con.prepareStatement("SELECT name FROM dog_types WHERE country = (?)")) {
            sql.setString(1, country.toUpperCase());
            return processResults(sql);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Unable to connect database", se);
        }
    }


    private List<String> processResults(PreparedStatement sql) {
        try (ResultSet rs = sql.executeQuery()) {
            List<String> dogsOfCountry = new ArrayList<>();
            while (rs.next()) {
                dogsOfCountry.add(rs.getString("name").toLowerCase());
            }
            Collections.sort(dogsOfCountry);
            return dogsOfCountry;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Unable to process data", se);
        }
    }
}
