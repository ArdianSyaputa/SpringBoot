package com.toko.tokoonline.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {
    public static <T> ResponseEntity<CommonResponse<T>> ok (T data) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setMessage("Succes");
        response.setStatus("200");
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<CommonResponse<T>> error(String error, HttpStatus httpStatus) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setMessage(String.valueOf(httpStatus));
        response.setStatus(httpStatus.name());
        response.setData((T) error);
        return new ResponseEntity<>(response, httpStatus);
    }
}
