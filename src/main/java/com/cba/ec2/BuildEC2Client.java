package com.cba.ec2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;

public class BuildEC2Client {

	public BuildEC2Client() {
		// TODO Auto-generated constructor stub
	}
	Properties prop = new Properties();
	
	
	/*
	 * instantiate an AWS Service client without explicitly providing credentials to the builder
	 */
	
	public AmazonEC2 buildDefaultEC2ClientCredentials() throws Exception{
		
    	final AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
    			.withRegion("us-east-2")
                .build();
		return ec2;
		
	}
	
	/*
	 * instantiate an AWS Service client through credentials to the builder, obtained from system environment variables
	 * AWS_ACCESS_KEY, AWS_SECRET_KEY
	 */
	
	public AmazonEC2 buildEC2ClientCredentialsEnvVariables() throws Exception{
		
    	final AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
    			.withCredentials(new EnvironmentVariableCredentialsProvider())
                .build();
		return ec2;
		
	}
	
	/*
	 * instantiate an AWS Service client with explicitly providing credentials to the builder
	 */
	
	public AmazonEC2 buildEC2ClientCredentialsExplicit() throws Exception{
		
		InputStream input = new FileInputStream("/Users/srikanth/Documents/workspace/CBAFramework/src/main/resources/config.properties");
		
		prop.load(input);
		
		
		String accessKey = prop.getProperty("accessKey");
		String secretKey = prop.getProperty("secretKey");
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
    	final AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
    			.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    			.withRegion("us-east-2")
                .build();
		return ec2;
		
	}
	
	

}
