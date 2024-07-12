package com.civa.futbolistasapi.entities;

import com.civa.futbolistasapi.enums.TipoPosicion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "posiciones")
@Entity(name = "Posicion")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoPosicion tipo;

    @OneToMany(mappedBy = "posicion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Futbolista> futbolistas;

}