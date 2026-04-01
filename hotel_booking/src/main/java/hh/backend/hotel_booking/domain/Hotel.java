package hh.backend.hotel_booking.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotel_id;
    private Integer roomAmount;
    private String address;
    private String city;
    private Integer postcode;
    private Integer stars;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(Long hotel_id, Integer roomAmount, String address, String city, Integer postcode,
            Integer stars, List<Room> rooms) {
        this.hotel_id = hotel_id;
        this.roomAmount = roomAmount;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.stars = stars;
        this.rooms = rooms;
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    
    public Integer getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Hotel [hotel_id=" + hotel_id + ", roomAmount=" + roomAmount + ", address=" + address
                + ", city=" + city
                + ", postcode=" + postcode + ", stars=" + stars + "]";
    }


}
