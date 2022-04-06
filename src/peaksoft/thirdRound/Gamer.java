package peaksoft.thirdRound;

public abstract class Gamer {

    private String name;
    private int totalPoints;
    private int prediction;
    private int dicePoints;
    private int result;

    public Gamer() {
    }

    public Gamer(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints += totalPoints;
    }

    public int getPrediction() {
        return prediction;
    }

    public void setPrediction(int prediction) {
        if (prediction < 2 || prediction > 12) {
            throw new RuntimeException("You can predict number < 12 and > 2");
        }
        this.prediction = prediction;
    }

    public int getDicePoints() {
        return dicePoints;
    }

    public void setDicePoints(int dicePoints) {
        this.dicePoints = dicePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "User{" +
                "totalPoints=" + totalPoints +
                ", prediction=" + prediction +
                ", dicePoints=" + dicePoints +
                '}';
    }
}
