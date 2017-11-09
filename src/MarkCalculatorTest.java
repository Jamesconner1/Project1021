import java.util.Arrays;

/**
 * Created by samueleldred on 09/11/2017.
 */
public class MarkCalculatorTest {

    public static void main(String[] args) {
        int[][] results = {
                {10, 20}, // CSC1021
                {20, 30}, // CSC1022
                {40, 50}, // CSC1023 // coursework only
                {40, 50}, // CSC1024
                {50, 60}, // CSC1025
                {60, 70}, // CSC1026
        };
        int[] expectedMarks = {15, 26, 40, 45, 58, 67};
        testComputeMarksReturnsExpected(results, expectedMarks);

        int[] moduleMarks = {15, 36, 30, 45, 58, 36};
        String[] expectedResults = {"Fail", "Fail", "Fail", "Pass", "Pass", "Compensatable Fail"};
        testComputeModuleResultsReturnsExpected(moduleMarks, expectedResults);

        String[] moduleResults = {"Fail", "Fail", "Fail", "Pass", "Pass", "Compensatable Fail"};
        testComputeStageResultReturnsExpected(moduleResults, "Fail");

        moduleResults = new String[] {"Pass", "Pass", "Compensatable Fail", "Pass", "Pass", "Compensatable Fail"};
        testComputeStageResultReturnsExpected(moduleResults, "Pass By Compensation");

        moduleResults = new String[] {"Pass", "Pass", "Pass", "Pass", "Pass", "Pass"};
        testComputeStageResultReturnsExpected(moduleResults, "Pass");

        // end to end!
        testComputeResultReturnsExpected(results, "Fail");

        // let's try for a pass this time...
        int[][] moreResults = {
                {40, 50}, // CSC1021
                {50, 60}, // CSC1022
                {50, 40}, // CSC1023 // coursework only
                {40, 50}, // CSC1024
                {50, 60}, // CSC1025
                {60, 70}, // CSC1026
        };
        testComputeResultReturnsExpected(moreResults, "Pass");
    }

    private static void testComputeMarksReturnsExpected(int[][] results, int[] expectedMarks) {
        IMarkCalculator mc = new MarkCalculator();
        int[] marks = mc.computeMarks(results);
        System.out.println(Arrays.toString(marks));
        // Disclaimer: this is a horrible way to test things - JUnit would be much nicer!
        for (int i = 0; i < marks.length; i++) {
            assert marks[i] == expectedMarks[i] : String.format("Expected %s but found %s", expectedMarks[i], marks[i]);
        }
    }

    private static void testComputeModuleResultsReturnsExpected(int[] moduleMarks, String[] expectedResults) {
        IMarkCalculator mc = new MarkCalculator();
        // have to cast because this method isn't in the interface
        String[] moduleResults = ((MarkCalculator) mc).computeModuleResults(moduleMarks);
        System.out.println(Arrays.toString(moduleResults));
        for (int i = 0; i < moduleResults.length; i++) {
            assert moduleResults[i].equals(expectedResults[i]) : String.format("Expected %s but found %s", expectedResults[i], moduleResults[i]);
        }
    }

    private static void testComputeStageResultReturnsExpected(String[] moduleResults, String expectedResult) {
        IMarkCalculator mc = new MarkCalculator();
        String result = ((MarkCalculator) mc).computeStageResult(moduleResults);
        System.out.println(result);
        assert result.equals(expectedResult) : String.format("Expected %s but found %s", expectedResult, result);
    }

    private static void testComputeResultReturnsExpected(int[][] results, String expectedResult) {
        IMarkCalculator mc = new MarkCalculator();
        String result = mc.computeResult(results);
        System.out.println(result);
        assert result.equals(expectedResult) : String.format("Expected %s but found %s", expectedResult, result);
    }
}
