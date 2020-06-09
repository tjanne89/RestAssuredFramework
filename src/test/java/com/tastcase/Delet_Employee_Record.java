package com.tastcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delet_Employee_Record extends Testbase
{
	RequestSpecification httprequest;
	Response response;
	 @BeforeClass
     void deletEmployees() throws InterruptedException
	  {
		     logger.info("Started TC001_Delet_singleemployee_record ");
             RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
             httprequest=RestAssured.given();
             response =httprequest.request(Method.GET,"/employees");
             
             JsonPath JasonPathEvaluator=response.jsonPath();
             
             String empID=JasonPathEvaluator.getString("(0).id");
             response =httprequest.request(Method.DELETE,"/employee/"+ empID);
             
             Thread.sleep(3);

     }

		      @Test
			  void checkResponseBody()
			{
			      logger.info("  ** Checking Respose Body");
			      String responsebody=response.getBody().asString();
			      System.out.println("Response body is: " +responsebody);
			
			}
		
		      @Test
		  void checkStatuscode()
		{
		      logger.info("  ** Checking Staus code ");
		      int statuscode=response.getStatusCode();
		      System.out.println("the status code is" + statuscode);
		      Assert.assertEquals(statuscode, 405);
		
		}
		
		      @Test
		  void checkStatusline()
		{
		      logger.info("  ** Checking Staus Line ");
		      String statusline=response.statusLine();
		      System.out.println("status line is" + statusline);
		
		}
		      @Test
		  void checkContentEncoding()
		{
		      logger.info("  ** Checking Content Encoding");
		      String contentencoding=response.header("Content-Encoding");
		      System.out.println("Content Encoding is: " +contentencoding);
		}
		  	@Test
		    void checkContenttype()
		{
			logger.info("  ** Checking Staus Line ");
			String contenttype=response.header("Content-Type");
			System.out.println("Content Type is : " +contenttype);
		}
		
			
			@Test
		    void getallheaders()
		{
			logger.info("  ** Checking All headers ");
		    Headers allheaders = response.headers();
		    for (Header header:allheaders)
		    {
		   System.out.println(header.getName()+"        " + header.getValue());
		 	 	   
		    }
		    
		}
		
			@Test
		    void checkServertype()
	   {
			logger.info("  ** Checking Server type");
			String servertype=response.header("Server");
			System.out.println("Server Type is : " +servertype);
		}
		
			@Test
		    void checkcookies()
		{
			logger.info("  ** Checking Cookies");
			String cookies=response.getCookie("PHPSESSID");
			System.out.println("Content Type is : " +cookies);
		}
		
			
			@Test
		    void checkResponsetime()
	 {
				logger.info("  ** Checking response time");
				long responsetime = response.getTime();
			   System.out.println("Server Type is : " +responsetime);
		}
		

}
