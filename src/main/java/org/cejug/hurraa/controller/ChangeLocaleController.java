package org.cejug.hurraa.controller;

import java.util.Locale;

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
    public void changeLocale(String locationName , Result result, HttpSession session ){
        Locale locale = new Locale( locationName );
        Config.set(session, Config.FMT_FALLBACK_LOCALE, locale);
        Config.set(session, Config.FMT_LOCALE, locale);
        result.redirectTo( IndexController.class).index();
    }
    
}
