package hh.backend.hotel_booking.web;

import org.springframework.security.access.prepost.PreAuthorize;
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
        model.addAttribute("comers", comerRepository.findAll());
        return"/comerlist";
    }

    @GetMapping("/addcomer")
    @PreAuthorize("hasRole('ADMIN')")
    public String addComer(Model model){
        model.addAttribute("comer", new Comer());
        model.addAttribute("booker", bookerRepository.findAll());
        return"addcomer";
    }

    @PostMapping("/savecomer")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveComer(@ModelAttribute Comer comer, Model model){
        comerRepository.save(comer);
        model.addAttribute("comer", comer);
        return"redirect:/comerlist";
    }
    @GetMapping("/deletecomer/{id}")
    @PreAuthorize("hasRole('ADMIN')")
        public String deleteRoom(@PathVariable("id") long  comerId, Model model){
            comerRepository.deleteById(comerId);
            return"redirect:../comerlist";
    }
    @GetMapping("/updatecomer/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateComer(@PathVariable("id") Long comerID, Model model ){
        Comer comer = comerRepository.findById(comerID).orElseThrow(() -> 
        new IllegalArgumentException("Wrong booker id"));
        model.addAttribute("comer",comer);
        return "editcomer";
    }

    @PostMapping("/comerupdate")
    @PreAuthorize("hasRole('ADMIN')")
    public String comerUpdate(@ModelAttribute Comer comer){
        comerRepository.save(comer);
        return "rederect:/comerlist";
    }
}
