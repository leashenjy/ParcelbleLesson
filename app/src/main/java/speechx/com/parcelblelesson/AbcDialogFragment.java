package speechx.com.parcelblelesson;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by leashen on 2017/8/20.
 */

public class AbcDialogFragment extends DialogFragment {

    private ArticleLine mData;


    public static AbcDialogFragment newInstance(ArticleLine articleLine){
        AbcDialogFragment fragment = new AbcDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("articleLine", articleLine);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        mData = (ArticleLine) getArguments().getParcelable("articleLine");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceSate){
        //super.onCreateView(inflater,container,saveInstanceSate);
        View view = inflater.inflate(R.layout.abc_dialog_fragment,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_word);
        RecyclerViewAdapterWord adapterWord = new RecyclerViewAdapterWord(getContext(),mData.getRecList());
        recyclerView.setAdapter(adapterWord);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        TextView titleTV = (TextView)view.findViewById(R.id.dialog_title);
        titleTV.setText("Great! "+mData.getScore()+"分");
        Log.w("leashen",titleTV.getText()+"");

        final TextView dictTV = (TextView)view.findViewById(R.id.syllable_dict);
        final TextView recTV  = (TextView)view.findViewById(R.id.syllable_rec);

        int n = mData.getRecList().size();
        ArticleWord word = mData.getRecList().get(0);
        for(int i=0; i<n; i++){
            if(mData.getRecList().get(i).is(RecResult.Unclear)){
                word = mData.getRecList().get(i);
                break;
            }
        }
        for(int i=0; i<n; i++){
            if(mData.getRecList().get(i).is(RecResult.Error)){
                word = mData.getRecList().get(i);
                break;
            }
        }

        dictTV.setText(word.getSyllableDict());
        recTV.setText(word.getSyllableRec());


        adapterWord.setOnRecyItemClickListener(new RecyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                dictTV.setText(mData.getRecList().get(position).getSyllableDict());
                recTV.setText(mData.getRecList().get(position).getSyllableRec());
            }
        });

        TextView playWord  = (TextView)view.findViewById(R.id.play_word);
        playWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"暂时没有音频",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}