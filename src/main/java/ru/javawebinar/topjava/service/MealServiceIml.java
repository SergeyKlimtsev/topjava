package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by root on 11.09.2016.
 */
public class MealServiceIml implements MealService {

    private static List<Meal> meals = new ArrayList<>(Arrays.asList(
            new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new Meal(2, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
            new Meal(3, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
            new Meal(4, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new Meal(5, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
            new Meal(6, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
    ));
    private static final AtomicInteger counter = new AtomicInteger(meals.size());

    @Override
    public List<Meal> getAllMeal() {
        return meals;
    }

    @Override
    public void addMeal(Meal meal) {
        meal.setId(counter.incrementAndGet());
        meals.add(meal);
    }

    @Override
    public Meal getMeal(int id) {
        return meals.stream().filter(meal -> meal.getId() == id).findFirst().get();
    }

    @Override
    public void deleteMeal(int id) {
        Iterator<Meal> iterator = meals.iterator();
        while (iterator.hasNext()) {
            Meal meal = iterator.next();
            if (meal.getId() == id) iterator.remove();
        }
    }

    @Override
    public void updateMeal(Meal meal) {
        deleteMeal(meal.getId());
        meals.add(meal);
    }
}
