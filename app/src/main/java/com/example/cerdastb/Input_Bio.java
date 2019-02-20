package com.example.cerdastb;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Input_Bio extends AppCompatActivity{
    EditText nama, tgl_lahir, kota, no_telp;
    private RadioGroup gender;
    private RadioGroup jenistb;
    private RadioButton gender2;
    private RadioButton jenistb2;
    Button btsub;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText btDatePicker;
    private TextView tvDateResult;
    private String data1;

    private void showDateDialog(){
        Calendar c = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(i, i1, i2);

                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }
        },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input__bio);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.tgl_lahir);
        btDatePicker = (EditText) findViewById(R.id.tgl_lahir);
        nama = (EditText) findViewById(R.id.nama);
        tgl_lahir = (EditText) findViewById(R.id.tgl_lahir);
        kota = (EditText) findViewById(R.id.kota);
        no_telp = (EditText) findViewById(R.id.no_telp);
        gender = (RadioGroup) findViewById(R.id.gender);
        jenistb = (RadioGroup) findViewById(R.id.jenistb);
        btsub = (Button) findViewById(R.id.button);
        btsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = gender.getCheckedRadioButtonId();
                int id2 = jenistb.getCheckedRadioButtonId();

                gender2 = (RadioButton) findViewById(id);
                jenistb2 = (RadioButton) findViewById(id2);

                String nama1 = String.valueOf(nama.getText().toString());
                String kota1 = String.valueOf(kota.getText().toString());
                String tgllhr = String.valueOf(tvDateResult.getText().toString());
                String hasilgender = String.valueOf(gender2.getText().toString());
                String hasiljtb = String.valueOf(jenistb2.getText().toString());
                String notelp = String.valueOf(no_telp.getText().toString());

                showDialog();
            }
        });
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.tgl_lahir);
        btDatePicker = (EditText) findViewById(R.id.tgl_lahir);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });


    }

    private void showDialog(){
        AlertDialog.Builder al = new AlertDialog.Builder(this);

        al.setTitle("Ayo Pretest!")
        .setMessage("Ayo Ikuti pretest Untuk melihat seberapa jauh Kamu tahu tentang penyakit TB ")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent pretest = new Intent(Input_Bio.this, Pretest.class);
                        startActivity(pretest);
                    }
                });
        AlertDialog alertDialog = al.create();

        alertDialog.show();
    }

}
