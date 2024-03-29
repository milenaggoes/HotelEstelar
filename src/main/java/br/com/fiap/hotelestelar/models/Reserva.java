package br.com.fiap.hotelestelar.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.hotelestelar.controllers.ReservaController;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @NotBlank
    @Column(name = "unidade")
    private String unidade;

    @NotNull
    @Column(name = "numero_quarto")
    private String numeroQuarto;

    @NotNull
    @Column(name = "data_reserva")
    private LocalDateTime dataReserva;

    @NotNull
    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @NotNull
    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @NotBlank
    @Column(name = "acomodacao")
    private String acomodacao;

    @NotNull
    @Min(value = 0, message = "O valor da reserva deve ser maior que 0")
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_informacoes_adicionais")
    private InformacoesAdicionais informacoesAdicionais;

    public void setId(Long idReserva) {
    }


    public EntityModel<Reserva> toModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(ReservaController.class).show(idReserva)).withSelfRel(),
            linkTo(methodOn(ReservaController.class).destroy(idReserva)).withRel("delete"),
            linkTo(methodOn(ReservaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(ReservaController.class).show(this.getInformacoesAdicionais().getIdInformacoesAdicionais())).withRel("informaçõesAdicionais")
        );
    }

}
