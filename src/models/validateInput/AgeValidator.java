package models.validateInput;

import utility.Console;
/**
 * Класс для запрашивания возраста с клавиатуры
 * @author Arseniy Rubtsov
*/

public class AgeValidator {
    /**
     * @param console
     * @see Console
     * @return long age
    */
    public static long validateAge(Console console) {
        long age;
        while(true) {
            console.print("enter <long> age > 0: ");
            String line = console.readln().trim();
            if (!line.isEmpty()) {
                try {
                    age = Long.parseLong(line);
                    break;
                }catch (NumberFormatException exception) {}
            }
        }
        return age;
    }
}
