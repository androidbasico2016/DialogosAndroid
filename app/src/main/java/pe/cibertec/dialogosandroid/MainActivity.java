package pe.cibertec.dialogosandroid;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FechaDialogo.ListenerOyente,HoraDialogo.ListenerOyente {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirDialogo(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mi primer Dialogo");

        //builder.setMessage("Voy aprobar el curso?");
        final String[] opciones = getResources().getStringArray(R.array.opcionesDialogo);
/*
        builder.setSingleChoiceItems(opciones, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
*/

        boolean[] valores = {true, false, false};
        final List<String> seleccionados = new ArrayList<>();

        builder.setMultiChoiceItems(opciones, valores, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String sele = opciones[which];
                if (!seleccionados.contains(sele)) {
                    seleccionados.add(sele);
                }
                if (!isChecked) {
                    seleccionados.remove(sele);
                }
            }
        });


        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "" + seleccionados.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

    public void abrirDialogoCustom(View view) {

        DialogFragment dialogFragment = new MyDialogCustom();
        dialogFragment.show(getSupportFragmentManager(), "custom");
    }

    public void seleccionFecha(View view) {
        DialogFragment dialogFragment = new FechaDialogo();
        dialogFragment.show(getSupportFragmentManager(), "fecha");
    }

    @Override
    public void setearfecha(String fecha) {
        TextView textView = (TextView) findViewById(R.id.txtFecha);
        textView.setText(fecha);
    }

    public void seleccionHora(View view) {

        DialogFragment dialogFragment = new HoraDialogo();
        dialogFragment.show(getSupportFragmentManager(), "hora");
    }

    @Override
    public void setearHora(int hora, int minuto) {
        TextView textView = (TextView) findViewById(R.id.txtHora);
        textView.setText(""+hora+":"+minuto);
    }
}
