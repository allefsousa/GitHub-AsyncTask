package tcc.developer.allef.mygithubasyncktask;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;

import tcc.developer.allef.mygithubasyncktask.Model.RepositorioGitHub;

/**
 * Created by allef on 21/10/2017.
 */

public class AsyncTaskActivity extends AsyncTask<Void,Void,ArrayList<RepositorioGitHub>>  {



    ListView listView;


    Activity context;
    ArrayList<String> NomeRepositorios = NomeRepositorios = new ArrayList<String>();


    public AsyncTaskActivity(Activity context) {
        this.context = context;
    }

    ArrayList<RepositorioGitHub> beanPostArrayList;

    @Override
    protected ArrayList<RepositorioGitHub> doInBackground(Void... voids) {
        try{
            URL url = new URL("https://api.github.com/users/Allefsousa/repos");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String value ;
            Type listType = new TypeToken<ArrayList<RepositorioGitHub>>(){}.getType();
            while((value = bf.readLine()) != null){
               beanPostArrayList = new GsonBuilder().create().fromJson(value, listType);
            }


           // Log.d("Allef", "doInBackground: " + beanPostArrayList.size());
            return beanPostArrayList;


        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(final ArrayList<RepositorioGitHub> repositorioGitHubs) {
        super.onPostExecute(repositorioGitHubs);
        ListView list = context.findViewById(R.id.listRepos);


        if (!repositorioGitHubs.isEmpty()){
            for (RepositorioGitHub git : repositorioGitHubs){
                String n = git.getName();
                NomeRepositorios.add(n);

            }
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, NomeRepositorios);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Allef", "onItemClick: " + NomeRepositorios.get(i));
                RepositorioGitHub re = new RepositorioGitHub();
                re = beanPostArrayList.get(i);
                Intent intent = new Intent(context,DetalhesActivity.class);
                intent.putExtra("valorcllicado", re);
                context.startActivity(intent);


            }
        });








    }
}
