package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Toast;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    // Open Facilities details
    public void onFacilitiesClick(View view) {
        openDetailActivity(0);
    }

    // Open Events details
    public void onEventsClick(View view) {
        openDetailActivity(1);
    }

    // Open Clubs details
    public void onClubsClick(View view) {
        openDetailActivity(2);
    }

    // Open Support details
    public void onSupportClick(View view) {
        openDetailActivity(3);
    }

    // Start DetailActivity and pass the selected category index
    private void openDetailActivity(int categoryIndex) {

        Intent intent = new Intent(
                MainActivity.this,
                DetailActivity.class
        );

        intent.putExtra(
                DetailActivity.EXTRA_CATEGORY_INDEX,
                categoryIndex
        );

        startActivity(intent);
    }
}