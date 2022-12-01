package comRmgYantrValidation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DyamicValidationTest {

	@Test
	public void dyamicValidationTest()
	{
		String expData="deepak_";
		
		Response rsps=	when()
			.get("http://localhost:8084/projects");
			
			List<String> actData=rsps.jsonPath().get("projectName");
			
		for(int i=0;i<actData.size();i++)
		{
			String actualData=actData.get(i);
			if(expData.equals(actualData))
			{
				System.out.println(expData+"is available");
				break;
			}
		}
			
	//	for(String data:actData)
	//	{
		//	if(expData.equals(actData))
		//	{
		//		System.out.println(expData+"is available");
		//break;
	//		}
	//	}
			
			}
}
