package com.yinheng.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
//新建git 仓库，并删除

public class FireFoxTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");

        //打开浏览器，进入网页
        WebDriver driver = new FirefoxDriver();
        driver.get("https://github.com/");

        //最大化窗口
        driver.manage().window().maximize();
        sleep(2000);

        //打开登录界面
        driver.findElement(By.linkText("Sign in")).click();
        sleep(2000);
        //输入用户名
        driver.findElement(By.id("login_field")).sendKeys("yinheng");
        //输入密码
        driver.findElement(By.id("password")).sendKeys("yinheng11");
        //登录
        driver.findElement(By.name("commit")).click();

        //新建仓库
        driver.findElement(By.className("boxed-group-action")).click();
        //输入仓库名称
        driver.findElement(By.id("repository_name")).sendKeys("FireboxTest1");
        //输入仓库描述
        driver.findElement(By.id("repository_description")).sendKeys("Firebox test by Selenium3");
        //选择public
        driver.findElement(By.id("repository_public_true")).click();
        //选择private
        driver.findElement(By.id("repository_public_false")).click();
        //选择public
        driver.findElement(By.id("repository_public_true")).click();

        //勾选readme
        driver.findElement(By.id("repository_auto_init")).click();

        //选择add .gitignore
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/form/div[4]/ul/li[1]/div")).click();
        //选择Android
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/form/div[4]/ul/li[1]/div/div/div/div[3]/div[1]/div[5]")).click();

        //选择add a license
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/form/div[4]/ul/li[2]/div/button")).click();
        //选择阿帕奇
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/form/div[4]/ul/li[2]/div/div/div/div[3]/div[1]/div[2]")).click();

        //点击create按钮
        driver.findElement(By.className("first-in-line")).click();

        //点击Settings
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/nav/a[4]")).click();

        //下拉到网页底部，直到找到delete
        while (true) {

            Actions down = new Actions(driver);
            down.sendKeys(Keys.DOWN).perform();

            try {
                //点击delete按钮
                driver.findElement(By.cssSelector("div.Box:nth-child(15) > ul:nth-child(1) > li:nth-child(4) > button:nth-child(1)")).click();
                break;
            } catch (Throwable e) {
                e.printStackTrace();
            }

        }

        //输入待删除的仓库名称
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[10]/ul/li[4]/div/div/div/div/div[2]/form/p/input")).sendKeys("FireboxTest");
        //点击确认删除按钮
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[10]/ul/li[4]/div/div/div/div/div[2]/form/button")).click();


        //关闭浏览器
        driver.close();
    }


}
