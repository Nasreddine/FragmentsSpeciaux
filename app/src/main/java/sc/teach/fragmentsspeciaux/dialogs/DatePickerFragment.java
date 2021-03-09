package sc.teach.fragmentsspeciaux.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;  // do not import java.icu.utils.Calendar

public class DatePickerFragment extends DialogFragment {


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Récupérer la date d'aujourd'hui afin d'initialiser DatePicker

        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH);

        int day = c.get(Calendar.DAY_OF_MONTH);


        // L'activité appelant ce fragment doit implémenter l'interface OnDateSetListener

        DatePickerDialog.OnDateSetListener listener = (DatePickerDialog.OnDateSetListener) getActivity();


        // Créer une instance de TimePickerDialog et la retourner

        return new DatePickerDialog(getActivity(), listener, year, month, day);

    }

}