package hh.backend.hotel_booking.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.hotel_booking.domain.Booker;
import hh.backend.hotel_booking.domain.BookerRepository;
import hh.backend.hotel_booking.domain.ComerRepository;
import hh.backend.hotel_booking.domain.RoomRepository;

@Controller
public class BookerController {

    private final BookerRepository bookerRepository;
    private final ComerRepository comerRepository;
    private final RoomRepository roomRepository;
    
    public BookerController(BookerRepository bookerRepository, ComerRepository comerRepository,
            RoomRepository roomRepository) {
        this.bookerRepository = bookerRepository;
        this.comerRepository = comerRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping("/bookerlist")
    @PreAuthorize("hasRole('ADMIN')")
    public String bookerlist(Model model){
        model.addAttribute("bookers", bookerRepository.findAll());
        return"bookerlist";
    }

    @GetMapping("/addbooker")
    @PreAuthorize("hasRole('ADMIN')")
    public String addBooker(Model model){
        model.addAttribute("booker", new Booker());
        model.addAttribute("comers", comerRepository.findAll());
        model.addAttribute("room", roomRepository.findAll());
        return "addbooker";
    }

    @PostMapping("/savebooker")
    public String saveBooker (@ModelAttribute Booker booker, Model model){
        bookerRepository.save(booker);
        model.addAttribute("bookers", booker);
        return"redirect:/bookerlist";
    }

    @GetMapping("/deletebooker/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBooker(@PathVariable("id")  long bookerId, Model model){
        bookerRepository.deleteById(bookerId);
        return"redirect:/bookerlist";
    }
 
    @GetMapping("/updatebooker/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateBooker(@PathVariable("id") long bookerId, Model model){
        Booker booker = bookerRepository.findById(bookerId).orElseThrow(() ->
        new IllegalArgumentException("Wrong booker id"));
        model.addAttribute("bookers", booker);
        return "editbooker";
    }

    @PostMapping("/bookerupdate")
    @PreAuthorize("hasRole('ADMIN')")
    public String bookerUpdate(@ModelAttribute Booker booker){
        bookerRepository.save(booker);
        return "redirect:../bookerlist";
    }
}
