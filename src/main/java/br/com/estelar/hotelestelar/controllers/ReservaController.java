package br.com.estelar.hotelestelar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.estelar.hotelestelar.models.Reserva;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservaController {

    Logger log = LoggerFactory.getLogger(ReservaController.class);

    List<Reserva> reservas = new ArrayList<>();

    @GetMapping("/api/reserva/cadastrar")
    public List<Reserva> index() {
        return reservas;
    }

    @PostMapping("/api/minhas-reservas")
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
        log.info("cadastrando reserva: " + reserva);
        reserva.setIdReserva(reservas.size() + 1l);
        reservas.add(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @GetMapping("/api/reserva/detalhes/{idReserva}")
    public ResponseEntity<Reserva> show(@PathVariable Long idReserva) {
        log.info("buscando reserva com id " + idReserva);
        var reservaEncontrada = reservas.stream().filter(d -> d.getIdReserva().equals(idReserva)).findFirst();

        if (reservaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(reservaEncontrada.get());

    }

    @DeleteMapping("/api/minha-reserva/apagar/{idReserva}")
    public ResponseEntity<Reserva> destroy(@PathVariable Long idReserva) {
        log.info("apagando reserva com id " + idReserva);
        var reservaEncontrada = reservas.stream().filter(d -> d.getIdReserva().equals(idReserva)).findFirst();

        if (reservaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        reservas.remove(reservaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/api/minha-reserva/atualizar")
    public ResponseEntity<Reserva> update(@PathVariable Long idReserva, @RequestBody Reserva reserva) {
        log.info("alterando reserva com id " + idReserva);
        var reservaEncontrada = reservas.stream().filter(d -> d.getIdReserva().equals(idReserva)).findFirst();

        if (reservaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        reservas.remove(reservaEncontrada.get());
        reserva.setIdReserva(idReserva);
        reservas.add(reserva);

        return ResponseEntity.ok(reserva);

    }

}