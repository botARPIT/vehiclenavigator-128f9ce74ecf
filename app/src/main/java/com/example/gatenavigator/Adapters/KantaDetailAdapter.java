package com.example.gatenavigator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gatenavigator.Models.KantaDetail;
import com.example.gatenavigator.R;

import java.util.List;

public class KantaDetailAdapter extends BaseAdapter {
    private Context context;
    private List<KantaDetail> kantaDetails;

    public KantaDetailAdapter(Context context, List<KantaDetail> kantaDetails) {
        this.context = context;
        this.kantaDetails = kantaDetails;
    }

    @Override
    public int getCount() {
        return kantaDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return kantaDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.kanta_list_view_item, parent, false);
        }

        KantaDetail detail = kantaDetails.get(position);

        TextView type = convertView.findViewById(R.id.tv_kanta_type);
        TextView weight = convertView.findViewById(R.id.tv_kanta_weight);
        TextView time = convertView.findViewById(R.id.tv_kanta_time);

        type.setText(detail.getType());
        weight.setText(detail.getWeight());
        time.setText(detail.getTime());

        return convertView;
    }
}

