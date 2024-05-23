package com.example.practicandolab6.Controller;

import com.example.practicandolab6.Entity.Dispositivo;
import com.example.practicandolab6.Repository.DispositivoRepository;
import com.example.practicandolab6.Repository.PrestamoRepository;
import com.example.practicandolab6.Repository.ReservaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
