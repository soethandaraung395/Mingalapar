package com.firstappsta.mingalapar.Data;

import android.util.Log;

import javax.sql.StatementEvent;

public class WordData {


    private int voiceId;
    private int imgId;
    private String textMm;
    private String textEng;
    private  String desc = "";

    public WordData( String textMm, String textEng, int imgId, int voiceId){
        this.voiceId = voiceId;
        this.imgId = imgId;
        this.textMm = textMm;
        this.textEng = textEng;
    }

    public WordData( String textMm, String textEng, int imgId, int voiceId, String desc){
        this.voiceId = voiceId;
        this.imgId = imgId;
        this.textMm = textMm;
        this.textEng = textEng;
        this.desc = desc;
    }

    public int getVoiceId() {
        return voiceId;
    }

    public void setVoiceId(int voiceId) {
        this.voiceId = voiceId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTextMm() {
        return textMm;
    }

    public void setTextMm(String textMm) {
        this.textMm = textMm;
    }

    public String getTextEng() {
        return textEng;
    }

    public void setTextEng(String textEng) {
        this.textEng = textEng;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
