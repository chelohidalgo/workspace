package other.packaging.bylayer.controller;

import other.packaging.bylayer.service.AuthorService;

public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    // implementation skipped for brevity
}
