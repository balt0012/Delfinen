public class Compatition {
    private String name;
    //it might be better to have a result class with WHAT member, the result and their time. While competition is the actual competition itself.
    private double competitionTime;
    private Member[] competitors;

    public Compatition(String name, double competitionTime)
    {
        this.name = name;
        this.competitionTime = competitionTime;
    }
}

