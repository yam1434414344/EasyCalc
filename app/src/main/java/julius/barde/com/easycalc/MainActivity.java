package julius.barde.com.easycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView result_tv;
    EditText firstNumber_et, secondNumber_et;
    private double firstNumber=0, secondNumber=0, result=0;
    private String firstText, secondText;
    DecimalFormat formatter = new DecimalFormat("#,###");
    Operators myOperators = new Operators();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findViews() {
        firstNumber_et = (EditText) findViewById(R.id.firstNum_et);
        secondNumber_et = (EditText) findViewById(R.id.secondNum_et);
        result_tv = (TextView) findViewById(R.id.result_btn);

        firstText = firstNumber_et.getText().toString();
        secondText = secondNumber_et.getText().toString();


    }
    public void setValues(){

        firstNumber = Double.parseDouble(firstText);
        secondNumber = Double.parseDouble(secondText);

    }


    public void add(View view) {
        findViews();
            if(firstText.matches("")||secondText.matches(""))
            Toast.makeText(this, "Incomplete Input", Toast.LENGTH_SHORT).show();



        else{
           setValues();
            result = myOperators.Add(firstNumber, secondNumber);
            result_tv.setText(formatResult());
}
    }

    public void minus(View view) {
        findViews();
        if(firstText.matches("")||secondText.matches(""))
            Toast.makeText(this, "Incomplete Input", Toast.LENGTH_SHORT).show();



        else{
            setValues();
            result = myOperators.Minus(firstNumber, secondNumber);
            result_tv.setText(formatResult());
        }

    }


    public void multiply(View view) {
        findViews();
        if(firstText.matches("")||secondText.matches(""))
            Toast.makeText(this, "Incomplete Input", Toast.LENGTH_SHORT).show();



        else{
            setValues();
            result = myOperators.Multiply(firstNumber, secondNumber);
            result_tv.setText(formatResult());
        }
    }

    public void divide(View view) {
        findViews();
        if(firstText.matches("")||secondText.matches(""))
            Toast.makeText(this, "Incomplete Input", Toast.LENGTH_SHORT).show();



        else{
            setValues();
            result = myOperators.Divide(firstNumber, secondNumber);
            result_tv.setText(formatResult());
        }
    }

    public void exit(View view) {
        finish();
        System.exit(0);
    }
    public void clear(View view) {
        firstNumber_et.setText("");
        secondNumber_et.setText("");
        result_tv.setText("0");

    }
    public String formatResult(){



        DecimalFormat formatter = new DecimalFormat("#,###");

        return formatter.format(result);

    }
}
