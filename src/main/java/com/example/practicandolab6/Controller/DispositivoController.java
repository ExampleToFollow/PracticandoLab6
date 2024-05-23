package com.example.practicandolab6.Controller;

import com.example.practicandolab6.Entity.Dispositivo;
import com.example.practicandolab6.Repository.DispositivoRepository;
import com.example.practicandolab6.Repository.PrestamoRepository;
import com.example.practicandolab6.Repository.ReservaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/Dispositivo")
public class DispositivoController {
    final DispositivoRepository dispositivoRepository;
    final PrestamoRepository prestamoRepository;
    final ReservaRepository reservaRepository;

    public DispositivoController(DispositivoRepository dispositivoRepository ,PrestamoRepository prestamoRepository ,
                                 ReservaRepository reservaRepository){
        this.dispositivoRepository = dispositivoRepository;
        this.prestamoRepository = prestamoRepository ;
        this.reservaRepository = reservaRepository;
    }
    @GetMapping("/verDispositivos")
    public String verDispositivos(Model model){
        model.addAttribute("listaDispositivos" , dispositivoRepository.findAll());
        return "Dispositivos/DispositivosLista";
    }

    @GetMapping("/delete")
    public String borrarDispositivo(@RequestParam("id") int id){
        Optional<Dispositivo> optional = dispositivoRepository.findById(id);
        if (optional.isPresent()) {
            dispositivoRepository.deleteById(id);
        }
        return "redirect:/Dispositivo/verDispositivos";
    }

    @GetMapping("/createDisp")
    public String verCrearDisp(Model model , @ModelAttribute("dispositivo") Dispositivo dispositivo){
        return "/Dispositivos/editDispositivo";
    }

    @GetMapping("/editarDisp")
    public String verEdicionCreado(Model model , @ModelAttribute("Dispositivo") Dispositivo dispositivo , @RequestParam("id") int idDisp){
        System.out.println("Hola");
        Optional<Dispositivo> dispAux = dispositivoRepository.findById(idDisp);
        if(dispAux.isPresent()){
            dispositivo = dispAux.get();
            model.addAttribute("dispositivo", dispositivo);
            System.out.println(dispositivo.getNombre());
        }
        return "/Dispositivos/editDispositivo";
    }

    @PostMapping("/createEditDispCompleted")
    public String CreateTechnicianCompleted(Model model, @ModelAttribute("dispositivo") @Valid Dispositivo dispositivo ,
                                            BindingResult bindingResult, RedirectAttributes attr){
        if(!bindingResult.hasErrors()) {
            dispositivoRepository.save(dispositivo);
            return "redirect:/Dispositivos/verDispositivos";
        }else{
            System.out.println("HUBO ERRORES D:");
            return "/Dispositivos/editDispositivo";
        }
    }


}
