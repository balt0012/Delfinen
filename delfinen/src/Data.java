import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Data {
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
                System.out.println("File already exists");
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

    public static ArrayList<Member> getBestButterfly() {
        return bestButterfly;
    }

    public static void setBestButterfly(Member[] bestButterfly) {
        bestButterfly = bestButterfly;
    }

    public static ArrayList<Member> getBestCrawl() {
        return bestCrawl;
    }

    public static void setBestCrawl(Member[] bestCrawl) {
        bestCrawl = bestCrawl;
    }

    public static ArrayList<Member> getBestBackcrawl() {
        return bestBackcrawl;
    }

    public static void setBestBackcrawl(Member[] bestBackcrawl) {
        bestBackcrawl = bestBackcrawl;
    }

    public static ArrayList<Member> getBestBreaststroke() {
        return bestBreaststroke;
    }

    public static void setBestBreaststroke(Member[] bestBreaststroke) {
        bestBreaststroke = bestBreaststroke;
    }

    public static ArrayList<Team> getSeniorTeam() {
        return seniorTeam;
    }

    public static void setSeniorTeam(Team seniorTeam) {
        seniorTeam = seniorTeam;
    }

    public static ArrayList<Team> getJuniorTeam() {
        return juniorTeam;
    }

    public static void setJuniorTeam(Team juniorTeam) {
        juniorTeam = juniorTeam;
    }

    public static ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public static void setTrainers(Trainer[] trainers) {
        trainers = trainers;
    }

    public static ArrayList<Competition> getCompetitions() {
        return competitions;
    }

    public static void setCompetitions(Competition[] competitions) {
        competitions = competitions;
    }

    public static ArrayList<TrainingSchedual> getTrainingScheduals() {
        return trainingScheduals;
    }

    public static void setTrainingScheduals(TrainingSchedual[] trainingScheduals) {
        trainingScheduals = trainingScheduals;
    }

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public static void setMembers(ArrayList<Member> members) {
        Data.members = members;
    }
}