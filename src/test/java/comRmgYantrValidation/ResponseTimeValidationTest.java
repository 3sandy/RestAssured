package comRmgYantrValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;



public class ResponseTimeValidationTest {

	@Test
	public void responseValTest()
	{
		
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.greaterThan((7000L)),TimeUnit.MICROSECONDS)
		.assertThat().body("[2].projectName",Matchers.equalTo("deepak_"))
		.log().all();
	}
}
