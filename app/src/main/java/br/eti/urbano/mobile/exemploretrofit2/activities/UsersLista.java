package br.eti.urbano.mobile.exemploretrofit2.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.R;
import br.eti.urbano.mobile.exemploretrofit2.boostrap.APIClient;
import br.eti.urbano.mobile.exemploretrofit2.model.Users;
import br.eti.urbano.mobile.exemploretrofit2.resource.UserResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsersLista extends AppCompatActivity {
    public ListView listaTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userslist);

        /*Pega a referencia do ENDPOINT e do converter(gson)
        * */
        Retrofit retrofit = APIClient.getClient();

        //Faz o 'bind' da instância do retrofit com interface
        //que contém as operações (GET,POST,PUT,DELETE)
        UserResource userResource = retrofit.create(UserResource.class);

        //Faz a chamada do serviço
        Call<List<Users>> get = userResource.get();

        get.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                //Se deu certo executa este método
                listaTeste = findViewById(R.id.lista);
                List<Users> listUsers = response.body();

                //PROCESSAMENTO
                //Convertendo a lista em um List<HashMap<String,String>
                //para o simpleAdapter
                List<String> colecaoArrayAdapter = new ArrayList<>();

                List<HashMap<String, String>> colecao = new ArrayList<>();

                //criando colecao para o adapter
                for (Users u : listUsers) {

                    HashMap<String, String> map = new HashMap<>();
                    map.put("id", u.getId()+" ");
                    map.put("name", u.getName());
                    map.put("userName", u.getUsername());
                    map.put("email", u.getEmail());
                    map.put("street",u.getAddress().getStreet());
                    map.put("suite",u.getAddress().getSuite());
                    map.put("city",u.getAddress().getCity());
                    map.put("zipCode",u.getAddress().getZipcode());

                    colecao.add(map);
                    colecaoArrayAdapter.add(u.getName());
                }

                //Fazer o mapeamento da colecao com o layout do item
                String[] de = {"id","name", "userName","email","street","suite","city","zipCode"};
                int[] para = {R.id.txtId, R.id.txtName, R.id.txtUserName,R.id.txtEmail,R.id.txtStreet, R.id.txtSuite, R.id.txtCity, R.id.txtZipCode};

                //SAIDA
                listaTeste  = findViewById(R.id.lista);

                //SIMPLE ADAPTER
                SimpleAdapter adapter =
                        new SimpleAdapter(getApplicationContext(),colecao,
                                R.layout.activity_itens,de,para);

                listaTeste.setAdapter(adapter);

                //Professor não consegui popular a tela
                //Por esse motivo não coloquei todos os campos, montei a estrutura que pensei que seria correta.
                //Diogo Leal

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                listaTeste = findViewById(R.id.lista);

            }
        });
    }
}
