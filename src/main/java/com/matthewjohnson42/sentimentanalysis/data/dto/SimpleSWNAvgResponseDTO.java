package com.matthewjohnson42.sentimentanalysis.data.dto;

public class SimpleSWNAvgResponseDTO {

    Float avg = 0F;

    public SimpleSWNAvgResponseDTO(Float avg){
        this.avg = avg;
    }

    public Float getAvg() { return avg; }

    public SimpleSWNAvgResponseDTO setAvg(Float avg) {
        this.avg = avg;
        return this;
    }
}
