package speechx.com.parcelblelesson;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AbcDialogFragment mDialogragment;
    private ArticleLoadDataManager mDataManager;
    private List<String> mTitleList;
    private Article mArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataManager = ArticleLoadDataManager.getManager();
        mTitleList = mDataManager.getTitleList();
        mArticle = mDataManager.getArticleList().get(mTitleList.get(0));

        final Perple perple = new Perple("zhong",28, new Family(99));
        Button button = (Button) findViewById(R.id.buttonPanel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("value",perple);
//                intent.putExtras(bundle);
//                startActivity(intent);

                showDialog(mArticle.getArticleLineList().get(0));

            }
        });


    }

    private void showDialog(ArticleLine articleLine) {

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            Log.w("leashen","原来的dilog还存在");
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        mDialogragment = AbcDialogFragment.newInstance(articleLine);
        //mDialogragment.setCancelable(false);
        mDialogragment.show(getSupportFragmentManager(),"dialog");

    }
}
