package com.example.lenovo.inter_iit;

public class channel {
    private String title;
    private String img;
    private String timing;
    private String duration;

    public channel(String title, String img, String timing, String duration) {
        this.title = title;
        this.img = img;
        this.timing = timing;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
