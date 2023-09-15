package br.com.matheushbmelo.workshopmongo.domain.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private LocalDateTime date;

    private AuthorDto author;

    public CommentDto() {
    }

    public CommentDto(String text, LocalDateTime date, AuthorDto author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
