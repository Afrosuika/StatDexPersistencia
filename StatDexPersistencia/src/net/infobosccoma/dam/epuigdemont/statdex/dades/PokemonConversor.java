package net.infobosccoma.dam.epuigdemont.statdex.dades;

import java.io.Serializable;
import java.util.ArrayList;

import net.infobosccoma.dam.epuigdemont.statdex.Pokemon;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PokemonConversor implements Serializable {

	private PokemonSQLiteHelper helper;

	public PokemonConversor() {

	}

	public PokemonConversor(PokemonSQLiteHelper helper) {
		this.helper = helper;
	}

	public long save(Pokemon pokemon) {
		long index = -1;
		// s'agafa l'objecte base de dades en mode escriptura
		SQLiteDatabase db = helper.getWritableDatabase();
		// es crea un objecte de diccionari (clau,valor) per indicar els valors
		// a afegir
		ContentValues dades = new ContentValues();

		dades.put("numero", pokemon.getNum());
		dades.put("nom", pokemon.getName());
		dades.put("hp", pokemon.getHp());
		dades.put("atac", pokemon.getAtk());
		dades.put("defensa", pokemon.getDef());
		dades.put("atac_especial", pokemon.getSpAtk());
		dades.put("defensa_especial", pokemon.getSpDef());
		dades.put("velocitat", pokemon.getSpe());
		dades.put("tipus1", pokemon.getType1());
		dades.put("tipus2", pokemon.getType2());

		try {
			index = db.insertOrThrow("Pokemons", null, dades);
			// volem veure en el log el que passa
			Log.i("Pokemons", dades.toString() + " afegit amb codi " + index);
		} catch (Exception e) {
			// volem reflectir en ellog que hi ha hagut un error
			Log.e("Pokemons", e.getMessage());
		}
		return index;
	}

	public Cursor getAll() {
		SQLiteDatabase db = helper.getReadableDatabase();

		return db.query(true, "Pokemons", null, null, null, null, null, null,
				null);
	}
	
	public boolean remove(Pokemon p) {		
		// obtenir l'objecte BD en mode esriptura
		SQLiteDatabase db = helper.getWritableDatabase();
 
		return db.delete("Pokemons", "numero=" + p.getNum(),null ) > 0;
	}
	
	public boolean removeAll() {		
		// obtenir l'objecte BD en mode escriptura
		SQLiteDatabase db = helper.getWritableDatabase();
 
		return db.delete("Pokemons", null, null ) > 0;
	}
	
	public ArrayList<Pokemon> emplenarLlista() {
		Cursor elCursor =this.getAll();
		ArrayList<Pokemon> dades2 = new ArrayList<Pokemon>();
		if (elCursor.moveToFirst()) {
			do {
				dades2.add(new Pokemon(elCursor.getInt(0),elCursor.getString(1),elCursor.getInt(2),elCursor.getInt(3),elCursor.getInt(4),elCursor.getInt(5),elCursor.getInt(6),elCursor.getInt(7),elCursor.getString(8),elCursor.getString(9)));
			} while (elCursor.moveToNext());
		}
	 
		if (elCursor != null && !elCursor.isClosed()) {
			elCursor.close();
		}
		return dades2;
	}

}
