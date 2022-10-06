package br.ulbra.appescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNome, edDisciplina, edAulas, edFaltas, edNota1, edNota2;
    Button btresultado, btLimpar;
    TextView txtResultado;

    public void iniciarcomponentes(){

        edNome = findViewById(R.id.txtNome);
        edDisciplina = findViewById(R.id.txtDisci);
        edAulas = findViewById(R.id.txtAulas);
        edFaltas = findViewById(R.id.txtFaltas);
        edNota1 = findViewById(R.id.txtNota1);
        edNota2 = findViewById(R.id.txtNota2);
        txtResultado = findViewById(R.id.txtResultado);
        btresultado = findViewById(R.id.btnResultado);
        btLimpar = findViewById(R.id.btnLimpar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarcomponentes();
        btresultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nAula, nFalta,n1,n2,freq,med;
                nAula = Double.parseDouble(edAulas.getText().toString());
                nFalta = Double.parseDouble(edFaltas.getText().toString());
                n1 = Double.parseDouble(edNota1.getText().toString());
                n2 = Double.parseDouble(edNota2.getText().toString());
                freq = (nAula - nFalta)/nAula*100;
                med = (n1*2 + n2*4)/6;
                if (med>=7 && freq >=75){
                    String r = "Resultado: "+ edNome.getText().toString() + " Nota: " + med + " freq: " + freq + " Aprovado";
                    txtResultado.setText(r);
                }
            }
        });
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edNome.setText("");
                edDisciplina.setText("");
                edAulas.setText("");
                edFaltas.setText("");
                edNota1.setText("");
                edNota2.setText("");
                edNota1.setText("");
            }
        });
    }
}