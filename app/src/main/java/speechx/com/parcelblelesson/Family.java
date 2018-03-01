package speechx.com.parcelblelesson;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by leashen on 2017/8/20.
 */

public class Family implements Parcelable {
    private int count;

    public int getCount(){
        return count;
    }

    public Family(int c){
        count = c;
    }

    protected Family(Parcel in) {
        count = in.readInt();
    }

    public static final Creator<Family> CREATOR = new Creator<Family>() {
        @Override
        public Family createFromParcel(Parcel in) {
            return new Family(in);
        }

        @Override
        public Family[] newArray(int size) {
            return new Family[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
    }
}
