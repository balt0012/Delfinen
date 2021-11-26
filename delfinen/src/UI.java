import java.util.Scanner;

public class UI {
    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("what do you want to do? (1.add member 2.expected income 3.members in debt)");
        int menuOption = scanner.nextInt();
        if (menuOption == 0){

        }else if (menuOption == 1){
            addMember();
        }else if (menuOption == 2){
            System.out.println(Data.getExpectedIncome());
        }else if (menuOption == 3){

        }
    }

    public static void addMember(){
        Scanner scanner = new Scanner(System.in);
        boolean isActive = false;
        int id = Data.nextMemberID();
        String active;
        System.out.println("what is the name of the new member?");
        String name = scanner.nextLine();
        System.out.println("what is the age of the new member?");
        int age = scanner.nextInt();
        do {
            System.out.println("is the member active? (y/n)");
            active = scanner.nextLine();
            if (active.equals("y")) {
                isActive = true;
            } else if (active.equals("n")) {
                isActive = false;
            } else {
                System.out.println("invalid input");
            }
        }while (!active.equals("y") && !active.equals("n"));

        Member newMember = new Member(age, id, isActive, name);
        Data.addToMembers(newMember);
        System.out.println("new member has been added!");
    }

    public static double inputTime() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        System.out.println("Enter minutes");
        System.out.print(">");
        double timeMinutes = scanner.nextDouble();

        System.out.println("Enter seconds");
        System.out.print(">");
        double timeSeconds = scanner.nextDouble();

        return timeMinutes + (timeSeconds/100);
    }
}
