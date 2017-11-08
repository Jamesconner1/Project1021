import java.util.Scanner;

public class Summary {

	public static void main(String[] args) {
		
		int[][] results = studentSummary(); // creates an array where the user enters the data
		MarkCalculator mc = new MarkCalculator(); //creating a new mark calculator object
		int[]a = mc.computeMarks(results); 
		
		StudentChart sc = new StudentChart(results);
		sc.draw(a);
		sc.printSummary(a);
		

	}
	
	public static int[][] studentSummary(){
		
		
		Scanner input = new Scanner(System.in);
		String[] moduleNames = {"CSC1021", "CSC1022", "CSC1023", "CSC1024", "CSC1025", "CSC1026"};
		
		int moduleMarks[][] = new int[6][2];
	    
		for (int i = 0; i < 6; i++){						
			
			System.out.println("Module " + (moduleNames[i]));
						
			System.out.print("Coursework Mark: ");
			moduleMarks[i][0] = input.nextInt();
			
			System.out.print("Exam Mark: ");
			moduleMarks[i][1] = input.nextInt();
			
			System.out.println();
			
		}
		
		return moduleMarks;
	}
	
	
			
	

}
