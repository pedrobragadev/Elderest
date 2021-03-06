package br.com.pucminas.elderest.service;

import org.springframework.stereotype.Component;

import br.com.pucminas.elderest.dto.MedicamentoDTO;
import br.com.pucminas.elderest.entity.Medicamento;

@Component
public class Mapper {

    public Medicamento dtoToMedicamento(final MedicamentoDTO medicamentoDto) {
        if(medicamentoDto == null) {
            return null;
        }

        //TODO need to fix id letters

        Integer quantity = 0;
        if(medicamentoDto.getQuantidade() >= 0) {
            quantity = medicamentoDto.getQuantidade();
        }

        String situacao = "OK";
        if(quantity == 0) {
            situacao = "EM FALTA";
        }
        else if(quantity < 5) {
            situacao = "ENCOMENDAR";
        }

        return new Medicamento(medicamentoDto.getId(),
                medicamentoDto.getFornecedora(),
                quantity,
                medicamentoDto.getSubstancia(), situacao);
    }

    public MedicamentoDTO medicamentoToDto(final Medicamento medicamento) {
        if(medicamento == null) {
            return null;
        }

        return new MedicamentoDTO(medicamento.getId(),
                medicamento.getFornecedora(),
                medicamento.getQuantidade(),
                medicamento.getSubstancia());
    }
}
