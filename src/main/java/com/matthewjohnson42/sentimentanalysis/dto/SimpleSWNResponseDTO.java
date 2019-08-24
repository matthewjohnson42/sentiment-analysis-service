package com.matthewjohnson42.sentimentanalysis.dto;

public class SimpleSWNResponseDTO {

    private Float posScore;
    private Float negScore;

    public SimpleSWNResponseDTO(Float posScore, Float negScore) {
        this.posScore = posScore;
        this.negScore = negScore;
    }

    public Float getPosScore() {
        return posScore;
    }

    public SimpleSWNResponseDTO setPosScore(Float posScore) {
        this.posScore = posScore;
        return this;
    }

    public Float getNegScore() {
        return negScore;
    }

    public SimpleSWNResponseDTO setNegScore(Float negScore) {
        this.negScore = negScore;
        return this;
    }
}
