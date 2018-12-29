package com.example.mac.practise.restApi.model;

import java.util.Objects;

public class Greetings {

    private final Long id;
    private final String content;

    public Greetings(Long id, String content){
        this.id=id;
        this.content=content;

    }


    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Greetings{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greetings greetings = (Greetings) o;
        return Objects.equals(id, greetings.id) &&
                Objects.equals(content, greetings.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }
}
