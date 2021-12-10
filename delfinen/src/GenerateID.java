import java.util.Random;

public class GenerateID {

    public static String generateID() {
        Random random = new Random();
        int lengthID = 5;
        String id = "#";
        String charactersID = "123456789abc";
        char[] charactersIDAsChars = charactersID.toCharArray();

        for (int i = 0; i < lengthID; i++) {
            id += charactersIDAsChars[random.nextInt(charactersID.length())];
        }

        return id;
    }
}
