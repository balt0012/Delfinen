import java.util.Scanner;

public class UI {

    public static void programSetup() {
        // team and coaches should be created first before main menu.
        Data.addCoaches();
        Data.setJuniorTeam(Team.createTeam("Junior Team"));
        Data.setSeniorTeam(Team.createTeam("Senior Team"));
    }

    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        int menuOption;
        do {
            System.out.println("what do you want to do? (1.economy 2.member management)");
            menuOption = scanner.nextInt();
            if (menuOption == 1) {
                economicMenu();
            } else if (menuOption == 2) {
                memberManagementMenu();
            } else if (menuOption != 0){
                System.out.println("invalid input");
            }
        } while (menuOption != 0);
    }

    public static void economicMenu(){
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

    public static void memberManagementMenu(){
        Scanner scanner = new Scanner(System.in);
        int menuOption;
        do {
            System.out.println("what do you want to do? (1.add member 2.edit member 3.add result )");
            menuOption = scanner.nextInt();
            if (menuOption == 1) {
                Member.createMember();

            } else if (menuOption == 2){
                Member.editMember();
            } else if (menuOption == 3){

            } else if (menuOption != 0){
                System.out.println("invalid input");
            }
        } while (menuOption != 0);
    }

    public static void trainingAndCompetitionMenu(ActiveDisciplinesClub activeDisciplinesClub) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String menuOption;

        System.out.println("What would you like to do?\n1 - Register Training\n2 - Register Competition");

        while (loop) {
            System.out.println(">");
            menuOption = scanner.nextLine();

            if (menuOption.equals("1")) {

                Data.addTraining(new Training(activeDisciplinesClub.inputDiscipline(), Data.receiveTeam()));
                loop = false;

            } else if (menuOption.equals("2")) {
                // insert method for creating competition here
                loop = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }

        }



    }
}
