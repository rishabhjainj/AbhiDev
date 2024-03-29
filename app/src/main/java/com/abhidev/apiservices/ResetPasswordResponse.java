package com.abhidev.apiservices;

import com.abhidev.apiservices.responses.GenericResponse;

public class ResetPasswordResponse extends GenericResponse {
    String  status;
    String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
