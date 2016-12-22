package com.function.demo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.function.demo.R;
import com.function.demo.dao.TBagFunctionItem;

import java.util.List;

/**
 * Created by yangkunjian on 2016/12/4.
 */

public class FunctionAdapter extends TBagAdapter<TBagFunctionItem,FunctionAdapter.Holder> {

    public FunctionAdapter(Context context, List<TBagFunctionItem> list) {
        super(context, list);
    }

    @Override
    public int getResource() {
        return R.layout.layout_tbag_item;
    }

    @Override
    public Holder initHolder(View convertView) {
        Holder holder = new Holder();
        holder.tv = (TextView) convertView.findViewById(R.id.tv);
        return holder;
    }

    @Override
    public void setValue(Holder holder, TBagFunctionItem tBagFunctionItem,int position) {
        holder.tv.setText(tBagFunctionItem.getTv());
    }

    class Holder{
        TextView tv;
    }
}
