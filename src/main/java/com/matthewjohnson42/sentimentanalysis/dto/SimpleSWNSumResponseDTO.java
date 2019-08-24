package com.matthewjohnson42.sentimentanalysis.dto;

public class SimpleSWNSumResponseDTO {

    private Float sum;

    public SimpleSWNSumResponseDTO(Float sum) {
        this.sum = sum;
    }

    public Float getSum() { return sum; }

    public SimpleSWNSumResponseDTO setSum(Float sum) {
        this.sum = sum;
        return this;
    }
}
