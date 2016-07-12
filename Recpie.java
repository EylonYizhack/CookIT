package com.chatter.android.uploadrec;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Eylon Yizhack on 7/10/2016.
 */
public class Recpie {
    public String userName;
    public String recpieName;
    public String Time;
    public String category;
    public String people;
    public String hezka;
    public String worth;
    public String lvl;
    public String hollyday;
    public String halfy;
    public String id;



    public Recpie(){}  //empty constructor, must have


    public Recpie(String id,String userName, String recpieName, String time, String category, String people, String hezka, String worth, String lvl, String hollyday, String halfy)
    {
        this.userName = userName;
        this.recpieName = recpieName;
        this.Time = time;
        this.category = category;
        this.people = people;
        this.hezka = hezka;
        this.worth = worth;
        this.lvl = lvl;
        this.hollyday = hollyday;
        this.halfy = halfy;
        this.id = id;
    }

    public void saveRecpie()
    {
        //create an instance of User class
        Recpie recpie=new Recpie(id,userName,recpieName,Time,category,people,hezka,worth,lvl,hollyday,halfy);

        //creating a connection to fire base
        FirebaseDatabase database=FirebaseDatabase.getInstance();

        //creating a reference to Users object
        DatabaseReference myRef=database.getReference(id);

        //saving the user under the UUID
        myRef.child(String.valueOf(recpieName)).setValue(recpie);
    }
}
