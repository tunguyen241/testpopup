package com.example.demo.creatExcelTemplate;

public class User {
    private String title;
    private String startDate;
    private String endDate;
    private String imageUrl;


    public User(String title, String startDate, String endDate, String imageUrl) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public void setTitle() {
        this.title = title;
    }

   public void setStartDate() {
        this.startDate = startDate;
   }


   public void setEndDate() {
        this.endDate = endDate;
   }


   public  void setImageUrl() {
        this.imageUrl = imageUrl;
   }
}
