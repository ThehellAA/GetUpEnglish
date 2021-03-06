package com.getupenglish.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/deconnexion" )
public class Deconnexion extends HttpServlet {
    private static final String URL_REDIRECTION = "/index.jsp";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();

        /* Redirection vers l'index */
        response.sendRedirect( request.getContextPath() + URL_REDIRECTION );
        // this.getServletContext().getRequestDispatcher(VUE).forward(request,
        // response);
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    }
}
