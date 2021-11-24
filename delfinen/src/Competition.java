public class Competition {

    private String name;
    private Member[] competitors;
    private Result[] results;
    private int competitionCounter;
    private int resultCounter;

    public Competition(String name, double competitionTime)
    {
        this.name = name;
        this.competitors = new Member[5];
        this.results = new Result[5];
        this.competitionCounter  = 0;
        this.resultCounter = 0;
    }

    public void addCompetitor(Member competitor){
        if(competitionCounter <= 4){
            competitors[competitionCounter] = competitor;
            competitionCounter++;
        }
    }
    public void addResult(Result result){
        if(resultCounter <= 4){
            results[resultCounter] = result;
            resultCounter++;
        }
    }
}


