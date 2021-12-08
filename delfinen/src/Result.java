public class Result
{
    private double competitionTime;
    private String discipline;
    private CompetitiveSwimmer competitiveSwimmer;

    public Result(CompetitiveSwimmer competitiveSwimmer, String discipline)
    {
        this.competitionTime = new UserInputTime().receiveTime();
        this.discipline = discipline;
        this.competitiveSwimmer = competitiveSwimmer;
    }


}
