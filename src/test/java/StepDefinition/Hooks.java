package StepDefinition;

import Util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static DriverFactory driverFactory = new Util.DriverFactory();

    @Before
    public void before(){
        driverFactory.getDriver();
    }

    @After
    public void after(){
        driverFactory.quitDriver();
    }
}
