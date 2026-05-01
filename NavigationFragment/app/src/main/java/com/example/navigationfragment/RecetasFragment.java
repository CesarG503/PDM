package com.example.navigationfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.navigationfragment.Adapter.AdapterReceta;
import com.example.navigationfragment.DAO.DAOReceta;
import com.example.navigationfragment.dataBase.AppDatabase;
import com.example.navigationfragment.entitys.Receta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class RecetasFragment extends Fragment {

     private RecyclerView recycleViewReceta;
     private ArrayList<Receta> listaReceta = new ArrayList<>();
     private AdapterReceta adapterReceta;

     private AppDatabase db;

     FloatingActionButton floatingActionButton2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recetas, container, false);

        db = AppDatabase.getINSTANCE(getContext());

        recycleViewReceta = view.findViewById(R.id.recycleViewReceta);
        recycleViewReceta.setLayoutManager(new LinearLayoutManager(getContext()));


        floatingActionButton2 = view.findViewById(R.id.floatingActionButton2);


        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecetaActivityUI.class);
                startActivity(intent);
            }
        });


        adapterReceta = new AdapterReceta(listaReceta, new AdapterReceta.Listener() {
            @Override
            public void OnClickEdit(Receta receta) {
                Intent intent = new Intent(getActivity(), RecetaActivityUI.class);
                intent.putExtra("id", receta.id);
                startActivity(intent);
            }

            @Override
            public void OnClickDelete(Receta receta) {

                try
                {
                    AlertDialog.Builder log = new AlertDialog.Builder(getContext());

                    log.setTitle("desea borrar");
                    log.setMessage("Si o no ?");
                    log.setPositiveButton("si", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AppDatabase.databaseWriteExecutor.execute(new Runnable() {
                                @Override
                                public void run() {

                                    db.daoReceta().delete(receta);

                                    //si se necesita ejecutar algo dentro de este database Writer
                                    if (getActivity() != null) {
                                        getActivity().runOnUiThread(() -> {
                                            loadCategorias();
                                            Toast.makeText(getContext(), "Se borro Correctamente", Toast.LENGTH_SHORT).show();
                                        });
                                    };
                                }
                            });

                        }
                    });

                    log.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    log.show();

                } catch (Exception e) {
                    Toast.makeText(getContext(), "No se borro!", Toast.LENGTH_SHORT).show();
                }

            }

        });

        recycleViewReceta.setAdapter(adapterReceta);


        return view;


    }

    @Override
    public void onResume() {
        super.onResume();

        loadCategorias();
    }

    private void loadCategorias() {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {

                    List<Receta> list = db.daoReceta().selectAll();
                    if (getActivity() != null) {
                        getActivity().runOnUiThread(() -> {
                            listaReceta.clear();
                            listaReceta.addAll(list);
                            adapterReceta.notifyDataSetChanged();
                        });
                    }

            }
        });
    }
}