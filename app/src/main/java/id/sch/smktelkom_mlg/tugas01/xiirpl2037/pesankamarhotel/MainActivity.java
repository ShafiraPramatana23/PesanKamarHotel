package id.sch.smktelkom_mlg.tugas01.xiirpl2037.pesankamarhotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTL;
    RadioButton rbL, rbP;
    CheckBox cbSU, cbD, cbS;
    Spinner spKamar;
    TextView tvHas, tvHsl, tvHasil, tvLisah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTL = (EditText) findViewById(R.id.editTextTL);
        rbL = (RadioButton) findViewById(R.id.radioButtonLK);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);

        cbSU = (CheckBox) findViewById(R.id.checkBoxSU);
        cbD = (CheckBox) findViewById(R.id.checkBoxD);
        cbS = (CheckBox) findViewById(R.id.checkBoxS);

        spKamar = (Spinner) findViewById(R.id.spinnerKR);

        tvHas = (TextView) findViewById(R.id.textViewHasil1);
        tvHsl = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil = (TextView) findViewById(R.id.textViewHasil3);
        tvLisah = (TextView) findViewById(R.id.textViewHasil4);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if(isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTL.getText().toString());
            int usia = 2016 - tahun;
            tvHas.setText(nama + " berusia " + usia + " tahun");
        }

        String hasil = null;
        if (rbL.isChecked()) {
            hasil = rbL.getText().toString();
        } else if (rbP.isChecked()) {
            hasil = rbP.getText().toString();
        }

        if (hasil == null) {
            tvHsl.setText("Belum memilih Status");
        } else {
            tvHsl.setText("Jenis Kelamin : " + hasil);
        }

        String hasill="Tipe Kamar yang dipilih : ";
        int startlen = hasill.length();
        if(cbSU.isChecked()) hasill+=cbSU.getText().toString();
        if(cbD.isChecked()) hasill+=cbD.getText().toString();
        if(cbS.isChecked()) hasill+=cbS.getText().toString();

        if(hasill.length()==startlen) hasill+="Tidak ada pada Pilihan";
        tvHasil.setText(hasill);

        tvLisah.setText("Kapasitas Kamar yang dipilih : "+spKamar.getSelectedItem().toString());

    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTL.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if(tahun.isEmpty())
        {
            etTL.setError("Tahun Kelahiran belum diisi");
            valid = false;
        }
        else if(tahun.length()!=4)
        {
            etTL.setError("Format Tahun Kelahiran bukan yyyy");
            valid = false;
        }
        else
        {
            etTL.setError(null);
        }

        return valid;
    }
}
