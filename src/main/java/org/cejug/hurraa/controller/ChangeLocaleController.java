package org.cejug.hurraa.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

/**
 * 
 * @author eprogramming
 * @author Efraim Gentil (efriam.gentil@gmail.com)
 */
@Controller
public class ChangeLocaleController {
    
    
    @Path("/change-location/{locationName}")
    public void changeLocale(String locationName , Result result, HttpSession session , HttpServletRequest request ){
        Locale locale = new Locale( locationName );
        Config.set( session, Config.FMT_FALLBACK_LOCALE, locale);
        Config.set (session, Config.FMT_LOCALE, locale);
        redirectBack(result , request);
    }
    
    public void redirectBack( Result result, HttpServletRequest request ){
        String urlToGoBack = request.getHeader("Referer"); //Get the url that originated the request
        if(urlToGoBack != null)
            result.redirectTo( urlToGoBack );
        else
            result.redirectTo( IndexController.class ).index();
    }
    
}
