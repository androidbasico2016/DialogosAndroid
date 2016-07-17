package pe.cibertec.dialogosandroid;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Android-SAB-PM on 16/07/2016.
 * 
 * 
 */
 //comentario desde github
public class FechaDialogo extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    ListenerOyente listenerOyente;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, anio, mes, dia);
    }
    interface ListenerOyente{
        public void setearfecha(String fecha);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listenerOyente=(ListenerOyente) activity;
    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        listenerOyente.setearfecha("" + dayOfMonth + "/" + monthOfYear + "/" + year);

    }


}
