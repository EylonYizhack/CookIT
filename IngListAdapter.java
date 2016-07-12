package com.chatter.android.uploadrec;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eylon Yizhack on 7/11/2016.
 */
public class IngListAdapter extends BaseAdapter {
   Context context;
    List<Ingredients> inglist;
    public IngListAdapter(){}
    public List<String> chList=new ArrayList<>();

    public IngListAdapter(Context context,List inglist) {
        this.context = context;
        this.inglist=new ArrayList<>();
        this.inglist=inglist;
        chList.add("מחק רכיב");
        chList.add("מחק את כל הרכיבי");

    }

    @Override
    public int getCount() {
        return inglist.size() ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        final LinearLayout Llayout = new LinearLayout(context);
        Llayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView tvAmountNum = new TextView(context);
        tvAmountNum.setText(inglist.get(position).numAmount + " ");
        tvAmountNum.setTextSize(25);
        final TextView tvAmount = new TextView(context);
        tvAmount.setText(inglist.get(position).amount  + " ");
        tvAmount.setTextSize(25);
        TextView tvIng = new TextView(context);
        tvIng.setText(inglist.get(position).Ing  + " ");
        tvIng.setTextSize(25);
        Llayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        Llayout.setClickable(true);

        Llayout.addView(tvAmountNum);
        Llayout.addView(tvAmount);
        Llayout.addView(tvIng);
        final Ingredients iLP=inglist.get(position); //****

        Llayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog bldr = new AlertDialog.Builder(context).create();
                final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = vi.inflate(R.layout.custom_listview, null);
                ListView lst = (ListView)view.findViewById(R.id.cusAmountList);
                final ArrayAdapter<String> adapter = new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,chList);;
                lst.setAdapter(adapter);
                bldr.setView(view);
                lst.setClickable(true);
                lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if (chList.get(position).equals("מחק רכיב"))
                        {
                            inglist.remove(iLP);
                        }
                        else
                        {
                            inglist.clear();

                        }
                        bldr.dismiss();
                        notifyDataSetChanged();
                    }
                });

                bldr.show();
            }
        });
        return Llayout;
    }

}
