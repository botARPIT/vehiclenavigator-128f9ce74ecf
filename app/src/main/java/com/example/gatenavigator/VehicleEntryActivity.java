package com.example.gatenavigator;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gatenavigator.Adapters.KantaDetailAdapter;
import com.example.gatenavigator.Models.KantaDetail;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class VehicleEntryActivity extends AppCompatActivity {

    // Declare variables for Gate section
    private LinearLayout gateDetails;
    private ImageView gateArrowIcon;

    // Declare variables for Kanta section
    private LinearLayout kantaDetails;
    private ImageView kantaArrowIcon;


    // Declare variables for Loading section
    private LinearLayout loadingDetails;
    private ImageView loadingArrowIcon;


    private TextInputEditText gateEntryTimeEditText;

    private ListView lvKantaDetails;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vehicle_entry_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Gate views
        gateDetails = findViewById(R.id.gate_details);
//        gateArrowIcon = findViewById(R.id.gate_arrow_icon);


        // Initialize Kanta views
        kantaDetails = findViewById(R.id.kanta_details);
//        kantaArrowIcon = findViewById(R.id.kanta_arrow_icon);


        // Initialize Loading views
        loadingDetails = findViewById(R.id.loading_details);
//        loadingArrowIcon = findViewById(R.id.loading_arrow_icon);


        // Set click listener for the Gate header
        findViewById(R.id.gate_header).setOnClickListener(v -> toggleGateDetails());

        // Set click listener for the Kanta header
        findViewById(R.id.kanta_section_header).setOnClickListener(v -> togglekantaDetails());

        // Set click listener for the Loading header
        findViewById(R.id.loading_section_header).setOnClickListener(v -> toggleLoadingDetails());



//        // Reference to the EditText for gate entry time
//        gateEntryTimeEditText = findViewById(R.id.gate_entry_time_edit_text);
//
//        // Set up a click listener to show the time picker
//        gateEntryTimeEditText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showTimePickerDialog(gateEntryTimeEditText);
//            }
//        });

        lvKantaDetails = findViewById(R.id.lv_kanta_details);

        // Sample data
        List<KantaDetail> kantaDetails = new ArrayList<>();
        kantaDetails.add(new KantaDetail("Kanta 1", "13735 kg", "11:55 AM"));
        kantaDetails.add(new KantaDetail("Empty vehicle", "12430 kg", "11:35 AM"));
        kantaDetails.add(new KantaDetail("Empty vehicle", "12430 kg", "11:35 AM"));
        kantaDetails.add(new KantaDetail("Empty vehicle", "12430 kg", "11:35 AM"));
        kantaDetails.add(new KantaDetail("Empty vehicle", "12430 kg", "11:35 AM"));

        // Set adapter
        KantaDetailAdapter adapter = new KantaDetailAdapter(this, kantaDetails);
        lvKantaDetails.setAdapter(adapter);



        gateEntryTimeEditText = findViewById(R.id.gate_entry_time_edit_text);

        // Set onClickListener for the EditText
        gateEntryTimeEditText.setOnClickListener(v -> setCurrentTime());


    }

    private void toggleGateDetails() {
        if (gateDetails.getVisibility() == View.VISIBLE) {
            gateDetails.setVisibility(View.GONE);
//            gateArrowIcon.setImageResource(R.drawable.dr); // Replace with your down arrow icon
        } else {
            gateDetails.setVisibility(View.VISIBLE);
//            gateArrowIcon.setImageResource(R.drawable.ic_arrow_up); // Replace with your up arrow icon
        }
    }
    private void togglekantaDetails() {
        if (kantaDetails.getVisibility() == View.VISIBLE) {
            kantaDetails.setVisibility(View.GONE);
//            kantaArrowIcon.setImageResource(R.drawable.dr); // Replace with your down arrow icon
        } else {
            kantaDetails.setVisibility(View.VISIBLE);
//            kantaArrowIcon.setImageResource(R.drawable.ic_arrow_up); // Replace with your up arrow icon
        }
    }

    private void toggleLoadingDetails() {
        if (loadingDetails.getVisibility() == View.VISIBLE) {
            loadingDetails.setVisibility(View.GONE);
//            loadingArrowIcon.setImageResource(R.drawable.dr); // Replace with your down arrow icon
        } else {
            loadingDetails.setVisibility(View.VISIBLE);
//            loadingArrowIcon.setImageResource(R.drawable.ic_arrow_up); // Replace with your up arrow icon
        }
    }




    private void showTimePickerDialog(final EditText editText) {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Show the time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                VehicleEntryActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(android.widget.TimePicker view, int selectedHour, int selectedMinute) {
                        // Format the time as "hh:mm a" (e.g., "11:00 AM")
                        String formattedTime = formatTime(selectedHour, selectedMinute);
                        editText.setText(formattedTime);
                    }
                },
                hour,
                minute,
                false // Use 12-hour format
        );

        timePickerDialog.show();
    }

    private String formatTime(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        return DateFormat.format("hh:mm a", calendar).toString();
    }


    private void setCurrentTime() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();

        // Format the time in hh:mm AM/PM format
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String currentTime = timeFormat.format(calendar.getTime());

        // Set the current time in the EditText
        gateEntryTimeEditText.setText(currentTime);

        // Show a toast message
        Toast.makeText(this, "Entry time is recorded: " + currentTime, Toast.LENGTH_SHORT).show();

    }






}