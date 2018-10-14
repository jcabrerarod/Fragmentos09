package es.jcabrera.fragmentos09;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Cabecera extends ListFragment {

    CabeceraListener mCallback;

    public interface CabeceraListener {

        public void siSeleccion(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Elementos.Cabeceras));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mCallback = (CabeceraListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        mCallback.siSeleccion(position);


    }
}
