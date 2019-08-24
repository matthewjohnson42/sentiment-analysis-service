# sentiment-analyis-service

A web service that is used for exposing sentiment analysis functionality via HTTP requests.

Currently contains endpoints that expose basic sentiment analysis of String input. The endpoints utilize the [SentiWordNet](https://github.com/aesuli/SentiWordNet) sentiment lexicon to attribute sentiment scores to input strings using a number of different methods.

Please note that these endpoints use methods that rely on the immediately apparent sentiment of the words of the input and the size of the input to provide accurate output. Short excerpts that are positive in nature but communicate that positivity using concepts may not be evaluated by the endpoints as being positive (eg: The Little Engine that Could).

####```POST /sentiWordNet/simpleScores```
Does some pre-processing to prepare the input and iterates over the words of the input. Looks up each word in a simple interpretation of SentiWordNet, and averages the positive and negative scores of the words in the input. See: [Pre-processing JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/controller/SentiWordNetController.java), [SentiWordNet Parsing JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/util/resourceparsers/SentiWordNetSimpleParser.java).

####```POST /sentiWordNet/simpleSum```
Does some pre-processing and iterates over the words of the input. Looks up the words in a simple interpretation of SentiWordNet, adds the positive and negative values for each word and then sums the combined value. See: [Pre-processing JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/controller/SentiWordNetController.java), [SentiWordNet Parsing JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/util/resourceparsers/SentiWordNetSimpleParser.java).

####```POST /sentiWordNet/simpleAvg```
Does some pre-processing and iterates over the words of the input. Looks up the words in a simple interpretation of SentiWordNet, adds the positive and negative values for each word and then computes average of the combined value across the words in the input. See: [Pre-processing JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/controller/SentiWordNetController.java), [SentiWordNet Parsing JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/util/resourceparsers/SentiWordNetSimpleParser.java).
