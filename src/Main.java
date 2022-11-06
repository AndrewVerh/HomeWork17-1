import java.util.*;

public class Main {

    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        Map<Character, Integer> words = new HashMap<>();
        char[] charMatrix = text.toLowerCase().toCharArray();


        for (int i = 0; i < charMatrix.length; i++) {
            if (Character.isLetter(charMatrix[i])) {
                if (words.containsKey(charMatrix[i])) {
                    int quantity = words.get(charMatrix[i]);
                    quantity++;
                    words.put(charMatrix[i], quantity);
                } else {
                    words.put(charMatrix[i], 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>(words.values()); //список из значений мапы words
        int max = words.get(charMatrix[0]);
        int min = words.get(charMatrix[0]);
        for (int j : list) {
            if (j > max) {
                max = j; //Наибольшее количество раз встречается буква
            }
        }
        for (int h : list) {
            if (h < min) {
                min = h; //Наименьшее количество раз встречается буква
            }
        }

        for (Map.Entry<Character, Integer> entry : words.entrySet()) {
            if (entry.getValue() == max) {
                char maxChar = entry.getKey();
                System.out.println("Наибольшее количество раз встречается буква " + maxChar + " - " + max + " раз(а)!");
            } else if (entry.getValue() == min) {
                char minChar = entry.getKey();
                System.out.println("Наименьшее количество раз встречается буква " + minChar + " - " + min + " раз(а)!");
            }
        }
    }
}
