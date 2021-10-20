package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        String text = "Solemos utilizar diariamente este elemento, pero si nos preguntarán ¿Qué es Internet? " +
                "¿Crees que serías capaz de responderlo? " +
                "La verdad que son pocas las personas que saben lo que realmente es Internet, " +
                "la utilizan diariamente, a veces todo el día o por muchas horas, pero pocos tienen claro, " +
                "o saben decir que Internet es un conjunto descentralizado de redes de comunicación interconectadas.";

        // Чистая функция - детерминирована и без побочных эффектов
        Function<String, ArrayList<String>> function = x -> new ArrayList<String>(Arrays.asList(x.split("[ ,.?!;:¿\n\r]")));

        List<String> dictionary = function.apply(text);

        // Монада
        // Но так как нужен вывод словаря, то есть побочный эффект - операция вывода
        dictionary.stream()
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}
