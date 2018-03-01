package speechx.com.parcelblelesson;

import java.util.List;

/**
 * Created by leashen on 2017/8/20.
 */

public class Article {
    private String title;
    private String pcmPath;   //单句pcm 拼接成的 整篇pcm
    private String wavPath;   // pcmPath 转成的wavPath
    private String combineBgmPath;
    private List<ArticleLine> articleLineList;
    private int currentPosion = 0;

    public Article(String p1, List<ArticleLine> p2){
        title = p1;
        articleLineList = p2;
    }


    public List<ArticleLine> getArticleLineList(){
        return this.articleLineList;
    }

    public String getTitle(){
        return this.title;
    }

    public void setPcmPath(String path){
        this.pcmPath = path;
    }

    public void setAudioPath(String path){
        this.wavPath = path;
    }

    public void setCombineBgmPath(String path){
        this.combineBgmPath = path;
    }

    public String getCombineBgmPath(){
        return combineBgmPath;
    }

    public String getPcmPath(){
        return this.pcmPath;
    }

    public String getAudioPath(){
        return this.wavPath;
    }

    public void setCurrentPosion(int posion){
        this.currentPosion = posion;
    }

    public int getCurrentPosion(){
        return this.currentPosion;
    }

}