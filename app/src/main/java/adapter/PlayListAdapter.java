package adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson34.OnItemClickListener;
import com.example.lesson34.R;

import java.util.ArrayList;

import models.PlayList;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.ViewHolder> {
    private ArrayList<PlayList> playLists;
    private OnItemClickListener listener;
    private Context context;
    private final int FIRST_TYPE = 0;
    private final int SECOND_TYPE = 1;

    public PlayListAdapter(Context context, ArrayList<PlayList> playLists, OnItemClickListener listener) {
        this.context = context;
        this.playLists = playLists;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == FIRST_TYPE) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_first, parent, false));
        } else {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (playLists.get(position).getType() == 1) {
            return FIRST_TYPE;
        } else {
            return SECOND_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(playLists.get(position),listener);

    }

    @Override
    public int getItemCount() {
        return playLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView num;
        private TextView song;
        private TextView singer;
        private TextView duration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.nums);
            song = itemView.findViewById(R.id.song);
            singer = itemView.findViewById(R.id.singer);
            duration = itemView.findViewById(R.id.durat);

        }

        public void onBind(PlayList playLists, OnItemClickListener listener) {
            num.setText(playLists.getNum());
            song.setText(playLists.getSong());
            singer.setText(playLists.getSinger());
            duration.setText(playLists.getDuration());
            itemView.setOnClickListener(v -> {
                listener.onItemClick(playLists,getAdapterPosition());
                Log.d("ololo", "onBind:+ "+ getAdapterPosition());
            });
        }
    }

}
