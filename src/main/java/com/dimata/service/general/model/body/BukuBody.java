package com.dimata.service.general.model.body;

public record BukuBody(
        String name,
        String author,
        Integer page
) {

    public boolean isValid() {
        return name != null
                && author != null
                && page != null;
    }
}
