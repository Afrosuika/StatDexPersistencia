package net.infobosccoma.dam.epuigdemont.statdex;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressLint("DefaultLocale")
public class PokemonAdapter extends ArrayAdapter<Pokemon>{
	private ArrayList<Pokemon> dades;
	
	public PokemonAdapter(Activity context, ArrayList<Pokemon> dades) {
		super(context, R.layout.listitem_poke,dades);
		this.dades=dades;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
	      View element = convertView;
	      Vista vista;
	 
	      if(element == null) {
	         LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
	         element = inflater.inflate(R.layout.listitem_poke, null);
	 
	         vista = new Vista();
	         vista.num = (TextView)element.findViewById(R.id.poke_number);
	         vista.name = (TextView)element.findViewById(R.id.poke_name);
	 
	         element.setTag(vista);
	      }
	      else {
	         vista = (Vista)element.getTag();
	      }
//	      aquesta operació fa que sempre es mostrin tres xifres, sense importar quin és el número
	      String numeromostrar = String.format("%03d", dades.get(position).getNum());	 
	      vista.num.setText(numeromostrar);
	      vista.name.setText(dades.get(position).getName());
	 
	      return element;
	   }

}