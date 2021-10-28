package fragments;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson34.MainActivity;
import com.example.lesson34.OnItemClickListener;
import com.example.lesson34.R;
import com.example.lesson34.SecondActivity;

import java.util.ArrayList;

import adapter.PlayListAdapter;
import models.PlayList;

public class SecondFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlayListAdapter playListAdapter;
    private OnItemClickListener listener;
    private ArrayList<PlayList> playLists = new ArrayList<>();

    public SecondFragment(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SecondFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playListCreated();
        recyclerView = view.findViewById(R.id.recycler);
        listener = (playList,position) -> {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("key", playLists.get(position).getSong());
                startActivity(intent);

        };
        playListAdapter = new PlayListAdapter(this.getActivity(),playLists,listener);
        recyclerView.setAdapter(playListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void playListCreated() {
        playLists.add(new PlayList("1","Blank Space","Taylor Swift","3:22"));
        playLists.add(new PlayList("2","Watch Me","Silento","5:36"));
        playLists.add(new PlayList("3","Earned It","The Weekend","4:51"));
        playLists.add(new PlayList("4","The Hills","The Weekend","3:41"));
        playLists.add(new PlayList("5","Shape Of My Heart","Sting","5:33"));
    }
}