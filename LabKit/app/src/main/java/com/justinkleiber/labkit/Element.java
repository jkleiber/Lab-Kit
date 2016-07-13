package com.justinkleiber.labkit;

public class Element {
	
	String name, symbol, type; //name, symbol, type of element i.e. (Transition Metals, Alkali Earth, Halogens etc.)
	int at_num;
	String mol_mass, v_elec, group, ion_energy, elecneg, atomrad; //atomic number, atomic mass, valence electrons, group number, first ionization energy, electronegativity, atomic radius
	String notate; //electron notation
	String phase; //solid, liquid, gas
	
	public Element(int num, String nam, String symb, String mmass, String velec, String g, String ion, String electro, String radi, String typ, String nota, String s)
	{
		this.at_num=num;
		this.name=nam;
		this.symbol=symb;
		this.mol_mass=mmass;
		this.v_elec=velec;
		this.group=g;
		this.ion_energy=ion;
		this.elecneg=electro;
		this.atomrad=radi;
		this.type=typ;
		this.notate=nota;
		this.phase=s;
	}
	
	//INTS
	//atomic number
	public int getNum()
	{
		return this.at_num;
	}
	public void setNum(int n)
	{
		this.at_num=n;
	}
	//atomic mass
	public String getMass()
	{
		return this.mol_mass;
	}
	public void setMass(String n)
	{
		this.mol_mass=n;
	}
	//valence
	public String getVal()
	{
		return this.v_elec;
	}
	public void setVal(String n)
	{
		this.v_elec=n;
	}
	//group
	public String getG()
	{
		return this.group;
	}
	public void setG(String n)
	{
		this.group=n;
	}
	//ionization
	public String getIon()
	{
		return this.ion_energy;
	}
	public void setIon(String n)
	{
		this.ion_energy=n;
	}
	//electronegativity
	public String getNeg()
	{
		return this.elecneg;
	}
	public void setNeg(String n)
	{
		this.elecneg=n;
	}
	//radius
	public String getRad()
	{
		return this.atomrad;
	}
	public void setRad(String n)
	{
		this.atomrad=n;
	}
	
	//STRINGS
	//name
	public String getName()
	{
		return this.name;
	}
	public void setName(String n)
	{
		this.name=n;
	}
	//symbol
	public String getIcon()
	{
		return this.symbol;
	}
	public void setIcon(String n)
	{
		this.symbol=n;
	}
	//type
	public String getType()
	{
		return this.type;
	}
	public void setType(String n)
	{
		this.type=n;
	}
	//notation
	public String getNote()
	{
		return this.notate;
	}
	public void setNote(String n)
	{
		this.notate=n;
	}
	//phase
	public String getPhase()
	{
		return this.phase;
	}
	public void setPhase(String n)
	{
		this.phase=n;
	}

}
