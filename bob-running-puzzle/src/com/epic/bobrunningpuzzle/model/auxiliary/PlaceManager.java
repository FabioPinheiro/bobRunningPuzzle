package com.epic.bobrunningpuzzle.model.auxiliary;

import com.badlogic.gdx.utils.ArrayMap;
import com.epic.bobrunningpuzzle.model.Gate;
import com.epic.bobrunningpuzzle.model.auxiliary.Place;

public class PlaceManager {
	///** Class with private constructor is static.*/
	//private PlaceManager() {}
	private static ArrayMap<String, Place> map = new ArrayMap<String, Place>();
	public static ArrayMap<String, Place> getMap() {return map;}
	public static void setMap(ArrayMap<String, Place> map) {PlaceManager.map = map;}

	public static int sizeOfMap(){return PlaceManager.size1();}
	private static int size1(){return PlaceManager.map.size;}
	private static int size2(String key){return PlaceManager.map.get(key).size();}
	/*public Points() {
		Gdx.app.log("POINT", "TTTTTTTTTEEEEEEEESSSSSSSSSSSSSTTTTTTTTTEEEEEE");
		Gdx.app.log("POINT", "map.size" + map.size);
		for (int i = 0 ; i< map.size; i++) {
			Gdx.app.log("POINT", "map.getKeyAt(i): " + map.getKeyAt(i));
			Gdx.app.log("POINT", "map.getKeyAt(i): " + map.getValueAt(i).getLst().size());
		}
	}*/
	public static Place getPlace(String key){return PlaceManager.map.get(key);}
	
	public static String add(Place point) {
		String aux = PlaceManager.GenericIdentifier.newIdentifier();
		PlaceManager.map.put(aux, point);
		return aux;
	}
	
	public static PlaceIdentifier register(String key, Gate gate) {
		return PlaceManager.getPlace(key).register(gate);
	}
	
	public static class GenericIdentifier {
		private static String NAME = "ID";//"GenericIdentifier";
		public static String getNAME() {return NAME;}
		public static void setNAME(String nAME) {NAME = nAME;}
		public static String newIdentifier() {return "[" + NAME + ":" + map.size + "]";}
		public static String newSubIdentifier(String key) {return "[" + NAME + "_sub:" + PlaceManager.size2(key) + "]";}
		public static String newSubIdentifier(Place point) {return "[" + NAME + "_sub:" + point.size() + "]";}
	}
}
