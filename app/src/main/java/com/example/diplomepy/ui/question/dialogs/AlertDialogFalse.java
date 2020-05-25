package com.example.diplomepy.ui.question.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class AlertDialogFalse extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Надано неправильну відповідь, перегляньте матеріал, та спробуйте ще раз")
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });
        return builder.create();
    }
}
