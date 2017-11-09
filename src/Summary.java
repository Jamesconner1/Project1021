import java.util.Scanner;

public class Summary {

	public static void main(String[] args) {
		
		int[][] results = studentSummary(); // creates an array where the user enters the data
		MarkCalculator mc = new MarkCalculator(); //creating a new mark calculator object
		int[]a = mc.computeMarks(results); // creating an array to store results that are returned from the MarkCalculator computeMarks method
		String stageResult = mc.computeResult(results); //creating a string for the stage result which is returned the MarkCalculator computeResult method
		
		
		
		StudentChart sc = new StudentChart(results); //creating a student chart object
		sc.draw(a); //calling the draw method and passing through the module marks array
		sc.printSummary(a, stageResult); //calling the printSummary method and passing through the module marks array and the stageResult string
		

	}
	
	public static int[][] studentSummary(){
		
		
		Scanner input = new Scanner(System.in); //creating a scanner object to detect user input
		String[] moduleNames = {"CSC1021", "CSC1022", "CSC1023", "CSC1024", "CSC1025", "CSC1026"}; //creating an array that stores the the names of the modules being studied
		
		int moduleMarks[][] = new int[6][2]; //creating an array which holds the inputed marks from the user.
	    
		for (int i = 0; i < 6; i++){	//creating a for loop
			
			
			
			System.out.println("Module " + (moduleNames[i])); // prints out a line saying what module you are entering data for
						
			System.out.print("Coursework Mark: ");
			moduleMarks[i][0] = input.nextInt(); // asks the user to enter the course-work mark for that module, and stores the data inputed into the first column. 
			
			System.out.print("Exam Mark: ");
			moduleMarks[i][1] = input.nextInt(); // asks the user to enter the exam mark for that module, and stores the data inputed into the second column. 
			
			System.out.println();
			
			if (moduleMarks[i][0] > 101 || moduleMarks[i][1] > 101 || moduleMarks[i][0] < -1 || moduleMarks[i][1] < -1){ //validation to check that the value inputed by the user is less than or equal to 100 or more than or equal to 0
				System.out.println("The students mark can't be greater than 100 or less than 0");		
				System.exit(0);
			}
			
			//TODO: Have it so when the exam mark for "CSC1023" is asked for it automatically sets the exam mark to 100 and doesn't require the user to enter anything.
//			if(i == 3){
//				moduleMarks[i][0] = input.nextInt();
//				moduleMarks[3][1] = 100;
//				continue;
//			}
			
		}
		
		return moduleMarks; //returns the module marks to the summary where is is stored in an array
	}
	
	
			
	

}
