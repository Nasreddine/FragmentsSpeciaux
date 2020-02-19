package sc.teach.fragmentsspeciaux.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

    public AlertDialogFragment() {

        // Empty constructor required for DialogFragment

    }


    public static AlertDialogFragment newInstance(String title) {

        AlertDialogFragment frag = new AlertDialogFragment();

        Bundle args = new Bundle();

        args.putString("title", title);

        frag.setArguments(args);

        return frag;

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String title = getArguments().getString("title");

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setTitle(title);

        alertDialogBuilder.setMessage("Are you sure?");

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                // on success

            }

        });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (dialog != null ) {

                    dialog.dismiss();

                }

            }


        });


        return alertDialogBuilder.create();

    }

}