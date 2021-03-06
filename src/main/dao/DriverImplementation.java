package main.dao;

import main.ConnectionToDB;
import main.Exception.TaxiException;
import main.pojo.Driver;
import main.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/*
 * Implemntation of UserInterface for postgressql DB
 */
@Repository
public class DriverImplementation implements DriverInterface {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(DriverImplementation.class);

    public void create(Driver driver) throws TaxiException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String qText = "INSERT INTO public.\"Driver\"" +
                "(users_pkey_driver, full_name, car_number, car_description, passport, birth)" +
                "  VALUES (" +
                Long.valueOf(driver.getUsersPkey().getUsersPkey()) +", " +
                "'" + driver.getFullName() + "' , " +
                "'" + driver.getCarNumber() + "' , " +
                "'" + driver.getCarDescription() + "' , " +
                "'" + driver.getPassport() + "' , " +
                "'" + format.format(driver.getBirth()) +"')";
        ConnectionToDB.execute(qText);
    }

    public Driver read(int users_pkey_driver) {
        return null;
    }

    public Driver read(String login) throws TaxiException {
        Driver driver = null;
        try {
            ConnectionToDB connectionToDB = new ConnectionToDB();
            Connection connection = connectionToDB.toConnect();
            Statement st = connection.createStatement();
            String qtext = "SELECT * FROM PUBLIC.\"Driver\" Dr LEFT JOIN PUBLIC.\"User\" Us\n" +
                    "ON Us.users_pkey = Dr.users_pkey_driver\n" +
                    "WHERE Us.login = '"+ login +"' LIMIT 1";
            ResultSet resultSet = st.executeQuery(qtext);
            if (resultSet.next()) {
                driver = new Driver();
                User user = new User(resultSet.getLong("users_pkey_driver"), login);
                driver.setUsersPkey(user);
                driver.setFullName(resultSet.getString("full_name"));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new TaxiException(e.getMessage());
        }
        return driver;
    }

    public void update(Driver driver) {

    }

    public void delete(Driver driver) {

    }

    public void getAll() {

    }
}
