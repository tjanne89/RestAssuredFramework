package com.baseclass;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testbase 
{
    public static RequestSpecification httprequest;
    public static Response response;
    public String empID = "51838";

    public Logger logger;

    @BeforeClass
    public void setup()
    {
    logger=Logger.getLogger("EmployeesRestAPI");
    PropertyConfigurator.configure("C:\\Users\\Sudhakar\\eclipse-workspace\\RestAssuredFramework\\src\\test\\resources\\Log4jproperties\\Log4j.properties");
    logger.setLevel(Level.DEBUG);
    }
}
