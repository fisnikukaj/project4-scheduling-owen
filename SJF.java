
public class SJF {
	Jobs[] jobs;
	
	public SJF(Jobs[] jobs){
		this.jobs = jobs;
	}
	
	
	public void sortJobs(){
		boolean check = true;
		Jobs temp;
		

		while(check){
			check = false;
			for(int i = 0; i < this.jobs.length-1; i++){
				if (jobs[i].arrivalTime > jobs[i+1].arrivalTime){
					temp = jobs[i];
					jobs[i] = jobs[i+1];
					jobs[i+1] = temp;
					check = true;
				}
			}
		}
		}
	
	public void start(){
		//loop through jobs
		sortJobs();
		int turnaroundTime = 0;
		int completionTime = 0;
		Jobs temp;
		//sort by run time
		for (int i = 0; i < jobs.length-1; i++){
			for (int j = i+1; j < jobs.length-1; j++){
				//if job at current has the same arrival time as the next job
				if(jobs[i].arrivalTime == jobs[j].arrivalTime){
					//check if current has a lower run time
					if ((jobs[i].runTime > jobs[j].runTime)){
						temp = jobs[i];
						jobs[i] = jobs[j];
						jobs[j] = temp;
					}
				}
			}
		}
		for (int i = 0; i < jobs.length; i++){
			completionTime += jobs[i].runTime;
			turnaroundTime += (completionTime - jobs[i].arrivalTime);
		}
		int turnaroundTimeAvg = turnaroundTime/jobs.length;
		System.out.println("The average turnaround time for SJF is: " + turnaroundTimeAvg + "s");
	}
	
}
