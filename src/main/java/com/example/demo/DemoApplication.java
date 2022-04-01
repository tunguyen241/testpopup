package com.example.demo;

import com.example.demo.function.FunctionWeb;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.FormulaEvaluator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) throws IOException {
//		SpringApplication.run(DemoApplication.class, args);
        FunctionWeb functionWeb = new FunctionWeb();
		System.out.println("Hello, World!");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "D:\\demo\\demo\\src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(options);


//		WebDriver driver = new ChromeDriver();
		driver.get("https://qc-admin.k-id.global/login");

		//login
        functionWeb.login(driver, "admin@kid.vn", "123123");

		driver.getTitle();

        //smart wait
        functionWeb.goToPopupScreen(driver);


        //Path of the excel file sheet 0
        FileInputStream fs = null;
        try {
            fs = new FileInputStream("D:\\demo\\demo\\src\\main\\resources\\document\\test.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Creating a workbook

        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

        for(int i=1;i<=rowCount;i++){

//            XSSFCell cell = sheet.getRow(1).getCell(1);
//            cell.getStringCellValue();

            //get cell count in a row
            int cellcount=sheet.getRow(i).getLastCellNum();

            //iterate over each cell to print its value
            System.out.println("Row"+ i+" data is :");

            String titleCell = sheet.getRow(i).getCell(0).getStringCellValue();
            String startDate = sheet.getRow(i).getCell(1).getStringCellValue();
            String endDate = sheet.getRow(i).getCell(2).getStringCellValue();
            String image = sheet.getRow(i).getCell(3).getStringCellValue();

            functionWeb.openCreaatePopup(driver);
            functionWeb.createPopup(driver, titleCell, image);
            functionWeb.allUser(driver);
            functionWeb.notRepeat(driver);
            functionWeb.timePicker(driver,  startDate, endDate);


            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            functionWeb.openCreaatePopup(driver);
        }



        XSSFSheet sheet1 = workbook.getSheetAt(1);
        int rowCount1 = sheet1.getLastRowNum()-sheet1.getFirstRowNum();

        for(int j=1;j<=rowCount1;j++){
            int cellcount1 = sheet1.getRow(j).getLastCellNum();

            //iterate over each cell to print its value
            System.out.println("Row"+ j+" data is :");

            String titleCell1 = sheet1.getRow(j).getCell(0).getStringCellValue();
            String startDate1 = sheet1.getRow(j).getCell(1).getStringCellValue();
            String endDate1 = sheet1.getRow(j).getCell(2).getStringCellValue();
            String image1 = sheet1.getRow(j).getCell(3).getStringCellValue();

            functionWeb.openCreaatePopup(driver);
            functionWeb.createPopup(driver, titleCell1, image1);
            functionWeb.userConditions(driver);
            functionWeb.notRepeat(driver);
            functionWeb.timePicker(driver,  startDate1, endDate1);


        }






//		driver.quit();
	}



}
