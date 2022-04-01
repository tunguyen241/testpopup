package com.example.demo.function;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//@Service
public class FunctionWeb {
    public void login(WebDriver driver, String username, String password) {
        WebElement id = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));

        id.sendKeys(username);
        pass.sendKeys(password);

        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit' and contains(., 'Đăng nhập')]"));
        submit.click();
    }

    public void goToPopupScreen(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name = 'Banner' and contains(.,'Banner - Pop Up')]")));
        element.click();


        WebElement popup = driver.findElement(By.xpath("//a[@href='/system/banner-popup/popup']"));
        popup.click();
    }

    public void openCreaatePopup(WebDriver driver) {
        WebElement addPopup = driver.findElement(By.xpath("//button[@type = 'button' and contains(., 'Thêm popup')]"));
        addPopup.click();
    }

    public void createPopup(WebDriver driver, String titleCell, String image) {
        WebDriverWait waitTitle = new WebDriverWait(driver, 10);
        WebElement title = waitTitle.until(ExpectedConditions.elementToBeClickable(By.name("name")));
        title.sendKeys(titleCell);


        WebDriverWait waitUploadFile = new WebDriverWait(driver, 10);
        WebElement uploadFile = waitUploadFile.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        uploadFile.sendKeys(image);


        WebDriverWait waitConfirm = new WebDriverWait(driver, 10);
        WebElement confirm = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(.,'Xác nhận')]")));
        confirm.click();

        WebDriverWait waitForNav = new WebDriverWait(driver, 10);
        WebElement nav = waitForNav.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-selection__rendered' and contains(., 'Loại điều hướng')]")));
        nav.click();


        WebElement url = driver.findElement(By.xpath("//li[@role='option' and contains(., 'URL')]"));
        url.click();


        WebElement inputUrl = driver.findElement(By.name("inputUrl"));
        inputUrl.sendKeys("https://www.youtube.com/watch?v=Rrr-5-4wcEs");


        //random check radio button
        List<WebElement> listRadio = driver.findElements(By.xpath("//input[@type='radio']"));
        Random r = new Random();
        int randomValue = r.nextInt(listRadio.size());
        System.out.println(randomValue);
        listRadio.get(randomValue).click();


        WebDriverWait waitForPopupLogic = new WebDriverWait(driver, 10);
        WebElement addLogic = waitForPopupLogic.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(., 'Thêm')]")));
        addLogic.click();


    }

    public void allUser(WebDriver driver) {
        WebDriverWait waitForOppView = new WebDriverWait(driver, 10);
        WebElement oopView = waitForOppView.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-selection__rendered' and contains(., 'Đối tượng hiển thị')]")));
        oopView.click();


        WebElement allUser = driver.findElement(By.xpath("//li[@role='option' and contains(., 'Tất cả user')]"));
        allUser.click();


    }


    public void notRepeat(WebDriver driver) {
        List<WebElement> radioYesNo = driver.findElements(By.xpath("//input[@type='radio']"));
        radioYesNo.get(3).click();


        List<WebElement> btnConfirm = driver.findElements(By.xpath("//button[@type='button']"));
        btnConfirm.get(6).click();
    }


    public void timePicker(WebDriver driver, String startDate, String endDate) {
//        WebElement inputStartTime = driver.findElement(By.xpath("//input[@placeholder='Thời gian bắt đầu']"));
        WebElement inputStartTime = this.getInputElement(driver,null, "Thời gian bắt đầu", null);
        inputStartTime.click();
        String dot = startDate;
        String doe = endDate;

        WebElement inputDot = driver.findElement(By.xpath("//input[@class='ant-calendar-input ']"));


        inputDot.sendKeys(dot);

        WebElement inputEndTime = driver.findElement(By.xpath("//input[@placeholder='Thời gian Kết thúc']"));
        inputEndTime.click();

//        WebDriverWait waitForInputEndTime = new WebDriverWait(driver, 10);
//        WebElement inputEndTime = waitForInputEndTime.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Thời gian Kết thúc']")));
//        inputEndTime.click();

//


//        List<WebElement> countEndDay = driver.findElements(By.xpath("//div[@class='ant-calendar-date' and contains(.,'31')]"));
//        System.out.println(countEndDay.size());
//        for(int k = 0; k< countEndDay.size(); k++)
//        {
//            try {
//
//                countEndDay.get(k).click();
//            } catch (Exception e){
//
//            }
//        }

//        WebElement inputDoe = driver.findElement(By.xpath("//input[@class='ant-calendar-input ']"));
//        WebElement inputDoe = driver.findElement(By.xpath("//input[@class='ant-calendar-input ' and @placeholder='Thời gian Kết thúc']"));
        WebElement inputDoe = this.getInputElement(driver,"ant-calendar-input ", "Thời gian Kết thúc", null);
        inputDoe.sendKeys(doe);
//        String expectedHeading = "30/04/2022";
//        String heading = driver.findElement(By.xpath("//input[@class='ant-calendar-input ")).getText();
//        if(expectedHeading.equalsIgnoreCase(heading))
//        {
//            inputEndTime.click();
//            inputDoe.sendKeys(doe);
//        }


        WebDriverWait waitBtnSubmit = new WebDriverWait(driver, 10);
        WebElement btnSubmit = waitBtnSubmit.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        btnSubmit.click();
    }


    public void userConditions(WebDriver driver) {
        WebDriverWait waitConditions = new WebDriverWait(driver, 10);
        WebElement condition = waitConditions.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-selection__rendered' and contains(., 'Đối tượng hiển thị')]")));
        condition.click();


        WebElement userCondition = driver.findElement(By.xpath("//li[@role='option' and contains(., 'User theo điều kiện cụ thể')]"));
        userCondition.click();

    }

    public WebElement getInputElement(WebDriver driver, String className, String placeholder, String contains) {
        String query = "";
        List<String> param = new ArrayList<>();
        if (StringUtils.isNotEmpty(className)) {
            param.add(String.format("@class='%s'", className));
        }
        if (StringUtils.isNotEmpty(placeholder)) {
            param.add(String.format("@placeholder='%s'", placeholder));
        }
        if (StringUtils.isNotEmpty(contains)) {
            param.add(String.format("contains(., '%s')", contains));
        }
        query += "//input[";
        if (param.size() > 0) {
            for (String str: param){
                query += str;
                query += " and ";
            }
            query = query.substring(0, query.lastIndexOf(" and "));
            query = query + "]";
        }
        return driver.findElement(By.xpath(query.replace("[[", "[").replace("]]", "]")));
    }


}
