package hh.backend.hotel_booking.domain;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Room {
    @Id
    private Long roomId;
    private Integer beds;
    private Integer price;// jaa sadalla ku laitat nettisivulle
    private LocalDate available;
    private LocalDate availableEnding;

    @ManyToOne
    @JsonIgnoreProperties("room")
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @OneToOne
    private Booker booker;

    public Room() {

    }

    public Room(Long roomId, Integer beds, Integer price, LocalDate available, LocalDate availableEnding) {
        this.roomId = roomId;
        this.beds = beds;
        this.price = price;
        this.available = available;
        this.availableEnding = availableEnding;
    }

    public void setAvailable(LocalDate available) {
        this.available = available;
    }

    public LocalDate getAvailableEnding() {
        return availableEnding;
    }

    public void setAvailableEnding(LocalDate availableEnding) {
        this.availableEnding = availableEnding;
    }

    public LocalDate getAvailable() {
        return available;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    @Override
    public String toString() {
        return "Room [roomId=" + roomId + ", beds=" + beds + ", price=" + price
                + ", available=" + available + ", availableEnding=" + availableEnding + "]";
    }

}
