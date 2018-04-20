package com.cba.ec2;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DryRunResult;
import com.amazonaws.services.ec2.model.DryRunSupportedRequest;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.cba.ec2.BuildEC2Client;

/**
 * Starts or stops and EC2 instance
 */
public class StartStopInstance {

	static BuildEC2Client buildCred = new BuildEC2Client();
	static EC2Utils utils = new EC2Utils();

	public static void startInstance(String instance_id) throws Exception {

		AmazonEC2 ec2 = buildCred.buildDefaultEC2ClientCredentials();

		DryRunSupportedRequest<StartInstancesRequest> dry_request = () -> {
			StartInstancesRequest request = new StartInstancesRequest().withInstanceIds(instance_id);

			return request.getDryRunRequest();
		};

		DryRunResult dry_response = ec2.dryRun(dry_request);

		if (!dry_response.isSuccessful()) {
			System.out.printf("Failed dry run to start instance %s", instance_id);

			throw dry_response.getDryRunResponse();
		}

		StartInstancesRequest request = new StartInstancesRequest().withInstanceIds(instance_id);

		ec2.startInstances(request);

		Thread.sleep(3000);
		String publicIp = utils.getPublicIpFromInstanceId(instance_id);

		System.out.println("Successfully started instance is" + instance_id);
		System.out.println("Pubic IP of the started instance is" + publicIp);
	}

	public static void stopInstance(String instance_id) throws Exception {

		AmazonEC2 ec2 = buildCred.buildDefaultEC2ClientCredentials();

		DryRunSupportedRequest<StopInstancesRequest> dry_request = () -> {
			StopInstancesRequest request = new StopInstancesRequest().withInstanceIds(instance_id);

			return request.getDryRunRequest();
		};

		DryRunResult dry_response = ec2.dryRun(dry_request);

		if (!dry_response.isSuccessful()) {
			System.out.printf("Failed dry run to stop instance %s", instance_id);
			throw dry_response.getDryRunResponse();
		}

		StopInstancesRequest request = new StopInstancesRequest().withInstanceIds(instance_id);

		ec2.stopInstances(request);

		System.out.printf("Successfully stop instance %s", instance_id);
	}

	public static void main(String[] args) throws Exception {

		// stopInstance("i-04535f42d02c0474c");
		stopInstance("i-077bc907d878e50b4");

		/*
		 * final String USAGE =
		 * "To run this example, supply an instance id and start or stop\n" +
		 * "Ex: StartStopInstance <instance-id> <start|stop>\n";
		 * 
		 * //final String USAGE = "StartStopInstance i-04535f42d02c0474c stop";
		 * 
		 * if (args.length != 1) { System.out.println(USAGE); System.exit(1); }
		 * 
		 * String instance_id = args[0];
		 * 
		 * boolean start;
		 * 
		 * if(args[1].equals("start")) { start = true; } else { start = false; }
		 * 
		 * if(start) { startInstance(instance_id); } else {
		 * stopInstance(instance_id); }
		 */
	}
}