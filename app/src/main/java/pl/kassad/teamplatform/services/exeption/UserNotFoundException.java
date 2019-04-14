package pl.kassad.teamplatform.services.exeption;

public class UserNotFoundException extends RuntimeException{

   public UserNotFoundException(String message){
        super(message);
    }
}
