package com.cba.ec2;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.Tag;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.CreateTagsResult;

public class CreateInstance
{
	
	//BuildEc2Client ec2 = new BuildEc2Client();
	String ami_id;
	String name;
	String instance_id ;
	
	public  void createInstance(String instance_id){
		
		AmazonEC2 ec2 = buildCred.buildDefaultEC2ClientCredentials();
    	
    	RunInstancesRequest run_request = new RunInstancesRequest()
                .withImageId(ami_id)
                .withInstanceType(InstanceType.T2Micro)
                .withMaxCount(1)
                .withMinCount(1);

            RunInstancesResult run_response = ec2.runInstances(run_request);

            instance_id = run_response.getReservation().getReservationId();

            Tag tag = new Tag()
                .withKey("Name")
                .withValue(name);

            CreateTagsRequest tag_request = new CreateTagsRequest()
                .withTags(tag);

            CreateTagsResult tag_response = ec2.createTags(tag_request);

            System.out.printf(
                "Successfully started EC2 instance %s based on AMI %s",
                instance_id, ami_id);
    	
    	
    	
	}
	
	
	
	
	
	
	
    public static void main(String[] args)
    {
        /*final String USAGE =
            "To run this example, supply an instance name and AMI image id\n" +
            "Ex: CreateInstance <instance-name> <ami-image-id>\n";

        if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String name = args[0];
        String ami_id = args[1];

        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

        RunInstancesRequest run_request = new RunInstancesRequest()
            .withImageId(ami_id)
            .withInstanceType(InstanceType.T1Micro)
            .withMaxCount(1)
            .withMinCount(1);

        RunInstancesResult run_response = ec2.runInstances(run_request);

        String instance_id = run_response.getReservation().getReservationId();

        Tag tag = new Tag()
            .withKey("Name")
            .withValue(name);

        CreateTagsRequest tag_request = new CreateTagsRequest()
            .withTags(tag);

        CreateTagsResult tag_response = ec2.createTags(tag_request);

        System.out.printf(
            "Successfully started EC2 instance %s based on AMI %s",
            instance_id, ami_id);*/
    }
}
