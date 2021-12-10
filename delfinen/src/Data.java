import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Data {
    // Lavet af Balthazarr
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<CompetitiveSwimmer> competitiveSwimmers = new ArrayList<>();
    private static Team seniorTeam;
    private static Team juniorTeam;
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static ArrayList<Competition> competitions = new ArrayList<>();
    private static ArrayList<Training> trainings = new ArrayList<>();


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

    public static Team receiveTeam() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String userInputTeam;
        Team team = null;

        System.out.println("Please enter the team:\n 1 - Junior Team\n 2 - Senior Team");

        while (loop) {
            System.out.print(">");
            userInputTeam = scanner.nextLine();

            if (userInputTeam.equals("1")) {
                team = juniorTeam;
                loop = false;
            } else if (userInputTeam.equals("2")) {
                team = seniorTeam;
                loop = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return team;
    }

    public static String receiveMemberID() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        boolean matchIsFound = false;
        String userInputID = null;

        System.out.println("Please enter the ID of the customer: ");

        for (int i = 0; i < members.size(); i++) {
            System.out.println("Name: " + members.get(i).getName() + " ID: " + members.get(i).getMemberID());
        }
        while (loop) {
            System.out.print(">");
            userInputID = scanner.nextLine();

            for (int i = 0; i < members.size(); i++) {
                if (userInputID.equals(members.get(i).getMemberID())) {
                    matchIsFound = true;
                    loop = false;
                    break;
                }
            }
            if (!matchIsFound) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return userInputID;
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

    public static void addCoaches() {
        boolean loop = true;
        int numberOfCoachesToAdd = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount of coaches you would like to add");

        while (loop) {
            System.out.print(">");
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

    public static void addMemberToTeam(Team seniorTeam, Team juniorTeam, CompetitiveSwimmer competitiveSwimmer) {
        if (competitiveSwimmer.getAge() > 18 ) {
            seniorTeam.getRoster().add(competitiveSwimmer);
        } else {
            juniorTeam.getRoster().add(competitiveSwimmer);
        }
    }

    public static void addTraining(Training training) {
        trainings.add(training);
    }

    public static ArrayList<Member> getMembers() { return members; }

    public static void setSeniorTeam(Team team) {
        seniorTeam = team;
    }

    public static void setJuniorTeam(Team team) {
        juniorTeam = team;
    }

    public static Team getSeniorTeam() {
        return seniorTeam;
    }

    public static Team getJuniorTeam() {
        return juniorTeam;
    }

    public static ArrayList<Competition> getCompetitions() {
        return competitions;
    }

    public static ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public static ArrayList<CompetitiveSwimmer> getCompetitiveSwimmers() {
        return competitiveSwimmers;
    }

    public static void setMembers(ArrayList<Member> members) {
        Data.members = members;
    }
}