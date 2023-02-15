package MyFirstPackage;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

public class SuperApp_QATestGilbert {
	
	// Fungsi yang digunakan untuk melakukan delay selama 3 detik
		static void Wait_Tiga_Detik() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
					
				e.printStackTrace();
			}
		}
		
	// Fungsi yang digunakan untuk melakukan delay selama 10 detik
		static void Wait_LimaBelas_Detik() {
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
						
				e.printStackTrace();
			}
		}
	
	public static void main(String[] args) {
        
		//Mempersiapkan Selenium Webdriver agar dapat dijalankan pada browser 
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// Lalu menuju ke halaman Create Akun Cermati
        String baseUrl = "https://www.saucedemo.com/";
       
        driver.get(baseUrl);

        // Memanggil fungsi delay selama 3 detik agar halaman website terbuka terlebih dahulu
        Wait_LimaBelas_Detik();
        
        // Mengisi Username
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input")).sendKeys("standard_user");
        
        // Mengisi Password
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[2]/input")).sendKeys("secret_sauce");
        
        // Menekan tombol Login
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/input")).click();
        
        Wait_Tiga_Detik();
        
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = "";
        
        actualURL = driver.getCurrentUrl();
        
        // Lalu melakukan verifikasi apakah sudah berhasil login atau belum menggunakan Title website
        if (expectedURL.contentEquals(actualURL)){
        	System.out.println("User sudah login ke application");
        }
        else {
        	System.out.println("User masih belum login ke application");
        }
        
        // Menekan filter barang
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select")).click();
        
        // Menekan pilihan filter barang - sort harga dari yang tertinggi
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select/option[4]")).click();
        
        String Hargatertinggiexpected = "$49.99";
        
        String Hargatertinggiactual = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div")).getText();
        
        // Lalu melakukan verifikasi apakah sort barang tertinggi sudah berhasil atau belum
        // Dengan melakukan pemeriksaan apakah barang pertama di list sudah memiliki harga tertinggi (49.99)
        if (Hargatertinggiexpected.contentEquals(Hargatertinggiactual)){
        	System.out.println("Filter barang dari harga tertinggi sudah benar");
        }
        else {
        	System.out.println("Filter barang dari harga tertinggi salah");
        }
        
        Wait_Tiga_Detik();
        
        String HargaBarangPertamaExpected = "$49.99";
        String NamaBarangPertamaExpected = "Sauce Labs Fleece Jacket";
        
        // Menekan hyperlink dari barang pertama
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a")).click();
        
        String NamaBarangPertamaActual = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[1]")).getText();
        String HargaBarangPertamaActual = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[3]")).getText();
        
        // Lalu melakukan verifikasi detail barang yang di-klik
        // mulai dari nama produk hingga harga produk
        if (HargaBarangPertamaExpected.contentEquals(HargaBarangPertamaActual)){
        	if(NamaBarangPertamaExpected.contentEquals(NamaBarangPertamaActual)) {
        		System.out.println("Proses verifikasi produk pertama sudah benar yaitu Sauce Labs Fleece Jacket dengan harga $49.99");
        	}
        	
        }
        else {
        	System.out.println("Proses verifikasi produk pertama masih salah");
        }
        
        //Menekan tombol add to cart
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/button")).click();
        
        //Lalu menekan tombol cart di sebelah atas menu
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        
        //Menekan tombol checkout
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]")).click();
        
        //Mengisi first name di verifikasi halaman checkout dengan data asal
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Test");
        
        //Mengisi last name di verifikasi halaman checkout dengan data asal
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("Test");
        
        //Mengisi ZIP Code di verifikasi halaman checkout dengan data asal
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys("123");
        
        Wait_Tiga_Detik();
        
        //Menekan tombol continue
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input")).click();
        
        // Menekan tombol Finish
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]/button[2]")).click();
        
        boolean TombolBacktohome = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button")).isDisplayed();
        
        if (TombolBacktohome == true) {
        	System.out.println("Status order sudah dikirim");
        }
        else
        {
        	System.out.println("Status order tidak berhasil dikirim");
        }
        
        Wait_LimaBelas_Detik();
	
        // Lalu menutup Selenium Webdriver
        driver.close();
	}
}
