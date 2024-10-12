package com.eroses.external.society.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WriteAjkBranchRequest {
    private String branchNo;
    private String ajkCode;
    private String titleCode;
    private String ajkName;
    private String gender;
    private String citizenshipStatus;
    private String identityType;
    private String ajkIcNo;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String jobCode;
    private String status;
    private String ajkAddressStatus;
    private String ajkAddress;
    private String ajkCountryCode;
    private String ajkStateCode;
    private String ajkDistrict;
    private String ajkSmallDistrict;
    private String ajkCity;
    private String postcode;
    private String email;
    private String homePhoneNumber;
    private String phoneNumber;
    private String officePhoneNumber;
    private String ajkEmployerName;
    private String ajkEmployerAddressStatus;
    private String ajkEmployerAddress;
    private String ajkEmployerCountryCode;
    private String ajkEmployerStateCode;
    private String ajkEmployerDistrict;
    private String ajkEmployerCity;
    private String ajkEmployerPostcode;
    private String batalFlat;
    private String applicationStatusCode;
    private String pegHarta;
    private String otherPosition;
    private LocalDate tarikhTukarSu;
    private int idSu;
}
