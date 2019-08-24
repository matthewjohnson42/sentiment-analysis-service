# sentiment-analyis-service

A web service that is used for exposing sentiment analysis functionality via HTTP requests.

Currently contains endpoints that expose basic sentiment analysis of String input. The endpoints utilize the [SentiWordNet](https://github.com/aesuli/SentiWordNet) sentiment lexicon to attribute sentiment scores to input strings using a number of different methods.

Please note that these endpoints use methods that rely on the immediately apparent sentiment of the words of the input and the size of the input to provide accurate output. Short excerpts that are positive in nature but communicate that positivity using concepts may not be evaluated by the endpoints as being positive (eg: The Little Engine that Could).

#### ```POST /sentiWordNet/simpleScores```
Does some pre-processing to prepare the input and iterates over the words of the input. Looks up each word in a simple interpretation of SentiWordNet, and averages the positive and negative scores of the words in the input. See the [JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/controller/SentiWordNetController.java) for more details.

#### ```POST /sentiWordNet/simpleSum```
Does some pre-processing and iterates over the words of the input. Looks up the words in a simple interpretation of SentiWordNet, adds the positive and negative values for each word, and then sums the combined values of the words in the input. See the [JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/controller/SentiWordNetController.java) for more details.

#### ```POST /sentiWordNet/simpleAvg```
Does some pre-processing and iterates over the words of the input. Looks up the words in a simple interpretation of SentiWordNet, adds the positive and negative values for each word, and then computes average of the combined value across the words in the input. See the [JavaDoc](https://github.com/matthewjohnson42/sentiment-analysis-service/blob/master/src/main/java/com/matthewjohnson42/sentimentanalysis/controller/SentiWordNetController.java) for more details.

## Setup

1. Download and install [Gradle](https://gradle.org/).

2. Download and install [Git](https://git-scm.com/).

3. Clone the repository using git. Run at the command line ```git clone https://github.com/matthewjohnson42/sentiment-analysis-service```

4. Change directory into the cloned repository by running the command ```cd sentiment-analysis-service```

5. Run at the command line ```gradle bootRun```

6. Submit an HTTP request to the endpoint of your choice using [Curl](https://curl.haxx.se/) or another HTTP request software like [Postman](https://www.getpostman.com/). Example curl command: ```curl --data "<YOUR INPUT STRING HERE>" localhost:8080/sentiWordNet/simpleScores```
