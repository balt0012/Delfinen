import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Data {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Member> bestButterfly = new ArrayList<>();
    private static ArrayList<Member> bestCrawl = new ArrayList<>();
    private static ArrayList<Member> bestBackcrawl = new ArrayList<>();
    private static ArrayList<Member> bestBreaststroke = new ArrayList<>();
    private static ArrayList<Team> seniorTeam = new ArrayList<>();
    private static ArrayList<Team> juniorTeam = new ArrayList<>();
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static ArrayList<Competition> competitions = new ArrayList<>();


    public static void addToMembers(Member newMember){
        members.add(newMember);
        try {
            File newFile = new File("members/" + newMember.getName() + ".csv");
            if (!newFile.createNewFile()) {
                System.out.println("file has been overridden");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("members/" + newMember.getName() + ".csv");
            //toString is to be added
            writer.write(newMember.toString());
            writer.close();
            System.out.println("new member has been added!");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static int getExpectedIncome(){
        int expectedIncome = 0;
        for(Member member : members){
            if (!member.PriceYearlyIsPaid()){
                expectedIncome += member.getPriceYearly();
            }
        }
        return expectedIncome;
    }

    public static int getMembersInDebt(){
        int membersInDebt = 0;
        for(Member member : members){
            if (!member.PriceYearlyIsPaid()){
                membersInDebt++;
            }
        }
        return membersInDebt;
    }

    public static void registerPayment(String memberID) {
        boolean matchIsFound = false;

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberID().equals(memberID)) {
                matchIsFound = true;
                members.get(i).setPriceYearlyIsPaid(true);
                System.out.println("Payment on " + members.get(i).getPriceYearly() + " dkk from " + members.get(i).getName() + "has been registered.");
                break;
            }
        }
        if (!matchIsFound) {
            System.out.println("Error. Invalid memberID.");
        }
    }


    public static ArrayList<Member> getMembers() {

        return members;
    }

    public static void setMembers(ArrayList<Member> members) {
        Data.members = members;
    }

    public static void addCoaches() {
        boolean loop = true;
        int numberOfCoachesToAdd = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount of coaches you would like to add");

        while (loop) {
            System.out.println(">");
            try {
                numberOfCoachesToAdd = scanner.nextInt();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Input must be a number with no decimals.");
            }
        }

        for (int i = 0; i < numberOfCoachesToAdd; i++) {
            trainers.add(Trainer.createTrainer());
        }
    }

    public static ArrayList<Trainer> getTrainers() {
        return trainers;
    }


}