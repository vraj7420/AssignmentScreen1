package com.example.screen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etxtName;
    EditText etxtPassword;
    EditText etxtEmail;
    EditText etxtPhone;
    Button bttnNext;
    NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         etxtName =(EditText)findViewById(R.id.txtName);
        etxtPassword=(EditText)findViewById(R.id.txtPassoowrd);
        etxtEmail=(EditText)findViewById(R.id.txtEmail);
         etxtPhone=(EditText)findViewById(R.id.txtPhone);
         bttnNext=(Button)findViewById(R.id.btnNext);
         np = findViewById(R.id.numberPickerAge);
        np.setMinValue(18);
        np.setMaxValue(100);

        bttnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameValidate(etxtName);
                emailValidator(etxtEmail);
                passwordValidate(etxtPassword);
                contectValidate(etxtPhone);
                getNumberPikervalue(np);
                //allValidate();

           }
        });

    }
    public  void nameValidate(EditText name)
    {
        String nameText=name.getText().toString();
        if(nameText.isEmpty() || nameText.matches("\\s+"))
        {
            Toast.makeText(this,"Plese Enter name",Toast.LENGTH_SHORT).show();

        }
        else
        {
            return;
        }
    }
    public void emailValidator(EditText etMail) {

        String emailToText = etMail.getText().toString();

        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
            return;
        } else {
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }
    }
    public  void  passwordValidate(EditText pass)
    {
        String paassword=pass.getText().toString();
        if(paassword.isEmpty())
        {
            Toast.makeText(this,"Plese Enter Password",Toast.LENGTH_SHORT).show();

        }
        else
        {
            return;
        }
    }
     public  void  contectValidate(EditText call)
     {
         if(call.getText().toString().isEmpty() || call.getText().toString().matches("\\s+"))
         {
             Toast.makeText(this,"please enter contact number",Toast.LENGTH_SHORT).show();
         }
         else
         {
             return;
         }
     }

 public  void getNumberPikervalue(NumberPicker np) {
        int temp=np.getValue();
         Toast.makeText(this,""+temp,Toast.LENGTH_SHORT).show();

 }


 public  void  allValidate() {
     if (etxtName.getText().toString().isEmpty() || etxtName.getText().toString().matches("\\s+")) {
         Toast.makeText(this, "Plese Enter name", Toast.LENGTH_SHORT).show();

     } else if (!(!etxtEmail.getText().toString().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(etxtEmail.getText().toString()).matches())) {
         Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
     } else if (etxtPassword.getText().toString().isEmpty()) {
         Toast.makeText(this, "Plese Enter Password", Toast.LENGTH_SHORT).show();

     } else if (etxtPhone.getText().toString().isEmpty() || etxtPhone.getText().toString().matches("\\s+")) {
         Toast.makeText(this, "please enter contact number", Toast.LENGTH_SHORT).show();
     } else {
         /*int temp=np.getValue();
         Toast.makeText(this,""+temp,Toast.LENGTH_SHORT).show();*/
         Toast.makeText(this,"All Value are Validate",Toast.LENGTH_SHORT).show();
     }
 }
}