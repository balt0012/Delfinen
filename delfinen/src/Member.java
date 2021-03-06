import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    // Lavet af Carl.
    private double priceYearly;
    private boolean priceYearlyIsPaid = false;
    private boolean isActive;
    private int age;
    private final String memberID;
    private String name;
    private boolean isPricePaid;

    public Member(int age, String memberID, boolean isActive, String name) {
        this.age = age;
        this.memberID = GenerateID.generateID();
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

    /*public String resultsToString(){
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < results.toArray().length; i++) {
            resultString.append(results.toArray()[i] + ",");
        }
        return resultString.toString();
    }
    */


    public static void createMember(){
        InputCreateMember inputCreateMember = new InputCreateMember();
        Member member = new Member(inputCreateMember.receiveAge(), GenerateID.generateID(), inputCreateMember.receiveActiveStatus(), inputCreateMember.receiveName());
        Data.getMembers().add(member);
       // Data.addToMembers(member);
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

    public void setPriceYearlyIsPaid(boolean paymentStatus) {
        this.priceYearlyIsPaid = paymentStatus;
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

    public String getMemberID() {
        return memberID;
    }

    public double getPriceYearly() {
        return priceYearly;
    }

    public boolean PriceYearlyIsPaid() {
        return priceYearlyIsPaid;
    }


    @Override
    public String toString() {
        return priceYearly + "\n" + priceYearlyIsPaid + "\n" + isActive + "\n" + age + "\n" + memberID + "\n" + name + "\n" + isPricePaid;
        //resultsToString()
    }

}
