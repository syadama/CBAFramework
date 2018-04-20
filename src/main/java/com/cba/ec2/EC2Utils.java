package com.cba.ec2;

import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;

public class EC2Utils {

	public EC2Utils() {
		// TODO Auto-generated constructor stub
	}
	
	BuildEC2Client buildCred = new BuildEC2Client();

	public String getPublicIpFromInstanceId(String instanceId) throws Exception {
		AmazonEC2 ec2 = buildCred.buildDefaultEC2ClientCredentials();
		
		String publicAddress = ec2.describeInstances(new DescribeInstancesRequest().withInstanceIds(instanceId))
				.getReservations().stream().map(Reservation::getInstances).flatMap(List::stream).findFirst()
				.map(Instance::getPublicIpAddress).orElse(null);

		return publicAddress;

	}

}
