package PizzaG.Logic.controller;

import PizzaG.Logic.model.Pizza;
import PizzaG.Logic.service.ServPizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.*;
import java.io.IOException;

/**
 * Created by Zeit on 08.02.2017.
 * 13:14
 */
@Controller
public class LoginControl {

    private ServPizz servPizz;

    @Autowired(required = true)
    @Qualifier(value = "ServPizz")
    public void setServPizz(ServPizz servPizz) {
        this.servPizz = servPizz;
    }

    /*страница логина\пароля*/
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String CheckOut() {
        return "WEB-INF/pages/adminka/login";
    }

    /*проверка логина пароля*/
    @RequestMapping("loginCheck")
    public ModelAndView getLogin(
            @RequestParam(value = "adminlogin", required = false, defaultValue = "1") String loginA,
            @RequestParam(value = "adminpass", required = false, defaultValue = "1") String passA,
            HttpSession session, Model model) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        StandardPasswordEncoder passwordEncoder = new StandardPasswordEncoder();

        // log "admin" d0b72c39e0795c453b554be84206266db7901987c541f0e957b8f2f099ad867bd802ea5d61060c5b
        // pass "wadtlp123" 5ab813c1d616c101adbde853d659caea4fbffff24f6ccf726def7975a553003f0b50e8186ee77529

        /*String aaa = "admin";
        String hash = passwordEncoder.encode(aaa);
        System.out.println(hash);*/

        String message = "";

        boolean pass_match = passwordEncoder.matches(passA, "5ab813c1d616c101adbde853d659caea4fbffff24f6ccf726def7975a553003f0b50e8186ee77529");
        boolean login_match = passwordEncoder.matches(loginA, "d0b72c39e0795c453b554be84206266db7901987c541f0e957b8f2f099ad867bd802ea5d61060c5b");

        if (pass_match && login_match) {
            session.setAttribute("admin", "okay");

            model.addAttribute("pizza", new Pizza());
            model.addAttribute("listPizza", this.servPizz.listPizza());

            return new ModelAndView("WEB-INF/pages/adminka/pizzaAdmin");

        } else {

            message = "Проверьте правильность введенного логина/пароля";
        }
        return new ModelAndView("WEB-INF/pages/adminka/login", "result", message);
    }
}
