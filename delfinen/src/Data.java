import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
    private static ArrayList<TrainingSchedual> trainingScheduals = new ArrayList<>();


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
            System.out.println(">");
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

    public static void addTraining(Training training) {
        trainings.add(training);
    }


    public static ArrayList<Member> getMembers() {
        int memberAmount = 0;
        String[] memberNames = new String[1];
        ArrayList<Member> newMembers = new ArrayList<>();
        try{
            File file = new File("members/names.csv");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                memberAmount ++;
                String name = sc.nextLine();
                //System.out.println(name);
            }
            sc = new Scanner(file);
            memberNames = new String[memberAmount];
            for (int i = 0; i < memberAmount; i++) {
                memberNames[i] = sc.nextLine();
            }
        }catch(FileNotFoundException e){
            System.out.println("Could not find names");
        }
        try{
            for (int i = 0; i < memberAmount; i++) {
                File file = new File("members/" + memberNames[i] + ".csv");
                Scanner sc = new Scanner(file);
                String priceYearly = sc.nextLine();
                double priceYearlyInt = Double.parseDouble(priceYearly);
                String priceYearlyIsPaid = sc.nextLine();
                boolean priceYearlyIsPaidBoolean;
                if (priceYearlyIsPaid.equals("true")){
                    priceYearlyIsPaidBoolean = true;
                } else {
                    priceYearlyIsPaidBoolean = false;
                }
                String isActive = sc.nextLine();
                boolean isActiveBoolean;
                if (isActive.equals("true")){
                    isActiveBoolean = true;
                } else {
                    isActiveBoolean = false;
                }
                String age = sc.nextLine();
                int ageInt = Integer.parseInt(age);
                String memberId = sc.nextLine();

                String name = sc.nextLine();
                String isPricePaid = sc.nextLine();
                boolean isPricePaidBoolean;
                if (isPricePaid.equals("true")){
                    isPricePaidBoolean = true;
                } else {
                    isPricePaidBoolean = false;
                }
                Member member = new Member(priceYearlyInt, priceYearlyIsPaidBoolean, isActiveBoolean, ageInt, memberId, name, isPricePaidBoolean);
                newMembers.add(member);
                sc.close();
            }
        }catch(FileNotFoundException e){
            System.out.println("Could not find names");
        }
        setMembers(newMembers);

        return members;
    }

    public static void setMembers(ArrayList<Member> members) {
        Data.members = members;
    }
}