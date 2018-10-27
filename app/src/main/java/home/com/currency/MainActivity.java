package home.com.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String USD_RATE = "30.9";
    private EditText edNtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        edNtd = findViewById(R.id.ntd);
        TextView usd = findViewById(R.id.usd);
        usd.setText("1:" + USD_RATE);

    }

    public void calculate(View view){
        String n = edNtd.getText().toString();

        if (n.equals("")){
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK", null)
                    .show();
        }else {
            Float floatNtd = Float.parseFloat(n);
            Float floatUsdRate = Float.parseFloat(USD_RATE);
            Float result = floatNtd / floatUsdRate;
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + result)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edNtd.setText("");
                        }
                    })
                    .show();
        }
    }
}
