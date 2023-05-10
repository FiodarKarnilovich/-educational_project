package by.karnilovich.entity.order;

import by.karnilovich.entity.auto.Auto;

import java.time.LocalDate;

public class Order {

    private int id;
    private String autoBrand;
    private String autoModel;
    private LocalDate startDate;
    private LocalDate finishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public String getAutoModel() {
        return autoModel;
    }

    public void setAutoModel(String autoModel) {
        this.autoModel = autoModel;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
}
