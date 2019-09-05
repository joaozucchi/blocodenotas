package com.joaohercilio.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences.Editor editor = null;
    private static final String PREFERENCIAS_FILE = "Notas";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(PREFERENCIAS_FILE, MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvarTexto(View view) {
        EditText nota = findViewById(R.id.editText);
        editor.putString("nota", nota.getText().toString());
        editor.commit();
    }

    public void recuperarTexto(View view) {
        EditText nota = findViewById(R.id.editText);
        nota.setText(preferences.getString("nota",""));
    }
}
