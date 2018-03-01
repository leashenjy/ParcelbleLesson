package speechx.com.parcelblelesson;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by leashen on 2017/8/20.
 */

public class ArticleLine  implements Parcelable{
    private String orginLine;
    private String audioPath;
    private String pcmAudioPath;
    private String stdAudioPath;
    private List<ArticleWord> recList;
    private int score = -1;


    public ArticleLine(String line){
        orginLine = line;
    }

    public void setAudioPath(String path){
        this.audioPath = path;
    }

    public void setPcmAudioPath(String path){
        this.pcmAudioPath = path;
    }

    public void setStdAudioPath(String path){
        this.stdAudioPath = path;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setRecList(List<ArticleWord> list){
        recList = list;
    }

    public String getOrginLine(){
        return this.orginLine;
    }

    public String getAudioPath(){
        return this.audioPath;
    }

    public String getPcmAudioPath(){
        return this.pcmAudioPath;
    }

    public String getStdAudioPath(){
        return this.stdAudioPath;
    }

    public List<ArticleWord> getRecList(){
        return this.recList;
    }

    public int getScore(){
        return this.score;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orginLine);
        dest.writeString(audioPath);
        dest.writeString(pcmAudioPath);
        dest.writeString(stdAudioPath);
        dest.writeList(recList);
        dest.writeInt(score);


    }

    public static final Creator<ArticleLine> CREATOR = new Creator<ArticleLine>() {
        @Override
        public ArticleLine createFromParcel(Parcel in) {
            return new ArticleLine(in);
        }

        @Override
        public ArticleLine[] newArray(int size) {
            return new ArticleLine[size];
        }
    };

    public ArticleLine(Parcel in){
        orginLine = in.readString();
        audioPath = in.readString();
        pcmAudioPath = in.readString();
        stdAudioPath = in.readString();
        recList = in.readArrayList(ArticleWord.class.getClassLoader());
        score = in.readInt();

    }
}
