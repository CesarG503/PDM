package com.example.navigationfragment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationfragment.Adapter.AdapterIngrediente;
import com.example.navigationfragment.R;
import com.example.navigationfragment.dataBase.AppDatabase;
import com.example.navigationfragment.entitys.Ingrediente;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class IngredientesFragment extends Fragment {
    private RecyclerView recyclerViewIngrediente;
    private AdapterIngrediente adapterIngrediente;
    private ArrayList<Ingrediente> ingredientesLista = new ArrayList<>();

    private AppDatabase db;
    FloatingActionButton floatingActionButton3;

    public IngredientesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ingredientes, container, false);

        db = AppDatabase.getINSTANCE(getContext());

        recyclerViewIngrediente = view.findViewById(R.id.recyclerViewIngrediente);

        recyclerViewIngrediente.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));



        adapterIngrediente = new AdapterIngrediente(ingredientesLista, new AdapterIngrediente.Listener() {
            @Override
            public void OnClick(Ingrediente ingrediente) {

            }

            @Override
            public void OnDeleteClick(Ingrediente ingrediente) {

            }

            @Override
            public void OnUpdateClick(Ingrediente ingrediente) {

            }
        });
        recyclerViewIngrediente.setAdapter(adapterIngrediente);

        floatingActionButton3 = view.findViewById(R.id.floatingActionButton3);

        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });
        return view ;

    }

    @Override
    public void onResume()
    {
        super.onResume();
        loadIngrediente();
    }

    private void loadIngrediente()
    {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {

                List<Ingrediente> list = db.daoIngrediente().obtenerTodos();

                if (getActivity() != null)
                {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ingredientesLista.clear();
                            ingredientesLista.addAll(list);
                            adapterIngrediente.notifyDataSetChanged();

                        }
                    });
                }
            }
        });
    }
}