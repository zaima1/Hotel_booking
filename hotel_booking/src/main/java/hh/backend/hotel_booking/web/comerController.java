package hh.backend.hotel_booking.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.backend.hotel_booking.domain.BookerRepository;
import hh.backend.hotel_booking.domain.Comer;
import hh.backend.hotel_booking.domain.ComerRepository;

@Controller
public class comerController {
    private final ComerRepository comerRepository;
    private final BookerRepository bookerRepository;

    public comerController(ComerRepository comerRepository, BookerRepository bookerRepository) {
        this.comerRepository = comerRepository;
        this.bookerRepository = bookerRepository;
    }

    @GetMapping("/comerlist")
    public String listComer(Model model){
        model.addAttribute("comer", comerRepository.findAll());
        return"/comerlist";
    }

    @GetMapping("/addcomer")
    public final addComer(Model model){
        model.addAttribute("comer", new Comer());
        model.addAttribute("booker", bookerRepository.findAll());
       
        return"addcomer";
    }

    
}
