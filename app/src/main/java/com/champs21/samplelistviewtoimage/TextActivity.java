package com.champs21.samplelistviewtoimage;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.master.permissionhelper.PermissionHelper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TextActivity extends AppCompatActivity {
    PermissionHelper permissionHelper;
    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        permissionHelper = new PermissionHelper(this, new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        permissionHelper.request(new PermissionHelper.PermissionCallback() {
            @Override
            public void onPermissionGranted() {
                Log.d(TAG, "onPermissionGranted() called");
            }

            @Override
            public void onIndividualPermissionGranted(String[] grantedPermission) {
                Log.d(TAG, "onIndividualPermissionGranted() called with: grantedPermission = [" + TextUtils.join(",",grantedPermission) + "]");
            }

            @Override
            public void onPermissionDenied() {
                Log.d(TAG, "onPermissionDenied() called");
            }

            @Override
            public void onPermissionDeniedBySystem() {
                Log.d(TAG, "onPermissionDeniedBySystem() called");
                permissionHelper.openAppDetailsActivity();
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new ArrayList<>();
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
                list.add("tomal");
                list.add("maruf");
                list.add("chy");
               CreatePDF(list);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (permissionHelper != null) {
            permissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void CreatePDF(List<String>list){
        EditText editText = (EditText)findViewById(R.id.editText);
        Document document = new Document();
        String path = Environment.getExternalStorageDirectory() + "/mypdf.pdf";
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
//            for(int i =0; i< 10; i++) {
//                document.add(new Paragraph(editText.getText().toString()));
//            }
            for (int i =0; i<list.size(); i++)
                document.add(new Paragraph(list.get(i)));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//
//        }catch (Exception e){
//
//        }
    }

}
