package com.xcg.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xiongchengguang on 2018/4/12.
 */

public class GridAdapter extends BaseAdapter {
    private List<String> stringList;

    public GridAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
            viewHolder.tvValue = convertView.findViewById(R.id.value);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvValue.setText(stringList.get(position));
        return convertView;
    }

    class ViewHolder {
        private TextView tvValue;
    }

}
