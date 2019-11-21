package com.passport.application;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * <h1>Java program to compute total processing time for completion of all the below tasks at
 * a Passport office for all candidates:</h1>
 * <p>
 * <ul>
 * <li>Form submission</li>
 * <li>Document Verification</li>
 * <li>Biometrics</li>
 * </ul>
 * 
 * <b>Assumptions/Prerequisites considered</b>
 * </p>
 * <ul>
 * <li>More number of candidates go to the counters where the
 * applications are processed faster/in lesser execution times</li>
 * <li>All 3 tasks(Application submissin, doc verification and biometrics) happen simultaneously</li>
 * </ul>
 *
 */
public class PassportApplicationApproach2 {

	public static void main(String[] args) {

		// submit application
		int[] submitApplicationExecTimes = { 4, 2, 4 };

		int[] personsArrivingIn15minInteval = { 20, 30, 20, 45 };

		// No of persons handled in 15 min
		int personsHandledForSubApplication = getPersonsHandledIn15min(submitApplicationExecTimes);

		int overallTimeTakenForApplicationSubmission = timeTakenToProcessStepForAllCandidates(
				personsArrivingIn15minInteval, personsHandledForSubApplication);

		System.out.println("Approach 2:");
		System.out.println(
				"Time taken for submission of applications:" + overallTimeTakenForApplicationSubmission + " min");

		// doc verification
		int[] docVerificationExecTimes = { 7, 5, 5 };
		int personsHandledForDocVerification = getPersonsHandledIn15min(docVerificationExecTimes);

		int overallTimeTakenForDocVerification = timeTakenToProcessStepForAllCandidates(personsArrivingIn15minInteval,
				personsHandledForDocVerification);

		System.out.println("Time taken for document verification:" + overallTimeTakenForDocVerification + " min");

		// biometrics
		int[] biometricsExecTimes = { 7, 7, 8 };
		int personsHandledForBiometrics = getPersonsHandledIn15min(biometricsExecTimes);

		int overallTimeTakenForBiometrics = timeTakenToProcessStepForAllCandidates(personsArrivingIn15minInteval,
				personsHandledForBiometrics);

		System.out.println("Time taken for biometrics:" + overallTimeTakenForBiometrics + " min");

		int averageTimeForCompletionOfAllTasks = Collections.max(Arrays.asList(overallTimeTakenForApplicationSubmission,
				overallTimeTakenForDocVerification, overallTimeTakenForBiometrics));

		int hours = averageTimeForCompletionOfAllTasks / 60;
		int minutes = averageTimeForCompletionOfAllTasks % 60;

		System.out.println(
				"Average time required to complete all tasks(assuming all tasks happen simultaneously/parallely):"
						+ hours + " hours and " + minutes + " minutes");
	}

	private static int timeTakenToProcessStepForAllCandidates(int[] personsArrivingIn15minInteval,
			int personsHandledForSubApplication) {
		int time = 0;
		int personsRemaining = 0;
		int n = 0;

		// process the time taken for all 115 candidates who arrive at the passport
		// office at 15 min intervals.
		while (n < personsArrivingIn15minInteval.length || personsRemaining > 0) {

			if (n < personsArrivingIn15minInteval.length) {
				personsRemaining += personsArrivingIn15minInteval[n];
				n++;
			}
			personsRemaining = personsRemaining - personsHandledForSubApplication;
			time += 15;
		}
		return time;
	}

	private static int getPersonsHandledIn15min(int[] submitApplicationExecTimes) {
		int personsHandled = 0;
		for (int i = 0; i < submitApplicationExecTimes.length; i++) {
			int persons = 15 / submitApplicationExecTimes[i];
			personsHandled += persons;
		}
		return personsHandled;
	}
}
