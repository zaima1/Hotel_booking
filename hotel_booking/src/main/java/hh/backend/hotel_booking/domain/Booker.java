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
public class Booker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookerId;
    private String firstName;
    private String lastName;

    @JsonIgnoreProperties("booker")
    @OneToOne
    private Comer comer;
    @JsonIgnoreProperties("booker")
    @OneToOne
    private Booking booking;
    @JsonIgnoreProperties("booker")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "booker")
    private Room room;

    public Booker() {
    }

    public Booker(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public Long getBookerId() {
        return bookerId;
    }

    public void setBookerId(Long bookerId) {
        this.bookerId = bookerId;
    }

    @Override
    public String toString() {
        return "Booker [bookerId=" + bookerId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    
    

}
