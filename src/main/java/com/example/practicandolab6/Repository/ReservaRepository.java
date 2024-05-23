package com.example.practicandolab6.Repository;

import com.example.practicandolab6.DTO.ReservaDTO;
import com.example.practicandolab6.Entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Query(nativeQuery = true, value="select count(TicketID) as cantidad , s.SiteName as sede from ticket t left join site s on t.SiteId = s.SiteId group by s.SiteId")
    List<ReservaDTO> getReservasPor();
}
