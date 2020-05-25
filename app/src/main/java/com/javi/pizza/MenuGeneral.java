package com.javi.pizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;

public class MenuGeneral extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment Frpizza, Frpastas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_general);

        Frpizza = new FragmentPizza ();
        Frpastas = new FragmentPastas();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorfragment,Frpizza).commit();

    }

    public void onClick (View view){

        transaction=getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.imageView6: transaction.replace(R.id.contenedorfragment,Frpizza);
                break;
            case R.id.imageView5: transaction.replace(R.id.contenedorfragment,Frpastas);
                break;
        }

        transaction.commit();

    }

}
