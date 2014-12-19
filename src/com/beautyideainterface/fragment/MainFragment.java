package com.beautyideainterface.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beautyideainterface.activity.MainActivity;
import com.beautyideainterface.activity.R;
import com.beautyideainterface.adapter.MainListViewAdapter;
import com.beautyideainterface.utils.ParseJson;
import com.beautyideainterface.utils.Path_Url;

public class MainFragment extends Fragment {
    private ParseJson mParseJson;
    private ListView main_listView;
    private RequestQueue mQueue;
    private Context context;
    private int pageNo;
    private MainListViewAdapter mMainListAdapter;

    public MainFragment() {
        super();
    }

    public MainFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        pageNo = 0;
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        main_listView = (ListView) view.findViewById(R.id.main_listView);

        mQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(
                Path_Url.PATH_URL1 + pageNo + Path_Url.PATH_URL2,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mParseJson = new ParseJson(response);
                        mMainListAdapter = new MainListViewAdapter(context, mParseJson.parselistInfo());

                        main_listView.setAdapter(mMainListAdapter);
                        mMainListAdapter.notifyDataSetChanged();
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        request.setTag("down");
        mQueue.add(request);
        return view;
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//
//        mQueue.cancelAll(new RequestQueue.RequestFilter() {
//            @Override
//            public boolean apply(Request<?> request) {
//                if ("down".equals(request.getTag())){
//
//                }
//                return false;
//            }
//        });
//
//    }
}
