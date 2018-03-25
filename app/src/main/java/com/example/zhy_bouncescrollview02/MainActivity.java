package com.example.zhy_bouncescrollview02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.zhy_bouncescrollview02.BounceScrollView.Callback;

import java.util.ArrayList;

public class MainActivity extends Activity {

    //    private ListView mListView;
    private BounceScrollView mScrollView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScrollView = (BounceScrollView) findViewById(R.id.id_scrollView);
        mScrollView.setCallBack(new Callback() {

            @Override
            public void callback() {
                Toast.makeText(MainActivity.this, "you can do something!", Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


//        mListView = (ListView) findViewById(R.id.id_listView);
//        mListView.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, new ArrayList<String>(
//                Arrays.asList("Hello", "World", "Welcome", "Java",
//                        "Android", "Lucene", "C++", "C#", "HTML",
//                        "Welcome", "Java", "Android", "Lucene", "C++",
//                        "C#", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML", "HTML",
//                        "HTML", "HTML", "HTML", "HTML"))));

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.rl);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);
//        解决冲突滑动
        mRecyclerView.setNestedScrollingEnabled(false);
    }

    private void initData() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new MyAdapter(getData());
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for (int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }


}
