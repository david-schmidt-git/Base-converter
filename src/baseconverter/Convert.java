package baseconverter;

/**
 * Contains convertBetweeenBases method
 * 
 * @author David
 */

public class Convert {
    /**
     * Converts String value <i>input</i> in <i>baseFrom</i> to String value <i>result</i> in <i>baseTo</i>.
     * 
     * @param input value to be converted from <i>baseFrom</i> to <i>baseTo</i>
     * @param baseFrom base to be converted from
     * @param baseTo base to be converted to
     * @return String <i>result</i>
     * @throws CustomException if input is either empty or incorrect
     */
    public static String convertBetweenBases(String input, int baseFrom, int baseTo) throws CustomException{
        String result = "ERROR";
        try {
            result = Integer.toString(Integer.parseInt(input, baseFrom), baseTo);
        } catch (NumberFormatException e) {
            if (input.isEmpty()) {
                throw new CustomException("Please insert the value that you want\nto convert.");
            } else {
                throw new CustomException("NumberFormatException ocurred.\nPlease check your input.");
            }
        }
        return result;
    }
}
