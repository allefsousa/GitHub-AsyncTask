package tcc.developer.allef.mygithubasyncktask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar();
        getSupportActionBar().setTitle("Repositorios");

        new AsyncTaskActivity(MainActivity.this).execute();


    }

//    class myTask extends AsyncTask<Void,Void,Void>{
//
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            try{
//                URL url = new URL("https://api.github.com/users/Allefsousa/repos");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//                connection.connect();
//
//                BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String value = bf.readLine();
//                System.out.println("Ressult" + value);
//
//
//            }catch (Exception e){
//                System.out.println(e);
//            }
//            return null;
//        }
//    }

}

