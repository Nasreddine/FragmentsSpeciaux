package sc.teach.fragmentsspeciaux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sc.teach.fragmentsspeciaux.dialogs.AlertDialogFragment;
import sc.teach.fragmentsspeciaux.dialogs.SimpleDialogFragment;


public class MainActivity extends AppCompatActivity {

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

}
