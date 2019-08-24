package com.matthewjohnson42.sentimentanalysis.config;

import com.matthewjohnson42.sentimentanalysis.data.lexicon.SimpleSentiWordNet;
import com.matthewjohnson42.sentimentanalysis.util.resourceparsers.SentiWordNetSimpleParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LexiconConfig {

    @Value("classpath:lexicons/SentiWordNet_3.0.0_20130122.txt")
    Resource resource;

    @Bean
    SimpleSentiWordNet simpleSentiWordNet() {
        return SentiWordNetSimpleParser.readResource(resource);
    }

}
