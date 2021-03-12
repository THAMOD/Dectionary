package com.almutarreb.dectionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.almutarreb.dectionary.Entities.Words;
import com.almutarreb.dectionary.R;

import java.util.List;

public class RecyclerViewAdaper extends RecyclerView.Adapter<RecyclerViewAdaper.WordViewHolder> {
    private List<Words> wordsList;
    private Context context;
   public RecyclerViewAdaper(Context context)
    {
        this.context=context;
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
View view =inflater.inflate(R.layout.word_list_item,parent,false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
Words cuuremnt_word =wordsList.get(position);
holder.word_name.setText(cuuremnt_word.getWordname());
holder.word_meaning.setText(cuuremnt_word.getWordMean());
holder.word_type.setText(cuuremnt_word.getWordType());
    }
public void setWordsList(List<Words> wordsList)
{
this.wordsList=wordsList;
notifyDataSetChanged();
}
    @Override
    public int getItemCount() {
        return wordsList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        TextView word_name;
        TextView word_meaning;
        TextView word_type;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            word_name=(itemView).findViewById(R.id.word_txt_view);
            word_meaning=(itemView).findViewById(R.id.meaning_txt_view);
            word_type=(itemView).findViewById(R.id.txt_word_type);

        }
    }
}
