package exceptions;

public class BlankNameException extends RuntimeException{
    
    public BlankNameException(){
        super("Name cannot be blank.");
    }
    
}
