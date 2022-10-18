package cheetos.main.auth.exception;

public class TokenValidFailedException extends RuntimeException{

    public TokenValidFailedException() {
        super("Falied to generate Token.");
    }

    private TokenValidFailedException(String message) {
        super(message);
    }
}
