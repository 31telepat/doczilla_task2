package com.doczilla.servlet;

import com.doczilla.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainPageServlet extends HttpServlet {

    private List<Student> studentList;

    @Override
    public void init() throws ServletException{
        studentList = new CopyOnWriteArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF8");

        final String name = req.getParameter("name");
        final String surname = req.getParameter("surname");
        final String patronymic = req.getParameter("patronymic");
        final String dateOfBornString = req.getParameter("dateOfBorn");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        Date dateOfBorn = null;
        try {
            dateOfBorn = sdf.parse(dateOfBornString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        final String group = req.getParameter("group");
        final Student student = new Student(name,surname, patronymic, dateOfBorn, group);

        studentList.add(student);
        doGet(req,resp);
    }
}
