package com.example.practicandolab6.Controller;

import com.example.practicandolab6.Repository.DispositivoRepository;
import com.example.practicandolab6.Repository.PrestamoRepository;
import com.example.practicandolab6.Repository.ReservaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Prestamo")
public class PrestamoController {
    final DispositivoRepository dispositivoRepository;
    final PrestamoRepository prestamoRepository;
    final ReservaRepository reservaRepository;

    public PrestamoController(DispositivoRepository dispositivoRepository ,PrestamoRepository prestamoRepository ,
                                 ReservaRepository reservaRepository){
        this.dispositivoRepository = dispositivoRepository;
        this.prestamoRepository = prestamoRepository ;
        this.reservaRepository = reservaRepository;
    }
    @GetMapping("/verPrestamo")
    public String verPrestamo(){
        return "/Prestamos/PrestamosLista";
    }
}
