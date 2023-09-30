package com.cst2335.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.toast_message),
                Toast.LENGTH_LONG).show());

        Switch switchBtn = findViewById(R.id.switch1);
        View view = findViewById(R.id.textView);

        switchBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String switchMessage = getString(R.string.switch_message);
            // Format the message based on the switch state (isChecked)
            String formattedMessage = String.format(switchMessage, isChecked ? "on" : "off");
            Snackbar snackbar = Snackbar.make(view, formattedMessage, Snackbar.LENGTH_LONG)
                    .setAction("Undo", v -> {
                        // Undo action: Toggle the switch state back
                        switchBtn.setChecked(!isChecked);
                    });
            snackbar.show();
        });


    }

}