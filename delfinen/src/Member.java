import java.util.ArrayList;

public class Member {
    private double priceYearly;
    private boolean priceYearlyIsPaid;
    private boolean isActive;
    private int age;
    private String memberID;
    private String name;
    private boolean isPricePaid;
    private ArrayList<Result> results = new ArrayList<>();

    public Member(int age, String memberID, boolean isActive, String name) {
        this.age = age;
        this.memberID = memberID;
        this.isActive = isActive;
        this.name = name;
        setPriceYearly();
    }

    public void setPriceYearly() {
        // sets price based on active status and age.
        if (!isActive) {
            priceYearly = 500;
        } else if (age < 0) {
            System.out.println("Age can't be below zero.");
        } else if (age < 18) {
            priceYearly = 1000;
        } else if (age < 60) {
            priceYearly = 1600;
        } else if (age > 60) {
            priceYearly = 1600*0.75;
        }
    }

    public boolean GetIsActive() {
        return isActive;
    }

    public void setActive(boolean status) {
        isActive = status;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getPriceYearly() {
        return priceYearly;
    }

    public boolean PriceYearlyIsPaid() {
        return priceYearlyIsPaid;
    }

    @Override
    //to be added
    public String toString() {
        return "new member";
    }
}
