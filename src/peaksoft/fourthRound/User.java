package peaksoft.fourthRound;

public class User extends Gamer {

    public User() {
        super("User");
    }

    @Override
    public void setCheating(String cheating) {
        if (cheating.equals("Y")) {
            super.setCheating(true);
        }
    }
}
