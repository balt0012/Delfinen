public class Result
{
    private double competitionTime;
    private String discipline;
    private int date;
    private boolean competition;

    public Result(Member competitor, double competitionTime, String discipline, int date, boolean competition)
    {
        this.competitionTime = competitionTime;
        this.discipline = discipline;
        this.date = date;
        this.competition = competition;
    }


}
