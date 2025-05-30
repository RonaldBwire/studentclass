package com.yourdomain.yourappname; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare EditText and Button variables
    EditText editTextName, editTextStudentId, editTextResearchTopic;
    Button buttonSubmit;
    CheckBox checkBoxGraduate;

    // Define keys for Intent extras
    public static final String EXTRA_NAME = "com.yourdomain.yourappname.EXTRA_NAME";
    public static final String EXTRA_STUDENT_ID = "com.yourdomain.yourappname.EXTRA_STUDENT_ID";
    public static final String EXTRA_RESEARCH_TOPIC = "com.yourdomain.yourappname.EXTRA_RESEARCH_TOPIC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the content view to the layout

        // Get references to the EditText fields and Button
        editTextName = findViewById(R.id.editTextName);
        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextResearchTopic = findViewById(R.id.editTextResearchTopic);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        checkBoxGraduate = findViewById(R.id.checkBoxGraduate); // Checkbox for Graduate Student

        // Set an OnClickListener for the Button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the text from each EditText
                String name = editTextName.getText().toString().trim();
                String studentId = editTextStudentId.getText().toString().trim();
                String researchTopic = editTextResearchTopic.getText().toString().trim();

                // Input validation
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (studentId.isEmpty() || !isValidStudentId(studentId)) {
                    Toast.makeText(MainActivity.this, "Invalid Student ID format", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (checkBoxGraduate.isChecked() && researchTopic.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Research Topic cannot be empty for Graduate Students", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create an Intent to start ProfileActivity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

                // Put the data into the Intent
                intent.putExtra(EXTRA_NAME, name);
                intent.putExtra(EXTRA_STUDENT_ID, studentId);
                intent.putExtra(EXTRA_RESEARCH_TOPIC, researchTopic);

                // Start the ProfileActivity
                startActivity(intent);
            }
        });
    }

    // Method to validate Student ID format (example: must be alphanumeric and 6-10 characters long)
    private boolean isValidStudentId(String studentId) {
        return studentId.matches("^[a-zA-Z0-9]{6,10}$"); // Adjust regex as needed
    }
}
