package com.rmgyantraDifferentWaysToPost;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgYantraPojoClass.POJO;

import io.restassured.http.ContentType;

public class CreateProjectUsingDataProvider {

	@Test(dataProvider="provideData")
	public void CreateProjectUsingDataProvider(String createdBy, String projectName, String status, int teamSize)
	{
POJO P=new POJO(createdBy,projectName,status,teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(P)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and().assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] objArr=new Object[2][4];
		
		objArr[0][0]="xyz";
		objArr[0][1]="SDET_10_Project_12378";
		objArr[0][2]="created";
		objArr[0][3]=8;
		
		objArr[1][0]="xyz";
		objArr[1][1]="SDET_10_Project_699";
		objArr[1][2]="created";
		objArr[1][3]=8;
		
		return objArr;
		
	}
	
	
}
