
public class FIFO {
	Jobs[] jobs;

	
	public FIFO(Jobs[] jobs){
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
		for (int i = 0; i < jobs.length; i++){
			completionTime += jobs[i].runTime;
			turnaroundTime += (completionTime - jobs[i].arrivalTime);
		}
		int turnaroundTimeAvg = turnaroundTime/jobs.length;
		System.out.println("The average turnaround time for FIFO is: " + turnaroundTimeAvg + "s");
	}
	
}
