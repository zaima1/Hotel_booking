package hh.backend.hotel_booking.domain;


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
    private Integer roomNumber;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "comer")
    private Booker booker;    
 
    public Comer(Integer people, Boolean checked_in, Integer roomNumber) {
        this.people = people;
        this.checked_in = checked_in;
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
    @Override
    public String toString() {
        return "Comer [people=" + people + ", checked_in=" + checked_in + ", roomNumber=" + roomNumber + "]";
    }

    
    

    
}
