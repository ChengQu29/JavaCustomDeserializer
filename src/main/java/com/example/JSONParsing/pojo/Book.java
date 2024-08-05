package com.example.JSONParsing.pojo;

import java.util.Date;

public class Book {
    private String title;
    private boolean inPrint;
    private Date publishDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isInPrint() {
        return inPrint;
    }

    public void setInPrint(boolean inPrint) {
        this.inPrint = inPrint;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}
