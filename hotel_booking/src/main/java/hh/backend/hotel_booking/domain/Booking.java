package hh.backend.hotel_booking.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDate arriving;
    private LocalDate leaving;
    private Integer price;
    private Integer peopleComing;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "booking")
    @JsonIgnoreProperties("booker")
    private Booker booker;

  

    public Booking( LocalDate arriving, LocalDate leaving, Integer price, Integer peopleComing) {
        this.arriving = arriving;
        this.leaving = leaving;
        this.price = price;
        this.peopleComing = peopleComing;
    }


    public Booking() {
    }

    
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    
    public LocalDate getArriving() {
        return arriving;
    }


    public void setArriving(LocalDate arriving) {
        this.arriving = arriving;
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


    public Integer getPeopleComing() {
        return peopleComing;
    }


    public void setPeopleComing(Integer peopleComing) {
        this.peopleComing = peopleComing;
    }


    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + "]";
    }

    
}
