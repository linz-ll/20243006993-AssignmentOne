package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY_INDEX =
            "com.example.assignmentone.CATEGORY_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);


        // Get the category index passed from MainActivity
        int selectedIndex = getIntent().getIntExtra(
                EXTRA_CATEGORY_INDEX,
                -1
        );

        // Temporarily display the received index for testing
        Toast.makeText(
                this,
                "Received category index: " + selectedIndex,
                Toast.LENGTH_SHORT
        ).show();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}