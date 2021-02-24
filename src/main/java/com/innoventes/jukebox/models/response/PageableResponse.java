package com.innoventes.jukebox.models.response;

public class PageableResponse extends JukeboxResponse{

    private Long total;

    public PageableResponse(Object body, Long total) {
        super(body);
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
