package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.util.List;

/**
 * Created by root on 11.09.2016.
 */
public interface MealService {
    List<Meal> getAllMeal();
    void addMeal(Meal meal);
    Meal getMeal(int id);
    void deleteMeal(int id);
    void updateMeal(Meal meal);
}
