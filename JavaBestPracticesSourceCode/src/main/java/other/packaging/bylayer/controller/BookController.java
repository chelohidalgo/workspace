package other.packaging.bylayer.controller;

import other.packaging.bylayer.service.BookService;

public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // implementation skipped for brevity

}
