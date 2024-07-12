package com.civa.futbolistasapi.dto;

import com.civa.futbolistasapi.entities.Futbolista;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FutbolistaDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String caracteristicas;
    private String posicion;

}
