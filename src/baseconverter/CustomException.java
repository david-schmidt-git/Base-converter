package baseconverter;

public class CustomException extends Exception{
    /**
     * Creates a {@link CustomException} object with a custom <i>localizedMessage</i>
     * 
     * @param msg The error message String of the exception
     * @see Exception
     */
    public CustomException(String msg){
        super(msg);
    }

}
