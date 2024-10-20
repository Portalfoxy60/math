package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] animals = {"крысы", "коровы", "тигра", "зайца", "дракона", "змеи", "лошади", "овцы", "обезьяны", "курицы", "собаки", "свиньи"};
        String[] colors = {"зеленой", "красной", "желтой", "белой", "черной"};
        System.out.print("Введите год для определения по восточному календарю: ");
        int year = scanner.nextInt();
        int offset = year - 1984;
        int animalIndex = offset % 12;
        if (animalIndex < 0) animalIndex += 12;
        int colorIndex = (offset % 10) / 2;
        if (colorIndex < 0) colorIndex += 5;
        System.out.println("Год " + colors[colorIndex] + " " + animals[animalIndex]);
        Random random = new Random();
        int correctAnswers = 0;
        for (int i = 1; i <= 5; i++) {
            int a = random.nextInt(9) + 1;
            int b = random.nextInt(9) + 1;
            System.out.print("Пример " + i + ": Сколько будет " + a + " * " + b + "? ");
            int userAnswer = scanner.nextInt();
            int correctAnswer = a * b;
            if (userAnswer == correctAnswer) {
                System.out.println("\u001B[32mПравильно\u001B[0m");
                correctAnswers++;
            } else {
                System.out.println("\u001B[31mОшибка\u001B[0m. Правильный ответ: " + correctAnswer);
            }
        }
        System.out.println("Правильных ответов: " + correctAnswers);
        if (correctAnswers == 5) {
            System.out.println("Молодец!");
        } else if (correctAnswers >= 3) {
            System.out.println("Надо бы еще поучить.");
        } else {
            System.out.println("Срочно нужно учить таблицу умножения.");
        }
    }
}
