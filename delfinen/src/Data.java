import java.util.ArrayList;

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


    //doesnt work just a placeholder
    public static int nextMemberID(){
        return 1;
    }

    public static void addToMembers(Member newMember){
        members.add(newMember);
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

    public static Member[] getBestButterfly() {
        return bestButterfly;
    }

    public static void setBestButterfly(Member[] bestButterfly) {
        this.bestButterfly = bestButterfly;
    }

    public static Member[] getBestCrawl() {
        return bestCrawl;
    }

    public static void setBestCrawl(Member[] bestCrawl) {
        this.bestCrawl = bestCrawl;
    }

    public static Member[] getBestBackcrawl() {
        return bestBackcrawl;
    }

    public static void setBestBackcrawl(Member[] bestBackcrawl) {
        this.bestBackcrawl = bestBackcrawl;
    }

    public static Member[] getBestBreaststroke() {
        return bestBreaststroke;
    }

    public static void setBestBreaststroke(Member[] bestBreaststroke) {
        this.bestBreaststroke = bestBreaststroke;
    }

    public static Team getSeniorTeam() {
        return seniorTeam;
    }

    public static void setSeniorTeam(Team seniorTeam) {
        this.seniorTeam = seniorTeam;
    }

    public static Team getJuniorTeam() {
        return juniorTeam;
    }

    public static void setJuniorTeam(Team juniorTeam) {
        this.juniorTeam = juniorTeam;
    }

    public static Trainer[] getTrainers() {
        return trainers;
    }

    public static void setTrainers(Trainer[] trainers) {
        trainers = trainers;
    }

    public static Competition[] getCompetitions() {
        return competitions;
    }

    public static void setCompetitions(Competition[] competitions) {
        this.competitions = competitions;
    }

    public static TrainingSchedual[] getTrainingScheduals() {
        return trainingScheduals;
    }

    public static void setTrainingScheduals(TrainingSchedual[] trainingScheduals) {
        this.trainingScheduals = trainingScheduals;
    }

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public static void setMembers(ArrayList<Member> members) {
        Data.members = members;
    }
}