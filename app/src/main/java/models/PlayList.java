package models;

public class PlayList {
    private String num;
    private String song;
    private String singer;
    private String duration;
    private int type;

    public PlayList(String num, String song, String singer, String duration) {
        this.num = num;
        this.song = song;
        this.singer = singer;
        this.duration = duration;
    }

    public int getType() {
        return type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
