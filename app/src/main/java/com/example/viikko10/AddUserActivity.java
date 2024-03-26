package com.example.viikko10;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }
    public void addUser(View view) {
        EditText editFirstName = findViewById(R.id.editFirstName);
        EditText editLastName = findViewById(R.id.editLastName);
        EditText editEmail = findViewById(R.id.editEmail);
        RadioGroup rgUserProgram = findViewById(R.id.radioDegreeProgram);
        CheckBox bcCheckBox = findViewById(R.id.bcCheckBox);
        CheckBox msCheckBox = findViewById(R.id.msCheckBox);
        CheckBox lciCheckBox = findViewById(R.id.lciCheckBox);
        CheckBox phdCheckBox = findViewById(R.id.phdCheckBox);

        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();
        String degreeProgram = "";
        ArrayList<String> degrees = new ArrayList<>();

        if (rgUserProgram.getCheckedRadioButtonId() == R.id.seRadioButton) {
            degreeProgram = "Software Engineering";
        } else if (rgUserProgram.getCheckedRadioButtonId() == R.id.imRadioButton) {
            degreeProgram = "Industrial Management";
        } else if (rgUserProgram.getCheckedRadioButtonId() == R.id.ceRadioButton) {
            degreeProgram = "Computational Engineering";
        } else if (rgUserProgram.getCheckedRadioButtonId() == R.id.eeRadioButton) {
            degreeProgram = "Electrical Engineering";
        }

        if (phdCheckBox.isChecked()) {
            degrees.add("Doctoral degree");
        }
        if (lciCheckBox.isChecked()) {
            degrees.add("Licenciate");
        }
        if (msCheckBox.isChecked()) {
            degrees.add("M.Sc. degree");
        }
        if (bcCheckBox.isChecked()) {
            degrees.add("B.Sc. degree");
        }

        context = AddUserActivity.this;

        User user = new User(firstName, lastName, email, degreeProgram, degrees);
        UserStorage.getInstance().addUser(user);
        saveUsers(context);
    }

    public void saveUsers(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(UserStorage.getInstance().getUsers());
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Käyttäjien tallentaminen ei onnistunut");
        }
    }
}