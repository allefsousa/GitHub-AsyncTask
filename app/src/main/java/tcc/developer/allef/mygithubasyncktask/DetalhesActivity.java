package tcc.developer.allef.mygithubasyncktask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import tcc.developer.allef.mygithubasyncktask.Model.RepositorioGitHub;

public class DetalhesActivity extends AppCompatActivity {
    String receber = "dados";
    RepositorioGitHub repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        repository = new RepositorioGitHub();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * Recebendo a intent com o objeto clicado do List View
         */
        repository = (RepositorioGitHub) getIntent().getSerializableExtra("valorcllicado");



        Toast.makeText(this, "Chama Nois"+ repository.getName(), Toast.LENGTH_LONG).show();

    }

}
