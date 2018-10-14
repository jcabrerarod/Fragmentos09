package es.jcabrera.fragmentos09;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

public class Fragmentos09 extends FragmentActivity
        implements Cabecera.CabeceraListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentos09);

        if (savedInstanceState != null) {
            return;
        }

        Cabecera firstFragment = new Cabecera();

        firstFragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedor, firstFragment).commit();
    }

    public void siSeleccion(int position) {

        Contenido opcionSeleccionada = (Contenido)
                getSupportFragmentManager().findFragmentById(R.id.contenido);

        Contenido newFragment = new Contenido();
        Bundle args = new Bundle();
        args.putInt(Contenido.ARG_POSITION, position);
        newFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.contenedor, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
