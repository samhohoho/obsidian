package com.eroses.external.society.api.facadeImp;

import com.eroses.external.society.api.annotation.MicroService;
import com.eroses.external.society.api.facade.AjkBranchWriteFacade;
import com.eroses.external.society.model.AjkBranch;
import com.eroses.external.society.model.ApiResponse;
import com.eroses.external.society.service.AjkBranchWriteDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AjkBranchWriteFacadeImpl implements AjkBranchWriteFacade {
    private final AjkBranchWriteDomainService ajkBranchWriteDomainService;

    @Override
    @MicroService
    public ApiResponse<Long> create(AjkBranch ajkBranch) {
        try {
            Long ajkBranchId = ajkBranchWriteDomainService.create(ajkBranch);
            return new ApiResponse<>("Society updated successfully.", ajkBranchId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
