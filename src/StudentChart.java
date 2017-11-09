
public class StudentChart {
	public StudentChart(int[][] results) {
		IMarkCalculator mc = new MarkCalculator();
		draw(mc.computeMarks(results)); // calling the draw method and passing through the returned result from the computeMarks method in the MarkCalculator class.
	}

	public void draw(int[] moduleMarks) { // a method which draws this bars based off values in an array
		
		boolean[] coreModule = new boolean[] { true, false, true, true, true, true }; // creating a boolean array to work out if a module is core or not
		
		Bar x = new Bar(); // creating an object called 'x' which will be the x axis on my graph
		x.makeVisible(); // making the object visible
		x.changeSize(200, 5); // making the object into the shape of a thin line
		x.changeColour(Colour.BLACK); // making the line black
		x.moveVertical(200); //aligning the line so it is in the correct place
		
		Bar y = new Bar(); // creating an object called 'y' which will be the y axis on my graph
		y.makeVisible(); // making the object visible
		y.changeSize(5, 200); // making the object into the shape of a thin line
		y.changeColour(Colour.BLACK); // making the line black
		
		int xPosition = 5; // Stating x position for the bars
		int xDistance = 23; // the distance the bars are moved to the right
	
		for (int i = 0; i < moduleMarks.length; i++){ // creating a for loop for creating the bars
			
			Bar j = new Bar(); // making an object j which will by the bars for each module
			j.makeVisible(); // making the bars visible
			j.moveHorizontal(xPosition); // sets the horizontal position of the bars to 'xPosition'
			xPosition += xDistance; // each time a new bar is created it adds the xDistance to the previous position.
			j.changeSize(20, moduleMarks[i]); //changing the size of the bars depending on the results
			j.moveVertical(200 - moduleMarks[i]); // changes the height of the bars depending on the marks
			
			if (moduleMarks[i] > 70){ //changes the colour of the bars depending on the result which the student got
				j.changeColour(Colour.MAGENTA);
			}
			else if(moduleMarks[i] >= 40){
				j.changeColour(Colour.GREEN);
			}
			else if(moduleMarks[i] < 40 && moduleMarks[i] > 35 && coreModule[i] == true){
				j.changeColour(Colour.YELLOW);
			}
			else{
				j.changeColour(Colour.RED);
			}
		}
		
		
	}
	
	public void printSummary(int[] moduleMarks, String stageResult) {// prints a table of returned marks corresponding to the chart and the overall stage result achieved by the student
		
		
		String[] moduleNames = {"CSC1021", "CSC1022", "CSC1023", "CSC1024", "CSC1025", "CSC1026"}; //creating an array that stores the the names of the modules being studied
		System.out.println("     " + "Module" + "  -  " + "Mark");
		System.out.println("--------------------------");
		
		for (int i = 0; i < moduleMarks.length; i++){ // for loop which display the module followed by the module mark
			System.out.println("     " + moduleNames[i] + "     " + moduleMarks[i]);			
		}
		
		System.out.println("--------------------------");
		System.out.println("The Student Has obtain an overall grade of: " + stageResult); // displays the overall grade obtained by the student
	}

	

}
