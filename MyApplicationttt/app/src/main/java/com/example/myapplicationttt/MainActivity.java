package com.example.myapplicationttt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableObserver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationttt.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListModel.AlbumBean> albumBeans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(activityMainBinding.getRoot());

        RecyclerView recyclerView = activityMainBinding.recycler;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {

            class ListViewHold extends RecyclerView.ViewHolder {

                public ListViewHold(@androidx.annotation.NonNull View itemView) {
                    super(itemView);
                }
            }

            @androidx.annotation.NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {

                TextView textView = (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);

                return new ListViewHold(textView);
            }

            @Override
            public void onBindViewHolder(@androidx.annotation.NonNull RecyclerView.ViewHolder holder, int position) {

                TextView textView = (TextView)holder.itemView;

                ListModel.AlbumBean albumBean = albumBeans.get(position);

                textView.setText(albumBean.getTitle());
            }

            @Override
            public int getItemCount() {

                if (albumBeans == null) {

                    return 0;
                }
                return albumBeans.size();
            }
        };

        recyclerView.setAdapter(adapter);

        DisposableObserver disposableObserver = new DisposableObserver<ListModel>() {
            @Override
            public void onNext(ListModel o) {

                albumBeans = o.getAlbum();

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Toast.makeText(MainActivity.this,"请求失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

                Toast.makeText(MainActivity.this,"请求成功",Toast.LENGTH_SHORT).show();
            }
        };

        TestHttps.getInstance().requestList(disposableObserver);

    }
}
