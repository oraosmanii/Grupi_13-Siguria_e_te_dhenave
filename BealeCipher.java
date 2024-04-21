import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BealeCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose an option:\n1. Enter the key word or phrase manually.\n2. Provide a file as the key.\nYour choice: ");
        int choice = scanner.nextInt();

        String keyText;
        switch (choice) {
            case 1:
                System.out.print("Enter your key word or phrase: ");
                scanner.nextLine(); // Consume newline
                keyText = scanner.nextLine().toLowerCase(); // Convert to lowercase
                break;
            case 2:
                System.out.print("Enter the path to the file: ");
                scanner.nextLine(); // Consume newline
                String filePath = scanner.nextLine();
                keyText = readFromFile(filePath).toLowerCase();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return;
        }

        if (keyText.trim().isEmpty()) {
            System.out.println("Key word cannot be empty. Exiting program.");
            return;
        }

        System.out.print("Enter the text you want to encrypt: ");
        String plainText = scanner.nextLine().toLowerCase().trim();

        if (plainText.isEmpty()) {
            System.out.println("Plain text cannot be empty. Exiting program.");
            return;
        }

        String cipherText = encrypt(plainText, keyText);
        System.out.println("Encrypted Text: " + cipherText);

        System.out.print("Enter the text you want to decrypt: ");
        String cipherInput = scanner.nextLine().trim();
        String decryptedText = decrypt(cipherInput, keyText);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String plainText, String keyText) {
        Map<String, Integer> keyMap = generateKeyMap(keyText);
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)) {
                String word = "";
                while (i < plainText.length() && Character.isLetter(plainText.charAt(i))) {
                    word += plainText.charAt(i++);
                }
                Integer number = keyMap.get(word);
                if (number != null) {
                    cipherText.append(number).append(" ");
                }
            }
        }

        return cipherText.toString().trim();
    }

    public static String decrypt(String cipherText, String keyText) {
        Map<String, Integer> keyMap = generateKeyMap(keyText);
        Map<Integer, String> reverseKeyMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : keyMap.entrySet()) {
            reverseKeyMap.put(entry.getValue(), entry.getKey());
        }
        String[] cipherNumbers = cipherText.split(" ");
        StringBuilder decryptedText = new StringBuilder();

        int currentIndex = 0;
        while (currentIndex < cipherNumbers.length) {
            StringBuilder word = new StringBuilder();
            int number = Integer.parseInt(cipherNumbers[currentIndex++]);
            while (reverseKeyMap.containsKey(number)) {
                word.append(reverseKeyMap.get(number)).append(" ");
                if (currentIndex >= cipherNumbers.length) {
                    break;
                }
                number = Integer.parseInt(cipherNumbers[currentIndex++]);
            }
            decryptedText.append(word);
        }

        return decryptedText.toString().trim();
    }

    private static Map<String, Integer> generateKeyMap(String keyText) {
        Map<String, Integer> keyMap = new HashMap<>();
        String[] keyWords = keyText.split("\\. |\\s+");
        int index = 1;

        for (String word : keyWords) {
            if (!word.isEmpty() && !keyMap.containsKey(word)) {
                keyMap.put(word, index++);
            }
        }

        return keyMap;
    }

    private static String readFromFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                contentBuilder.append(scanner.nextLine());
                contentBuilder.append(" "); // Add space between lines
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return contentBuilder.toString();
    }
}

