package com.angel_fere.agenda_2;

import android.content.Intent;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Datos extends MainActivity {
    TextView Rnombre,Rfnacimiento,Rtelefono,Remail,Rdescripcion;
    private Button Reditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);



        //Validando los TextView
        Rnombre = (TextView) findViewById(R.id.Rnombre);
        Rfnacimiento = (TextView) findViewById(R.id.Rfnacimiento);
        Rtelefono = (TextView) findViewById(R.id.Rtelefono);
        Remail = (TextView)findViewById(R.id.Remail);
        Rdescripcion = (TextView)findViewById(R.id.Rdescripcion);
        ///Recuperacion de datos
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String datoNombre= (String)extras.get("nombre");
        String datoFnacimiento=(String)extras.get("fnacimiento");
        String datoTelefono = (String)extras.get("telefono");
        String datoDescripcion = (String)extras.get("descripcion");
        String datoemail=(String)extras.get("email");
        //Imprimiendo los datos
        Rnombre.setText(datoNombre);
        Rfnacimiento.setText(datoFnacimiento);
        Rtelefono.setText(datoTelefono);
        Remail.setText(datoemail);
        Rdescripcion.setText(datoDescripcion);

        //////////Boton

        Reditar = (Button) findViewById(R.id.Reditar);

        Reditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aux2nombre= Rnombre.getText().toString();
                String aux2fnacimiento= Rfnacimiento.getText().toString();
                String aux2telefono= Rtelefono.getText().toString();

                String aux2email= Remail.getText().toString();
                String aux2descripcion = Rdescripcion.getText().toString();

                Intent Reditar = new Intent(Datos.this,MainActivity.class);
                Reditar.putExtra("Rnombre", aux2nombre);
                Reditar.putExtra("Rfnacimiento", aux2fnacimiento);
                Reditar.putExtra("Rtelefono", aux2telefono);
                Reditar.putExtra("Remail", aux2email);
                Reditar.putExtra("Rdescripcion", aux2descripcion);
                startActivity(Reditar);






            }
        });



    }
}
