package hh.backend.hotel_booking.domain;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Booker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booker_id;
    private LocalDate arraiving;
    private LocalDate leaving;
    private Integer price;
    private Integer peopleComing;
    private String name;

    @OneToOne
    private Comer comer; 
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "booker")
    private Room room;

    public Booker() {
    }

    

    public Booker(Long booker_id, LocalDate arraiving, LocalDate leaving, Integer price, Integer peopleComing, String name) {
        this.booker_id = booker_id;
        this.arraiving = arraiving;
        this.leaving = leaving;
        this.price = price;
        this.peopleComing = peopleComing;
        this.name = name;
    }



    public Integer getPeopleComing() {
        return peopleComing;
    }

    public void setPeopleComing(Integer peopleComing) {
        this.peopleComing = peopleComing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBooker_id() {
        return booker_id;
    }

    public void setBooker_id(Long booker_id) {
        this.booker_id = booker_id;
    }

    public LocalDate getArraiving() {
        return arraiving;
    }

    public void setArraiving(LocalDate arraiving) {
        this.arraiving = arraiving;
    }

    public LocalDate getLeaving() {
        return leaving;
    }

    public void setLeaving(LocalDate leaving) {
        this.leaving = leaving;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getpeople() {
        return peopleComing;
    }

    public void setpeople(Integer peopleComing) {
        this.peopleComing = peopleComing;
    }



    @Override
    public String toString() {
        return "Booker [booker_id=" + booker_id + ", arraiving=" + arraiving + ", leaving=" + leaving + ", price="
                + price + ", peopleComing=" + peopleComing + ", name=" + name + "]";
    }

   

    

    
}
