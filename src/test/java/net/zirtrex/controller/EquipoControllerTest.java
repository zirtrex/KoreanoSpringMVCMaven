package net.zirtrex.controller;

import java.util.ArrayList;
import java.util.List;
import net.zirtrex.dao.EquipoDao;
import net.zirtrex.entity.Equipo;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.validation.BindingResult;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import javax.servlet.http.HttpServletRequest;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
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
    
    @Mock
    HttpServletRequest request;
    
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
        e.setNombre("Axel");
        e.setMarca("Mazda");
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
    public void testIndex() {        
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
    public void testProcesarAgregarFormTrue() {
        when(result.hasErrors()).thenReturn(false);
        when(service.guardarEquipo((Equipo)equipos.get(0))).thenReturn(1);
        Assert.assertEquals(equipoController.procesarAgregarForm( (Equipo) equipos.get(0), result, model), "agregar-equipo");
        Assert.assertEquals(model.get("message"), "Se ha agregado el equipo correctamente");
    }
    
    @Test
    public void testProcesarAgregarFormFalse() {
        when(result.hasErrors()).thenReturn(true);
        when(service.guardarEquipo((Equipo)equipos.get(0))).thenReturn(1);
        Assert.assertEquals(equipoController.procesarAgregarForm( (Equipo) equipos.get(0), result, model), "agregar-equipo");
        Assert.assertEquals(model.get("message"), "Validacion incorrecta");
    }
    
}
