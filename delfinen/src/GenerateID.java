import java.util.Random;

public class GenerateID {
    // lavet af Carl.

    public static String generateID() {
        // can be used for coaches and members.
        Random random = new Random();
        boolean loop = true;
        int lengthID = 5;
        String id = "#";
        String charactersID = "123456789abc";
        char[] charactersIDAsChars = charactersID.toCharArray();


        while (loop) {

            for (int i = 0; i < lengthID; i++) {
                id += charactersIDAsChars[random.nextInt(charactersID.length())];
            }
            if (!checkForDuplicates(id)) {
                loop = false;
            }
        }
        return id;
    }

    public static boolean checkForDuplicates(String id) {
        boolean isADuplicate = false;
        boolean isADuplicateMembers = false;
        boolean isADuplicateTrainers = false;

        for (int i = 0; i < Data.getMembers().size(); i++) {
            if (id.equals(Data.getMembers().get(i).getMemberID())) {
                isADuplicateMembers = true;
                break;
            }
        }
        for (int i = 0; i < Data.getTrainers().size(); i++) {
            if (id.equals(Data.getTrainers().get(i).getTrainerID())) {
                isADuplicateTrainers = true;
            }
        }

        if (isADuplicateMembers || isADuplicateTrainers) {
            isADuplicate = true;
        }
        return isADuplicate;
    }

}
