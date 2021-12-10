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

    public Member(double priceYearly, boolean priceYearlyIsPaid, boolean isActive, int age, String memberID, String name, boolean isPricePaid) {
        this.priceYearly = priceYearly;
        this.priceYearlyIsPaid = priceYearlyIsPaid;
        this.isActive = isActive;
        this.age = age;
        this.memberID = memberID;
        this.name = name;
        this.isPricePaid = isPricePaid;

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

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceYearly() {
        return priceYearly;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setPricePaid(boolean pricePaid) {
        isPricePaid = pricePaid;
    }

    public void setPriceYearlyIsPaid(boolean priceYearlyIsPaid) {
        this.priceYearlyIsPaid = priceYearlyIsPaid;
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
        ArrayList<String> newNames = Data.getNames();
        newNames.add(newMember.getName());
        String newNamesString = "";
        for (int i = 0; i < newNames.toArray().length; i++) {
            newNamesString = newNamesString + newNames.toArray()[i] + "\n";
        }
        Data.setNames(newNamesString);
    }

    public static void editMember(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("which member do you want to edit:");
        for (int i = 0; i < Data.getMembers().toArray().length; i++) {
            System.out.println("\n" + (i+1) + " " + Data.getMembers().toArray()[i].toString());
        }
        Member memberToEdit = (Member) Data.getMembers().toArray()[scanner.nextInt()-1];
        System.out.println(memberToEdit.getName());
        System.out.println("what do you want to edit: 1.active 2.age 3.price paid");
        int varToEdit = scanner.nextInt();
        do {
            if (varToEdit == 1){
                if(memberToEdit.getIsActive()){
                    memberToEdit.setActive(false);
                } else {
                    memberToEdit.setActive(true);
                }
                System.out.println("member activity switched");
            }else if (varToEdit == 2){
                System.out.println("what is the age of the member?");
                int age = scanner.nextInt();
                memberToEdit.setAge(age);
            }else if (varToEdit == 3){
                if(memberToEdit.isPricePaid){
                    memberToEdit.setPricePaid(false);
                    memberToEdit.setPriceYearlyIsPaid(false);
                } else {
                    memberToEdit.setPricePaid(true);
                    memberToEdit.setPriceYearlyIsPaid(true);
                }
            }
        } while (varToEdit != 0 && varToEdit != 1 && varToEdit != 2 && varToEdit != 3);
        memberToEdit.setPriceYearly();
        Data.addToMembers(memberToEdit);
    }

    @Override
    public String toString() {
        return priceYearly + "\n" + priceYearlyIsPaid + "\n" + isActive + "\n" + age + "\n" + memberID + "\n" + name + "\n" + isPricePaid + "\n" + resultsToString();
    }

}
