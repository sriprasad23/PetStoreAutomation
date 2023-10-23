package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	public Logger logger; // For Logs
	
	
	@BeforeClass
	public void setup()           // By using this generate data by using Faker library
	{
		
		faker= new Faker();			// Faker object
		userPayload=new User();		  // user object
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
		
		logger.debug("debugging.....");
		
	}
	
	@Test(priority =1)
	public void testPostUser()
	{
		logger.info("*************** Creating User ******************");
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*************** User is Created ******************");
	}
	
	@Test(priority =2)
	public void testGetUserByName()
	{
		logger.info("*************** Reading User Info ******************");
		
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*************** User Info is Displayed ******************");
	
	}
	
	@Test(priority =3)
	public void testUpdateUserByName()
	{
		// Update Data using Payload
		
		logger.info("*************** Updating User  ******************");
		
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
	//	response.then().log().body().statusCode(200); // Another way of Assertion chai assertion from RestAssured
		
		Assert.assertEquals(response.getStatusCode(), 200); // TestNG Assertion
		
		logger.info("*************** User is Updated ******************");
		
		// Checking data after update
		
		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
	}
	
	@Test(priority =4)
	public void testDeleteUserByName()
	{
		logger.info("*************** Deleting User ******************");
		
		Response response =	UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*************** User Deleted ******************");
		
		
	}
}
