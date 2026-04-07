package hh.backend.hotel_booking.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String addComer(Model model){
        model.addAttribute("comer", new Comer());
        model.addAttribute("booker", bookerRepository.findAll());
        return"addcomer";
    }

    @PostMapping("/savecomer")
    public String saveComer(@ModelAttribute Comer comer, Model model){
        comerRepository.save(comer);
        model.addAttribute("comer", comer);
        return"redirect:/comerlist";
    }

    @GetMapping("/updatecomer/{id}")
    public String updateComer(@PathVariable("id") Long comerID, Model model ){
        Comer comer = comerRepository.findById(comerID).orElseThrow(() -> 
        new IllegalArgumentException("Wrong booker id"));
        return "editcomer";
    }

    @PostMapping("/comerupdate")
    public String comerUpdate(@ModelAttribute Comer comer){
        comerRepository.save(comer);
        return "rederect:/comerlist";
    }
}
