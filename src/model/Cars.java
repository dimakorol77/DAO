package model;

public class Cars {
    private String mark;
    private String model;
    private int year;

    public Cars(String mark, String model, int year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
