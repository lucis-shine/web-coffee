package POJO;

public class CoffeePOJO {
    private Integer id;
    private String picture;
    private String name;
    private Integer coffeetypeid;
    private double price;
    private int num;
    private String netweight;
    private String qualittydate;
    private Integer tasteid;
    private String brand;
    private String storage;
    private String detail;

    public CoffeePOJO() {
    }

    public CoffeePOJO(Integer id, String picture, String name, Integer coffeetypeid, double price, int num, String netweight, String qualittydate, Integer tasteid, String brand, String storage, String detail) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.coffeetypeid = coffeetypeid;
        this.price = price;
        this.num = num;
        this.netweight = netweight;
        this.qualittydate = qualittydate;
        this.tasteid = tasteid;
        this.brand = brand;
        this.storage = storage;
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoffeetypeid() {
        return coffeetypeid;
    }

    public void setCoffeetypeid(Integer coffeetypeid) {
        this.coffeetypeid = coffeetypeid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNetweight() {
        return netweight;
    }

    public void setNetweight(String netweight) {
        this.netweight = netweight;
    }

    public String getQualittydate() {
        return qualittydate;
    }

    public void setQualittydate(String qualittydate) {
        this.qualittydate = qualittydate;
    }

    public Integer getTasteid() {
        return tasteid;
    }

    public void setTasteid(Integer tasteid) {
        this.tasteid = tasteid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
