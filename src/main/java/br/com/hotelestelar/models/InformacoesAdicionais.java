package br.com.hotelestelar.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "informacoes_adicionais")
public class InformacoesAdicionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacoes_adicionais")
    private Long idInformacoesAdicionais;

    @NotNull
    @Column(name = "aceita_pet")
    private boolean aceitaPet;

    @NotNull
    @Column(name = "possui_wifi")
    private boolean possuiWifi;

    @NotNull
    @Column(name = "possui_escritorio")
    private boolean possuiEscritorio;

    @NotNull
    @Column(name = "possui_ar_condicionado")
    private boolean possuiArCondicionado;

    @NotNull
    @Column(name = "eh_beira_mar")
    private boolean ehBeiraMar;

    @NotNull
    @Column(name = "possui_maquina_de_lavar")
    private boolean possuiMaquinaDeLavar;

    @NotNull
    @Column(name = "possui_ferro_de_passar")
    private boolean possuiFerroDePassar;

    @NotNull
    @Column(name = "possui_tv")
    private boolean possuiTv;

    @NotNull
    @Column(name = "possui_secadora")
    private boolean possuiSecadora;

    @NotNull
    @Column(name = "possui_terraco")
    private boolean possuiTerraco;

    @NotNull
    @Column(name = "possui_berco")
    private boolean possuiBerco;

    @NotNull
    @Column(name = "possui_lareira")
    private boolean possuiLareira;

}