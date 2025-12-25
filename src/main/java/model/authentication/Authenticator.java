package model.authentication;

public abstract class Authenticator {
    public final boolean authenticate(String username, String password) {
        if (isLoginExists(username)) {
            String storedPassword = getPassword(username);
            return storedPassword != null && storedPassword.equals(password);
        }
        return false;
    }

    protected abstract boolean isLoginExists(String username) ;

    protected abstract String getPassword(String username) ;

    protected abstract boolean register(String username, String password) ;
}


// ici ça utilise bien le patron Template Method mais va relire pourquoi