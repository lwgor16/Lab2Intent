package my.edu.taruc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textViewMessage;
        textViewMessage = findViewById(R.id.textViewMessage);
        //Read the intent extra value
        Intent intent = getIntent(); //Who called me?
        if(intent.hasExtra(MainActivity.TAG_MESSAGE))
        {
            String stringMsg;
            stringMsg = intent.getStringExtra(MainActivity.TAG_MESSAGE);
            double BMI = 0.0;
            BMI = Double.parseDouble(stringMsg);
            BMI = Math.round(BMI * 100) / 100;
            stringMsg = String.valueOf(BMI);
            String weight = "";
            if(BMI < 18.5)
            {
                weight = "underweight.";
            }
            else if(BMI < 24.9)
            {
                weight = "normal weight.";
            }
            else
            {
                weight = "overweight.";
            }
            textViewMessage.setText("Your BMI is : " + stringMsg + ", and you are " + weight);
        }
    }
}
