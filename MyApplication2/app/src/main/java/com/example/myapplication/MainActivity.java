package com.example.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private EditText editTextNIK, editTextName, editTextBirthPlace, editTextAddress, editTextEmail;
    private View buttonReset;
    private View buttonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodayDate());
        editTextNIK = findViewById(R.id.editTextText);
        editTextName = findViewById(R.id.editTextText2);
        editTextBirthPlace = findViewById(R.id.editTextText3);
        editTextAddress = findViewById(R.id.editTextText4);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        buttonReset = findViewById(R.id.button);
        buttonSubmit = findViewById(R.id.button2);
        setupButtonListeners();
        Spinner spinner = findViewById(R.id.spinner);
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AdapterView<Adapter> adapterView;
                string item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(context MainActivity.this, text "selected Item: " + item, toast,LENGHT_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("WNA");
        arrayList.add("WNI");
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(context; this, android.R.Layout.simple_spinner_item, arrayList);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setupButtonListeners() {
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear all EditTexts
                editTextNIK.setText("");
                editTextName.setText("");
                editTextBirthPlace.setText("");
                editTextAddress.setText("");
                editTextEmail.setText("");
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve data from EditTexts
                String nik = editTextNIK.getText().toString();
                String name = editTextName.getText().toString();
                String birthPlace = editTextBirthPlace.getText().toString();
                String address = editTextAddress.getText().toString();
                String email = editTextEmail.getText().toString();

                // Implement your submission logic here
                submitFormData(nik, name, birthPlace, address, email);
            }
        });
    }
    private void submitFormData(String nik, String name, String birthPlace, String address, String email) {
        System.out.println("Submission Data:");
        System.out.println("NIK: " + nik);
        System.out.println("Name: " + name);
        System.out.println("Birth Place: " + birthPlace);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
    }

    private String getTodayDate(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(dayOfMonth, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = makeDateString(dayOfMonth, month, year);
                dateButton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT( context this, style, dateSetListener, year, month, dayOfMonth);

    }

    private String makeDateString(int dayOfMonth, int month, int year)
    {
        return getMonthFormat(month) +   + dayOfMonth +   +year;
    }

    private String getMonthFormat(int month)
    {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "Mei";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OKT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        return "JAN";

    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}


    }

