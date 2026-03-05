package ytanii.booklist.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class GoogleApiConfig {

    private final static Logger log = LoggerFactory.getLogger(GoogleApiConfig.class);
    @Value("${GOOGLE_BOOKS_API_KEY}")
    private String apiKey;

    @Bean
    public RestClient googleBooksClient(RestClient.Builder builder){
        return builder
                .baseUrl("https://www.googleapis.com/books/v1")
                .defaultHeader("x-goog-api-key",apiKey)
                .build();
    }

}

