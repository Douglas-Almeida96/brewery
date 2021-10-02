package com.douglas.brewery.model.mapper;

import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita.form.ReceitaForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceitaMapper {

    ReceitaMapper INSTANCE = Mappers.getMapper(ReceitaMapper.class);

    Receita dtoToModel(ReceitaForm receitaForm);
    /*ReceitaDto modelToDto(Receita receita);*/
}
