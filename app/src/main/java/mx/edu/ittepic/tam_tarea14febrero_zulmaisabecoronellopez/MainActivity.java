package mx.edu.ittepic.tam_tarea14febrero_zulmaisabecoronellopez;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnempezar;
    TextView numero;
    float random,numerof,progreso,cap;
    String a,b,c;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnempezar = findViewById(R.id.btn1);
        numero = findViewById(R.id.txtnumero);
        progreso=0;

        final DecimalFormat df = new DecimalFormat("#.0");
        random = (float) (Math.random()*3);
        a = df.format(random);
        numero.setText(""+a);
        numerof=Float.parseFloat(a);
        timer = new CountDownTimer(10000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                progreso= (float) (progreso+0.1);
                b = df.format(progreso);
                btnempezar.setText(""+b);
                if (progreso>=2.9){
                    progreso= (float) 0.0;
                }
            }
            @Override
            public void onFinish() {
                timer.start();
            }
        };timer.start();
        btnempezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=b;
                cap= Float.parseFloat(c);
                if (numerof==cap){
                    Toast.makeText(MainActivity.this, "Haz ganado!!", Toast.LENGTH_SHORT).show();
                    timer.cancel();
                }else {
                    random = (float) (Math.random()*3);
                    a = df.format(random);
                    numero.setText(""+a);
                }
            }
        });
    }
}