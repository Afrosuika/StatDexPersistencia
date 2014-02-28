package net.infobosccoma.dam.epuigdemont.statdex;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pokemon implements Serializable{
	private int num, hp,atk,def,spAtk,spDef,spe;
	private String name, type1, type2;
	public int getNum() {
		return num;
	}
	public Pokemon(){
		
	}
	public Pokemon(int num, String name, int hp, int atk, int def, int spAtk,
			int spDef, int spe, String type1, String type2) {
		super();
		this.num = num;
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.spe = spe;
		this.type1=type1;
		this.type2=type2;
	}	

	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getSpAtk() {
		return spAtk;
	}
	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}
	public int getSpDef() {
		return spDef;
	}
	public void setSpDef(int spDef) {
		this.spDef = spDef;
	}
	public int getSpe() {
		return spe;
	}
	public void setSpe(int spe) {
		this.spe = spe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTotal(){
		return (this.hp+this.atk+this.def+this.spAtk+this.spDef+this.spe);
	}

}
