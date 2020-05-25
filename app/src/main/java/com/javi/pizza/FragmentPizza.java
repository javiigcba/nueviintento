package com.javi.pizza;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.javi.pizza.adaptadores.Adaptador;
import com.javi.pizza.entidades.Platos;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPizza#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPizza extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Adaptador adaptador;
    RecyclerView recyclerViewPlatos;
    ArrayList<Platos>listaPlatos;

    public FragmentPizza() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPizza.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPizza newInstance(String param1, String param2) {
        FragmentPizza fragment = new FragmentPizza();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pizza, container, false);
        listaPlatos = new ArrayList<>();

        //cargo lista
        cargarLista();

        //muestro datos

        mostrarDatos();

        return view;



    }

    public  void  cargarLista (){
        listaPlatos.add(new Platos("Carbonara","1111111111111111","$320",R.drawable.p_carbonara));
        listaPlatos.add(new Platos("Cuatro quesos","2222222222222222","$350",R.drawable.p_cuatroqueso));
    }

    public void mostrarDatos(){

        recyclerViewPlatos.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptador = new Adaptador(getContext(),listaPlatos);
        recyclerViewPlatos.setAdapter(adaptador);
    }




}
