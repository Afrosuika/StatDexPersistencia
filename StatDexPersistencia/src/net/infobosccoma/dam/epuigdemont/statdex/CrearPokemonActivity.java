package net.infobosccoma.dam.epuigdemont.statdex;

import java.util.ArrayList;

import net.infobosccoma.dam.epuigdemont.statdex.dades.PokemonConversor;
import net.infobosccoma.dam.epuigdemont.statdex.dades.PokemonSQLiteHelper;
import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearPokemonActivity extends Activity implements OnClickListener {
	Spinner tipus1;
	Spinner tipus2;
	PokemonSQLiteHelper leHelper = new PokemonSQLiteHelper(this,
			MainActivity.BD_NOM, null, MainActivity.BD_VERSIO);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crear_pokemon);
		Button botocrear = (Button) findViewById(R.id.button1);
		botocrear.setOnClickListener(this);
		tipus1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.tipos1, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tipus1.setAdapter(adapter1);
		tipus1.setSelection(adapter1.getPosition("Normal"));
		tipus2 = (Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.tipos2, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tipus2.setAdapter(adapter2);
		tipus2.setSelection(adapter2.getPosition("Ninguno"));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crear_pokemon, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {

		if (((EditText) findViewById(R.id.editText7)).getText().toString()
				.equals("")
				|| ((EditText) findViewById(R.id.entrarNom)).getText()
						.toString().equals("")
				|| ((EditText) findViewById(R.id.editText1)).getText()
						.toString().equals("")
				|| ((EditText) findViewById(R.id.editText2)).getText()
						.toString().equals("")
				|| ((EditText) findViewById(R.id.editText3)).getText()
						.toString().equals("")
				|| ((EditText) findViewById(R.id.editText4)).getText()
						.toString().equals("")
				|| ((EditText) findViewById(R.id.editText5)).getText()
						.toString().equals("")
				|| ((EditText) findViewById(R.id.editText6)).getText()
						.toString().equals("")) {
			Toast.makeText(getApplicationContext(), "Emplena tots els camps!",
					Toast.LENGTH_SHORT).show();
		} else {
			int num = Integer
					.parseInt(((EditText) findViewById(R.id.editText7))
							.getText().toString());
			String nom = ((EditText) findViewById(R.id.entrarNom)).getText()
					.toString();
			int hp = Integer.parseInt(((EditText) findViewById(R.id.editText1))
					.getText().toString());
			int atk = Integer
					.parseInt(((EditText) findViewById(R.id.editText2))
							.getText().toString());
			int def = Integer
					.parseInt(((EditText) findViewById(R.id.editText3))
							.getText().toString());
			int spatk = Integer
					.parseInt(((EditText) findViewById(R.id.editText4))
							.getText().toString());
			int spdef = Integer
					.parseInt(((EditText) findViewById(R.id.editText5))
							.getText().toString());
			int spe = Integer
					.parseInt(((EditText) findViewById(R.id.editText6))
							.getText().toString());
			String verdadertipus1 = traduirtipus(tipus1.getSelectedItem()
					.toString());
			String verdadertipus2 = traduirtipus(tipus2.getSelectedItem()
					.toString());

			if (hp > 255 || atk > 255 || def > 255 || spatk > 255
					|| spdef > 255 || spe > 255) {
				Toast.makeText(this,
						"Algun dels estats está per sobre de 255.",
						Toast.LENGTH_SHORT).show();
			} else if (hp + atk + def + spatk + spdef + spe > 720) {
				Toast.makeText(this, "El total no pot ser superior a 720.",
						Toast.LENGTH_SHORT).show();
			} else if (verdadertipus1.equals(verdadertipus2)) {
				Toast.makeText(this, "Els tipus no poden coincidir.",
						Toast.LENGTH_SHORT).show();
			} else {

			}
			PokemonConversor conversor = new PokemonConversor(leHelper);
			ArrayList<Pokemon> laLlista = conversor.emplenarLlista();
			boolean espotcrear = true;
			for (Pokemon unpokemon : laLlista) {
				if (unpokemon.getNum() == num) {
					espotcrear = false;
				}
			}
			if (espotcrear) {
				conversor.save(new Pokemon(num, nom, hp, atk, def, spatk,
						spdef, spe, verdadertipus1, verdadertipus2));
				// retornem els valors als valors en blanc
				((EditText) findViewById(R.id.editText7)).setText("");
				((EditText) findViewById(R.id.entrarNom)).setText("");
				((EditText) findViewById(R.id.editText1)).setText("");
				((EditText) findViewById(R.id.editText2)).setText("");
				((EditText) findViewById(R.id.editText3)).setText("");
				((EditText) findViewById(R.id.editText4)).setText("");
				((EditText) findViewById(R.id.editText5)).setText("");
				((EditText) findViewById(R.id.editText6)).setText("");

				Toast.makeText(getApplicationContext(), "Pokemon creat",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(),
						"Ja existeix un pokemon amb aquest numero",
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	private String traduirtipus(String eltipus) {
		if (eltipus.equals("Bicho")) {
			return "bug";
		} else if (eltipus.equals("Siniestro")) {
			return "dark";
		} else if (eltipus.equals("Dragón")) {
			return "dragon";
		} else if (eltipus.equals("Eléctrico")) {
			return "electric";
		} else if (eltipus.equals("Hada")) {
			return "fairy";
		} else if (eltipus.equals("Lucha")) {
			return "fighting";
		} else if (eltipus.equals("Fuego")) {
			return "fire";
		} else if (eltipus.equals("Volador")) {
			return "flying";
		} else if (eltipus.equals("Fantasma")) {
			return "ghost";
		} else if (eltipus.equals("Planta")) {
			return "grass";
		} else if (eltipus.equals("Tierra")) {
			return "ground";
		} else if (eltipus.equals("Hielo")) {
			return "ice";
		} else if (eltipus.equals("Normal")) {
			return "normal";
		} else if (eltipus.equals("Veneno")) {
			return "poison";
		} else if (eltipus.equals("Psíquico")) {
			return "psychic";
		} else if (eltipus.equals("Roca")) {
			return "rock";
		} else if (eltipus.equals("Acero")) {
			return "steel";
		} else if (eltipus.equals("Agua")) {
			return "water";
		} else if (eltipus.equals("Ninguno")) {
			return null;
		} else {
			return null;
		}
	}

}
