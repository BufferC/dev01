package com.fc.entity;

public class TbMusic {
    private Integer musicId;

    private String musicName;

    private String musicAlbumName;

    private String musicAlbumPicUrl;

    private String musicMp3Url;

    private String musicArtistName;

    private Integer sheetId;

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName == null ? null : musicName.trim();
    }

    public String getMusicAlbumName() {
        return musicAlbumName;
    }

    public void setMusicAlbumName(String musicAlbumName) {
        this.musicAlbumName = musicAlbumName == null ? null : musicAlbumName.trim();
    }

    public String getMusicAlbumPicUrl() {
        return musicAlbumPicUrl;
    }

    public void setMusicAlbumPicUrl(String musicAlbumPicUrl) {
        this.musicAlbumPicUrl = musicAlbumPicUrl == null ? null : musicAlbumPicUrl.trim();
    }

    public String getMusicMp3Url() {
        return musicMp3Url;
    }

    public void setMusicMp3Url(String musicMp3Url) {
        this.musicMp3Url = musicMp3Url == null ? null : musicMp3Url.trim();
    }

    public String getMusicArtistName() {
        return musicArtistName;
    }

    public void setMusicArtistName(String musicArtistName) {
        this.musicArtistName = musicArtistName == null ? null : musicArtistName.trim();
    }

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }
}