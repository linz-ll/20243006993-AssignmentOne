package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY_INDEX =
            "com.example.assignmentone.CATEGORY_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        populateDetail();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * Populates the detail screen using the category index
     * received from MainActivity.
     *
     * The same index is used to retrieve the corresponding
     * image, title and content from the resource arrays.
     */
    private void populateDetail() {

        // Step 1: Receive the selected category index
        int selectedIndex = getIntent().getIntExtra(
                EXTRA_CATEGORY_INDEX,
                -1
        );

        // Step 2: Read the three arrays from resources
        String[] imageNames = getResources().getStringArray(
                R.array.string_array_images
        );

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles
        );

        String[] contents = getResources().getStringArray(
                R.array.string_array_content
        );

        // Step 3: Resource IDs for the category names
        int[] categoryLabels = {
                R.string.facilities,
                R.string.events,
                R.string.clubs,
                R.string.support
        };

        // Step 4: Find the UI components
        ImageView detailIcon =
                findViewById(R.id.detailIcon);

        TextView detailCategory =
                findViewById(R.id.detailCategory);

        TextView detailTitle =
                findViewById(R.id.detailTitle);

        TextView detailContent =
                findViewById(R.id.detailContent);

        try {

            // Step 5: Find the selected drawable name
            String imageName =
                    imageNames[selectedIndex].trim();

            // Convert the image name into a drawable resource ID
            int imageResourceId = getResources().getIdentifier(
                    imageName,
                    "drawable",
                    getPackageName()
            );

            // Step 6: Update the header icon and category name
            detailIcon.setImageResource(imageResourceId);

            detailCategory.setText(
                    categoryLabels[selectedIndex]
            );

            detailIcon.setContentDescription(
                    getString(categoryLabels[selectedIndex])
            );

            // Step 7: Update the detail title and content
            detailTitle.setText(titles[selectedIndex]);

            detailContent.setText(contents[selectedIndex]);

        } catch (ArrayIndexOutOfBoundsException e) {

            // Handle an invalid or missing category index
            Toast.makeText(
                    this,
                    "Invalid category selection",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
        }
    }

}