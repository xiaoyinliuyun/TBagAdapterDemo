package com.function.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by yangkunjian on 2016/12/1.
 */

public abstract class TBagAdapter<T, H> extends BaseAdapter {

    private List<T> list;
    private Context context;
    private LayoutInflater inflater;

    public TBagAdapter(Context context, List<T> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        H h = null;
        if (convertView == null) {
            convertView = inflater.inflate(getResource(), null);
            h = initHolder(convertView);
            convertView.setTag(h);
        } else {
            h = (H) convertView.getTag();
        }

        T t = (T) list.get(position);
        setValue(h,t,position);
        return convertView;
    }

    public abstract int getResource();

    public abstract H initHolder(View convertView);

    public abstract void setValue(H h,T t,int position);
}
