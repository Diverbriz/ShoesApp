package com.example.shoesapp.Presentation.Repository.network.vk;

import java.util.List;

public class UserResponse {

    private List<Response> response;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }
}
class Response{
    private long id;
    private String bdate;
    private String first_name;
    private String last_name;
    private boolean can_access_closed;
    private boolean is_closed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isCan_access_closed() {
        return can_access_closed;
    }

    public void setCan_access_closed(boolean can_access_closed) {
        this.can_access_closed = can_access_closed;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", bdate='" + bdate + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", can_access_closed=" + can_access_closed +
                ", is_closed=" + is_closed +
                '}';
    }
}
