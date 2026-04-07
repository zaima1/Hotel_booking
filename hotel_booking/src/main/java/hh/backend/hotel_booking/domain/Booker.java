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
    private Long bookerId;

    private LocalDate araiving;
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

    

    public Booker( LocalDate araiving, LocalDate leaving, Integer price, Integer peopleComing, String name) {
        this.araiving = araiving;
        this.leaving = leaving;
        this.price = price;
        this.peopleComing = peopleComing;
        this.name = name;
    }



    public Long getBookerId() {
        return bookerId;
    }



    public void setBookerId(Long bookerId) {
        this.bookerId = bookerId;
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


    public LocalDate getAraiving() {
        return araiving;
    }

    public void setAraiving(LocalDate araiving) {
        this.araiving = araiving;
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





    @Override
    public String toString() {
        return "Booker [bookerId=" + bookerId + ", araiving=" + araiving + ", leaving=" + leaving + ", price="
                + price + ", peopleComing=" + peopleComing + ", name=" + name + "]";
    }

   

    

    
}
