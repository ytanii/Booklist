package ytanii.booklist.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ytanii.booklist.model.GoogleBooksResponse;

import java.util.List;

@Service
public class BookService {
    private final RestClient googleBooksClient;

    public BookService(RestClient googleBooksClient){
        this.googleBooksClient = googleBooksClient;
    }

    public List<String> searchBooks(String query){
        GoogleBooksResponse response = googleBooksClient.get()
                .uri(uriBuilder -> uriBuilder.path("/volumes")
                        .queryParam("q",query)
                        .build())
                .retrieve()
                .body(GoogleBooksResponse.class);

        return response.items().stream()
                .filter(bookItem -> titleMatchesLatinOnly(bookItem.volumeInfo().title()))
                .map(bookItem ->{
                    List<String> authors = bookItem.volumeInfo().authors();
                    String author = (authors != null && !authors.isEmpty()) ? authors.getFirst() : "No author";

                    return bookItem.volumeInfo().title() + " by " + author;

                } )
                .toList();
    }


    private boolean titleMatchesLatinOnly(String title){

        String titleRegex = "[A-Za-z0-9\\s.,!?'-]+";

        return title.matches(titleRegex);
    }
}
