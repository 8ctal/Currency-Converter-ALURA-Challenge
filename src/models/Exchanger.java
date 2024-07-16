package models;

public class Exchanger {
    private String from;
    private String to;
    private double rate;

    public Exchanger(String from, String to, double rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public double exchange(double amount) {
        return amount * rate;
    }
}
