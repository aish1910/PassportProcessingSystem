<h3>Scope</h3>
To simulate a passport application processing system and compute the total time taken for processing all applications.

<h3>Problem Statement</h3>
In a typical passport office, the following tasks will be carried out for processing and generating passports for the candidates:

* Application Submission
* Document Verification
* Biometrics

There are 3 officers assigned for each of the above tasks, hence a total of 9 officers. The below table illustrates the time taken by each officer to process a given step.

![](https://github.com/aish1910/PassportProcessingSystem/blob/master/src/images/Input.png)

Candidates start arriving at the passport office from 9 am onwards in periodic interval of 15 min as illustrated below

* 20 persons at 9.00 am
* 30 persons at 9.15 am
* 20 persons at 9.30 am
* 45 persons at 9.45 am

Calculate the total time taken by the passport officials to process all applications for all candidates.

<h3>High Level Design</h3>

![](https://github.com/aish1910/PassportProcessingSystem/blob/master/src/images/PassportApplicationSystem-Architecture.jpg)

<h3>Implementation</h3>

Two solutions are proposed to solve the above problem.

<ul><li>
<h3>APPROACH 1(Round Robin):</h3>
 Since the question does not state to compute the <b>minimum/ideal time</b> to process all applications but just <b>average total time</b>, we use a <b>round  robin</b> approach. Here, the persons arriving are arranged in a round-robin fashion. For eg, when the first 20 persons arrive at 9.00 am, they are arranged as follows:(taking only the arrangement of the first 6 persons below for the purpose of this example.)
 
 * Candidate 1 -> Counter 1
 * Candidate 2 -> Counter 2
 * Candidate 3 -> Counter 3
 * Candidate 4 -> Counter 1
 * Candidate 5 -> Counter 2
 * Candidate 6 -> Counter 3 etc.
 
 We compute the total time taken for processing all candidates( 115 in total ), at each of the 3 steps. Finally we compute the <b>maximum of all times</b> as illustrated below:
 
 `TotalTimeTaken = MAX(totalTimeForApplicationSubmission, totalTimeForDocumentVerification, totalTimeForBioMetrics);`
 
 We compute max of all times because we assume that <b>all 3 tasks happen simultaneously</b>. i.e candidates who have completed Application submission, immediately go to document verification, meaning the 3 tasks happen parallely.
 
 This approach gives <b>`14hours and 2 min`</b> as the total time taken to process passport applications of all candidates</li>
 
<li>
<h3>APPROACH 2(Allocating more persons to the counters which complete the task faster)</h3>

<p>In this Approach, we try to <b><i>allocate more persons to a counter which processes the applications faster</i></b>. For eg, the processing time of <b>counter 2</b> in Step#1(Application Submission) is <b>2 min</b>, but the processing times of the other two are <b>4 min</b>.

```
No of persons processed by counter1 in 15 min : 15/4 = 3 persons
No of persons processed by counter2 in 15 min : 15/2 = 7 persons
No of persons processed by counter3 in 15 min : 15/4 = 3 persons
```

So as illustrated above, <b>counter2</b> processes <b>7</b> persons in the first 15 min whereas <b>counter1 and counter3</b> can process just <b>3</b>.

At the end of 15 min, <b>13</b> persons are processed in Step#1 and they move to Step#2. The remaining <b>7</b> persons wait for their turn in Step#1 and they are followed by the new set of <b>30</b> persons who arrive at that time.

We compute the total time taken at each step based on the the persons remaining at the end of every 15 min and the new set of peope arriving after 15 min.

<b><i>The total time taken for completing all steps is computed as the maximum of the time taken for processing all candidates(total of 115) at each step.</i></b></p>

  `TotalTimeTaken = MAX(totalTimeForApplicationSubmission, totalTimeForDocumentVerification, totalTimeForBioMetrics);`
  
This approach gives <b>`5hours and 45 min`</b> as the total time taken to process passport applications of all candidates.</li>
</ul>

<h3>NOTE:</h3><b>Approach 2 is better than Approach 1 since it allocates more persons to the counters which complete the task faster. Approach 2 is suggested as the optimised solution to solve this problem</b>
