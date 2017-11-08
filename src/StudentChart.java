
public class StudentChart {
	public StudentChart(int[][] results) {
		draw(MarkCalculator.computeMarks(results));

	}

	public void draw(int[] moduleMarks) { // a method which draws this bars based off values in an array
		
		Bar x = new Bar();
		x.makeVisible();
		x.changeSize(200, 5);
		x.changeColour(Colour.BLACK);
		x.moveVertical(200);	
		
		Bar y = new Bar();
		y.makeVisible();
		y.changeSize(5, 200);
		y.changeColour(Colour.BLACK);
		
		int xPosition = 5;
		int xDistance = 23;
	
		for (int i = 0; i < moduleMarks.length; i++){
			
			Bar j = new Bar();
			j.makeVisible();
			j.moveHorizontal(xPosition);
			xPosition += xDistance;
			j.changeSize(20, moduleMarks[i]);
			j.moveVertical(200 - moduleMarks[i]);
			
			if (moduleMarks[i] > 70){
				j.changeColour(Colour.MAGENTA);
			}
			else if(moduleMarks[i] >= 40){
				j.changeColour(Colour.GREEN);
			}
			else if(moduleMarks[i] < 40 && moduleMarks[i] > 35){
				j.changeColour(Colour.YELLOW);
			}
			else{
				j.changeColour(Colour.RED);
			}
		}
		
		
	}
	
	public void printSummary(int[] moduleMarks) { // prints a table of returned marks corresponding to the chart
		String[] moduleNames = {"CSC1021", "CSC1022", "CSC1023", "CSC1024", "CSC1025", "CSC1026"};
		System.out.println("     " + "Module" + "     " + "Mark"+ "     ");
		System.out.println("--------------------------------------------");
		
		for (int i = 0; i < moduleMarks.length; i++){
			System.out.println(moduleMarks[i]);
		}
	}

}
