package net.zirtrex.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import net.zirtrex.dao.EquipoDao;
import net.zirtrex.entity.Equipo;
import net.zirtrex.form.ValidationEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EquipoController {
    
    private ValidationEquipo equipoValidation;     
    
    @Autowired
    @Qualifier("edao")
    EquipoDao edao;
    
    public EquipoController(){
        this.equipoValidation = new ValidationEquipo(); 
        WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
        //this.edao = (EquipoDao) ctx.getBean("edao");
    }
    
    @RequestMapping(value="index.htm", method = RequestMethod.GET)
    public String index(ModelMap model){
        List equipos = edao.obtenerEquipos();
        model.addAttribute("equipos", equipos);
        return "index";
    }
    
    @RequestMapping(value="agregar-equipo.htm", method = RequestMethod.GET)
    public String mostrarAgregarForm(ModelMap model) {
        model.addAttribute("equipo", new Equipo());
        return "agregar-equipo";
    }
    
    @RequestMapping(value="procesar-equipo.htm", method = RequestMethod.POST)
    public String procesarAgregarForm(/*@Valid*/ @ModelAttribute("equipo") @Validated Equipo equipoIn, BindingResult result, ModelMap model) {
        
        this.equipoValidation.validate(equipoIn, result);
        if (result.hasErrors()) {
            return "agregar-equipo";
        }else{
            int insert = edao.guardarEquipo(equipoIn);
            if(insert > 0){
                model.addAttribute("message", "Se ha agregado el equipo correctamente");
                model.addAttribute("equipoIn", equipoIn);
                return "agregar-equipo";
            }else{
                model.addAttribute("message", "Ha ocurrido un error");
                return "agregar-equipo";
            }
        }
    }
    
    @RequestMapping(value="editar-equipo.htm", method = RequestMethod.GET)
    public String mostrarEditarForm(HttpServletRequest request, Model model) {
            int codEquipo = Integer.parseInt(request.getParameter("codEquipo"));
            Equipo e = edao.obtenerEquipo(codEquipo);
            if(e != null){
                model.addAttribute("equipo", e);
                return "editar-equipo";
            }else{
                model.addAttribute("equipo", new Equipo());
                return "agregar-equipo";
            }
    }
    
    @RequestMapping(value="editar-equipo.htm", method = RequestMethod.POST)
    public String procesarEditarForm(/*@Valid*/ @ModelAttribute("equipo") @Validated Equipo equipoIn, BindingResult result, Model model) {
        
        this.equipoValidation.validate(equipoIn, result);
        if (result.hasErrors()) {
            return "editar-equipo";
        }else{
            int insert = edao.actualizarEquipo(equipoIn);
            if(insert > 0){
                model.addAttribute("message", "Se ha editado el equipo correctamente");
                model.addAttribute("equipoIn", equipoIn);
                return "editar-equipo";
            }else{
                model.addAttribute("message", "Ha ocurrido un error");
                return "editar-equipo";
            }
        }
    }
    
    @RequestMapping(value="eliminar-equipo.htm", method = RequestMethod.GET)
    public String mostrarEliminarForm(HttpServletRequest request, Model model) {
            int codEquipo = Integer.parseInt(request.getParameter("codEquipo"));
            Equipo e = edao.obtenerEquipo(codEquipo);
            if(e.getCodEquipo() != 0){
                model.addAttribute("equipo", e);
                return "eliminar-equipo";
            }else{
                model.addAttribute("equipo", new Equipo());
                return "agregar-equipo";
            }
    }
    
    @RequestMapping(value="eliminar-equipo.htm", method = RequestMethod.POST)
    public String procesarEliminarForm(/*@Valid*/ @ModelAttribute("equipo") @Validated Equipo equipoIn, BindingResult result, Model model) {
        
        //this.equipoValidation.validate(equipoIn, result);
        if (result.hasErrors()) {
            return "eliminar-equipo";
        }else{
            int insert = edao.eliminarEquipo(equipoIn);
            if(insert > 0){
                model.addAttribute("message", "Se ha eliminado el equipo correctamente");
                model.addAttribute("equipoIn", equipoIn);
                return "eliminar-equipo";
            }else{
                model.addAttribute("message", "Ha ocurrido un error");
                return "eliminar-equipo";
            }
        }
    }
}
