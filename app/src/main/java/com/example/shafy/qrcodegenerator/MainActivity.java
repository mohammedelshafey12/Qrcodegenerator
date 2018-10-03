package com.example.shafy.qrcodegenerator;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.QRCode;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
   EditText editText;
   Button button;
   ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText)findViewById(R.id.edittext);
        button = (Button)findViewById(R.id.button);
        imageView = (ImageView)findViewById(R.id.imageview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String text = editText.getText().toString().trim();
               if (text!=null){
                   MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                   BitMatrix bitMatrix = null;
                   try {
                       bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,500,500);
                   } catch (WriterException e) {
                       e.printStackTrace();
                   }
                   BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                   Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                   imageView.setImageBitmap(bitmap);
               }

            }
        });
    }
}
