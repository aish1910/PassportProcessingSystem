package com.passport.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * <h1>Java program to compute total processing time for completion of all the
 * below tasks at a Passport office for all candidates:</h1>
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
 * <li>Since there is no requirement to find the min time taken to process all
 * applications, we are assuming that candidates who arrive at the passport
 * office arrange themselves in queue in a round-robin fashion. i.e first 3
 * candidates get their processing done at the first 3 counters respectively and
 * the next 3 stand behind them in queue and wait for their turn.</li>
 * </ul>
 *
 */
public class PassportApplicationApproach1 {

	public static void main(String[] args) {
		int[] timeTakenForEachCounterFormSubmission = {4, 2, 4};
		int[] timeTakenForEachCounterDocVerification = {7, 5, 5};
		int[] timeTakenForEachCounterBioMetrics = {7, 7, 8};
		
		System.out.println("Approach 1:");
		int[] personsArrivingIn15minInteval = { 20, 30, 20, 45 };
		
		int totalTimeTaken = 0;
		
		for (int i = 0; i < personsArrivingIn15minInteval.length; i++) {
			totalTimeTaken += processApplication(personsArrivingIn15minInteval[i],
					timeTakenForEachCounterFormSubmission, timeTakenForEachCounterDocVerification,
					timeTakenForEachCounterBioMetrics);
		}
		
		if(totalTimeTaken > 60) {
			int noOfHours = totalTimeTaken/60;
			int remainingMin = totalTimeTaken%60;
			System.out.println("Total Time to complete processing of all candidates: "+noOfHours+" hours and "+remainingMin+" minutes");
		} else {
			System.out.println("Total Time to complete processing of all candidates: "+totalTimeTaken+" min");
		}
	}
	
	public static int processApplication(int n, int[] formSubmissionProcessingTime, int[] docVerificationProcessingTimes, int[] biometricsProcessingTimes) {
		int timeTakenForFormSubmission = 0;
		timeTakenForFormSubmission = formSubmission(n, formSubmissionProcessingTime);
		System.out.println("Total Time taken to complete application submission: "+timeTakenForFormSubmission);
		
		int timeTakenForDocVerification = 0;
		timeTakenForDocVerification = documentVerification(n, docVerificationProcessingTimes);
		System.out.println("Total Time taken to complete document verification: "+timeTakenForDocVerification);
		
		int timeTakenForBioMetrics = 0;
		timeTakenForBioMetrics = biometrics(n, biometricsProcessingTimes);
		System.out.println("Total Time taken to complete biometrics: "+timeTakenForBioMetrics);
		
		List<Integer> computedTimes = Arrays.asList(timeTakenForFormSubmission, timeTakenForDocVerification, timeTakenForBioMetrics);
		
		// Since candidates who have completed form submision might proceed to document
		// verification and those who have done doc verification proceed to Biometrics,
		// all these tasks can happen simultaneously/parallely. Hence we
		// are computing the max of the time taken at all counters to compute the
		// consolidated time to process the passport submission and verification.
		int finalConsolidatedTime = Collections.max(computedTimes);
		return finalConsolidatedTime;
	}

	private static int formSubmission(int n, int[] timeTakenByCounter) {
		int noOfCandidatesInEachCounter = n/timeTakenByCounter.length;
		int candidatesRemaining = n%timeTakenByCounter.length;
		
		int totalTimeTaken = 0;
		// calculate time taken for each counter and add it to totalTimeTaken
		for(int i=0;i<timeTakenByCounter.length;i++) {
			totalTimeTaken += (noOfCandidatesInEachCounter * timeTakenByCounter[i]);
		}
		
		int counterToAssign = 0;
		for(int j=0;j<candidatesRemaining;j++) {
			if(counterToAssign > 2) {
				counterToAssign=1;
			}
			totalTimeTaken+=timeTakenByCounter[counterToAssign];
		}
		
		return totalTimeTaken;
	}
	
	private static int documentVerification(int n, int[] timeTakenByCounter) {
		int noOfCandidatesInEachCounter = n/timeTakenByCounter.length;
		int candidatesRemaining = n%timeTakenByCounter.length;
		
		int totalTimeTaken = 0;
		// calculate time taken for each counter and add it to totalTimeTaken
		for(int i=0;i<timeTakenByCounter.length;i++) {
			totalTimeTaken += (noOfCandidatesInEachCounter * timeTakenByCounter[i]);
		}
		
		int counterToAssign = 0;
		for(int j=0;j<candidatesRemaining;j++) {
			if(counterToAssign > 2) {
				counterToAssign=1;
			}
			totalTimeTaken+=timeTakenByCounter[counterToAssign];
		}
		
		return totalTimeTaken;
	}
	
	private static int biometrics(int n, int[] timeTakenByCounter) {
		int noOfCandidatesInEachCounter = n/timeTakenByCounter.length;
		int candidatesRemaining = n%timeTakenByCounter.length;
		
		int totalTimeTaken = 0;
		// calculate time taken for each counter and add it to totalTimeTaken
		for(int i=0;i<timeTakenByCounter.length;i++) {
			totalTimeTaken += (noOfCandidatesInEachCounter * timeTakenByCounter[i]);
		}
		
		int counterToAssign = 0;
		for(int j=0;j<candidatesRemaining;j++) {
			if(counterToAssign > 2) {
				counterToAssign=1;
			}
			totalTimeTaken+=timeTakenByCounter[counterToAssign];
		}
		
		return totalTimeTaken;
	}
	
	
}
