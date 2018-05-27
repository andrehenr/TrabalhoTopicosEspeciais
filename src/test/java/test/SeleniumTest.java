package test;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;



public class SeleniumTest {
	
	private ChromeDriverService service;
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe")).usingAnyFreePort().build();
		service.start();
	}

	@After
	public void tearDown() throws Exception {
		
		if(driver != null) {
			driver.close();
		}
		
//		if(service != null) {
//			service.stop();
//		}
	}

	@Test
	public void test() {
		
		//Declaração do driver
		driver = new ChromeDriver(service);
		
		//Acesso a home do site
		driver.navigate().to("http://localhost:8181/topicos/");
		
		//Acessando página de cadatro
		driver.findElement(By.xpath("//*[@href='CadastraEquipamento.html']")).click();
		
		//preenchendo campo nome do equipamento
		driver.findElement(By.xpath("//input[@placeholder='nome']")).sendKeys("Notebook Dell");
		
    	//preenchendo campo tipo do equipamento
		driver.findElement(By.xpath("//*[@name='tipo']")).sendKeys("Computador");
		
		//preenchendo campo peso do equipamento
		driver.findElement(By.xpath("//*[@name='peso']")).sendKeys("2500");
		
		//clicando em Cadastrar
		driver.findElement(By.xpath("//input[@value='Cadastrar']")).click();
		
		//Coletando o ID do Equipamento
		String paginaListarEq = driver.getPageSource();
		String id = paginaListarEq.substring(paginaListarEq.indexOf("ID")+4, paginaListarEq.indexOf("ID")+5);
		
		//Voltando para a home
		driver.findElement(By.linkText("Home")).click();
		
		//Entrando na página que lista equipamentos
		driver.findElement(By.linkText("Listar Equipamentos")).click();
		
		List<WebElement> listaId = driver.findElements(By.xpath("//tbody/tr/td[4]")); 
		
		for(int i=0;i<listaId.size();i++){
			if(listaId.get(i).getText().equals(id)){
				Assert.assertTrue(true);
			}
		}
	}

}
