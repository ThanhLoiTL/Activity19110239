package com.android.s19110239;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    TextView txtTienLai, txtTongTien;
    Button btnCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        txtTienLai = findViewById(R.id.txtTienLai);
        txtTongTien = findViewById(R.id.txtTongTien);
        btnCamera = findViewById(R.id.btnCamera);

        Intent intent = getIntent();
        int tienLai = intent.getIntExtra("TienLai", 0);
        int tongTien = intent.getIntExtra("TongTien", 0);
        txtTienLai.setText(tienLai + " đ");
        txtTongTien.setText(tongTien + " đ");
    }

    public void onTakeAPicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
        setResult(RESULT_OK, intent);
        finish();
    }
}