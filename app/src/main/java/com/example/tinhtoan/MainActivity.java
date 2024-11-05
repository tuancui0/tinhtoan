package com.example.tinhtoan;

import static com.example.tinhtoan.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCheck;
    RadioGroup radioGroup;
    EditText editText, editText1;
    TextView result;
    RadioButton radioButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnCheck = findViewById(R.id.btnCheck);
        radioGroup = findViewById(R.id.radioGroup);
        editText = findViewById(R.id.txtA);
        editText1 = findViewById(R.id.txtB);
        result = findViewById(R.id.lbResult);
        radioButton = findViewById(R.id.rbtnPlus);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = findViewById(i);
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                double num1 = Double.parseDouble(editText.getText().toString());
                double num2 = Double.parseDouble(editText1.getText().toString());
                double num3 = 0;
                String charac = radioButton.getText().toString();

                switch(charac){
                    case "Cộng":{
                        num3 = num1 + num2;
                    }
                    break;
                    case "Trừ":{
                        num3 = num1 - num2;
                    }
                    break;
                    case "Nhân":{
                        num3 = num1 * num2;
                    }
                    break;
                    case "Chia":{
                        num3 = num1 / num2;
                    }
                    break;
                    default:
                }
                result.setText(num3+"");
            }
        });
    }
}