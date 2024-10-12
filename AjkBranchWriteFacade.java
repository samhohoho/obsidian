package com.eroses.external.society.api.facade;

import com.eroses.external.society.model.AjkBranch;
import com.eroses.external.society.model.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;

@Service
@Api("Create ajk-branch")
public interface AjkBranchWriteFacade {
    @ApiOperation("ajkBranchCreate")
    ApiResponse<Long> create(AjkBranch ajkBranch);
}