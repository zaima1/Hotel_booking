package hh.backend.hotel_booking.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.service.annotation.PatchExchange;

import hh.backend.hotel_booking.domain.BookerRepository;
import hh.backend.hotel_booking.domain.Booking;
import hh.backend.hotel_booking.domain.BookingRepository;
import hh.backend.hotel_booking.domain.HotelRepository;
import hh.backend.hotel_booking.domain.RoomRepository;

@Controller
public class BookedController {

    private final BookerRepository bookerRepository;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;

  
    public BookedController(BookerRepository bookerRepository, RoomRepository roomRepository,
            HotelRepository hotelRepository, BookingRepository bookingRepository) {
        this.bookerRepository = bookerRepository;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.bookingRepository = bookingRepository;
    }


    @GetMapping("/bookinglist")
    public String listOfBookings(Model model){
        model.addAttribute("booking",bookingRepository.findAll());
        return "bookinglist";
    
    }

    @GetMapping("/addbooking")
    public String addBooking(Model model){
        model.addAttribute("booking",new Booking());
        model.addAttribute("room", roomRepository.findAll());
        model.addAttribute("hotel", hotelRepository.findAll());
        model.addAttribute("booker", bookerRepository.findAll());
        return "addbooking";
    }
    

    @GetMapping("/editbooking/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editBooking(@PathVariable("id") Long bookingId, Model model){
        model.addAttribute("booking", bookingRepository.findById(bookingId));
        model.addAttribute("booker", bookerRepository.findAll());
        model.addAttribute("room", roomRepository.findAll());
        model.addAttribute("hotel", hotelRepository.findAll());
        return"editbooking";
    }
    
    @PostMapping("/savebooking")
    public String saveBooking(@ModelAttribute Booking booking,Model model){
        bookingRepository.save(booking);
        return"redirect:/bookinglist";
    }   

    @GetMapping("/deletebooking/{id}")
    @PreAuthorize("hasRole('ADMIN')")
      public String deleteBooking(@PathVariable("id") Long bookingId, Model model){
        bookingRepository.deleteById(bookingId);
        return"redirect:/bookinglist";
    }
    @GetMapping("/booked/{id}")
    public String myBooking(@PathVariable("id") Long bookingId, Model model){
        model.addAttribute(bookingRepository.findById(bookingId));
        return"bookinglist";
    }


}
