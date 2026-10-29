package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Category indices must match the order in arrays.xml.
    private static final int FACILITIES_INDEX = 0;
    private static final int EVENTS_INDEX = 1;
    private static final int CLUBS_INDEX = 2;
    private static final int SUPPORT_INDEX = 3;

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



    public void onFacilitiesClick(View view) {
        openDetailActivity(FACILITIES_INDEX);
    }

    public void onEventsClick(View view) {
        openDetailActivity(EVENTS_INDEX);
    }

    public void onClubsClick(View view) {
        openDetailActivity(CLUBS_INDEX);
    }

    public void onSupportClick(View view) {
        openDetailActivity(SUPPORT_INDEX);
    }


    // Start DetailActivity and pass the selected category index
    /**
     * Opens the shared detail screen and passes the selected
     * category index through an explicit Intent.
     *
     * @param categoryIndex index matching the arrays.xml resources
     */
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