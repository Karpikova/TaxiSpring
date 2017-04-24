package main.services;

import main.Exception.ExceptionDBStructure;
import main.Exception.TaxiException;
import main.controllers.DriverMainServlet;
import main.controllers.LoginServlet;
import main.dao.UserImplementation;
import main.dao.UserInterface;
import main.pojo.User;
import main.pojo.UserRole;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Date;


/*
 * User Service Implementation
 */
public class UserServiceImplementation implements UserServiceInterface {

    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader()
                .getResource("log4j.properties"));
    }
    private static final org.apache.log4j.Logger logger = Logger.getLogger(UserServiceImplementation.class);


    private static UserInterface userInterface = new UserImplementation();

    public User auth(String login, String password) throws TaxiException {
        return userInterface.read(login, password);
    }

    public User createBrandNew(User user) throws TaxiException {
        return userInterface.createBrandNew(user);
    }

    public UserRole getRole(String login) throws TaxiException {
        return userInterface.getRole(login);
    }

}
