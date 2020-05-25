package com.javi.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.zxing.Result;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    String ScannerMesa;
    FirebaseAuth fAuth;
    private static final String TAG ="EjemploActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;

    }

    public boolean onOptionsItemSelected (MenuItem item){
        int id =item.getItemId();

        if (id == R.id.itemmiUsuario){
            Toast.makeText(this, "este es mi usuario", Toast.LENGTH_SHORT).show();
            Intent siguiente = new Intent (this, MiUsuario.class);
            startActivity(siguiente);
            return false;

        }

        return super.onOptionsItemSelected(item);
    }

    private ZXingScannerView mScannerView;

    public void btnEscanear(View view){

       mScannerView = new ZXingScannerView(this);
       setContentView(mScannerView);
       mScannerView.setResultHandler(this);
       mScannerView.startCamera();


    }
    @Override
    public void handleResult(Result result) {


        ScannerMesa = result.getText();
        finish();
        updateDocument ();

    }


    private void updateDocument (){
        String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        final DocumentReference docref = FirebaseFirestore.getInstance()
                .collection("users")
                .document(Uid);
                //.document("OHQECKXkD3bkyv22cUvs2HNuJ1c2");

        Map<String,Object> map = new HashMap<>();
        map.put("sitio",ScannerMesa);
        //map.put("sitio","mesa1");

        docref.update(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                    public void onSuccess(Void aVoid) {
                       Intent siguiente = new Intent (MainActivity.this, MiUsuario.class);
                       startActivity(siguiente);
                        Log.d(TAG, "onSuccess: ¡Bienvenido! ya podes realizar tu pedido.");

                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG,"onFailure: se ha producido un error",e);
                    }
                });

    }





}
