package net.infobosccoma.dam.epuigdemont.statdex;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MostrastatsActivity extends Activity {
	ImageView laImatge;
	ImageView tipus1;
	ImageView tipus2;
	private TextView numeroHP, numeroAtk, numeroDef, numeroSpAtk, numeroSpDef,
			numeroSpe, numeroTotal;
	private ProgressBar barraHP, barraAtk, barraDef, barraSpAtk, barraSpDef,
			barraSpe, barraTotal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrastats);
		Pokemon elPokemon = (Pokemon) getIntent().getExtras().getSerializable(
				"pokemon");
		((TextView) findViewById(R.id.display_name)).setText(elPokemon
				.getName());
		laImatge = (ImageView) findViewById(R.id.display_portrait);
		tipus1 = (ImageView) findViewById(R.id.display_type1);
		tipus2 = (ImageView) findViewById(R.id.display_type2);
		definirTipus1(elPokemon.getType1());
		definirTipus2(elPokemon.getType2());
//		s'intenta carregar la imatge des d'internet, si no hi ha connexió, no es podrà carregar 
//		i es quedarà la imatge per defecte
		new TascaDescarrega().execute("http://www.serebii.net/xy/pokemon/"
				+ String.format("%03d", elPokemon.getNum()) + ".png");
		
//		separats en paràgrafs, les operacions amb cada parella TextView-Progressbar
		numeroHP = (TextView) findViewById(R.id.displaynumberhp);
		numeroHP.setVisibility(View.GONE);
		numeroHP.setText("" + elPokemon.getHp());
		barraHP = ((ProgressBar) findViewById(R.id.stats_hp_bar));
		barraHP.setProgress((elPokemon.getHp() * 100 / MainActivity.MAX_STAT));

		numeroAtk = (TextView) findViewById(R.id.displaynumberatk);
		numeroAtk.setVisibility(View.GONE);
		numeroAtk.setText("" + elPokemon.getAtk());
		barraAtk = ((ProgressBar) findViewById(R.id.stats_atk_bar));
		barraAtk.setProgress((elPokemon.getAtk() * 100 / MainActivity.MAX_STAT));

		numeroDef = (TextView) findViewById(R.id.displaynumberdef);
		numeroDef.setVisibility(View.GONE);
		numeroDef.setText("" + elPokemon.getDef());
		barraDef = ((ProgressBar) findViewById(R.id.stats_def_bar));
		barraDef.setProgress((elPokemon.getDef() * 100 / MainActivity.MAX_STAT));

		numeroSpAtk = (TextView) findViewById(R.id.displaynumberspatk);
		numeroSpAtk.setVisibility(View.GONE);
		numeroSpAtk.setText("" + elPokemon.getSpAtk());
		barraSpAtk = ((ProgressBar) findViewById(R.id.stats_spatk_bar));
		barraSpAtk
				.setProgress((elPokemon.getSpAtk() * 100 / MainActivity.MAX_STAT));

		numeroSpDef = (TextView) findViewById(R.id.displaynumberspdef);
		numeroSpDef.setVisibility(View.GONE);
		numeroSpDef.setText("" + elPokemon.getSpDef());
		barraSpDef = ((ProgressBar) findViewById(R.id.stats_spdef_bar));
		barraSpDef
				.setProgress((elPokemon.getSpDef() * 100 / MainActivity.MAX_STAT));

		numeroSpe = (TextView) findViewById(R.id.displaynumberspe);
		numeroSpe.setVisibility(View.GONE);
		numeroSpe.setText("" + elPokemon.getSpe());
		barraSpe = ((ProgressBar) findViewById(R.id.stats_spe_bar));
		barraSpe.setProgress((elPokemon.getSpe() * 100 / MainActivity.MAX_STAT));

		numeroTotal = (TextView) findViewById(R.id.displaynumbertotal);
		numeroTotal.setVisibility(View.GONE);
		numeroTotal.setText("" + elPokemon.getTotal());
		barraTotal = ((ProgressBar) findViewById(R.id.stats_total_bar));
		barraTotal
				.setProgress((elPokemon.getTotal() * 100 / MainActivity.MAX_TOTAL));
	}

//	es carreguen les imatges dels tipus, donat que android no permet fer switch amb Strings, ho he 
//	hagut de fer amb una cadena massiva de else if
	private void definirTipus2(String type2) {
//		el primer que comprovo és si és null, que vol dir que no té segon tipus, si no ho fes així
//		donaría NullPointerException en intentar comprovar els altres(si és null)
		if (type2 == null) {
			tipus2.setImageResource(R.drawable.notype);
		} else if (type2.equals("bug")) {
			tipus2.setImageResource(R.drawable.bugtype);
		} else if (type2.equals("dark")) {
			tipus2.setImageResource(R.drawable.darktype);
		} else if (type2.equals("dragon")) {
			tipus2.setImageResource(R.drawable.dragontype);
		} else if (type2.equals("electric")) {
			tipus2.setImageResource(R.drawable.electrictype);
		} else if (type2.equals("fairy")) {
			tipus2.setImageResource(R.drawable.fairytype);
		} else if (type2.equals("fighting")) {
			tipus2.setImageResource(R.drawable.fightingtype);
		} else if (type2.equals("fire")) {
			tipus2.setImageResource(R.drawable.firetype);
		} else if (type2.equals("flying")) {
			tipus2.setImageResource(R.drawable.flyingtype);
		} else if (type2.equals("ghost")) {
			tipus2.setImageResource(R.drawable.ghosttype);
		} else if (type2.equals("grass")) {
			tipus2.setImageResource(R.drawable.grasstype);
		} else if (type2.equals("ground")) {
			tipus2.setImageResource(R.drawable.groundtype);
		} else if (type2.equals("ice")) {
			tipus2.setImageResource(R.drawable.icetype);
		} else if (type2.equals("normal")) {
			tipus2.setImageResource(R.drawable.normaltype);
		} else if (type2.equals("poison")) {
			tipus2.setImageResource(R.drawable.poisontype);
		} else if (type2.equals("psychic")) {
			tipus2.setImageResource(R.drawable.psychictype);
		} else if (type2.equals("rock")) {
			tipus2.setImageResource(R.drawable.rocktype);
		} else if (type2.equals("steel")) {
			tipus2.setImageResource(R.drawable.steeltype);
		} else if (type2.equals("water")) {
			tipus2.setImageResource(R.drawable.watertype);
		} else {
		}

	}

	private void definirTipus1(String type1) {
//		aquí no comprovo si és null, donat que sempre es té tipus primari, i, per tant una entrada 
//		on fos null ja seria errónia de totes maneres
		if (type1.equals("bug")) {
			tipus1.setImageResource(R.drawable.bugtype);
		} else if (type1.equals("dark")) {
			tipus1.setImageResource(R.drawable.darktype);
		} else if (type1.equals("dragon")) {
			tipus1.setImageResource(R.drawable.dragontype);
		} else if (type1.equals("electric")) {
			tipus1.setImageResource(R.drawable.electrictype);
		} else if (type1.equals("fairy")) {
			tipus1.setImageResource(R.drawable.fairytype);
		} else if (type1.equals("fighting")) {
			tipus1.setImageResource(R.drawable.fightingtype);
		} else if (type1.equals("fire")) {
			tipus1.setImageResource(R.drawable.firetype);
		} else if (type1.equals("flying")) {
			tipus1.setImageResource(R.drawable.flyingtype);
		} else if (type1.equals("ghost")) {
			tipus1.setImageResource(R.drawable.ghosttype);
		} else if (type1.equals("grass")) {
			tipus1.setImageResource(R.drawable.grasstype);
		} else if (type1.equals("ground")) {
			tipus1.setImageResource(R.drawable.groundtype);
		} else if (type1.equals("ice")) {
			tipus1.setImageResource(R.drawable.icetype);
		} else if (type1.equals("normal")) {
			tipus1.setImageResource(R.drawable.normaltype);
		} else if (type1.equals("poison")) {
			tipus1.setImageResource(R.drawable.poisontype);
		} else if (type1.equals("psychic")) {
			tipus1.setImageResource(R.drawable.psychictype);
		} else if (type1.equals("rock")) {
			tipus1.setImageResource(R.drawable.rocktype);
		} else if (type1.equals("steel")) {
			tipus1.setImageResource(R.drawable.steeltype);
		} else if (type1.equals("water")) {
			tipus1.setImageResource(R.drawable.watertype);
		} else {
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mostrastats, menu);
		return true;
	}

	class TascaDescarrega extends AsyncTask<String, Void, Bitmap> {

		@Override
		protected Bitmap doInBackground(String... params) {
			return loadImageFromNetwork(params[0]);
		}

		protected void onPostExecute(Bitmap result) {
			laImatge.setImageBitmap(result);
		}

	}

	private Bitmap loadImageFromNetwork(String url) {

		Bitmap bitmap = null;
		try {
			bitmap = BitmapFactory.decodeStream((InputStream) new URL(url)
					.getContent());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;

	}

//	canviar el tipus de visualització, son dues operacions completament inverses
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.show_bars:
			numeroHP.setVisibility(View.GONE);
			barraHP.setVisibility(View.VISIBLE);
			numeroAtk.setVisibility(View.GONE);
			barraAtk.setVisibility(View.VISIBLE);
			numeroDef.setVisibility(View.GONE);
			barraDef.setVisibility(View.VISIBLE);
			numeroSpAtk.setVisibility(View.GONE);
			barraSpAtk.setVisibility(View.VISIBLE);
			numeroSpDef.setVisibility(View.GONE);
			barraSpDef.setVisibility(View.VISIBLE);
			numeroSpe.setVisibility(View.GONE);
			barraSpe.setVisibility(View.VISIBLE);
			numeroTotal.setVisibility(View.GONE);
			barraTotal.setVisibility(View.VISIBLE);
			break;

		case R.id.show_numbers:
			numeroHP.setVisibility(View.VISIBLE);
			barraHP.setVisibility(View.GONE);
			numeroAtk.setVisibility(View.VISIBLE);
			barraAtk.setVisibility(View.GONE);
			numeroDef.setVisibility(View.VISIBLE);
			barraDef.setVisibility(View.GONE);
			numeroSpAtk.setVisibility(View.VISIBLE);
			barraSpAtk.setVisibility(View.GONE);
			numeroSpDef.setVisibility(View.VISIBLE);
			barraSpDef.setVisibility(View.GONE);
			numeroSpe.setVisibility(View.VISIBLE);
			barraSpe.setVisibility(View.GONE);
			numeroTotal.setVisibility(View.VISIBLE);
			barraTotal.setVisibility(View.GONE);
			break;
		}		
//		potser hi ha alguna forma més elegant de fer-ho, agrupant préviament les vistes en "grups" 
//		o alguna cosa similar, i així podent definir les visibilitats en un parell de línies

		return super.onOptionsItemSelected(item);
	}

}
