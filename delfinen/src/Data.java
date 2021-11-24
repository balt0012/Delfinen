public class Data {
    private Member[] bestButterfly;
    private Member[] bestCrawl;
    private Member[] bestBackcrawl;
    private Member[] bestBreaststroke;
    private Team seniorTeam;
    private Team juniorTeam;
    private Trainer[] Trainers;
    private Compatition[] compatitions;
    private TrainingSchedual[] trainingScheduals;

    public Member[] getBestButterfly() {
        return bestButterfly;
    }

    public void setBestButterfly(Member[] bestButterfly) {
        this.bestButterfly = bestButterfly;
    }

    public Member[] getBestCrawl() {
        return bestCrawl;
    }

    public void setBestCrawl(Member[] bestCrawl) {
        this.bestCrawl = bestCrawl;
    }

    public Member[] getBestBackcrawl() {
        return bestBackcrawl;
    }

    public void setBestBackcrawl(Member[] bestBackcrawl) {
        this.bestBackcrawl = bestBackcrawl;
    }

    public Member[] getBestBreaststroke() {
        return bestBreaststroke;
    }

    public void setBestBreaststroke(Member[] bestBreaststroke) {
        this.bestBreaststroke = bestBreaststroke;
    }

    public Team getSeniorTeam() {
        return seniorTeam;
    }

    public void setSeniorTeam(Team seniorTeam) {
        this.seniorTeam = seniorTeam;
    }

    public Team getJuniorTeam() {
        return juniorTeam;
    }

    public void setJuniorTeam(Team juniorTeam) {
        this.juniorTeam = juniorTeam;
    }

    public Trainer[] getTrainers() {
        return Trainers;
    }

    public void setTrainers(Trainer[] trainers) {
        Trainers = trainers;
    }

    public Compatition[] getCompatitions() {
        return compatitions;
    }

    public void setCompatitions(Compatition[] compatitions) {
        this.compatitions = compatitions;
    }

    public TrainingSchedual[] getTrainingScheduals() {
        return trainingScheduals;
    }

    public void setTrainingScheduals(TrainingSchedual[] trainingScheduals) {
        this.trainingScheduals = trainingScheduals;
    }
}
