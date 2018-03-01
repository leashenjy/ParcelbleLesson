package speechx.com.parcelblelesson;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leashen on 2017/8/20.
 */

public class ArticleWord implements Parcelable{
    private SpannableStringBuilder word;
    private double score;
    List<StdPhone48> phoneArray = new ArrayList<>();
    private RecResult recResult = RecResult.Correct;

    private SpannableStringBuilder syllableRec;
    private SpannableStringBuilder syllableDict;

    public ArticleWord(SpannableStringBuilder word){
        this.word = word;
    }

    public void setWord(SpannableStringBuilder word){
        this.word = word;
    }

    public SpannableStringBuilder getWord(){
        return word;
    }

    private void setScore(double score){
        this.score = score;
    }

    public double getScore(){
        return score;
    }

    public boolean is(RecResult inRecResutl)
    {
        if (recResult.equals(inRecResutl))
            return true;
        else
            return false;
    }

    public void setRecResult(RecResult recResult){
        this.recResult = recResult;
    }

    public List<StdPhone48> getPhoneArray(){return this.phoneArray;}

    public void setPhoneArray(StdPhone48 phone48){phoneArray.add(phone48);}

    public void setSyllableRec(SpannableStringBuilder rec){
        this.syllableRec = rec;
    }

    public void setSyllableDict(SpannableStringBuilder dict){
        this.syllableDict = dict;
    }

    public SpannableStringBuilder getSyllableRec(){
        return this.syllableRec;
    }

    public SpannableStringBuilder getSyllableDict(){
        return this.syllableDict;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        TextUtils.writeToParcel(word,dest,flags);
        dest.writeDouble(score);
        dest.writeList(phoneArray);
        dest.writeString(recResult.name());
        TextUtils.writeToParcel(syllableRec,dest,flags);
        TextUtils.writeToParcel(syllableDict,dest,flags);


    }

    public static final Creator<ArticleWord> CREATOR = new Creator<ArticleWord>() {
        @Override
        public ArticleWord createFromParcel(Parcel in) {
            return new ArticleWord(in);
        }

        @Override
        public ArticleWord[] newArray(int size) {
            return new ArticleWord[size];
        }
    };

    public ArticleWord(Parcel in){
        word = (SpannableStringBuilder)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        score = in.readDouble();
        phoneArray = in.readArrayList(StdPhone48.class.getClassLoader());
        recResult = RecResult.valueOf(in.readString());
        syllableRec = (SpannableStringBuilder)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        syllableDict = (SpannableStringBuilder)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
    }
}

