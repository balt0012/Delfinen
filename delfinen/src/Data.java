import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public static void setMembers(ArrayList<Member> members) {
        Data.members = members;
    }
}