package com.cba.ec2;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;

public class BuildEC2Client {

	public BuildEC2Client() {
		// TODO Auto-generated constructor stub
	}
	
	public AmazonEC2 buildEC2ClientCredentials(){
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJCAH52HV5QH7FPVQ", "1b6dKbHlMO+YNdg4P4nRacaokfAcRzlG9bCjNLjQ");
    	final AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
    			.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    			.withRegion("us-east-2")
                .build();
		return ec2;
		
	}

}
