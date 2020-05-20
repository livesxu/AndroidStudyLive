package com.example.myapplication4;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.test_fragment,container,false);

        ConstraintLayout constraintLayout = view.findViewById(R.id.test_fragment);

        RecyclerView recyclerView = new RecyclerView(view.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setId(R.id.recycle1);
        recyclerView.setBackgroundColor(Color.BLUE);
        ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT);
        para.topToTop = R.id.test_fragment;
        para.leftToLeft = R.id.test_fragment;
        para.rightToRight = R.id.test_fragment;
        para.bottomToBottom = R.id.test_fragment;
        para.topMargin = 20;
        para.leftMargin = 20;
        para.rightMargin = 20;
        para.bottomMargin = 20;

        constraintLayout.addView(recyclerView,para);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {

            class AHolder extends RecyclerView.ViewHolder {

                TextView textView;
                public AHolder(@NonNull TextView textView) {
                    super(textView);

                    this.textView = textView;
                }
            }
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                TextView textView = new TextView(parent.getContext());

                textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

                return new AHolder(textView);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

                AHolder aHolder = (AHolder)holder;
                aHolder.textView.setText("这是一个列表子串");
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        };

        RecyclerView recyclerView = getView().findViewById(R.id.recycle1);
        recyclerView.setAdapter(adapter);
    }
}
