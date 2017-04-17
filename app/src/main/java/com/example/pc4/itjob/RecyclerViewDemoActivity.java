package com.example.pc4.itjob;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by PC4 on 2017/4/13.
 */

public class RecyclerViewDemoActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        TitileBar.getTitleBar(this, "RecyclerView_Demo");
        setContentView(R.layout.recyclerview_layout);

        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());
    }

    protected void initData(){
        mDatas = new ArrayList<>();
        for(int i = 'A'; i < 'Z'; i++)
            mDatas.add(""+(char) i);
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(RecyclerViewDemoActivity.this).inflate(R.layout.recyclerview_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView tv;
            public MyViewHolder(View view){
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}
