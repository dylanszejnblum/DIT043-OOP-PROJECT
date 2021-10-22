package exceptions;

public class EmptyIdException extends RuntimeException{
    public EmptyIdException(){
        super("No employees registered yet.");
    }
}
