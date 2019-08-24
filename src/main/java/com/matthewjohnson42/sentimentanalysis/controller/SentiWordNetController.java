package com.matthewjohnson42.sentimentanalysis.controller;

import com.matthewjohnson42.sentimentanalysis.dto.SimpleSWNAvgResponseDTO;
import com.matthewjohnson42.sentimentanalysis.dto.SimpleSWNResponseDTO;
import com.matthewjohnson42.sentimentanalysis.dto.SimpleSWNSumResponseDTO;
import com.matthewjohnson42.sentimentanalysis.service.SentiWordNetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sentiWordNet")
public class SentiWordNetController {

    private SentiWordNetService sentiWordNetService;

    @Autowired
    public SentiWordNetController(SentiWordNetService sentiWordNetService) {
        this.sentiWordNetService = sentiWordNetService;
    }

    /**
     * An endpoint that does a simple sentiment scoring of a given character string.
     * Uses the Porter Stemmer to strip word suffixes, and uses a naive reference to SentiWordNet to attribute
     * sentiment scores to each of the stemmed words. The response contains the average positive and negative sentiment
     * score of the words of the input string.
     * @param requestBody A String representing the text to be parsed.
     * @return an object describing the average positive and negative sentiment values of the input string.
     */
    @PostMapping("/simpleScores")
    public SimpleSWNResponseDTO getSimpleScore(@RequestBody @NonNull String requestBody) {
        return sentiWordNetService.getSimpleScores(requestBody);
    }

    /**
     * An endpoint that does a simple sentiment scoring of a given character string.
     * Uses the Porter Stemmer to strip word suffixes, and uses a naive reference to SentiWordNet to attribute
     * sentiment scores to each of the stemmed words. The response contains the sum of the positive and negative
     * sentiment scores of all words in the input string.
     * @param requestBody A String representing the text to be parsed.
     * @return an object describing sum of positive and negative sentiment scores for all words in the input.
     */
    @PostMapping("/simpleSum")
    public SimpleSWNSumResponseDTO getSimpleSum(@RequestBody @NonNull String requestBody) {
        return sentiWordNetService.getSimpleSum(requestBody);
    }

    /**
     * An endpoint that does a simple sentiment scoring of a given character string.
     * Uses the Porter Stemmer to strip word suffixes, and uses a naive reference to SentiWordNet to attribute
     * sentiment scores to each of the stemmed words. The response contains the average sum of the positive and
     * negative sentiment scores for each word in the input string.
     * @param requestBody A String representing the text to be parsed.
     * @return an object describing the average sentiment score of the words in the input string/
     */
    @PostMapping("/simpleAvg")
    public SimpleSWNAvgResponseDTO getSimpleAvg(@RequestBody @NonNull String requestBody) {
        return sentiWordNetService.getSimpleAverage(requestBody);
    }

}
