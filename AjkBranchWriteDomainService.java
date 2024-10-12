package com.eroses.external.society.service;

import com.eroses.external.society.mappers.AjkBranchMapper;
import com.eroses.external.society.model.AjkBranch;
import com.eroses.external.society.utils.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AjkBranchWriteDomainService {
    private final AjkBranchMapper ajkBranchMapper;

    public Long create(AjkBranch ajkBranch) {
        boolean result = ajkBranchMapper.create(ajkBranch);
        Assert.isTrue(result, "Create ajk-branch is unsuccessful.");
        return ajkBranch.getId();
    }
}
