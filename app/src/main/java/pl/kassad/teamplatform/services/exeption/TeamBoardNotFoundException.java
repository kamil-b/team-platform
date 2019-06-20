package pl.kassad.teamplatform.services.exeption;

public class TeamBoardNotFoundException extends RuntimeException {
    public TeamBoardNotFoundException(String message) {
        super(message);
    }
}
