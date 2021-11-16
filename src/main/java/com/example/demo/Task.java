package com.example.demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

  /*
  Zwróć listę aktywnych graczy posortowanych po ich wyniku malejąco
   */

    public static List<Person> getActivePlayersByScoreDesc(List<Person> people) {
        List<Person> people2 = new ArrayList<>();
        try {
            Field active = Person.class.getDeclaredField("active");
            active.setAccessible(true);
            Field score = Person.class.getDeclaredField("score");
            score.setAccessible(true);
            people2 = people.stream().filter(person -> {
                boolean act = false;
                try {
                    act = (boolean) active.get(person);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return act;
            }).sorted(Comparator.comparing(person ->{
                int value = 0;
                try {
                    value = ((Integer) score.get(person)).compareTo((Integer) score.get(person));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return value;
            } ).reversed()).collect(Collectors.toList());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return people2;
    }

  /*
  Zwróć listę aktywnych graczy z danej grupy posortowanych po ich wyniku malejąco
   */

    public static List<Person> getActivePlayersByScoreDesc(List<Person> people, Group group) {
        List<Person> people2 = new ArrayList<>();
        try {
            Field active = Person.class.getDeclaredField("active");
            active.setAccessible(true);
            Field score = Person.class.getDeclaredField("score");
            score.setAccessible(true);
            Field team = Person.class.getDeclaredField("group");
            team.setAccessible(true);
            people2 = people.stream().filter(person -> {
                boolean act = false;
                try {
                    act = (boolean) active.get(person);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return act;
            }).filter(person -> {
                boolean grp = false;
                try {
                    Group group1 = (Group) team.get(person);
                    grp = group1.equals(group);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return grp;
            }).sorted(Comparator.comparing(person ->{
                int value = 0;
                try {
                    value = ((Integer) score.get(person)).compareTo((Integer) score.get(person));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return value;
            } ).reversed()).collect(Collectors.toList());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return people2;
    }

    /*
    Zwróć grupę, która posiada najwyższy wynik. Jeżeli wynik wielu grup jest taki sam, zwróć tę, która ma mniejszą liczbę aktywnych członków.
    Jeżeli ta liczba jest również równa, zwróć którąkolwiek z nich.
     */
    public static Group getGroupWithHighestScore(List<Person> people) {
        throw new RuntimeException("Not Implemented!");
    }

  /*
  Zwróć listę wyników posortowaną malejąco na podstawie ilości punktów per zespół.
  Pojedynczy String powinien mieć format: "NazwaGrupy CałkowityWynik (lista_aktywnych_członków) [ilość nieaktywnych członków]"
   */

    public static List<String> printPoints(List<Person> people) {
        throw new RuntimeException("Not Implemented!");
    }
}
