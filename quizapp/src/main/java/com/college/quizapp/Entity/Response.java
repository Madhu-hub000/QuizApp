package com.college.quizapp.Entity;

public class Response {
    private Integer id;
    private String responses;

    public Response(Integer id, String responses) {
        this.id = id;
        this.responses = responses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponses() {
        return responses;
    }

    public void setResponses(String responses) {
        this.responses = responses;
    }
}
