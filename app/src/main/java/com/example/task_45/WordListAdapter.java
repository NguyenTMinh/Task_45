package com.example.task_45;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private static final String TAG = "TAG";
    private List<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, List<String> list){
        mWordList = list;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View itemView = mInflater.inflate(R.layout.wordlist_item,parent,false);
        return new WordViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        String current = mWordList.get(position);
        holder.wordItemView.setText(current);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWordList.set(position,"Clicked! "+current);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public void setmWordList(List<String> list){
        mWordList = list;
        this.notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            mAdapter = adapter;
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            int position = getLayoutPosition();
//            String element = mWordList.get(position);
//            mWordList.set(position,"Clicked! "+element);
//            mAdapter.notifyDataSetChanged();
//        }
    }
}
