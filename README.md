<h3>Scope</h3>
To simulate a passport application processing system and compute the total time taken for processing all applications.

<h3>Problem Statement</h3>
In a typical passport office, the following tasks will be carried out for processing and generating passports for the candidates:

* Application Submission
* Document Verification
* Biometrics

There are 3 officers assigned for each of the above tasks, hence a total of 9 officers. The below table illustrates the time taken by each officer to process a given step.



Candidates arrive at the passport office at 9 am in periodic interval of 15 min as illustrated below

* 20 persons at 9.00 am
* 30 persons at 9.15 am
* 20 persons at 9.30 am
* 45 persons at 9.45 am

Calculate the total time taken by the passport officials to process all applications.

<h3>Implementation</h3>

Two solutions are proposed to solve the above problem.

*Approach 1(Round Robin)
 Since the question does not state to compute the minimum/ideal time to process all applications but just average/total time, we use a round  robin approach. Here, the persons arriving are arranged in a round-robin fashion. For eg, when the first 20 persons arrive at 9.00 am, they are arranged as follows:(taking only the first 6 persons for the purpose of this example.
 
 * Candidate 1 -> Counter 1
 * Candidate 2 -> Counter 2
 * Candidate 3 -> Counter 3
 * Candidate 4 -> Counter 1
 * Candidate 5 -> Counter 2
 * Candidate 6 -> Counter 3 etc.
 
 We compute the total time taken for processing all candidates( 115 in total ), at each of the 3 steps. Finally we compute the maximum of all times as illustrated below:
 
 `TotalTimeTaken = MAX(totalTimeForApplicationSubmission, totalTimeForDocumentVerification, totalTimeForBioMetrics);`
 
 We compute max of all times because we assume that all 3 tasks happen simultaneously. i.e candidates who have completed Application submission, immediately go to document verification, meaning the 3 tasks happen parallely.
 
 This approach gives `14hours and 2 min` as the total time taken to process passport applications of all candidates
 

*Approach 2(Allocating more persons to the counters which complete the task faster)

In this Approach, we try to allocate more persons to a counter which processes the applications faster. For eg, the processing time of counter 2 in Step#1(Application Submission) is 2 min, but the processing times of the other two are 4 min.

No of persons processed by counter1 in 15 min : 15/4 = 3 persons
No of persons processed by counter2 in 15 min : 15/2 = 7 persons
No of persons processed by counter3 in 15 min : 15/4 = 3 persons

So as illustrated above, counter2 processes 7 persons in the first 15 min whereas counter1 and counter3 can process just 3.

At the end of 15 min, 13 persons are processed in Step#1 and they move to Step#2. The remaining 7 persons wait for their turn in Step#1 and they are followed by the new set of 30 persons who arrive at that time.

We compute the total time taken at each step based on the the persons remaining at the end of every 15 min and the new set of peope arriving after 15 min.

We compute the total time taken as the maximum of the time taken for processing all candidates(total of 115) at each step.

  `TotalTimeTaken = MAX(totalTimeForApplicationSubmission, totalTimeForDocumentVerification, totalTimeForBioMetrics);`
  
This approach gives `5hours and 45 min` as the total time taken to process passport applications of all candidates.

<h3>NOTE:</h3><b>Approach 2 is better than Approach 1 since it allocates more persons to the counters which complete the task faster. Approach 2 is suggested as the optimised solution to solve this problem</b>
