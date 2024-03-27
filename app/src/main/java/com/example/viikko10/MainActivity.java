package com.example.viikko10;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        UserStorage.getInstance().loadUsers(context);
    }

    public void switchToAddUser(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void switchToUserList(View view) {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }
    public void loadUsers() {
        UserStorage.getInstance().loadUsers(context);
    }
}