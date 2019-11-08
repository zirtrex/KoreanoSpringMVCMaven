package net.zirtrex.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import junit.framework.TestCase;
import net.zirtrex.dao.EquipoDao;
import net.zirtrex.entity.Equipo;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(locations={"classpath*:**/applicationContext.xml", "classpath*:**/dispatcher-servlet.xml"})
//@ContextConfiguration({"classpath*:**/dispatcher-servlet.xml"})
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
//@WebAppConfiguration
public class EquipoControllerTest {
    
    //private MockMvc mockMvc;
    
    //@Autowired
    //private WebApplicationContext wac;
    
    @Mock
    EquipoDao service;
    
    @InjectMocks
    EquipoController equipoController;
    
    @Spy
    List equipos = new ArrayList<Equipo>();
    
    @Spy
    ModelMap model;
    
    @Mock
    BindingResult result;
    
    @BeforeClass
    public void setUp() throws Exception {
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        // this must be called for the @Mock annotations above to be processed.
        MockitoAnnotations.initMocks(this);
        equipos = getEquipoList();
    }
    
    public List getEquipoList(){
        Equipo e = new Equipo();
        e.setCodEquipo(1);
        //e.setNombre("Axel");
        //e.setMarca("Mazda");
        e.setModelo("3");
         
        equipos.add(e);
        //equipos.add(e);
        return equipos;
    }
    
    /*@Test
    public void configTest() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        //Assert.assertNotNull(wac.getBean("equipoController"));
    }*/
    
    /**
     * Test of index method, of class EquipoController.
     */
    /*@Test
    public void testIndex() throws Exception{
        
        this.mockMvc.perform(get("/index.htm"))
                .andExpect(status().isOk())
                .andDo(print());
        
    }*/
    
    @Test
    public void testIndex() throws Exception{        
        when(service.obtenerEquipos()).thenReturn(equipos);
        Assert.assertEquals(equipoController.index(model), "index");
        Assert.assertEquals(model.get("equipos"), equipos);
        verify(service, atLeastOnce()).obtenerEquipos();        
    }

    /**
     * Test of mostrarAgregarForm method, of class EquipoController.
     */
    @Test
    public void testMostrarAgregarForm() {
        Assert.assertEquals(equipoController.mostrarAgregarForm(model), "agregar-equipo");
        Assert.assertNotNull(model.get("equipo"));
        Assert.assertEquals(((Equipo) model.get("equipo")).getCodEquipo(), 0);
    }

    /**
     * Test of procesarAgregarForm method, of class EquipoController.
     */
    @Test
    public void testProcesarAgregarForm() {
        when(result.hasErrors()).thenReturn(true);
        when(service.guardarEquipo((Equipo)equipos.get(0))).thenReturn(1);
        Assert.assertEquals(equipoController.procesarAgregarForm( (Equipo) equipos.get(0), result, model), "agregar-equipo");
        Assert.assertEquals(model.get("message"), "Se ha agregado el equipo correctamente");
    }

    /**
     * Test of mostrarEditarForm method, of class EquipoController.
     */
    /*public void testMostrarEditarForm() {
        System.out.println("mostrarEditarForm");
        HttpServletRequest request = null;
        Model model = null;
        EquipoController instance = new EquipoController();
        String expResult = "";
        String result = instance.mostrarEditarForm(request, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of procesarEditarForm method, of class EquipoController.
     */
    /*public void testProcesarEditarForm() {
        System.out.println("procesarEditarForm");
        Equipo equipoIn = null;
        BindingResult result_2 = null;
        Model model = null;
        EquipoController instance = new EquipoController();
        String expResult = "";
        String result = instance.procesarEditarForm(equipoIn, result_2, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of mostrarEliminarForm method, of class EquipoController.
     */
    /*public void testMostrarEliminarForm() {
        System.out.println("mostrarEliminarForm");
        HttpServletRequest request = null;
        Model model = null;
        EquipoController instance = new EquipoController();
        String expResult = "";
        String result = instance.mostrarEliminarForm(request, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of procesarEliminarForm method, of class EquipoController.
     */
    /*public void testProcesarEliminarForm() {
        System.out.println("procesarEliminarForm");
        Equipo equipoIn = null;
        BindingResult result_2 = null;
        Model model = null;
        EquipoController instance = new EquipoController();
        String expResult = "";
        String result = instance.procesarEliminarForm(equipoIn, result_2, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
