package com.android.s19110239;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int REQUEST_CODE = 123;
    EditText txtSoTienGui, txtLaiXuatGui, txtKyHanGui;
    Button btnXemKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSoTienGui = findViewById(R.id.txtSoTienGui);
        txtLaiXuatGui = findViewById(R.id.txtLaiXuatGui);
        txtKyHanGui = findViewById(R.id.txtKyHanGui);
    }

    public void onXemKetQua(View view) {
        int soTienGui;
        int laiXuatGui;
        int kyHanGui;
        try{
            soTienGui = getNumber(txtSoTienGui);
            laiXuatGui = getNumber(txtLaiXuatGui);
            kyHanGui = getNumber(txtKyHanGui);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
            return;
        }
        int lai = tinhLai(soTienGui, laiXuatGui, kyHanGui);
        Intent intern = new Intent(MainActivity.this, ViewActivity.class);
        intern.putExtra("TienLai", lai);
        intern.putExtra("TongTien", lai + soTienGui);
        startActivityForResult(intern, REQUEST_CODE);
    }

    public int tinhLai(int soTienGui, int laiXuatGui, int kyHanGui) {
        return (int)(soTienGui * (laiXuatGui/100.0) * (kyHanGui*30.0)/360);
    }

    private static int getNumber(EditText editText) {
        String text = getTextView(editText);
        return Integer.parseInt(text);
    }

    private static String getTextView(EditText text) {
        return text.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){

        }
    }
}