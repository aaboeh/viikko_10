package com.example.viikko10;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView firstName, lastName, email, degreeProgram, degrees;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        firstName = itemView.findViewById(R.id.textFirstName);
        lastName = itemView.findViewById(R.id.textLastName);
        email = itemView.findViewById(R.id.textEmail);
        degreeProgram = itemView.findViewById(R.id.textDegreeProgram);
        degrees = itemView.findViewById(R.id.textUserDegrees);
    }
}
