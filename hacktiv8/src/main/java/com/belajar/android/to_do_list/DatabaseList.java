package com.belajar.android.to_do_list;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DatabaseList {

    private final DatabaseReference databaseReference;

    public DatabaseList(){
        FirebaseDatabase db =  FirebaseDatabase.getInstance();
        databaseReference = db.getReference(ListModuleClass.class.getSimpleName());
    }

    public void add(ListModuleClass listModuleClass){
        databaseReference.push().setValue(listModuleClass);
    }

    public void update(String key, HashMap<String, Object> hashMap){
        databaseReference.child(key).updateChildren(hashMap);
    }

    public void remove(String key){
        databaseReference.child(key).removeValue();
    }

    public Query get(String key){
        return databaseReference.orderByKey();
    }
}
