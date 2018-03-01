package speechx.com.parcelblelesson;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by leashen on 2017/8/20.
 */

public class StdPhone48 implements Parcelable
{
    private StdPhoneName48 m_StdName_Rec = StdPhoneName48.sil;
    private StdPhoneName48 m_StdName_Dict = null;

    private ErrorType m_ErrorType = ErrorType.Sil;
    private double m_nScore;

    public StdPhone48(JSONObject obj)
    {
        set_info_from_phone_JSON(obj);
    }
    private void set_info_from_phone_JSON(JSONObject obj)
    {
        try {
            if (obj.has("rec")){
                set_StdName_Rec(obj.getString("rec"));
            }
            if (obj.has("dict"))
                set_StdName_Dict(obj.getString("dict"));

            if (obj.has("type")){
                set_ErrorType(ErrorType.getValue(obj.getString("type")));
            }
            if (obj.has("score"))
                m_nScore = obj.getDouble("score");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public StdPhoneName48 get_StdName_Rec() {
        return m_StdName_Rec;
    }

    public void set_StdName_Rec(String strName_Rec) {
        if (strName_Rec.trim().compareTo("-") == 0 || strName_Rec.trim().length() < 1)
            this.m_StdName_Rec = StdPhoneName48.sil;
        else
            this.m_StdName_Rec = StdPhoneName48.valueOf(strName_Rec);
    }

    public void set_StdName_Rec(StdPhoneName48 StdName_Rec) {
        this.m_StdName_Rec = StdName_Rec;
    }

    public StdPhoneName48 get_StdName_Dict() {
        return m_StdName_Dict;
    }

    public void set_StdName_Dict(String strPhone_Dict)
    {
        if (strPhone_Dict.trim().compareTo("-") == 0 || strPhone_Dict.trim().length() < 1)
            this.m_StdName_Dict = StdPhoneName48.sil;
        else
            this.m_StdName_Dict = StdPhoneName48.valueOf(strPhone_Dict);
    }

    public void set_StdName_Dict(StdPhoneName48 StdName_Dict) {
        this.m_StdName_Dict = StdName_Dict;
    }

    public boolean is(ErrorType inErrorType)
    {
        return m_ErrorType.equals(inErrorType);
    }

    public ErrorType get_ErrorType() {
        return m_ErrorType;
    }

    public void set_ErrorType(ErrorType inErrorType) {
        this.m_ErrorType = inErrorType;
    }

    public double getScore(){
        return this.m_nScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(m_StdName_Rec==null?"":m_StdName_Rec.name());
        dest.writeString(m_StdName_Dict==null?"":m_StdName_Dict.name());
        dest.writeString(m_ErrorType.name());
        dest.writeDouble(m_nScore);
    }

    public static final Creator<StdPhone48> CREATOR = new Creator<StdPhone48>() {
        @Override
        public StdPhone48 createFromParcel(Parcel in) {
            return new StdPhone48(in);
        }

        @Override
        public StdPhone48[] newArray(int size) {
            return new StdPhone48[size];
        }
    };

    public StdPhone48(Parcel in){
        m_StdName_Rec = StdPhoneName48.getValue(in.readString());
        m_StdName_Dict = in.readString().equals("")?null:StdPhoneName48.getValue(in.readString());
        m_ErrorType = ErrorType.valueOf(in.readString());
        m_nScore = in.readDouble();
    }
}

