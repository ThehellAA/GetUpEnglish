package com.getupenglish.servlets.administration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.getupenglish.beans.Utilisateur;

@WebServlet( "/administration" )
public class Administration extends HttpServlet {
    private static final String VUE              = "/WEB-INF/administration/cours.jsp";
    private static final String VUE_ECHEC        = "/404.jsp";
    private static final String ATT_SESSION_USER = "sessionUtilisateur";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( utilisateur != null && utilisateur.isAdmin() ) {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_ECHEC ).forward( request, response );
        }
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    }
}
