package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.MealServiceIml;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by root on 13.09.2016.
 */
public class EditMealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(EditMealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isAddMealAction = new Boolean(req.getParameter("addMeal"));
        if (isAddMealAction) req.getRequestDispatcher("/addMeal.jsp").forward(req, resp);

        Boolean isEditMealAction = new Boolean(req.getParameter("editMeal"));
        if (isEditMealAction) {
            int id = Integer.parseInt(req.getParameter("id"));
            MealService mealService = new MealServiceIml();
            req.setAttribute("meal", mealService.getMeal(id));
            req.getRequestDispatcher("/editMeal.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isAddMealAction = new Boolean(req.getParameter("addMeal"));
        if (isAddMealAction) addMeal(req, resp);

        Boolean isEditMealAction = new Boolean(req.getParameter("editMeal"));
        if (isEditMealAction) editMeal(req, resp);
    }

    private void editMeal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String description = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));
        LocalDateTime dateTime = TimeUtil.parseLocalDateTime(req.getParameter("dateTime"));

        MealService mealService = new MealServiceIml();
        mealService.updateMeal(new Meal(id, dateTime, description, calories));

        resp.sendRedirect("meal");
    }

    private void addMeal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String description = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));
        LocalDateTime dateTime = TimeUtil.parseLocalDateTime(req.getParameter("dateTime"));

        MealService mealService = new MealServiceIml();
        mealService.addMeal(new Meal(-1, dateTime, description, calories));

        resp.sendRedirect("meal");
    }
}
