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
    private Long hotelId;
    private Integer roomAmount;
    private String address;
    private String city;
    private String postcode;
    private Integer stars;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(Integer roomAmount, String address, String city, String postcode,
            Integer stars) {

        this.roomAmount = roomAmount;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.stars = stars;
    }

    public Long getHotel_id() {
        return hotelId;
    }

    public void setHotel_id(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
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
        return "Hotel [hotelId=" + hotelId + ", roomAmount=" + roomAmount + ", address=" + address
                + ", city=" + city
                + ", postcode=" + postcode + ", stars=" + stars + "]";
    }

}
