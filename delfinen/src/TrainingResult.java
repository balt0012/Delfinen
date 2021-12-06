public class TrainingResult {
    private String discipline;
    private CompetitiveSwimmer competitiveSwimmer;
    private float time;

    public TrainingResult(String discipline, CompetitiveSwimmer competitiveSwimmer, float time) {
        this.discipline = discipline;
        this.competitiveSwimmer = competitiveSwimmer;
        this.time = time;
    }

    public String getDiscipline() {
        return discipline;
    }

    public float getTime() {
        return time;
    }

    public CompetitiveSwimmer getCompetitiveSwimmer() {
        return competitiveSwimmer;
    }
}
