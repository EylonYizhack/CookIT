package com.chatter.android.uploadrec;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Eylon Yizhack on 7/10/2016.
 */
public class User
{
    private String userName;
    private String uuid;

    public User(String userName , String uuid)  {
        this.userName = userName;
        this.uuid = uuid;
    }
    public void saveUser()
    {
        //create an instance of User class
        User user=new User(userName,uuid);

        //creating a connection to fire base
        FirebaseDatabase database=FirebaseDatabase.getInstance();

        //creating a reference to Users object
        DatabaseReference myRef=database.getReference("User");

        //saving the user under the UUID
        myRef.child(String.valueOf(uuid)).setValue(user);
    }
    public String getUserName()
    {
        return this.userName;
    }
    public String getUuid()
    {
        return this.uuid;
    }
}
