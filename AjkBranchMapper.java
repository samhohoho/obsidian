package com.eroses.external.society.mappers;

import com.eroses.external.society.model.AjkBranch;
import org.mapstruct.Mapper;

@Mapper
public interface AjkBranchMapper {
    Boolean create(AjkBranch ajkBranch);
}
