package com.p_xhelper_smart.p_xhelper_smart.impl;

/*
 * Created by qianli.ma on 2019/7/26 0026.
 */
public class XResponceBody<T> {

    private String jsonrpc;
    private T result;
    private String id;
    private FwError fwError;

    public XResponceBody() {
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FwError getFwError() {
        return fwError;
    }

    public void setFwError(FwError fwError) {
        this.fwError = fwError;
    }
}
