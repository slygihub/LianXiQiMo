package com.example.dell.lianxiqimo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.dell.lianxiqimo.adapter.ARecAdapter;
import com.example.dell.lianxiqimo.ben.Bean;
import com.example.dell.lianxiqimo.model.MyModelimp;
import com.example.dell.lianxiqimo.person.MyPersonimp;
import com.example.dell.lianxiqimo.view.MyView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements MyView {


    private ImageView im;
    private GridView gv;
    private RecyclerView rec;
    private ArrayList<Bean.DataBean> list;
    private ARecAdapter adapter;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        initView(view);
        list = new ArrayList<>();
        adapter = new ARecAdapter(list, getContext());
        rec.setAdapter(adapter);
        MyPersonimp personimp = new MyPersonimp(new MyModelimp(), this);
        personimp.p();

        return view;
    }

    private void initView(View view) {
        im = (ImageView) view.findViewById(R.id.im);

        rec = (RecyclerView) view.findViewById(R.id.rec);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        rec.setLayoutManager(manager);
    }

    @Override
    public void cheng(Bean bean) {
        List<Bean.DataBean> data = bean.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
