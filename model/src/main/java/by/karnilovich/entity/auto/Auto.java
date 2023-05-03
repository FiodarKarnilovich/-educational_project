package by.karnilovich.entity.auto;

import by.karnilovich.entity.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Auto {

    private int id;
    private String autoBrand;
    private String autoModel;
    private String colourAuto;
    private String transmissionAuto;
    private Integer yearAuto;
    private Double priceAuto;
    private List<Order> orders = new ArrayList<>();

    public String getAutoModel() {
        return autoModel;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public void setAutoModel(String autoModel) {
        this.autoModel = autoModel;
    }

    public String getColourAuto() {
        return colourAuto;
    }

    public void setColourAuto(String colourAuto) {
        this.colourAuto = colourAuto;
    }

    public String getTransmissionAuto() {
        return transmissionAuto;
    }

    public void setTransmissionAuto(String transmissionAuto) {
        this.transmissionAuto = transmissionAuto;
    }

    public Integer getYearAuto() {
        return yearAuto;
    }

    public void setYearAuto(Integer yearAuto) {
        this.yearAuto = yearAuto;
    }

    public Double getPriceAuto() {
        return priceAuto;
    }

    public void setPriceAuto(Double priceAuto) {
        this.priceAuto = priceAuto;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public Auto() {
    }

    public Auto(String autoBrand, String autoModel, String colourAuto, String transmissionAuto, Integer yearAuto, Double priceAuto) {
        this.autoBrand = autoBrand;
        this.autoModel = autoModel;
        this.colourAuto = colourAuto;
        this.transmissionAuto = transmissionAuto;
        this.yearAuto = yearAuto;
        this.priceAuto = priceAuto;
    }

    public Auto(String autoModel, String colourAuto, String transmissionAuto, Integer yearAuto, Double priceAuto) {
        this.autoModel = autoModel;
        this.colourAuto = colourAuto;
        this.transmissionAuto = transmissionAuto;
        this.yearAuto = yearAuto;
        this.priceAuto = priceAuto;
    }

    @Override
    public String toString() {
        return "auto{" +
                "autoBrand='" + autoBrand + '\'' +
                ", autoModel='" + autoModel + '\'' +
                ", colourAuto='" + colourAuto + '\'' +
                ", transmissionAuto='" + transmissionAuto + '\'' +
                ", yearAuto=" + yearAuto +
                ", priceAuto=" + priceAuto +
                '}';
    }
}
