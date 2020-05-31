package com.example.myapplication4;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewTestFragment extends Fragment {

    private String id;
    private RecyclerView.Adapter adapter;
    private Handler handler = new Handler();
    public NewTestFragment(String id) {

        this.id = id;
    }
    private List<NewTestPageItemModel.PictureBean> items;
    private ImageLoader imageLoader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_test_fragment,container,false);

        adapter = new RecyclerView.Adapter() {

            class ItemHolder extends RecyclerView.ViewHolder {

                public ItemHolder(@NonNull View itemView) {
                    super(itemView);
                }
            }
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view1 = inflater.inflate(R.layout.new_test_fragment_adapter_item,parent,false);

                return new ItemHolder(view1);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

                NewTestPageItemModel.PictureBean pictureBean = getItems().get(position);

                ConstraintLayout layout = (ConstraintLayout)holder.itemView;

                ImageView imageView = layout.findViewById(R.id.image);
                TextView textView = layout.findViewById(R.id.text);

                imageLoader.displayImage(pictureBean.getUrl(),imageView);
                textView.setText(pictureBean.getContent());
            }

            @Override
            public int getItemCount() {
                return getItems().size();
            }
        };

        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public List<NewTestPageItemModel.PictureBean> getItems() {
        if (items == null){

            items = new ArrayList<>();
        }
        return items;
    }

    @Override
    public void onStart() {
        super.onStart();

        imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(getContext()).build();
        imageLoader.init(imageLoaderConfiguration);

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(String.format("http://dili.bdatu.com/jiekou/albums/a%s.html",id)).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.v("zzz","请求失败" + call.request().url());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                NewTestPageItemModel model = gson.fromJson(response.body().string(),NewTestPageItemModel.class);
                items = model.getPicture();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
