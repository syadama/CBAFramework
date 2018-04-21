package com.cba.ec2;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.Tag;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.CreateTagsResult;

public class CreateInstance {

	String ami_id;
	String name;
	String instance_id;
	BuildEC2Client buildCred = new BuildEC2Client();

	public void createInstance(String instance_id) throws Exception {

		AmazonEC2 ec2 = buildCred.buildDefaultEC2ClientCredentials();

		RunInstancesRequest run_request = new RunInstancesRequest().withImageId(ami_id)
				.withInstanceType(InstanceType.T2Micro).withMaxCount(1).withMinCount(1);

		RunInstancesResult run_response = ec2.runInstances(run_request);

		instance_id = run_response.getReservation().getReservationId();

		Tag tag = new Tag().withKey("Name").withValue(name);

		CreateTagsRequest tag_request = new CreateTagsRequest().withTags(tag);

		CreateTagsResult tag_response = ec2.createTags(tag_request);

		System.out.printf("Successfully started EC2 instance %s based on AMI %s", instance_id, ami_id);

	}

}
