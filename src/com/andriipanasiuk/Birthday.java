package com.andriipanasiuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Birthday {

    public static final List<String> COMMON_VALUES = new ArrayList<>(Arrays.asList(
            "любові",
            "натхнення",
            "аби мрії збувались",
            "міцного здоров'я",
            "сили",
            "радості від життя",
            "щастя",
            "хороших людей на шляху"
    ));
    public static final String TITLE = "Скріпт для привітання з Днем народження";
    public static final String WHAT_IS_NAME = "Як звати людину?";
    public static final String HOW_OLD = "Скільки років виповнюється?\n -1 якщо краще про це не згадувати";
    public static final String HOW_MANY_WISHES = "Чи будемо бажати загальноприйняті людські цінності? Скільки?" +
            "\n Від 0 до 8, 0 - не потрібно";
    public static final String I_WISH = "Бажаю тобі ";
    public static final String WHATS_IN_THE_END = "Яке закінчення оберемо?" +
            "\n1 - інтригуюче, 2 - підбадьорююче, 3 - енергійне";
    public static final String ENERGY_FINALITY = "А для того, аби простіше було здобути все те, що тобі сьогодні побажають - нехай у " +
            "тебе буде вдосталь енергії у твоєму Новому році! Тільки вперед!";
    public static final String ENCOURAGING_FINALITY = "Додай до моїх побажань те все, що тобі потрібно, і воно обов'язково у тебе буде!";
    public static final String INTRIGUING_FINALITY = "Я маю ще дещо тобі побажати, але впевнений, у твоєму наступному році це і так збудеться:)";

    public static final String INTRIGUING_TONE = "(Далі говоримо трохи інтригуючим тоном)";
    public static final String ENERGY_TONE = "(Далі говоримо дуже енергійно)";
    public static final String ENCOURAGING_TONE = "(Далі говоримо підбадьорюючи людину)";

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println(TITLE);
        System.out.println(WHAT_IS_NAME);

        String name = scanner.nextLine();

        builder.append(hiName(name));

        System.out.println(HOW_OLD);
        int age = scanner.nextInt();

        firstSentence(builder, age);

        System.out.println(HOW_MANY_WISHES);

        int countOfCommon = scanner.nextInt();

        if (countOfCommon != 0) {
            addCommonWishes(builder, countOfCommon);
        }
        System.out.println(WHATS_IN_THE_END);
        int end = scanner.nextInt();
        addEnd(builder, end);
        builder.append('\n');
        builder.append("Вітаю і гарного дня!\n");

        System.out.println(builder.toString());
    }

    private static void addEnd(StringBuilder builder, int end) {
        switch (end) {
            case 1:
                builder.append(INTRIGUING_TONE);
                builder.append('\n');
                builder.append(INTRIGUING_FINALITY);
                break;
            case 2:
                builder.append(ENCOURAGING_TONE);
                builder.append('\n');
                builder.append(ENCOURAGING_FINALITY);
                break;
            case 3:
                builder.append(ENERGY_TONE);
                builder.append('\n');
                builder.append(ENERGY_FINALITY);
        }
    }

    private static void addCommonWishes(StringBuilder builder, int countOfCommon) {
        builder.append(I_WISH);
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < countOfCommon; i++) {
            int index = random.nextInt(COMMON_VALUES.size());
            builder.append(COMMON_VALUES.get(index));
            if (i == countOfCommon - 2) {
                builder.append(" і ");
            } else if (i != countOfCommon - 1) {
                builder.append(", ");
            }
            COMMON_VALUES.remove(index);
        }
        builder.append("!\n");
    }

    private static void firstSentence(StringBuilder builder, int age) {
        builder.append("Вітаю тебе з ");
        if (age != -1) {
            builder.append(age);
            builder.append("-им ");
        }
        builder.append("Днем народження!\n");
    }

    private static String hiName(String name) {
        return String.format("Привіт %s!\n", name);
    }
}
