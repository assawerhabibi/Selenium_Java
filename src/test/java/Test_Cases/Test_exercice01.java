package Test_Cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_exercice01 {
	@Test
	public void test_endToend() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/admin/");
		// login
		WebElement user = driver.findElement(By.name("username"));
		user.clear();
		user.sendKeys("demo");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("demo");
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		// WebElement Btn=driver.findElement(By.cssSelector(".btn-close"));
		// Btn.click();
		// WebElement Btn=driver.findElement(By.xpath(".//button[@class='btn-close']"));
		// Btn.click();

		// pour gérer l'affichage de la modal
		if (driver.findElement(By.cssSelector(".btn-close")).isDisplayed()) {
			WebElement Btn = driver.findElement(By.cssSelector(".btn-close"));
			Btn.click();
		}
		// Valider l'affichage du bouton Logout

		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='d-none d-md-inline']")).isDisplayed());
		// gérer les clients
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']/li[1]/a")).click();
		Thread.sleep(4000);
		// affichage du nombre de pages
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end' ]")).getText();
		System.out.println(text);
		// extractionà partir du text la valeur numérique
		// conversion de notre entier de type primitif en objet Integer qui contient des
		// methodes comme parseInt
		// qui va considérer une chaine de caractère comme un nombre mais la chaine
		// contient ègalement des caractère alpha numérique. .
		// pour la nettoyer substing récupère uniquement la partie du text qui est après
		// la parenthèse+1 et pour éliminer la parenthèse on met -1
		int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

		// String S="25";
		// int i=Integer.parseInt(S)+10;
		// System.out.println(i);
		// driver.quit();

		// parcourir les pages et afficher les informations(3champs)
		for (int i = 1; i < 6; i++) {
			if (total_pages > 1) {
				WebElement page_number = driver
						.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=" + i + "]"));
				System.out.println(" le numéro de page est :" + page_number.getText());
				page_number.click();
				Thread.sleep(2000);
			}
			// récupérer les valeurs du client et email et le status
			int nombre_ligne = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
			System.out.println("le nombre de lignes  de la tables est:" + nombre_ligne);
			for (int j = 1; j < nombre_ligne; j++) {
				String nom_client = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+j+"]/td[2]")).getText();
				String email_client = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+j+"]/td[3]")).getText();
				String Statut_client = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+j+"]/td[5]")).getText();
				System.out.println(nom_client + " " + email_client + " " + Statut_client);
			}
		}
		driver.quit();
	}
}
