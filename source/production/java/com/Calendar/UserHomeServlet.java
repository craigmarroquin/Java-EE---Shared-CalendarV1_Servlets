package com.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by BHARATH on 2/26/2016.
 */
@WebServlet(name = "UserHomeServlet", urlPatterns = {"/loginsuccess","/welcome","/userhomepage"})
public class UserHomeServlet extends HttpServlet {

    private Map<Integer, event> eventDatabase = new LinkedHashMap<>();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("home");
            return;
        }

        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "create":
                this.createEvent(request, response);
                break;
            case "view":
                this.userHome(request, response);
                break;
            case "logout":
                this.userHome(request, response);
                break;
            default:
                this.userHome(request, response);
                break;

    }}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        }

        private void createEvent(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException
        {
            request.getRequestDispatcher("/WEB-INF/jsp/view/createEvent.jsp")//to create an event
                    .forward(request, response);
        }
          private void userHome(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
         {
        request.getRequestDispatcher("/WEB-INF/jsp/view/welcome.jsp")//User's Home page
                .forward(request, response);
        }
    private void logout(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {

        System.out.println("In log out");//to invalidate the session
    }




    }
