package com.example.demo.society_app;

public class viewanno {

    public String date;
    public String topic;
    public String time;

    public viewanno() {
    }

    public viewanno(String date, String topic, String time) {
        this.date = date;
        this.topic = topic;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
