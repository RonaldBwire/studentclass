package com.yourdomain.yourappname; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    // Declare TextView variables
    TextView textViewProfileName, textViewProfileId, textViewProfileTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // Set the content view to the layout

        // Get references to the TextView elements
        textViewProfileName = findViewById(R.id.textViewProfileName);
        textViewProfileId = findViewById(R.id.textViewProfileId);
        textViewProfileTopic = findViewById(R.id.textViewProfileTopic);

        // Get the Intent that started this activity
        Intent intent = getIntent();

        // Check if the intent has extras
        if (intent != null && intent.getExtras() != null) {
            // Extract the data using getStringExtra() with the same keys used in MainActivity
            String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
            String studentId = intent.getStringExtra(MainActivity.EXTRA_STUDENT_ID);
            String researchTopic = intent.getStringExtra(MainActivity.EXTRA_RESEARCH_TOPIC);

            // Display the data in the TextViews
            textViewProfileName.setText("Name: " + (name != null ? name : "N/A"));
            textViewProfileId.setText("Student ID: " + (studentId != null ? studentId : "N/A"));
            textViewProfileTopic.setText("Research Topic: " + (researchTopic != null && !researchTopic.isEmpty() ? researchTopic : "N/A"));
        } else {
            // Handle the case where no data was passed (optional)
            textViewProfileName.setText("Name: Error loading data");
            textViewProfileId.setText("Student ID: Error loading data");
            textViewProfileTopic.setText("Research Topic: Error loading data");
        }
    }
}
