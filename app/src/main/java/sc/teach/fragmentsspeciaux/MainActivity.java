package sc.teach.fragmentsspeciaux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

import sc.teach.fragmentsspeciaux.dialogs.AlertDialogFragment;
import sc.teach.fragmentsspeciaux.dialogs.DatePickerFragment;

import sc.teach.fragmentsspeciaux.dialogs.SimpleDialogListener;
import sc.teach.fragmentsspeciaux.dialogs.SimpleDialogFragment;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, SimpleDialogListener {

    Button frag_simple_btn;
    Button frag_alert_btn;
    Button frag_date_btn;
    Button frag_progress_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_simple_btn = findViewById(R.id.frag_simple_btn);
        frag_alert_btn = findViewById(R.id.frag_alert_btn);
        frag_date_btn = findViewById(R.id.frag_date_btn);
        frag_progress_btn = findViewById(R.id.frag_progress_btn);

        frag_simple_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog();

            }
        });
        frag_alert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();

            }
        });
        frag_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showDatePickerDialog(frag_date_btn);
            }
        });
        frag_progress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();

            }
        });


    }


    private void showSimpleDialog() {

        FragmentManager fm = getSupportFragmentManager();
        SimpleDialogFragment simpleDialogFragment = SimpleDialogFragment.newInstance("Some Title");
        simpleDialogFragment.show(fm, "fragment_simple_dialog");

    }

    private void showAlertDialog() {

        FragmentManager fm = getSupportFragmentManager();
        AlertDialogFragment alertDialog = AlertDialogFragment.newInstance("Some title");
        alertDialog.show(fm, "fragment_alert");

    }

    // Afficher le DatePicker

    public void showDatePickerDialog(View v) {

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");

    }

    // onDateSet est appellé automatiquement après avoir choisir la date
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        // stocker les valeurs sélectionnées dans une instance de type Calendar
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        Toast.makeText(this, c.getTime().toString(), Toast.LENGTH_SHORT).show();

    }

    public void showProgressDialog() {

        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Please wait.");
        progressDialog.setCancelable(true);
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.dismiss();
            }
        });

        progressDialog.show();
    }


    // Cette méthode est appellée dans l'activité quand le listener est déclanché
    // Les données sont passées en paramétres
    @Override
    public void onOkClickDialog(String nom) {
        Toast.makeText(this, "Hi, " + nom, Toast.LENGTH_SHORT).show();
    }

}
