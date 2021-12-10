import java.util.Scanner;

public class Controller {
    private ActiveDisciplinesClub activeDisciplinesClub = new ActiveDisciplinesClub();
    private DataGetTopFive dataGetTopFive = new DataGetTopFive();


    public void programSetup() {
        // team and coaches should be created first before main menu.
        Data.addCoaches();
        Data.setJuniorTeam(Team.createTeam("Junior team"));
        Data.setSeniorTeam(Team.createTeam("Senior team"));
    }

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        int menuOption;
        do {
            System.out.println("what do you want to do? (1.economy 2.member management 3. Training and Competition management)");
            menuOption = scanner.nextInt();
            if (menuOption == 1) {
                economicMenu();
            } else if (menuOption == 2) {
                memberManagementMenu();
            } else if (menuOption == 3){
                trainingAndCompetitionMenu();
            }

            else if (menuOption != 0){
                System.out.println("invalid input");
            }
        } while (menuOption != 0);
    }

    public void economicMenu(){
        Scanner scanner = new Scanner(System.in);
        int menuOption;
        do {
            System.out.println("what do you want to do? \n1 - Expected income.\n2 - Members in debt\n3 - Register Payment)");
            menuOption = scanner.nextInt();
            if (menuOption == 1) {
                System.out.println(Data.getExpectedIncome());
            } else if (menuOption == 2) {
                System.out.println(Data.getMembersInDebt());
            } else if (menuOption == 3){
                Data.registerPayment(Data.receiveMemberID());
            } else if (menuOption != 0) {
                System.out.println("invalid input");
            }
        } while (menuOption != 0);
    }

    public void memberManagementMenu(){
        Scanner scanner = new Scanner(System.in);
        int menuOption;
        do {
            System.out.println("what do you want to do?\n1 - create member.\n2 - Edit member.\n3 - Create competitive swimmer.\n4 - view team rosters\n 0 - Back to Main menu.");
            menuOption = scanner.nextInt();
            if (menuOption == 1) {
                Member.createMember();
            } else if (menuOption == 2){
                Member.editMember();
            } else if (menuOption == 3) {
                CompetitiveSwimmer competitiveSwimmer = CompetitiveSwimmer.createCompetitiveSwimmer();
                competitiveSwimmer.addSwimmerToDiscipline(activeDisciplinesClub);
            } else if (menuOption == 4){
                System.out.println("Junior team:");
                Data.getJuniorTeam().viewRoster();
                System.out.println("Senior team");
                Data.getSeniorTeam().viewRoster();
            } else if (menuOption != 0){
                System.out.println("invalid input");
            }
        } while (menuOption != 0);
    }

    public void trainingAndCompetitionMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String menuOption;

        System.out.println("What would you like to do?\n1 - Register Training\n2 - Register Competition\n0 - Back to main menu.");

        while (loop) {
            System.out.println(">");
            menuOption = scanner.nextLine();

            if (menuOption.equals("1")) {
                Training training = new Training(activeDisciplinesClub.inputDiscipline(), Data.receiveTeam());
                Data.addTraining(training);
                training.showTraining();
            } else if (menuOption.equals("2")) {
                Competition competition = new Competition(activeDisciplinesClub.inputDiscipline(), activeDisciplinesClub, dataGetTopFive);
                Data.getCompetitions().add(competition);
                competition.showSwimmers();
            } else if (menuOption.equals("0")) {
                loop = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
