package com.example.viikko10;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListUserActivity extends AppCompatActivity {

    private UserStorage ustorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_in_recycle_view);

        ustorage = UserStorage.getInstance();
        ArrayList<User> users = ustorage.getUsers();
        recyclerView = findViewById(R.id.rvUserView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserListAdapter(getApplicationContext(), users));
    }
}