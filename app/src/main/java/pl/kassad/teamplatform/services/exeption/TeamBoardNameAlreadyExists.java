package pl.kassad.teamplatform.services.exeption;

public class TeamBoardNameAlreadyExists extends RuntimeException{

    public TeamBoardNameAlreadyExists(String message) {
        super(message);
    }
}
