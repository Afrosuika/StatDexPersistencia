package net.infobosccoma.dam.epuigdemont.statdex.dades;

import java.io.Serializable;
import java.util.ArrayList;

import net.infobosccoma.dam.epuigdemont.statdex.Pokemon;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PokemonSQLiteHelper extends SQLiteOpenHelper implements Serializable{
	
	private final String SQL_CREATE_POKEMON = "CREATE TABLE Pokemons(" +
			"	numero INTEGER PRIMARY KEY, " +
			"	nom TEXT, " +
			"	hp INTEGER, " +
			"	atac INTEGER, " +
			"	defensa INTEGER, " +
			"	atac_especial INTEGER, " +
			"	defensa_especial INTEGER, " +
			"	velocitat INTEGER, " +
			"	tipus1 TEXT, " +
			"	tipus2 TEXT)";

	public PokemonSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_POKEMON);
		emplenarBaseDades(db);		
	}

	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {		
		//emplenarBaseDades(db);
	}
	
	private void emplenarBaseDades(SQLiteDatabase db) {
		
		
		ArrayList<Pokemon> llistaa = new ArrayList<Pokemon>();
		llistaa.add(new Pokemon(1,"Bulbasaur",45,49,49,65,65,45,"grass", "poison"));
		llistaa.add(new Pokemon(2,"Ivysaur",60,62,63,80,80,60,"grass", "poison"));
		llistaa.add(new Pokemon(3,"Venusaur",80,82,83,100,100,80,"grass", "poison"));
		llistaa.add(new Pokemon(4,"Charmander",39,52,43,60,50,65,"fire",null));
		llistaa.add(new Pokemon(5,"Charmeleon",58,64,58,80,65,80,"fire",null));
		llistaa.add(new Pokemon(6,"Charizard",78,	84,78,109,85,100,"fire","flying"));
		llistaa.add(new Pokemon(7,"Squirtle",44,48,65,50,64,43,"water",null));
		llistaa.add(new Pokemon(8,"Wartortle",59,63,80,65,80,58,"water",null));
		llistaa.add(new Pokemon(9,"Blastoise",79,83,100,85,105,78,"water",null));
		llistaa.add(new Pokemon(10,"Caterpie",45,30,35,20,20,45,"bug",null));
		llistaa.add(new Pokemon(11,"Metapod",50,20,55,25,25,30,"bug",null));
		llistaa.add(new Pokemon(12,"Butterfree",60,45,50,90,80,70,"bug","flying"));
		llistaa.add(new Pokemon(13,"Weedle",40,35,30,20,20,50,"bug","poison"));
		llistaa.add(new Pokemon(14,"Kakuna",45,25,50,25,25,35,"bug","poison"));
		llistaa.add(new Pokemon(15,"Beedrill",65,90,40,45,80,75,"bug","poison"));
		llistaa.add(new Pokemon(16,"Pidgey",40,45,40,35,35,56,"normal","flying"));
		llistaa.add(new Pokemon(17,"Pidgeotto",63,60,55,50,50,71,"normal","flying"));
		llistaa.add(new Pokemon(18,"Pidgeot",83,80,75,70,70,101,"normal","flying"));
		llistaa.add(new Pokemon(19,"Rattata",30,56,35,25,35,72,"normal",null));
		llistaa.add(new Pokemon(20,"Raticate",55,81,60,50,70,97,"normal",null));
		llistaa.add(new Pokemon(21,"Spearow",40,60,30,31,31,70,"normal","flying"));
		llistaa.add(new Pokemon(22,"Fearow",65,90,65,61,61,100,"normal","flying"));
		llistaa.add(new Pokemon(23,"Ekans",35,60,44,40,54,55,"poison",null));
		llistaa.add(new Pokemon(24,"Arbok",60,85,69,65,79,80,"poison",null));
		llistaa.add(new Pokemon(25,"Pikachu",35,55,40,50,50,90,"electric",null));
		llistaa.add(new Pokemon(26,"Raichu",60,90,55,90,80,110,"electric",null));
		llistaa.add(new Pokemon(27,"Sandshrew",50,75,85,20,30,40,"ground",null));
		llistaa.add(new Pokemon(28,"Sandslash",75,100,110,45,55,65,"ground",null));
		llistaa.add(new Pokemon(29,"Nidoran♀",55,47,52,40,40,41,"poison",null));
		llistaa.add(new Pokemon(30,"Nidorina",70,62,67,55,55,56,"poison",null));
		llistaa.add(new Pokemon(31,"Nidoqueen",90,92,87,75,85,76,"poison","ground"));
		llistaa.add(new Pokemon(32,"Nidoran♂",46,57,40,40,40,50,"poison",null));
		llistaa.add(new Pokemon(33,"Nidorino",61,72,57,55,55,65,"poison",null));
		llistaa.add(new Pokemon(34,"Nidoking",81,102,77,85,75,85,"poison","ground"));
		llistaa.add(new Pokemon(35,"Clefairy",70,45,48,60,65,35,"fairy",null));
		llistaa.add(new Pokemon(36,"Clefable",95,70,73,95,90,60,"fairy",null));
		llistaa.add(new Pokemon(37,"Vulpix",38,41,40,50,65,65,"fire",null));
		llistaa.add(new Pokemon(38,"Ninetales",73,76,75,81,100,100,"fire",null));
		llistaa.add(new Pokemon(39,"Jigglypuff",115,45,20,45,25,20,"normal","fairy"));
		llistaa.add(new Pokemon(40,"Wigglytuff",140,70,45,85,50,45,"normal","fairy"));
		llistaa.add(new Pokemon(41,"Zubat",40,45,35,30,40,55,"poison","flying"));
		llistaa.add(new Pokemon(42,"Golbat",75,80,70,65,75,90,"poison","flying"));
		llistaa.add(new Pokemon(43,"Oddish",45,50,55,75,65,30,"grass","poison"));
		llistaa.add(new Pokemon(44,"Gloom",60,65,70,85,75,40,"grass","poison"));
		llistaa.add(new Pokemon(45,"Vileplume",75,80,85,110,90,50,"grass","poison"));
		llistaa.add(new Pokemon(46,"Paras",35,70,55,45,55,25,"bug","grass"));
		llistaa.add(new Pokemon(47,"Parasect",60,95,80,60,80,30,"bug","grass"));
		llistaa.add(new Pokemon(48,"Venonat",60,55,50,40,55,45,"bug","poison"));
		llistaa.add(new Pokemon(49,"Venomoth",70,65,60,90,75,90,"bug","poison"));
		llistaa.add(new Pokemon(50,"Diglett",10,55,25,35,45,95,"ground",null));
		llistaa.add(new Pokemon(51,"Dugtrio",35,80,50,50,70,120,"ground",null));
		llistaa.add(new Pokemon(52,"Meowth",40,45,35,40,40,90,"normal",null));
		llistaa.add(new Pokemon(53,"Persian",65,70,60,65,65,115,"normal",null));
		llistaa.add(new Pokemon(54,"Psyduck",50,52,48,65,50,55,"water",null));
		llistaa.add(new Pokemon(55,"Golduck",80,82,78,95,80,85,"water",null));
		llistaa.add(new Pokemon(56,"Mankey",40,80,35,35,45,70,"fighting",null));
		llistaa.add(new Pokemon(57,"Primeape",65,105,60,60,70,95,"fighting",null));
		llistaa.add(new Pokemon(58,"Growlithe",55,70,45,70,50,60,"fire",null));
		llistaa.add(new Pokemon(59,"Arcanine",90,110,80,100,80,95,"fire",null));
		llistaa.add(new Pokemon(60,"Poliwag",40,50,40,40,40,90,"water",null));
		llistaa.add(new Pokemon(61,"Poliwhirl",65,65,65,50,50,90,"water",null));
		llistaa.add(new Pokemon(62,"Poliwrath",90,95,95,70,90,70,"water","fighting"));
		llistaa.add(new Pokemon(63,"Abra",25,20,15,105,55,90,"psychic",null));
		llistaa.add(new Pokemon(64,"Kadabra",40,35,30,120,70,105,"psychic",null));
		llistaa.add(new Pokemon(65,"Alakazam",55,50,45,135,95,120,"psychic",null));
		llistaa.add(new Pokemon(66,"Machop",70,80,50,35,35,35,"fighting",null));
		llistaa.add(new Pokemon(67,"Machoke",80,100,70,50,60,45,"fighting",null));
		llistaa.add(new Pokemon(68,"Machamp",90,130,80,65,85,55,"fighting",null));
		llistaa.add(new Pokemon(69,"Bellsprout",50,75,35,70,30,40,"grass","poison"));
		llistaa.add(new Pokemon(70,"Weepinbell",65,90,50,85,45,55,"grass","poison"));
		llistaa.add(new Pokemon(71,"Victreebel",80,105,65,100,70,70,"grass","poison"));
		llistaa.add(new Pokemon(72,"Tentacool",40,40,35,50,100,70,"water","poison"));
		llistaa.add(new Pokemon(73,"Tentacruel",80,70,65,80,120,100,"water","poison"));
		llistaa.add(new Pokemon(74,"Geodude",40,80,100,30,30,20,"rock","ground"));
		llistaa.add(new Pokemon(75,"Graveler",55,95,115,45,45,35,"rock","ground"));
		llistaa.add(new Pokemon(76,"Golem",80,120,130,55,65,45,"rock","ground"));
		llistaa.add(new Pokemon(77,"Ponyta",50,85,55,65,65,90,"fire",null));
		llistaa.add(new Pokemon(78,"Rapidash",65,100,70,80,80,105,"fire",null));
		llistaa.add(new Pokemon(79,"Slowpoke",90,65,65,40,40,15,"water","psychic"));
		llistaa.add(new Pokemon(80,"Slowbro",95,75,110,100,80,30,"water","psychic"));
		llistaa.add(new Pokemon(81,"Magnemite",25,35,70,95,55,45,"electric","steel"));
		llistaa.add(new Pokemon(82,"Magneton",50,60,95,120,70,70,"electric","steel"));
		llistaa.add(new Pokemon(83,"Farfetch'd",52,65,55,58,62,60,"normal","flying"));
		llistaa.add(new Pokemon(84,"Doduo",35,85,45,35,35,75,"normal","flying"));
		llistaa.add(new Pokemon(85,"Dodrio",60,110,70,60,60,100,"normal","flying"));
		llistaa.add(new Pokemon(86,"Seel",65,45,55,45,70,45,"water",null));
		llistaa.add(new Pokemon(87,"Dewgong",90,70,80,70,95,70,"water","ice"));
		llistaa.add(new Pokemon(88,"Grimer",80,80,50,40,50,25,"poison",null));
		llistaa.add(new Pokemon(89,"Muk",105,105,75,65,100,50,"poison",null));
		llistaa.add(new Pokemon(90,"Shellder",30,65,100,45,25,40,"water",null));
		llistaa.add(new Pokemon(91,"Cloyster",50,95,180,85,45,70,"water","ice"));
		llistaa.add(new Pokemon(92,"Gastly",30,35,30,100,35,80,"ghost","poison"));
		llistaa.add(new Pokemon(93,"Haunter",45,50,45,115,55,95,"ghost","poison"));
		llistaa.add(new Pokemon(94,"Gengar",60,65,60,130,75,110,"ghost","poison"));
		llistaa.add(new Pokemon(95,"Onix",35,45,160,30,45,70,"rock","ground"));
		llistaa.add(new Pokemon(96,"Drowzee",60,48,45,43,90,42,"psychic",null));
		llistaa.add(new Pokemon(97,"Hypno",85,73,70,73,115,67,"psychic",null));
		llistaa.add(new Pokemon(98,"Krabby",30,105,90,25,25,50,"water",null));
		llistaa.add(new Pokemon(99,"Kingler",30,105,90,25,25,50,"water",null));
		llistaa.add(new Pokemon(100,"Voltorb",40,30,50,55,55,100,"electric",null));
		llistaa.add(new Pokemon(101,"Electrode",60,50,70,80,80,140,"electric",null));
		llistaa.add(new Pokemon(102,"Exeggcute",60,40,80,60,45,40,"grass","psychic"));
		llistaa.add(new Pokemon(103,"Exeggutor",95,95,85,125,65,55,"grass","psychic"));
		llistaa.add(new Pokemon(104,"Cubone",50,50,95,40,50,35,"ground",null));
		llistaa.add(new Pokemon(105,"Marowak",60,80,110,50,80,45,"ground",null));
		llistaa.add(new Pokemon(106,"Hitmonlee",50,120,53,35,110,87,"fighting",null));
		llistaa.add(new Pokemon(107,"Hitmonchan",50,105,79,35,110,76,"fighting",null));
		llistaa.add(new Pokemon(108,"Lickitung",90,55,75,60,75,30,"normal",null));
		llistaa.add(new Pokemon(109,"Koffing",40,65,95,60,45,35,"poison",null));
		llistaa.add(new Pokemon(110,"Weezing",65,90,120,85,70,60,"poison",null));
		llistaa.add(new Pokemon(111,"Rhyhorn",80,85,95,30,30,25,"ground","rock"));
		llistaa.add(new Pokemon(112,"Rhydon",105,130,120,45,45,40,"ground","rock"));
		llistaa.add(new Pokemon(113,"Chansey",250,5,5,35,105,50,"normal",null));
		llistaa.add(new Pokemon(114,"Tangela",65,55,115,100,40,60,"grass",null));
		llistaa.add(new Pokemon(115,"Kangaskhan",105,95,80,40,80,90,"normal",null));
		llistaa.add(new Pokemon(116,"Horsea",30,40,70,70,25,60,"water",null));
		llistaa.add(new Pokemon(117,"Seadra",55,65,95,95,45,85,"water",null));
		llistaa.add(new Pokemon(118,"Goldeen",45,67,60,35,50,63,"water",null));
		llistaa.add(new Pokemon(119,"Seaking",80,92,65,65,80,68,"water",null));
		llistaa.add(new Pokemon(120,"Staryu",30,45,55,70,55,85,"water",null));
		llistaa.add(new Pokemon(121,"Starmie",60,75,85,100,85,115,"water","psychic"));
		llistaa.add(new Pokemon(122,"Mr.Mime",40,45,65,100,120,90,"psychic",null));
		llistaa.add(new Pokemon(123,"Scyther",70,110,80,55,80,105,"bug","fliying"));
		llistaa.add(new Pokemon(124,"Jynx",65,50,35,115,95,95,"ice","psychic"));
		llistaa.add(new Pokemon(125,"Electabuzz",65,83,57,95,85,105,"electric",null));
		llistaa.add(new Pokemon(126,"Magmar",65,95,57,100,85,93,"fire",null));
		llistaa.add(new Pokemon(127,"Pinsir",65,125,100,55,70,85,"bug",null));
		llistaa.add(new Pokemon(128,"Tauros",75,100,95,40,70,110,"normal",null));
		llistaa.add(new Pokemon(129,"Magikarp",20,10,55,15,20,80,"water",null));
		llistaa.add(new Pokemon(130,"Gyarados",95,125,79,60,100,81,"water","flying"));
		llistaa.add(new Pokemon(131,"Lapras",130,85,80,85,95,60,"water","ice"));
		llistaa.add(new Pokemon(132,"Ditto",48,48,48,48,48,48,"normal",null));
		llistaa.add(new Pokemon(133,"Eevee",55,55,50,45,65,55,"normal",null));
		llistaa.add(new Pokemon(134,"Vaporeon",130,65,60,110,95,65,"water",null));
		llistaa.add(new Pokemon(135,"Jolteon",130,65,60,110,95,65,"electric",null));
		llistaa.add(new Pokemon(136,"Flareon",65,130,60,95,110,65,"fire",null));
		llistaa.add(new Pokemon(137,"Porygon",65,60,70,85,75,40,"normal",null));
		llistaa.add(new Pokemon(138,"Omanyte",35,40,100,90,55,35,"rock","water"));
		llistaa.add(new Pokemon(139,"Omastar",70,60,125,115,70,55,"rock","water"));
		llistaa.add(new Pokemon(140,"Kabuto",30,80,90,55,45,55,"rock","water"));
		llistaa.add(new Pokemon(141,"Kabutops",60,115,105,65,70,80,"rock","water"));
		llistaa.add(new Pokemon(142,"Aerodactyl",80,105,65,60,75,130,"rock","flying"));
		llistaa.add(new Pokemon(143,"Snorlax",160,110,65,65,110,30,"normal",null));
		llistaa.add(new Pokemon(144,"Articuno",90,85,100,95,125,85,"ice","flying"));
		llistaa.add(new Pokemon(145,"Zapdos",90,90,85,125,90,100,"electric","flying"));
		llistaa.add(new Pokemon(146,"Moltres",90,100,90,125,85,90,"fire","flying"));
		llistaa.add(new Pokemon(147,"Dratini",41,64,45,50,50,50,"dragon",null));
		llistaa.add(new Pokemon(148,"Dragonair",61,84,65,70,70,70,"dragon",null));
		llistaa.add(new Pokemon(149,"Dragonite",91,134,95,100,100,80,"dragon","flying"));
		llistaa.add(new Pokemon(150,"Mewtwo",106,110,90,154,90,130,"psychic",null));
		llistaa.add(new Pokemon(151,"Mew",100,100,100,100,100,100,"psychic",null));
		
		for(Pokemon pokemon : llistaa){
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
				long index = db.insertOrThrow("Pokemons", null, dades);
				// volem veure en el log el que passa
				Log.i("Pokemons", dades.toString() + " afegit amb codi " + index);
			} catch (Exception e) {
				// volem reflectir en ellog que hi ha hagut un error
				Log.e("Pokemons", e.getMessage());
			}
		}
//		db.close();
	}




}
