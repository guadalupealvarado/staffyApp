package com.praxis.staffy.ui.requests.editRequest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.praxis.staffy.R;

public class EditRequestView extends AppCompatActivity {
    Button submit;
    Spinner spinnerTool, spinnerId, spinnerMail;
    ArrayAdapter<CharSequence> adapterTools;
    ArrayAdapter<CharSequence> adapterId;
    ArrayAdapter<CharSequence> adapterMail;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_request);
        eventTool();
        eventId();
        eventMail();
        saveChange();
    }

    private void saveChange()
    {
        submit= findViewById(R.id.btn_submit_request_edit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertSave();
            }
        });

    }

    private void alertSave()
    {
        new AlertDialog.Builder(this)
                .setTitle("Modificar")
                .setMessage("¿Desea hacer cambios?")
                .setIcon(R.drawable.img_alerta)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Consumir web Service", Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
        .show();
    }


    private void eventMail()
    {
        spinnerTool= findViewById(R.id.spi_tools_edit);
        adapterTools=ArrayAdapter.createFromResource( this, R.array.tools,
                android.R.layout.simple_spinner_dropdown_item);
        adapterTools.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTool.setAdapter(adapterTools);
    }

    private void eventId()
    {
        spinnerId = findViewById(R.id.spi_id_edit);
        adapterId= ArrayAdapter.createFromResource(this, R.array.id,
                android.R.layout.simple_spinner_dropdown_item);
        adapterId.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerId.setAdapter(adapterId);
    }

    private void eventTool()
    {
        spinnerMail= findViewById(R.id.spi_mail_edit);
        adapterMail = ArrayAdapter.createFromResource(this, R.array.mail,
                android.R.layout.simple_spinner_dropdown_item);
        adapterMail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMail.setAdapter(adapterMail);
    }

}
