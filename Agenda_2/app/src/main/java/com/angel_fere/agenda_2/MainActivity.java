package com.angel_fere.agenda_2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.nfc.Tag;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private EditText etnombre,ettelefono,etemail,etdescripcion;
    private Button Siguiente,tvfnaciemiento;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    String Snombre;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///Datos

        etnombre = (EditText) findViewById(R.id.etnombre);
        ettelefono = (EditText) findViewById(R.id.ettelefono);
        etemail = (EditText) findViewById(R.id.etemail);
        etdescripcion = (EditText) findViewById(R.id.etdescripcion);
        tvfnaciemiento = (Button) findViewById(R.id.tvfnacimiento);
        ////Recuperar datos
        Intent intentR = getIntent();
        String name = intentR.getStringExtra("Rnombre");
        String date = intentR.getStringExtra("Rfnacimiento");
        String phone = intentR.getStringExtra("Rtelefono");
        String email = intentR.getStringExtra("Remail");
        String description = intentR.getStringExtra("Rdescripcion");
        etnombre.setText(name);
        ettelefono.setText(phone);
        etemail.setText(email);
        etdescripcion.setText(description);
        tvfnaciemiento.setText(date);

        ///Boton Siguiente

            Siguiente = (Button) findViewById(R.id.bsig);

            Siguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String auxNombre = etnombre.getText().toString();
                    String auxTelefono = ettelefono.getText().toString();
                    String auxEmail = etemail.getText().toString();
                    String auxDescripcion = etdescripcion.getText().toString();
                    String auxtvfnacimiento = tvfnaciemiento.getText().toString();


                    Intent Siguiente = new Intent(MainActivity.this, Datos.class);
                    Siguiente.putExtra("nombre", auxNombre);
                    Siguiente.putExtra("telefono", auxTelefono);
                    Siguiente.putExtra("email", auxEmail);
                    Siguiente.putExtra("descripcion", auxDescripcion);
                    Siguiente.putExtra("fnacimiento", auxtvfnacimiento);
                    startActivity(Siguiente);
                }
            });



        ////////Guardar instancias





        ///
        //Calendario
        mDisplayDate = (TextView) findViewById(R.id.tvfnacimiento);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();


            }
        });
    mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Log.d(TAG,"OnDateSet: date:" + i + "/" +i1 + "/" +i2 );
            Integer month = i1 + 1;
            String date = i2 + "/" + month + "/" +i;
            mDisplayDate.setText(date);
        }
    };
    /////
    }


}
