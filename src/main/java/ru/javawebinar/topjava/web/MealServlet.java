package ru.javawebinar.topjava.web;


import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.MealServiceIml;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("MealServlet doGet");
        MealService mealService = new MealServiceIml();
        List<MealWithExceed> meals = MealsUtil.getFilteredWithExceeded(mealService.getAllMeal(), LocalTime.of(0, 0), LocalTime.of(23, 0), 2000);
        req.setAttribute("meals", meals);
        req.getRequestDispatcher("/mealList.jsp").forward(req,resp);
    }
}
