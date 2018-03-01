package speechx.com.parcelblelesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        Perple perple =(Perple) bundle.getParcelable("value");
        Log.w("leashen",perple.getNameL()+"   "+perple.getAgeL()+"  family count:"+perple.getFamilyL().getCount());


    }
}
