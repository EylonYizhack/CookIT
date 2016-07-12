package com.chatter.android.uploadrec;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.style.LineHeightSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    Context context;
    EditText rName,timeTillDone;
    Button category,people,hezka,worth,lvl,hollyday,halfy;

    private static List<String> categoryList;
    private static List<String> peopleList;
    private static List<String> hezkaList;
    private static List<String> worthList;
    private static List<String> lvlList;
    private static List<String> hollydayList;
    private static List<String> halfyList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        context=this;


        rName = (EditText)findViewById(R.id.rName);
        timeTillDone = (EditText)findViewById(R.id.timeTillDone);

        //Buttons pointers
        category = (Button)findViewById(R.id.category);
        people = (Button)findViewById(R.id.people);
        hezka = (Button)findViewById(R.id.hezka);
        worth = (Button)findViewById(R.id.worth);
        lvl = (Button)findViewById(R.id.lvl);
        hollyday = (Button)findViewById(R.id.hollyday);
        halfy = (Button)findViewById(R.id.halfy);




        //creation of the list
        categoryList = new ArrayList<>();
        peopleList = new ArrayList<>();
        hezkaList = new ArrayList<>();
        worthList = new ArrayList<>();
        lvlList = new ArrayList<>();
        hollydayList = new ArrayList<>();
        halfyList = new ArrayList<>();


        //enter options to the list
        categoryList.add("ארוחת בוקר");categoryList.add("ארוחת ערב"); categoryList.add("ארוחת צהריים");
        peopleList.add("1");peopleList.add("2"); peopleList.add("3");peopleList.add("4");peopleList.add("5"); peopleList.add("6");peopleList.add("7");peopleList.add("8"); peopleList.add("9"); peopleList.add("10");
        hezkaList.add("בשרי");hezkaList.add("חלבי");hezkaList.add("מעורב");hezkaList.add("פרווה");
        worthList.add("תקציב נמוך");worthList.add("תתקציב בינוני");worthList.add("יוקרתי");
        lvlList.add("מתחילים");lvlList.add("בעלי ניסיון");lvlList.add("מקצוענים");
        hollydayList.add("ללא");hollydayList.add("ראש השנה");hollydayList.add("חנוכה");hollydayList.add("פורים");hollydayList.add("פסח");hollydayList.add("שבועות");
        halfyList.add("בריא מאוד!");halfyList.add("בריא");halfyList.add("בינוני"); halfyList.add("משמין");


        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInflater(context,category,categoryList);
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInflater(context,people,peopleList);
            }
        });
        hezka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInflater(context,hezka,hezkaList);
            }
        });
        worth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInflater(context,worth,worthList);
            }
        });
        lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInflater(context,lvl,lvlList);
            }
        });
        hollyday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInflater(context,hollyday,hollydayList);
            }
        });
        halfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInflater(context,halfy,halfyList);
            }
        });
    }


    //-----------------------------------------

    public void setInflater(Context context, final Button btnName, final List listName)
    {
        final AlertDialog bldr = new AlertDialog.Builder(context).create();
        final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = vi.inflate(R.layout.custom_listview, null);
        ListView lst = (ListView)view.findViewById(R.id.cusAmountList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,android.R.layout.simple_selectable_list_item,listName);
        lst.setAdapter(adapter);
        bldr.setView(view);
        lst.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        lst.setTextDirection(View.TEXT_DIRECTION_RTL);
        lst.setClickable(true);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btnName.setText(listName.get(position).toString());
                bldr.dismiss();
            }
        });

        bldr.show();
    }
    //-----------------------------------------








    //__________________________________________________________________________________________________
    public void dSave(View view)
    {
        //create empty intent for puting data
        Intent i = new Intent();
        //put data in the intent
        i.putExtra("rName",rName.getText().toString());
        i.putExtra("timeTillDone",timeTillDone.getText().toString());
        i.putExtra("category",category.getText().toString());
        i.putExtra("people",people.getText().toString());
        i.putExtra("hezka",hezka.getText().toString());
        i.putExtra("worth",worth.getText().toString());
        i.putExtra("lvl",lvl.getText().toString());
        i.putExtra("hollyday",hollyday.getText().toString());
        i.putExtra("halfy",halfy.getText().toString());


        //return result with code RESULT_OK
        setResult(Activity.RESULT_OK,i);
        //kill the activity
        finish();
    }

    public void dCanceled(View view)
    {
        //create empty intent for puting data
        Intent i = new Intent();
        //return result with code RESULT_OK
        setResult(Activity.RESULT_CANCELED,i);
        //kill the activity
        finish();
    }
}
