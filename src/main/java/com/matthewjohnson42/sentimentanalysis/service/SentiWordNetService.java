package com.matthewjohnson42.sentimentanalysis.service;

import com.matthewjohnson42.sentimentanalysis.data.lexicon.SimpleSentiWordNet;
import com.matthewjohnson42.sentimentanalysis.data.wordrep.SimpleSWNWord;
import com.matthewjohnson42.sentimentanalysis.dto.SimpleSWNAvgResponseDTO;
import com.matthewjohnson42.sentimentanalysis.dto.SimpleSWNResponseDTO;
import com.matthewjohnson42.sentimentanalysis.dto.SimpleSWNSumResponseDTO;
import com.matthewjohnson42.sentimentanalysis.util.stemmers.PorterStemmer;
import com.matthewjohnson42.sentimentanalysis.util.stopwordfilters.StopWordFilter;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SentiWordNetService {

    private Logger log = LoggerFactory.getLogger(SentiWordNetService.class);
    private SimpleSentiWordNet simpleSentiWordNet;

    @Autowired
    SentiWordNetService(SimpleSentiWordNet simpleSentiWordNet) {
        this.simpleSentiWordNet = simpleSentiWordNet;
    }

    public SimpleSWNResponseDTO getSimpleScores(String input) {
        List<String> words = Arrays.asList(input.split("\\s"));
        log.info("Processing simple score for input with md5 hash {} and size {}", DigestUtils.md5Hex(input).toUpperCase(), words.size());
        PorterStemmer stemmer = new PorterStemmer();
        float runningPos = 0F;
        float runningNeg = 0F;
        for(int i=0; i < words.size(); i++) {
            String word = words.get(i).toLowerCase();
            if(StopWordFilter.filterWord(word) != null) {
                stemmer.add(word);
                stemmer.stem();
                String stemmedWord = stemmer.toString();
                stemmer.resetState();
                SimpleSWNWord simpleSWNWord = simpleSentiWordNet.getWord(stemmedWord);
                if(simpleSWNWord != null) {
                    runningPos += simpleSWNWord.getPositiveValue();
                    runningNeg += simpleSWNWord.getNegativeValue();
                }
            }
        }
        return new SimpleSWNResponseDTO(runningPos / (float) words.size(), runningNeg / (float) words.size());
    }

    public SimpleSWNSumResponseDTO getSimpleSum(String input) {
        List<String> words = Arrays.asList(input.split("\\s"));
        log.info("Processing simple sum for input with md5 hash {} and size {}", DigestUtils.md5Hex(input).toUpperCase(), words.size());
        return new SimpleSWNSumResponseDTO(getSimpleSum(words));
    }

    public SimpleSWNAvgResponseDTO getSimpleAverage(String input) {
        List<String> words = Arrays.asList(input.split("\\s"));
        log.info("Processing simple average for input with md5 hash {} and size {}", DigestUtils.md5Hex(input).toUpperCase(), words.size());
        return new SimpleSWNAvgResponseDTO(getSimpleSum(words) / (float) words.size() );
    }

    private float getSimpleSum(List<String> words) {
        PorterStemmer stemmer = new PorterStemmer();
        float score = 0F;
        for(int i=0; i < words.size(); i++) {
            String word = words.get(i).toLowerCase();
            if(StopWordFilter.filterWord(word) != null) {
                stemmer.add(word);
                stemmer.stem();
                String stemmedWord = stemmer.toString();
                stemmer.resetState();
                SimpleSWNWord simpleSWNWord = simpleSentiWordNet.getWord(stemmedWord);
                if(simpleSWNWord != null) {
                    score += simpleSWNWord.getFloatValue();
                }
            }
        }
        return score;
    }

}
