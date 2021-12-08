public class Result
{
    private double competitionTime;
    private String discipline;
    private CompetitiveSwimmer competitiveSwimmer;

    public Result(CompetitiveSwimmer competitiveSwimmer, double competitionTime, String discipline)
    {
        this.competitionTime = competitionTime;
        this.discipline = discipline;
        this.competitiveSwimmer = competitiveSwimmer;
    }


}
