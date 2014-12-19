package com.beautyideainterface.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.beautyideainterface.activity.R;
import com.beautyideainterface.bean.List_informations;
import com.beautyideainterface.utils.ParseJson;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by i-you on 14-12-18.
 */
public class MainListViewAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private ArrayList<List_informations> temp_datasource;

    public MainListViewAdapter (Context context,ArrayList<List_informations> temp_datasource){
        inflater = LayoutInflater.from(context);
        this.temp_datasource = temp_datasource;
    }
    @Override
    public int getCount() {

        if (temp_datasource==null){
            return 0;
        }else {

            return temp_datasource.size() ;
        }
    }

    @Override
    public Object getItem(int position) {

        return temp_datasource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        List_informations informations = temp_datasource.get(position);
        Holder mHolder;
        if(convertView ==null){
            convertView = inflater.inflate(R.layout.adapter_main_listview,null);
            mHolder = new Holder();
            mHolder.imageView = (NetworkImageView) convertView.findViewById(R.id.thumbnail);
            mHolder.duration_hour = (TextView) convertView.findViewById(R.id.duration_hour);
            mHolder.duration_min = (TextView) convertView.findViewById(R.id.duration_min);
            mHolder.title = (TextView) convertView.findViewById(R.id.title);
            mHolder.viewCount = (TextView) convertView.findViewById(R.id.viewCount);
        }else {
            mHolder = (Holder) convertView.getTag();
        }
        //计算视频时间
        String duration = informations.getDuration();
        BigDecimal bigDecimal=new BigDecimal(duration).setScale(0, BigDecimal.ROUND_HALF_UP);
        int hour = bigDecimal.intValue()/60;
        String mHour = (hour > 10) ? (hour + "") : ("0" + hour);
        int min = bigDecimal.intValue()%60;
        String mMin  = (min > 10) ? (min + "") : ("0" + min);
        Log.i("TEST",mHour+":"+mMin+","+hour+","+min);
//        mHolder.duration_hour.setText(null);
//        mHolder.duration_min.setText(null);
//
//        mHolder.duration_hour.setText(mHour);
//        mHolder.duration_min.setText(mMin);


        return convertView;
    }
    class Holder{
        NetworkImageView imageView;
        TextView duration_hour;
        TextView duration_min;
        TextView title;
        TextView viewCount;
    }
}
