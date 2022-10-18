package cheetos.main.auth.exception;

public class OAuthProviderMissMatchException extends  RuntimeException {

    public OAuthProviderMissMatchException(String message) {
        super(message);
    }
}
