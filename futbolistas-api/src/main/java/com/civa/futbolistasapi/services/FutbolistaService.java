package com.civa.futbolistasapi.services;

import com.civa.futbolistasapi.dto.FutbolistaDTO;
import com.civa.futbolistasapi.entities.Futbolista;
import com.civa.futbolistasapi.repositories.FutbolistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FutbolistaService {
    @Autowired
    private FutbolistaRepository futbolistaRepository;

    public Page<FutbolistaDTO> obtenerFutbolistas(Pageable pageable) {
        Page<Futbolista> page = futbolistaRepository.findAll(pageable);
        return page.map(this::covertirADTO);
    }


    public List<FutbolistaDTO> obtenerFutbolistas() {
        List<Futbolista> futbolista = futbolistaRepository.findAll();
        return futbolista.stream().map(this::covertirADTO).collect(Collectors.toList());
    }

    public FutbolistaDTO obtenerFutbolistaPorId(Long id) {
        Optional<Futbolista> futbolista = futbolistaRepository.findById(id);
        if (futbolista.isPresent()) {
            return covertirADTO(futbolista.get());
        } else {
            return null;
        }
    }

    private FutbolistaDTO covertirADTO(Futbolista futbolista) {
        FutbolistaDTO dto = new FutbolistaDTO();
        dto.setId(futbolista.getId());
        dto.setNombres(futbolista.getNombres());
        dto.setApellidos(futbolista.getApellidos());
        dto.setFechaNacimiento(futbolista.getFechaNacimiento());
        dto.setCaracteristicas(futbolista.getCaracteristicas());
        dto.setPosicion(futbolista.getPosicion().getTipo().name());
        System.out.println(dto);
        return dto;
    }


}
