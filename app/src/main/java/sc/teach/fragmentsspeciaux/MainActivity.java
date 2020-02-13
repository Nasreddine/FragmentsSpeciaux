package sc.teach.fragmentsspeciaux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

import sc.teach.fragmentsspeciaux.dialogs.AlertDialogFragment;
import sc.teach.fragmentsspeciaux.dialogs.DatePickerFragment;
import sc.teach.fragmentsspeciaux.dialogs.SimpleDialogFragment;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    Button frag_simple_btn;
    Button frag_alert_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frag_simple_btn = findViewById(R.id.frag_simple_btn);
        frag_alert_btn = findViewById(R.id.frag_alert_btn);

        frag_simple_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog();

            }
        });

        frag_alert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();

            }
        });

        ProgressDialog pd = new ProgressDialog(this);

        pd.setTitle("Loading...");

        pd.setMessage("Please wait.");

        pd.setCancelable(false);

        pd.show();

        pd.dismiss();


    }


    private void showEditDialog() {

        FragmentManager fm = getSupportFragmentManager();

        SimpleDialogFragment simpleDialogFragment = SimpleDialogFragment.newInstance("Some Title");

        simpleDialogFragment.show(fm, "fragment_simple_dialog");

    }

    private void showAlertDialog() {

        FragmentManager fm = getSupportFragmentManager();

        AlertDialogFragment alertDialog = AlertDialogFragment.newInstance("Some title");

        alertDialog.show(fm, "fragment_alert");

    }

    // attach to an onclick handler to show the date picker

    public void showDatePickerDialog(View v) {

        DatePickerFragment newFragment = new DatePickerFragment();

        newFragment.show(getSupportFragmentManager(), "datePicker");

    }



    // handle the date selected
    //https://guides.codepath.com/android/using-dialogfragment#styling-custom-dialog
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        // store the values selected into a Calendar instance

        final Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, year);

        c.set(Calendar.MONTH, monthOfYear);

        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

    }
}
