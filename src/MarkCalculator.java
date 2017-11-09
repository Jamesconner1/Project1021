public class MarkCalculator {

	public static int[] computeMarks(int[][] studentResults) { // created a method which will return an array of module marks using marks inputed by the user
																
		int[] weighting = new int[] { 50, 40, 0, 50, 20, 35 }; // an array to store the course-work weighting values for each module																
		int[] moduleMarks = new int[6]; // An array of integers which store the final module marks
		int finalModuleMark = 0; // Initialising an final module mark integer enabling me to use it in a calculation later on.

		for (int i = 0; i < studentResults.length; i++) { // creating a for loop for the student marks calculation

			int coursework = studentResults[i][0]; // creating an integer from the input given by the user in the first column.
			int exam = studentResults[i][1]; // creating an integer from the input given by the user in the second column.

			finalModuleMark = (int) ((((coursework * weighting[i]) + (exam * (100 - weighting[i]))) / 100.0) + 0.5); // calculation to work out the final module mark from the given exam and coursework marks against the weighting

			if (exam >= 35 && coursework >= 35) { // if both the exam and course-work mark are above 35 then the final module mark is their mark
				moduleMarks[i] = finalModuleMark;
			}

			else if (exam < 35 || coursework < 35) { //if either of the mark are below 35 then the maximum mark you can obtain is 35
				moduleMarks[i] = Math.min(35, finalModuleMark);
			}
		}

		return moduleMarks; // returns an array with the students final module marks to the summary class

	}

	public static String computeResult(int[][] studentResults) { // created a method that will return a stage result using the final module marks
		
		int[] moduleMarks = computeMarks(studentResults); // creates an array from the module marks calculated in the method 'computeMarks'
		boolean[] coreModule = new boolean[] { true, false, true, true, true, true }; // creating a boolean array to work out if a module is core or not
		String[] moduleResults = new String[6]; // created an array which stores what mark the student got for each one of the 6 modules
		String stageResult = ""; // Initialising a string variable which will store the students overall grade
		int compFail = 0; // Initialising an integer which works as a count for the about of fails by compensation the student got
		int fail = 0; // Initialising an integer which works as a count for the about of fails the student got

		for (int i = 0; i < 6; i++) { // a for loop to calculate the result of each module and store it in the 'moduleResult' array, if the student get a Compensatable Fail or fail then their respective counters will increase by 1 

			if (moduleMarks[i] >= 40) {
				moduleResults[i] = "Pass";
			} else if (moduleMarks[i] < 40 && moduleMarks[i] >= 35 && coreModule[i] == true) {
				moduleResults[i] = "Compensatable Fail";
				compFail++;
			} else if (moduleMarks[i] < 35 || coreModule[i] == false) {
				moduleResults[i] = "Fail";
				fail++;
			}
		}

		if (compFail <= 2 && fail == 0) { // if statement to calculate the stage result, if the student gets less than for equal to two compensatiable fails and no fails then they pass by compensation
			stageResult = "Pass By Compensation";
		} else if (compFail > 2 || fail > 0) { // if they score 1 or more fails or more than 2 compensatable fails then the fail the stage
			stageResult = "Fail";
		} else {
			stageResult = "Pass"; // anything else then they pass the stage
		}

		return stageResult; // returns a string with the students stage result to the summary class

	}
}
