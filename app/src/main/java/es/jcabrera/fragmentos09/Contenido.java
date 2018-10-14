package es.jcabrera.fragmentos09;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Contenido extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragmentos, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();


        actualizaContenido(args.getInt(ARG_POSITION));
    }

    public void actualizaContenido(int position) {
        TextView contenido = (TextView) getActivity().findViewById(R.id.contenido);
        contenido.setText(Elementos.Contenidos[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
