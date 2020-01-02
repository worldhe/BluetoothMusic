package com.world.music.entity;

public class Music {

    //歌曲名
    private String title;

    //歌手
    private String singer;

    //专辑
    private String album;

    //长度
    private long size;

    //时长
    private int duration;

    //路径
    private String url;

    //显示文件名称
    private String _dispaly_name;

    //类型
    private String mime_type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String get_dispaly_name() {
        return _dispaly_name;
    }

    public void set_dispaly_name(String _dispaly_name) {
        this._dispaly_name = _dispaly_name;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public Music(String title, String singer, String album, long size, int duration, String url, String _dispaly_name, String mime_type) {
        this.title = title;
        this.singer = singer;
        this.album = album;
        this.size = size;
        this.duration = duration;
        this.url = url;
        this._dispaly_name = _dispaly_name;
        this.mime_type = mime_type;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", album='" + album + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                ", url='" + url + '\'' +
                ", _dispaly_name='" + _dispaly_name + '\'' +
                ", mime_type='" + mime_type + '\'' +
                '}';
    }
}
