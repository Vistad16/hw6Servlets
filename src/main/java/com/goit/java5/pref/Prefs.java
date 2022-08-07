package com.goit.java5.pref;


public class Prefs {
	public static final String DB_JDBC_CONNECTION_URL = "jdbc:mysql://localhost/mydb";
	public static final String DB_USER = "root";
	public static final String DB_PASS = "pass";

//	public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
//
//	private Map<String, Object> prefs = new HashMap<>();
//
//	public Prefs() {
//		this(DEFAULT_PREFS_FILENAME);
//	}
//
//	public Prefs(String filename) {
//		try {
//			String json = String.join(
//					"\n",
//					Files.readAllLines(Paths.get(filename))
//			);
//
//			TypeToken<?> typeToken = TypeToken.getParameterized(
//					Map.class,
//					String.class,
//					Object.class
//			);
//			prefs = new Gson().fromJson(json, typeToken.getType());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public String getString(String key) {
//		return getPref(key).toString();
//	}
//
//	public Object getPref(String key) {
//		return prefs.get(key);
//	}
}
