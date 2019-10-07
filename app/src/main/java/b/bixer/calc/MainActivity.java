package b.bixer.calc;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import b.bixer.calc.R;

public class MainActivity extends AppCompatActivity {

    private Chronometer mChronometer;
    boolean i=false;
    double f1;
    double f2;
    double F;
    double V;
    String s;
    boolean but=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  RadioButton Okt=findViewById(R.id.Okt);
        Okt.setOnClickListener(radioButtonClickListener);
        RadioButton Gc=findViewById(R.id.Gc);
        Gc.setOnClickListener(radioButtonClickListener);
        mChronometer = findViewById(R.id.chronometer);
        // EditText F1=findViewById(R.id.F1);
        // EditText F2=findViewById(R.id.F2);
        // EditText v=findViewById(R.id.Speed);
        final TextView Formula=findViewById(R.id.Formula);
        // f1=Double.parseDouble(F1.getText().toString());
        //  f2=Double.parseDouble(F2.getText().toString());
        //  V=Double.parseDouble(v.getText().toString());
        final Button stop=findViewById(R.id.stop);
        final Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                EditText F1=findViewById(R.id.F1);
                EditText F2=findViewById(R.id.F2);
                EditText v=findViewById(R.id.Speed);
                f1 = Double.parseDouble(F1.getText().toString());
                f2 = Double.parseDouble(F2.getText().toString());
                V = Double.parseDouble(v.getText().toString());
                but=true;
            }
        });
        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapsedMillis = SystemClock.elapsedRealtime()
                        - mChronometer.getBase();
                if (i==false)//если Okt
                {
                    F = f1 * Math.pow(2, V * (elapsedMillis - (elapsedMillis / 3600000) * 3600000) / 60000);
                    //  F = F1 + V*T

                } else//если Gc
                {
                    //F = F1*2^(V*T/60)
                    F = f1 + V * (elapsedMillis - (elapsedMillis / 3600000) * 3600000) / 60000 ;
                }
                if(f2>f1) {

                    if (F >= f2) {
                        stop.performClick();
                        mChronometer.stop();
                        //  onStopClick=true;
                        stop.performClick();
                    }
                }else
                {
                    if(F<=f2)
                    {
                        stop.performClick();
                        mChronometer.stop();
                        //  onStopClick=true;
                        stop.performClick();
                    }
                }

                double value =F;
                MathContext mathContext = new MathContext(15, RoundingMode.HALF_UP); // для double
                BigDecimal bigDecimal = new BigDecimal(value, mathContext);
                bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
                value = bigDecimal.doubleValue();
                String str = String.format(String.valueOf(value));
                Formula.setText(str);
            }

        });
    }

    public void onStartClick(View view) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
    }

    public void onStopClick(View view) {
        mChronometer.stop();
    }

    public void onResetClick(View view) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        //    Formula.setText(0.0);
    }


    public final View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            switch (rb.getId()) {
                case R.id.Gc: i=true;
                    break;
                case R.id.Okt: i=false;
                    break;
                default:
                    break;
            }
        }
    };

}