package speechx.com.parcelblelesson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by leashen on 2017/8/20.
 */


public class RecyclerViewAdapterWord extends RecyclerView.Adapter<RecyclerViewAdapterWord.ViewHolder> {


    private Context mContext;
    private List<ArticleWord> wordList;
    private RecyItemClickListener mRecyItemClickListener;

    public RecyclerViewAdapterWord(Context context, List<ArticleWord> words){
        mContext = context;
        wordList = words;
    }

    public void setOnRecyItemClickListener(RecyItemClickListener listener){
        this.mRecyItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_word_item,parent,false);

        return new ViewHolder(view,mRecyItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mWordTv.setText(wordList.get(position).getWord());
    }

    @Override
    public int getItemCount() {
        return wordList == null? 0: wordList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private RecyItemClickListener mItemClickListener;

        @Bind(R.id.word_tv)
        TextView mWordTv;

        @OnClick({R.id.word_tv})
        public void onClick(View view){
            if(mItemClickListener != null){
                mItemClickListener.onItemClick(view,getAdapterPosition());
            }
        }
        public ViewHolder(View itemView, RecyItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.mItemClickListener = listener;

        }
    }


}
