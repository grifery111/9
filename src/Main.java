import java.io.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String filename = "9.txt";
        try {
            double sum = 0.0;
            int count = 0;
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                try {
                    String[] parts = line.split(",");
                    for (String part : parts) {
                        double number = Double.parseDouble(part.trim());
                        sum += number;
                        count++;
                    }
                } catch (NumberFormatException e) {
                    throw new func("Неверный формат чисел в файле.");
                }
                line = reader.readLine();
            }
            reader.close();

            if (count > 0) {
                double average = sum / count;
                System.out.println("Сумма чисел: " + sum);
                System.out.println("Среднее значение: " + average);
            } else {
                throw new func("В файле не найдено чисел");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка чтение файла: " + e.getMessage());
        } catch (func e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
class func extends Exception {
    public func(String message) {
        super(message);
    }
}