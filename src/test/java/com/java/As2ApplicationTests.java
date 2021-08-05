package com.java;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.java.LoadBrowser.driver;


public class As2ApplicationTests {

    @Test
    public void testUrl() {
        Assert.assertNotEquals("", driver.getCurrentUrl());
    }

    @Test
    public void testLogin() throws InterruptedException{
        driver.navigate().to("http://localhost:8080/signin");
        driver.findElement(By.xpath("/html/body/div/div/main/section/div/div[1]/div[1]/div/form/input[1]")).sendKeys("admin");
        driver.findElement(By.xpath("/html/body/div/div/main/section/div/div[1]/div[1]/div/form/input[2]")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div/div/main/section/div/div[1]/div[1]/div/form/button")).click();
        Thread.sleep(2000);
        Assert.assertEquals("http://localhost:8080/user/user", driver.getCurrentUrl());
    }

    @Test
    public void testRegister() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/signin");
        driver.findElement(By.xpath("/html/body/div/div/main/section/div/div[2]/div[1]/div/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("testAcc1");
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("testAcc1");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"userSignUp\"]/button")).click();
        Thread.sleep(2000);
        Assert.assertEquals("http://localhost:8080/user/user", driver.getCurrentUrl());
    }

}
