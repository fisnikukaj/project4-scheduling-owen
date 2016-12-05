import java.util.Random;
import java.util.Scanner;

public class Jobs {
	
	int arrivalTime;
	int runTime;
	

	
	
	public Jobs(){
		Random ran1 =  new Random();
		Random ran2 = new Random();
		/*generate random numbers 1-10
		 * then multiply by 10
		 * to get nubmers between 1-100
		 * that are multiples of 10
		 * (e.g. 10,20,30,40,50,60,70,80,90,100)
		 */
		this.arrivalTime = ran1.nextInt(10)*10;
		this.runTime = ran2.nextInt(10)*10;
		
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter how many jobs: ");
		int input = scan.nextInt();
		Jobs[] jobs = new Jobs[input];
		for (int i = 0; i < input; i++){
			jobs[i] = new Jobs();
		}
		SJF sjf = new SJF(jobs);
		FIFO fifo = new FIFO(jobs);
		
		fifo.start();
		sjf.start();
		
	}

}
