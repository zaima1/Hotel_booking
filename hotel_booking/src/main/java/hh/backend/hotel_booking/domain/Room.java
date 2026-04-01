package hh.backend.hotel_booking.domain;


import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Room {
    @Id
    private Long roomNumber;
    private Integer beds;
    private Integer price;//jaa sadalla ku laitat nettisivulle 
    private LocalDate available;
    private LocalDate availableEnding;

    @ManyToOne
    @JsonIgnoreProperties("room")
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    
    @OneToOne
    private Booker booker;

    public Room() {
        
    }

  

   



    public Room(Long roomNumber, Integer beds, Integer price, LocalDate available, LocalDate availableEnding) {
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.price = price;
        this.available = available;
        this.availableEnding = availableEnding;
    }







    public LocalDate getAvailableEnding() {
        return availableEnding;
    }



    public void setAvailableEnding(LocalDate availableEnding) {
        this.availableEnding = availableEnding;
    }


    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getAvailable() {
        return available;
    }

    public void setAvailable(LocalDate available) {
        this.available = available;
    }



    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", beds=" + beds + ", price=" + price
                + ", available=" + available + ", availableEnding=" + availableEnding + "]";
    }







  

  



    

    
    

}
