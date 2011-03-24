package ro.cuzma.larry.persistance.xml.samples.sample2.objects;

import java.util.ArrayList;
import java.util.List;

import ro.cuzma.larry.persistance.common.Entity;

public class CalibreBook extends Entity<Long> {

    // private String uuid;
    // // package
    // private String xmlns = "http://www.idpf.org/2007/opf";
    // private String unique_identifier = "uuid_id";
    // // metadata
    // private String metadata_xmlns_dc = "http://purl.org/dc/elements/1.1/";
    // private String metadata_xmlns_opf = "http://www.idpf.org/2007/opf";

    private String       title;
    private List<String> creator;
    private String       isbn;
    private String       publisher;
    private String       date;
    private String       language;
    private String       series;
    private String       series_index;
    private String       rating;
    private String       boughtDate;
    private String       toRead;
    private Long         colnr;
    private Double       price;
    private String       collection;
    private String       status;
    private String       type;
    private Long         readNr;
    private String       languagemetadata;
    private String       currency;
    private String       originalTitle;
    // true/false
    private String       digitalBook;

    public CalibreBook(Long id) {
        this.id = id;
    }

    public String getDigitalBook() {
        return digitalBook;
    }

    public void setDigitalBook(String digitalBook) {
        this.digitalBook = digitalBook;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public CalibreBook() {
    }

    public String getToRead() {
        return toRead;
    }

    public void setToRead(String toRead) {
        this.toRead = toRead;
    }

    public String getElementValue() {
        return id.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCreator() {
        if (creator == null) {
            this.creator = new ArrayList<String>();
        }
        return creator;
    }

    public void setCreator(List<String> creator) {
        this.creator = creator;
    }

    public void addCreator(String author) {
        if (creator == null) {
            this.creator = new ArrayList<String>();
        }
        creator.add(author);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSeries_index() {
        return series_index;
    }

    public void setSeries_index(String series_index) {
        this.series_index = series_index;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(String boughtDate) {
        this.boughtDate = boughtDate;
    }

    public Long getColnr() {
        return colnr;
    }

    public void setColnr(Long colnr) {
        this.colnr = colnr;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getReadNr() {
        return readNr;
    }

    public void setReadNr(Long readNr) {
        this.readNr = readNr;
    }

    public String getLanguagemetadata() {
        return languagemetadata;
    }

    public void setLanguagemetadata(String languagemetadata) {
        this.languagemetadata = languagemetadata;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
