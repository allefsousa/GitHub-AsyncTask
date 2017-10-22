package tcc.developer.allef.mygithubasyncktask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import tcc.developer.allef.mygithubasyncktask.Model.RepositorioGitHub;

public class DetalhesActivity extends AppCompatActivity {
    String receber = "dados";
    RepositorioGitHub repository;
    @BindView(R.id.Urlre)
    TextView url;
    @BindView(R.id.Linguagem)
    TextView linguag;
    @BindView(R.id.NomeRepo)
    TextView nomerepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.too);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        repository = new RepositorioGitHub();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * Recebendo a intent com o objeto clicado do List View
         */
        repository = (RepositorioGitHub) getIntent().getSerializableExtra("valorcllicado");
        String nome, lan, emai;

        nome = nomerepo.getText().toString();
        lan = linguag.getText().toString();
        emai = url.getText().toString();


        url.setText(emai+repository.getHtml_url());
        url.setTextColor(getResources().getColor(R.color.colorAccent));

        linguag.setText(lan+repository.getLanguage());
        nomerepo.setText(nome+repository.getName());

        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_VIEW, Uri.parse(repository.getHtml_url()));
                startActivity(in);
            }
        });




    }

}
