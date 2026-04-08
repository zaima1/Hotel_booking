package hh.backend.hotel_booking.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Comer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comerId;
    private Integer people;
    private Boolean checked_in;
    private Boolean checked_out;
    private Integer roomNumber;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "comer")
    @JsonIgnoreProperties("comer")
    private Booker booker;    
 
    public Comer(Integer people, Boolean checked_in, Boolean checked_out, Integer roomNumber) {

        this.people = people;
        this.checked_in = checked_in;
        this.checked_out = checked_out;
        this.roomNumber = roomNumber;
    }
    public Comer() {
    }
    public Integer getPeople() {
        return people;
    }
    public void setPeople(Integer people) {
        this.people = people;
    }
    public Boolean getChecked_in() {
        return checked_in;
    }
    public void setChecked_in(Boolean checked_in) {
        this.checked_in = checked_in;
    }
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public Boolean getChecked_out() {
        return checked_out;
    }
    public void setChecked_out(Boolean checked_out) {
        this.checked_out = checked_out;
    }
    public Long getComerId() {
        return comerId;
    }
    public void setComerId(Long comerId) {
        this.comerId = comerId;
    }
    @Override
    public String toString() {
        return "Comer [comerId=" + comerId + ", people=" + people + ", checked_in=" + checked_in + ", checked_out="
                + checked_out + ", roomNumber=" + roomNumber + ", booker=" + booker + "]";
    }
  

    
    

    
}
