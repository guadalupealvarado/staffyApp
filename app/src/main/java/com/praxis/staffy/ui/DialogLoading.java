package com.praxis.staffy.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.praxis.staffy.R;

public class DialogLoading extends android.support.v4.app.DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle sBundle)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setView(getActivity().getLayoutInflater().inflate(R.layout.fragment_fragment_dialog_loading,null));
        return builder.create();
    }
}
