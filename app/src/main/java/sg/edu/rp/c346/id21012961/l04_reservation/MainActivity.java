package sg.edu.rp.c346.id21012961.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnConfirm;
    Button btnReset;
    EditText edtName;
    EditText edtNum;
    EditText edtPax;
    CheckBox smoke;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnReset = findViewById(R.id.btnReset);
        edtName = findViewById(R.id.editName);
        edtNum = findViewById(R.id.editContNum);
        edtPax = findViewById(R.id.editCapacity);
        smoke = findViewById(R.id.checkSmoke);

        dp.updateDate(2020, 5, 01);

        tp.setCurrentHour(18);
        tp.setCurrentMinute(30);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = String.format("%s/%s/%s", dp.getDayOfMonth(), dp.getMonth(), dp.getYear());
                String time = String.format("/%s/%s", tp.getCurrentHour(), tp.getCurrentMinute());
                String name = edtName.getText().toString();
                String number = edtNum.getText().toString();
                String capacity = edtPax.getText().toString();

                String output = String.format("Name: %s \n Phone Number: %s \n Capacity of group: %s \n Table is at %s area \n %s \n %s"
                , name, number, capacity, date, time);

                if ((name.isEmpty()) || (number.isEmpty()) || (capacity.isEmpty())) {
                    Toast.makeText(getApplicationContext(), "Error, missing information", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dp.updateDate(2020, 5, 01);

                tp.setCurrentHour(18);
                tp.setCurrentMinute(30);

                edtName.getText().clear();
                edtNum.getText().clear();
                edtPax.getText().clear();

                smoke.setChecked(false);

            }
        });
        
    }
}