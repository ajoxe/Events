package com.example.android.events.model;



import java.util.List;

public class Events {

    private Seatmap seatmap;

    private List<Products> products;

    private List<PriceRanges> priceRanges;
    private String pleaseNote;
    private String info;

    private List<Classification> classifications;

    private Dates dates;

    private List<Images> images;
    private String locale;
    private String url;
    private String id;
    private String type;
    private String name;

    private VenueEmbedded _embedded;

    private boolean isSaved;

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public Events(){

    }

    public Events(Seatmap seatmap, List<Products> products, List<PriceRanges> priceRanges, String pleaseNote, String info, List<Classification> classifications, Dates dates, List<Images> images, String locale, String url, String id, String type, String name, VenueEmbedded _embedded) {
        this.seatmap = seatmap;
        this.products = products;
        this.priceRanges = priceRanges;
        this.pleaseNote = pleaseNote;
        this.info = info;
        this.classifications = classifications;
        this.dates = dates;
        this.images = images;
        this.locale = locale;
        this.url = url;
        this.id = id;
        this.type = type;
        this.name = name;
        this._embedded = _embedded;
    }

    public VenueEmbedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(VenueEmbedded _embedded) {
        this._embedded = _embedded;
    }


    public Seatmap getSeatmap() {
        return seatmap;
    }

    public void setSeatmap(Seatmap seatmap) {
        this.seatmap = seatmap;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<PriceRanges> getPriceRanges() {
        return priceRanges;
    }

    public void setPriceRanges(List<PriceRanges> priceRanges) {
        this.priceRanges = priceRanges;
    }

    public String getPleaseNote() {
        return pleaseNote;
    }

    public void setPleaseNote(String pleaseNote) {
        this.pleaseNote = pleaseNote;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
