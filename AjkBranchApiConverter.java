package com.eroses.external.society.api.converter.input;

import com.eroses.external.society.dto.request.WriteAjkBranchRequest;
import com.eroses.external.society.model.AjkBranch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AjkBranchApiConverter {
    AjkBranch convertToModel(WriteAjkBranchRequest writeAjkBranchRequest);
}
