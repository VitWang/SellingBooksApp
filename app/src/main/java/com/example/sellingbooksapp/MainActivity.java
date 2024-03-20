package com.example.sellingbooksapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtPass;
    Button btnLogin, btnRegister, btnExit;
    String name, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
        ControlButtonRegister();
        ControlButtonLogin();
    }


    private void Anhxa() {
        edtEmail = (EditText) findViewById(R.id.email);
        edtPass = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);
        btnRegister = (Button) findViewById(R.id.register);
        btnExit = (Button) findViewById(R.id.btnExit);
    }
    private void ControlButton(){
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát khỏi app");
                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setCancelable(false);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getOnBackPressedDispatcher();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    private void ControlButtonRegister() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.register_main);
                EditText emaildk = (EditText) dialog.findViewById(R.id.edtdkemail);
                EditText passdk = (EditText) dialog.findViewById(R.id.edtdkpass);
                Button btnAcceptRegister = (Button) dialog.findViewById(R.id.btnaccept);
                Button btncancelRegister = (Button) dialog.findViewById(R.id.btnnoaccept);

                btnAcceptRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = emaildk.getText().toString();
                        pass = passdk.getText().toString();
                        edtEmail.setText(name);
                        edtPass.setText(pass);
                        dialog.cancel();
                    }
                });

                btncancelRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
    }
    private void ControlButtonLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtEmail.getText().length() != 0 && edtPass.getText().length()!= 0){
                    if(edtEmail.getText().toString().equals(name) && edtPass.getText().toString().equals(pass)){
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Bạn đã nhập sai thông tin đã đăng kí, vui lòng nhập lại!!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}