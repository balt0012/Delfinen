import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    private double priceYearly;
    private boolean priceYearlyIsPaid;
    private boolean isActive;
    private int age;
    private final String memberID;
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

    public String resultsToString(){
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < results.toArray().length; i++) {
            resultString.append(results.toArray()[i] + ",");
        }
        return resultString.toString();
    }

    public static void addMember(){
        Scanner scanner = new Scanner(System.in);
        boolean isActive = false;
        String id = GenerateID.generateID();
        String active;
        System.out.println("what is the name of the new member?");
        String name = scanner.nextLine();
        System.out.println("what is the age of the new member?");
        int age = scanner.nextInt();
        do {
            System.out.println("is the member active? (y/n)");
            scanner.nextLine();
            active = scanner.nextLine();
            if (active.equals("y")) {
                isActive = true;
            } else if (active.equals("n")) {
                isActive = false;
            } else {
                System.out.println("invalid input");
            }
        }while (!active.equals("y") && !active.equals("n"));

        Member newMember = new Member(age, id, isActive, name);
        Data.addToMembers(newMember);
    }

    public static void editMember(){
        //WIP
        Scanner scanner = new Scanner(System.in);
        System.out.println("which member do you want to edit:");
        for (int i = 0; i < Data.getMembers().toArray().length; i++) {
            System.out.println("\n" + (i+1) + " " + Data.getMembers().toArray()[i].toString());
        }
        Member memberToEdit = (Member) Data.getMembers().toArray()[scanner.nextInt()];
    }


    @Override
    public String toString() {
        return priceYearly + "\n" + priceYearlyIsPaid + "\n" + isActive + "\n" + age + "\n" + memberID + "\n" + name + "\n" + isPricePaid + "\n" + resultsToString();
    }

}
