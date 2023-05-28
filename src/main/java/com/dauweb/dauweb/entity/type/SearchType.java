package com.dauweb.dauweb.entity.type;

import lombok.Getter;

public enum SearchType {
    TITLE("제목"),
    CONTENT("내용");

    @Getter
    private final String description;

    SearchType(String description){
        this.description = description;
    }
}
