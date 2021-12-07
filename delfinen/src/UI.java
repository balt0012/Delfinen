import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static void programSetup() {
        // team and coaches should be created first before main menu.
        Data.addCoaches();
        Team.createTeam("Junior Team");
        Team.createTeam("Senior Team");
        // to be continued.
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
                Data.registerPayment("Placeholder!!!!!");
                // WIP.
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
                Member.addMember();
            } else if (menuOption == 2){
                Member.editMember();
            } else if (menuOption == 3){

            } else if (menuOption != 0){
                System.out.println("invalid input");
            }
        } while (menuOption != 0);
    }
}
