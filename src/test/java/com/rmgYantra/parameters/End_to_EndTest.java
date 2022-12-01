package com.rmgYantra.parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.rmgYantraPojoClass.POJO;
import com.rmgyantra.GenericLibrary.BaseClass;
import com.rmgyantra.GenericLibrary.EndPoints;
import com.rmgyantra.GenericLibrary.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class End_to_EndTest extends BaseClass{

	@Test
	public void end_to_EndTest() throws SQLException
	{
		//create project
POJO P=new POJO("sandeep.u","sdet_"+JavaUtility.getRandomNumber(),"created",7);
				
						baseURI="http://localhost";
						port=8084;
							
		Response rsps=given()
				.contentType(ContentType.JSON)
				.body(P)
				.when()
				.post(EndPoints.addProject);
				
		String projectid=rsps.jsonPath().get("projectId");
		System.out.println(projectid);
		
		//update
		POJO Q=new POJO("sandeep.u","sdet_"+JavaUtility.getRandomNumber(),"created",9);
		
		Response got=	given()
		.pathParam("proId", projectid)
		.contentType(ContentType.JSON)
		.body(Q)
	    .when()
		.put(EndPoints.completeUpdate);
		String projectname=got.jsonPath().get("projectName");
		System.out.println(projectname);
		
		String expData=projectname;
		
		dUtil.connectToDB();
		dUtil.executeQueryAndVerifyTheData("select * from project;", 4, expData);
		dUtil.closeDB();	
		
				
	}
	}

