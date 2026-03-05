package ytanii.booklist.model;

import java.util.List;

public record GoogleBooksResponse(
        List<BookItem> items
) {}

