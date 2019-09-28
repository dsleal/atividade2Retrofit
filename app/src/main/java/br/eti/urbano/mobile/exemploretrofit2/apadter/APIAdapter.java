package br.eti.urbano.mobile.exemploretrofit2.apadter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.R;
import br.eti.urbano.mobile.exemploretrofit2.model.Users;


public class APIAdapter extends BaseAdapter {


    Context context;
    List<Users> colecao;

    public APIAdapter(final Context applicationContext, final List<Users> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;

    }

    @Override
    public int getCount() {
        return this.colecao != null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return this.colecao.get(i);
    }

    private Users parsetItem(int i) {
        return this.colecao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // inflate the layout for each list row
        //'Infla' o layout(pega a referencia) para ser trabalhada
        //no método
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.activity_itens,
                            viewGroup, false);
        }

        // pega o objeto corrente da lista
        Users users = parsetItem(i);

        TextView id, name, userName;

        id = view.findViewById(R.id.txtId);
        name = view.findViewById(R.id.txtName);
        userName = view.findViewById(R.id.txtUserName);

        id.setText(Integer.toString(users.getId()));
        name.setText(users.getName());
        userName.setText(users.getUsername());

        return view;

    }
}
