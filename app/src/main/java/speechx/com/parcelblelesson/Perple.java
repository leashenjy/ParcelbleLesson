package speechx.com.parcelblelesson;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by leashen on 2017/8/18.
 */

public class Perple  implements Parcelable {

    private String nameL;
    private int ageL;

    private Family familyL;

    public Perple(String name, int age, Family family){
        nameL = name;
        ageL = age;

        familyL = family;
    }

    public void setNameL(String name){
        nameL = name;
    }

    public void setAgeL(int age){
        ageL = age;
    }

    public String getNameL(){
        return nameL;
    }

    public int getAgeL(){
        return ageL;
    }

    public Family getFamilyL(){
        return familyL;
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameL);
        dest.writeInt(ageL);
        dest.writeParcelable(familyL,flags);
    }

    public static final Parcelable.Creator<Perple> CREATOR = new Parcelable.Creator<Perple>() {

        @Override
        public Perple createFromParcel(Parcel source) {
            return new Perple(source);
        }

        @Override
        public Perple[] newArray(int size) {
            return new Perple[0];
        }
    };

    private Perple(Parcel source){
        nameL = source.readString();
        ageL = source.readInt();
        familyL = source.readParcelable(Family.class.getClassLoader());

    }
}
