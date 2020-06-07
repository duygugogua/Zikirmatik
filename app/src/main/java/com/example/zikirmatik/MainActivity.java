package com.example.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        Button sifirla = findViewById(R.id.buttonSifirla);
        Button zikir = findViewById(R.id.buttonZikir);
        final TextView totalnumber = findViewById(R.id.textViewTotal);

        final TextView zikirSayisi = findViewById(R.id.textViewZikirSayisi);
        zikir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int zikirnumber = Integer.parseInt(zikirSayisi.getText().toString());
                zikirnumber++;
                if(zikirnumber==33)
                {
                    new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                            .setTitleText("33 Zikir tamamlandı")
                            .setContentText("Allah zikrinizi kabul etsin")
                            .setConfirmText("İnşallah")
                            .setCustomImage(R.drawable.rose)
                            .show();
                    zikirnumber=0;

                    int total = Integer.parseInt(totalnumber.getText().toString());
                            total++;
                            totalnumber.setText(String.valueOf(total));

                }
                zikirSayisi.setText(String.valueOf(zikirnumber));
            }
        });
        sifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int zikirnumber=0;
                zikirSayisi.setText(String.valueOf(zikirnumber));
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("Basarıyla Sıfırlandı!")
                        .setContentText("Bilin ki, kalpler ancak Allah'ın zikriyle huzur bulur. ( Rad, 1 3/28) ")
                        .setConfirmText("Tamam")
                        .setCustomImage(R.drawable.rose)
                        .show();
            }
        });



    }
}
