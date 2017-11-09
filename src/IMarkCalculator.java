public interface IMarkCalculator {

    /**
     * Returns an array of module marks based on the given array of student results.
     *
     * @param studentResults an n x 2 array with coursework marks at index 0 and exam marks at index 1.
     * @return an array of module marks of length n
     */
    int[] computeMarks(int[][] studentResults);

    /**
     * Returns an array of module marks based on the given array of student results.
     *
     * @param studentResults an n x 2 array with coursework marks at index 0 and exam marks at index 1.
     * @return an overall result: "Pass", "Fail" or "Pass By Compensation"
     */
    String computeResult(int[][] studentResults);
}