package org.cejug.hurraa;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Simple servlet to change locale.
 * 
 * @author eprogramming
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/loc")
public class ChangeLocaleServlet extends HttpServlet {

    private static final String LOC = "loc";
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        System.out.println(req.getParameter(LOC));
        
        Locale loc = new Locale(req.getParameter(LOC));
        HttpSession session = req.getSession(); 
        Config.set(session, Config.FMT_FALLBACK_LOCALE, loc);
        Config.set(session, Config.FMT_LOCALE, loc);
        res.sendRedirect(req.getContextPath());
    }

}
