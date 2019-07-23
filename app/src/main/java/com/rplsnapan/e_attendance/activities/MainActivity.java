package com.rplsnapan.e_attendance.activities;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;
import com.rplsnapan.e_attendance.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {


    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mScannerView);
        mScannerView = new ZXingScannerView(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.v("TAG", result.getText());
        Log.v("TAG", result.getBarcodeFormat().toString());
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Result");
        alert.setMessage(result.getText());
        AlertDialog alertDialog = alert.create();
        alertDialog.show();

        mScannerView.resumeCameraPreview(this);
    }
}
