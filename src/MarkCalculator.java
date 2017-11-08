public class MarkCalculator {

	public static int[] computeMarks(int[][] studentResults) { // created a
																// method with
																// will return
																// an array of
																// module marks

		int[] weighting = new int[] { 50, 40, 0, 50, 20, 35 }; // an array to
																// store the
																// coursework
																// weighting
																// values for
																// each module
		int[] moduleMarks = new int[6]; // An array of integers which store the
		int finalModuleMark = 0;

		for (int i = 0; i < studentResults.length; i++) {

			int coursework = studentResults[i][0];
			int exam = studentResults[i][1];

			// TODO: Fix this
			finalModuleMark = (int) ((((coursework * weighting[i]) + (exam * (100 - weighting[i]))) / 100) + 0.5);

			if (exam >= 35 && coursework >= 35) {
				moduleMarks[i] = finalModuleMark;
			}

			else if (exam < 35 || coursework < 35) {
				moduleMarks[i] = Math.min(35, finalModuleMark);
			}
		}

		return moduleMarks;

	}

	public String computeResult(int[][] studentResults) { // created a
																	// method
																	// that will
																	// return a
																	// stage
																	// result
		int[] moduleMarks = computeMarks(studentResults);
		boolean[] coreModule = new boolean[] { true, true, false, true, true, true };
		String[] moduleResults = new String[6];
		//double stageAverage = 0;
		String stageResult = "";
		int compFail = 0;
		int fail = 0;

		for (int i = 0; i < 6; i++) {

			if (moduleMarks[i] >= 40) {
				moduleResults[i] = "Pass";
			} else if (moduleMarks[i] < 40 && moduleMarks[i] >= 35 && coreModule[3] != false) {
				moduleResults[i] = "Compensatable Fail";
				
			} else {
				moduleResults[i] = "Fail";
			}
		}
		
		for (int i = 0; i < 6; i++) {

			if (moduleResults[i].equals("Compensatable Fail")) {
				compFail++;
			}
			else if(moduleResults[i].equals("Compensatable Fail")) {
				fail++;
		}
			
			
		if (compFail >= 2 && fail == 0){
			stageResult = "Pass By Compensation";
		}
		else if (compFail > 2 || fail > 0){
			stageResult = "Fail";
		}
		else{
			stageResult = "Pass";
		}
		
		
		
		
		

	}
		return stageResult;

}}

