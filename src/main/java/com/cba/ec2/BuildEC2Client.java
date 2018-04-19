package com.cba.ec2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;

public class BuildEC2Client {

	public BuildEC2Client() {
		// TODO Auto-generated constructor stub
	}
	Properties prop = new Properties();
	
	
	public AmazonEC2 buildEC2ClientCredentials() throws Exception{
		
		InputStream input = new FileInputStream("config.properties");
		
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
