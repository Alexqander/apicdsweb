package com.cds.mx.apicds.utils.aws;

public class Asset {
    private byte[] content;
    private String contentType;

    public Asset(byte[] content, String contentType) {
        this.content = content;
        this.contentType = contentType;
    }

    public Asset() {
    }

    public Asset(byte[] content) {
        this.content = content;
    }

    public Asset(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
