import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@RunWith(JUnit4.class)
public class NewSeleneseIT {
    
    private static WebDriver driver = null;
    
    @BeforeClass
    public static void inicializarDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rafael\\Downloads\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver", "R:\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    
    @AfterClass
    public static void liquidarDriver() {
        driver.quit();
    }
    
    @Test
    public void testAgregarEquipo() {

        driver.get("http://localhost:8080/KoreanoSpringMVCMaven/");
        
        WebElement btnAgregar = driver.findElement(By.id("agregar"));
        btnAgregar.click();
        
        ExpectedCondition<Boolean> pageLoadCondition = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        
        wait.until(pageLoadCondition);
        
        WebElement nombre = driver.findElement(By.id("nombre"));
        nombre.sendKeys("Equipo 4");
        WebElement marca = driver.findElement(By.id("marca"));
        marca.sendKeys("Mazda");
        WebElement modelo = driver.findElement(By.id("modelo"));
        modelo.sendKeys("2");
        
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();
        
        WebElement mensaje = driver.findElement(By.className("uk-alert-danger"));
        wait.until(ExpectedConditions.visibilityOf(mensaje));
        
        Assert.assertEquals("Se ha agregado el equipo correctamente", mensaje.getText());

    }
    
    @Test
    public void testEditarEquipo() {

        driver.get("http://localhost:8080/KoreanoSpringMVCMaven/editar-equipo.htm?codEquipo=10");        
        
        WebDriverWait wait = new WebDriverWait(driver, 5);        
        
        WebElement nombre = driver.findElement(By.id("nombre"));
        nombre.sendKeys(" - Editado");  
        WebElement marca = driver.findElement(By.id("marca"));
        marca.sendKeys(" - Editado");
        WebElement modelo = driver.findElement(By.id("modelo"));
        modelo.sendKeys(" - Editado");
        
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();
        
        WebElement mensaje = driver.findElement(By.className("uk-alert-danger"));
        wait.until(ExpectedConditions.visibilityOf(mensaje));
        
        Assert.assertEquals("Se ha editado el equipo correctamente", mensaje.getText());

    }
    
    @Test
    public void testEliminarEquipo() {

        driver.get("http://localhost:8080/KoreanoSpringMVCMaven/eliminar-equipo.htm?codEquipo=16");
        
        WebDriverWait wait = new WebDriverWait(driver, 10);        
        
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();
        
        WebElement mensaje = driver.findElement(By.className("uk-alert-danger"));
        wait.until(ExpectedConditions.visibilityOf(mensaje));
        
        Assert.assertEquals("Se ha eliminado el equipo correctamente", mensaje.getText());

    }
    
}
