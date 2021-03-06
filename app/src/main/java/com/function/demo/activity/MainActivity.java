package com.function.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.function.demo.R;
import com.function.demo.adapter.FunctionAdapter;
import com.function.demo.dao.TBagFunctionItem;
import com.function.demo.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvList;
    private List<TBagFunctionItem> list;
    private FunctionAdapter adapter;
    private TextView tvTop;
    private int step;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();
    }
    private void initData() {
        tvTop = (TextView)findViewById(R.id.tvTop);

        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new TBagFunctionItem("编号:"+i));
        }
        adapter = new FunctionAdapter(this,list);
    }
    private void initViews() {
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(adapter);
    }

    public void onPre(View view){
        tvTop.setText(TimeUtils.getLastTimeInterval(--step));
    }

    public void onNext(View view){
        tvTop.setText(TimeUtils.getLastTimeInterval(++step));
    }
}
