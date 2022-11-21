package com.mayikt.common.core.api;

import com.mayikt.common.core.api.constants.ApiConstants;
import lombok.Data;


@Data
public class BaseApiService<T> {

    public BaseResponse<T> setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    /**
     * 返回错误，可以传msg
     *
     * @param msg
     * @return
     */
    public BaseResponse<T> setResultError(String msg) {
        return setResult(ApiConstants.HTTP_RES_CODE_500.getCode(), msg, null);
    }

    /***
     * 返回成功，可以传data值
     * @param data
     * @return
     */
    public BaseResponse<T> setResultSuccessData(T data) {
        return setResult(ApiConstants.HTTP_RES_CODE_200.getCode(), ApiConstants.HTTP_RES_CODE_200.getValue(), data);
    }

    /**
     * 返回成功，沒有data值
     *
     * @return
     */
    public BaseResponse<T> setResultSuccess() {
        return setResult(ApiConstants.HTTP_RES_CODE_200.getCode(), ApiConstants.HTTP_RES_CODE_200.getValue(), null);
    }


    /**
     * 通用封装 通用封装
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */

    public BaseResponse<T> setResult(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }

    public BaseResponse<T> setResultDb(int result) {
        return result > 0 ? setResultSuccess() : setResultError("fail");
    }
}