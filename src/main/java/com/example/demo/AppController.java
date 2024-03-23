package com.example.demo;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        // Widoki dotyczące tabeli ze statkami --------------------------------------------
        registry.addViewController("/new_statek").setViewName("admin/new_statek");
        registry.addViewController("/save_statek").setViewName("save_statek");
        registry.addViewController("/update_statek").setViewName("update_statek");
        //---------------Widoki dotyczące marek-----------------------------------------------------------------------
        registry.addViewController("/new_marka").setViewName("admin/new_marka");
        registry.addViewController("/save_marka").setViewName("save_marka");
        registry.addViewController("/update_marka").setViewName("update_marka");
        //---------------Widoki dotyczące modeli-----------------------------------------------------------------------
        registry.addViewController("/new_moedl").setViewName("admin/new_model");
        registry.addViewController("/save_model").setViewName("save_model");
        registry.addViewController("/update_model").setViewName("update_model");
        //---------------Widoki dotyczące portów-----------------------------------------------------------------------
        registry.addViewController("/new_port").setViewName("admin/new_port");
        registry.addViewController("/save_port").setViewName("save_port");
        registry.addViewController("/update_port").setViewName("update_port");
        //---------------Widoki dotyczące pracowników-----------------------------------------------------------------------
        registry.addViewController("/new_pracownik").setViewName("admin/new_pracownik");
        registry.addViewController("/save_pracownik").setViewName("save_pracownik");
        registry.addViewController("/update_pracownik").setViewName("update_pracownik");
        //---------------Widoki dotyczące wynagrodzeń-----------------------------------------------------------------------
        registry.addViewController("/new_wynagrodzenie").setViewName("admin/new_wynagrodzenie");
        registry.addViewController("/save_wynagrodzenie").setViewName("save_wynagrodzenie");
        registry.addViewController("/update_wynagrodzenie").setViewName("update_wynagrodzenie");
        //----------------Widoki dotyczące klientów------------------------------------------------
        registry.addViewController("/update_klient").setViewName("update_klient");
    }
    //--------------------------------Zmienne klas sterujących ------------------------------------------------------------------
    @Autowired
    private StatekDAO daoStatek = new StatekDAO(new JdbcTemplate());
    @Autowired
    private PortDAO daoPort = new PortDAO(new JdbcTemplate());
    @Autowired
    private PracownikDAO daoPracownik = new PracownikDAO(new JdbcTemplate());
    @Autowired
    private MarkaDAO daoMarka = new MarkaDAO(new JdbcTemplate());
    @Autowired
    private ModelDAO daoModel = new ModelDAO(new JdbcTemplate());
    @Autowired
    private WynagrodzenieDAO daoWynagrodzenie = new WynagrodzenieDAO(new JdbcTemplate());
    @Autowired
    private KlientDAO daoKlient = new KlientDAO(new JdbcTemplate());
    // -----------------------------------------------Kontroler-------------------------------------
    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else {
                return "redirect:/index";
            }
        }
    }
    // ------------------------------------Widoki główne admina i usera -----------------------------------------------------
    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        List<Statek> listStatek = daoStatek.list();
        model.addAttribute("listStatek", listStatek);
        List<Port> listPort = daoPort.list();
        model.addAttribute("listPort", listPort);
        List<Pracownik> listPracownik = daoPracownik.list();
        model.addAttribute("listPracownik", listPracownik);
        List<Marka> listMarka = daoMarka.list();
        model.addAttribute("listMarka", listMarka);
        List<Moodel> listModel = daoModel.list();
        model.addAttribute("listModel", listModel);
        List<Wynagrodzenie> listWynagrodzenie = daoWynagrodzenie.list();
        model.addAttribute("listWynagrodzenie", listWynagrodzenie);
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        List<Port> listPort = daoPort.list();
        model.addAttribute("listPort", listPort);
        List<Statek> listStatek = daoStatek.list();
        model.addAttribute("listStatek", listStatek);
        List<Klient> listKlient = daoKlient.list();
        model.addAttribute("listKlient", listKlient);
        return "user/main_user";
    }
    //-------------------------------------------Mapowanie STATKÓW ----------------------------------------------------------------
    @RequestMapping(value={"/new_statek"})
    public String newStatek(Model model) {
        Statek statek = new Statek();
        model.addAttribute("statek", statek);
        return "admin/new_statek";
    }
    @RequestMapping(value = "/save_statek", method = RequestMethod.POST)
    public String saveStatek(@ModelAttribute("statek") Statek statek){

        daoStatek.save(statek);
        return "redirect:/main_admin";
    }
    @RequestMapping("/edit_statek/{id_statku}")
    public ModelAndView showEditFromStatek(@PathVariable(name="id_statku") int id_statku){
        ModelAndView mav = new ModelAndView("admin/edit_form_statek");
        Statek statek = daoStatek.get(id_statku);
        mav.addObject("statek",statek);
        return mav;
    }
    @RequestMapping(value = "/update_statek", method=RequestMethod.POST)
    public String updateStatek(@ModelAttribute("statek") Statek statek){
        daoStatek.update(statek);
        return "redirect:/main_admin";
    }
    @RequestMapping("/delete_statek/{id_statku}")
    public String deleteStatek(@PathVariable(name="id_statku") int id_statku){
        daoStatek.delete(id_statku);
        return "redirect:/main_admin";
    }
    //---------------------------------------Mapowanie marek---------------------------
    @RequestMapping(value={"/new_marka"})
    public String newMarka(Model model) {
        Marka marka = new Marka();
        model.addAttribute("marka", marka);
        return "admin/new_marka";
    }
    @RequestMapping(value = "/save_marka", method = RequestMethod.POST)
    public String saveMarka(@ModelAttribute("marka") Marka marka){
        daoMarka.save(marka);
        return "redirect:/main_admin";
    }
    @RequestMapping("/edit_marka/{id_marki}")
    public ModelAndView showEditFromMarka(@PathVariable(name="id_marki") int id_marki){
        ModelAndView mav = new ModelAndView("admin/edit_form_marka");
        Marka marka = daoMarka.get(id_marki);
        mav.addObject("marka",marka);
        return mav;
    }
    @RequestMapping(value = "/update_marka", method=RequestMethod.POST)
    public String updateMarka(@ModelAttribute("marka") Marka marka){
        daoMarka.update(marka);
        return "redirect:/main_admin";
    }
    @RequestMapping("/delete_marka/{id_marki}")
    public String deleteMarka(@PathVariable(name="id_marki") int id_marki){
        daoMarka.delete(id_marki);
        return "redirect:/main_admin";
    }
    //---------------------------------------Mapowanie modeli--------------------------------------------
    @RequestMapping(value={"/new_model"})
    public String newModel(Model model) {
        Moodel moodel = new Moodel();
        model.addAttribute("model", moodel);
        return "admin/new_model";
    }
    @RequestMapping(value = "/save_model", method = RequestMethod.POST)
    public String saveModel(@ModelAttribute("model") Moodel moodel){
        daoModel.save(moodel);
        return "redirect:/main_admin";
    }
    @RequestMapping("/edit_model/{id_modelu}")
    public ModelAndView showEditFromModel(@PathVariable(name="id_modelu") int id_modelu){
        ModelAndView mav = new ModelAndView("admin/edit_form_model");
        Moodel moodel = daoModel.get(id_modelu);
        mav.addObject("model",moodel);
        return mav;
    }
    @RequestMapping(value = "/update_model", method=RequestMethod.POST)
    public String updateModel(@ModelAttribute("model") Moodel moodel){
        daoModel.update(moodel);
        return "redirect:/main_admin";
    }
    @RequestMapping("/delete_model/{id_modelu}")
    public String deleteModel(@PathVariable(name="id_modelu") int id_modelu){
        daoModel.delete(id_modelu);
        return "redirect:/main_admin";
    }
    //--------------------------------------Mapowanie portów----------------------------------------------
    @RequestMapping(value={"/new_port"})
    public String newPort(Model model) {
        Port port = new Port();
        model.addAttribute("port", port);
        return "admin/new_port";
    }
    @RequestMapping(value = "/save_port", method = RequestMethod.POST)
    public String savePort(@ModelAttribute("port") Port port){
        daoPort.save(port);
        return "redirect:/main_admin";
    }
    @RequestMapping("/edit_port/{id_portu}")
    public ModelAndView showEditFromPort(@PathVariable(name="id_portu") int id_portu){
        ModelAndView mav = new ModelAndView("admin/edit_form_port");
        Port port = daoPort.get(id_portu);
        mav.addObject("port",port);
        return mav;
    }
    @RequestMapping(value = "/update_port", method=RequestMethod.POST)
    public String updatePort(@ModelAttribute("port") Port port){
        daoPort.update(port);
        return "redirect:/main_admin";
    }
    @RequestMapping("/delete_port/{id_portu}")
    public String deletePort(@PathVariable(name="id_portu") int id_portu){
        daoPort.delete(id_portu);
        return "redirect:/main_admin";
    }
    //----------------------------Mapowanie pracowników------------------------------------
    @RequestMapping(value={"/new_pracownik"})
    public String newPracownik(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);
        return "admin/new_pracownik";
    }
    @RequestMapping(value = "/save_pracownik", method = RequestMethod.POST)
    public String savePracownik(@ModelAttribute("pracownik") Pracownik pracownik){
        daoPracownik.save(pracownik);
        return "redirect:/main_admin";
    }
    @RequestMapping("/edit_pracownik/{id_pracownika}")
    public ModelAndView showEditFromPracownik(@PathVariable(name="id_pracownika") int id_pracownika){
        ModelAndView mav = new ModelAndView("admin/edit_form_pracownik");
        Pracownik pracownik = daoPracownik.get(id_pracownika);
        mav.addObject("pracownik",pracownik);
        return mav;
    }
    @RequestMapping(value = "/update_pracownik", method=RequestMethod.POST)
    public String updatePracownik(@ModelAttribute("pracownik") Pracownik pracownik){
        daoPracownik.update(pracownik);
        return "redirect:/main_admin";
    }
    @RequestMapping("/delete_pracownik/{id_pracownika}")
    public String deletePracownik(@PathVariable(name="id_pracownika") int id_pracownika){
        daoPracownik.delete(id_pracownika);
        return "redirect:/main_admin";
    }
    //------------------------Mapowanie wynagrodzeń----------------------------------------
    @RequestMapping(value={"/new_wynagrodzenie"})
    public String newWynagrodzenie(Model model) {
        Wynagrodzenie wynagrodzenie = new Wynagrodzenie();
        model.addAttribute("wynagrodzenie", wynagrodzenie);
        return "admin/new_wynagrodzenie";
    }
    @RequestMapping(value = "/save_wynagrodzenie", method = RequestMethod.POST)
    public String saveWynagrodzenie(@ModelAttribute("wynagrodzenie") Wynagrodzenie wynagrodzenie){

        daoWynagrodzenie.save(wynagrodzenie);
        return "redirect:/main_admin";
    }
    @RequestMapping("/edit_wynagrodzenie/{id_wynagrodzenia}")
    public ModelAndView showEditFromWynagrodzenie(@PathVariable(name="id_wynagrodzenia") int id_wynagrodzenia){
        ModelAndView mav = new ModelAndView("admin/edit_form_wynagrodzenie");
        Wynagrodzenie wynagrodzenie = daoWynagrodzenie.get(id_wynagrodzenia);
        mav.addObject("wynagrodzenie",wynagrodzenie);
        return mav;
    }
    @RequestMapping(value = "/update_wynagrodzenie", method=RequestMethod.POST)
    public String updateWynagrodzenie(@ModelAttribute("wynagrodzenie") Wynagrodzenie wynagrodzenie){
        daoWynagrodzenie.update(wynagrodzenie);
        return "redirect:/main_admin";
    }
    @RequestMapping("/delete_wynagrodzenie/{id_wynagrodzenia}")
    public String deleteWynagrodzenie(@PathVariable(name="id_wynagrodzenia") int id_wynagrodzenia){
        daoWynagrodzenie.delete(id_wynagrodzenia);
        return "redirect:/main_admin";
    }
    //--------------------------------Mapowanie klientów-------------------------------------------
    @RequestMapping("/edit_klient/{id_klienta}")
    public ModelAndView showEditFromKlient(@PathVariable(name="id_klienta") int id_klienta){
        ModelAndView mav = new ModelAndView("user/edit_form_klient");
        Klient klient = daoKlient.get(id_klienta);
        mav.addObject("klient",klient);
        return mav;
    }
    @RequestMapping(value = "/update_klient", method=RequestMethod.POST)
    public String updateKlient(@ModelAttribute("klient") Klient klient){
        daoKlient.update(klient);
        return "redirect:/main_user";
    }

}
