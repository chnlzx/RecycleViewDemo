package com.android.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DemoAdpter.OnItemClickLitener {

    private List<String> list = new ArrayList<>();
    private RecyclerView mRv_list;
    private DemoAdpter mDemoAdpter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        mRv_list = (RecyclerView) findViewById(R.id.rv_list);
        mDemoAdpter = new DemoAdpter(this);
        mRv_list.setAdapter(mDemoAdpter);
        mDemoAdpter.setOnItemClickLitener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv_list.setLayoutManager(linearLayoutManager);

    }

    private void initData() {
        gainData();
    }

    private void gainData() {
        for (int i = 0; i < 50; i++) {
            list.add(new String("item： " + i));
        }
        mDemoAdpter.setData(list);
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, list.get(position), Toast.LENGTH_SHORT).show();
    }
}
