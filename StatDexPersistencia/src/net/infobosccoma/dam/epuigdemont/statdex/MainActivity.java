package net.infobosccoma.dam.epuigdemont.statdex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import net.infobosccoma.dam.epuigdemont.statdex.dades.PokemonConversor;
import net.infobosccoma.dam.epuigdemont.statdex.dades.PokemonSQLiteHelper;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Telephony.Sms.Conversations;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	public final static int MAX_STAT = 255;
	public final static int MAX_TOTAL = 720;
	public final static int BD_VERSIO = 1;
	public final static String BD_NOM = "pokemon.db";
	private ArrayList<Pokemon> dades;
	private PokemonAdapter adapter;
	PokemonConversor conversor;
	ListView llista;
	PokemonSQLiteHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		// dades= new ArrayList<Pokemon>();

		helper = new PokemonSQLiteHelper(this, BD_NOM, null, BD_VERSIO);
		SQLiteDatabase db = helper.getWritableDatabase();
		db.close();
		conversor = new PokemonConversor(helper);
		dades = conversor.emplenarLlista();

		adapter = new PokemonAdapter(this, dades);

		llista = ((ListView) findViewById(R.id.listPokes));
		llista.setOnItemClickListener(this);

		llista.setAdapter(adapter);

	}

	public ArrayList<Pokemon> emplenarLlista(PokemonConversor conversor) {
		Cursor elCursor = conversor.getAll();
		ArrayList<Pokemon> dades2 = new ArrayList<Pokemon>();
		if (elCursor.moveToFirst()) {
			do {
				dades2.add(new Pokemon(elCursor.getInt(1), elCursor
						.getString(2), elCursor.getInt(3), elCursor.getInt(4),
						elCursor.getInt(5), elCursor.getInt(6), elCursor
								.getInt(7), elCursor.getInt(8), elCursor
								.getString(9), elCursor.getString(10)));
			} while (elCursor.moveToNext());
		}

		if (elCursor != null && !elCursor.isClosed()) {
			elCursor.close();
		}
		return dades2;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent i = new Intent(MainActivity.this, MostrastatsActivity.class);
		Bundle b = new Bundle();
		b.putSerializable("pokemon", (Pokemon) llista.getItemAtPosition(arg2));
		i.putExtras(b);
		startActivity(i);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// es mira quina de les opcions s'ha triat, i es fa servir el comparator
		// corresponent
		switch (item.getItemId()) {
		case R.id.orderby_number:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p1.getNum() - p2.getNum();
				}
			});
			adapter.notifyDataSetChanged();
			break;
		case R.id.orderby_name:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p1.getName().compareToIgnoreCase(p2.getName());
				}
			});
			adapter.notifyDataSetChanged();
			break;
		case R.id.orderby_hp:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p2.getHp() - p1.getHp();
				}
			});
			adapter.notifyDataSetChanged();
			break;
		case R.id.orderby_atk:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p2.getAtk() - p1.getAtk();
				}
			});
			adapter.notifyDataSetChanged();
			break;
		case R.id.orderby_def:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p2.getDef() - p1.getDef();
				}
			});
			adapter.notifyDataSetChanged();
			break;
		case R.id.orderby_spatk:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p2.getSpAtk() - p1.getSpAtk();
				}
			});
			adapter.notifyDataSetChanged();
			break;
		case R.id.orderby_spdef:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p2.getSpDef() - p1.getSpDef();
				}
			});
			adapter.notifyDataSetChanged();
			break;
		case R.id.orderby_spe:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p2.getSpe() - p1.getSpe();
				}
			});
			adapter.notifyDataSetChanged();
			break;
		case R.id.orderby_total:
			Collections.sort(dades, new Comparator<Pokemon>() {
				@Override
				public int compare(Pokemon p1, Pokemon p2) {
					return p2.getTotal() - p1.getTotal();
				}
			});
			adapter.notifyDataSetChanged();
			break;

		case R.id.AddPokemon:
			Intent i = new Intent(MainActivity.this, CrearPokemonActivity.class);
			// Bundle b = new Bundle();
			// b.putSerializable("llista", dades);
			// i.putExtras(b);
			startActivity(i);
			break;

		case R.id.RemovePokemon:
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			alert.setMessage("Introdueix el numero");

			final EditText input = new EditText(this);
			alert.setView(input);

			alert.setPositiveButton("Elimina!",
					new DialogInterface.OnClickListener() {
						boolean espotmirar;

						public void onClick(DialogInterface dialog,
								int whichButton) {
							Editable value = input.getText();
							int nombreintroduit = 8000;
							try {
								nombreintroduit = Integer.parseInt(value
										.toString());
								espotmirar = true;

							} catch (Exception e) {
								Toast.makeText(getApplicationContext(),
										"Has d'introduir un numero",
										Toast.LENGTH_SHORT).show();
								espotmirar = false;

							}
							if (espotmirar) {
								esborrarSiExisteix(nombreintroduit);
							}
						}
					});

			alert.setNegativeButton("Cancelar",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
						}
					});

			alert.show();

			break;
		}

		return super.onOptionsItemSelected(item);
	}

	public void esborrarSiExisteix(int numero) {
		boolean trobat = false;
		Pokemon pokemon = null;
		for (Pokemon elpokemon : dades) {
			if (elpokemon.getNum() == numero) {
				conversor.remove(elpokemon);
				pokemon = elpokemon;
				trobat = true;
			}
		}

		if (!trobat) {
			Toast.makeText(this, R.string.pokemonNoExist, Toast.LENGTH_SHORT)
					.show();
		} else {
			dades.remove(pokemon);
			adapter.notifyDataSetChanged();
			Toast.makeText(this, "És súper eficaç!!", Toast.LENGTH_SHORT)
					.show();
		}
	}

}
