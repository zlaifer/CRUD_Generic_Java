package util;

public class StringUtil {

	private static StringUtil instance;

	private StringUtil() {

	}

	public synchronized static StringUtil getInstance() {
		if(instance == null) {
			instance = new StringUtil();
		}
		return instance;
	}

	public String converterColumnNameToFieldName(String ColumnName) {
		String newName = "";
		char[] letters = ColumnName.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			char c = letters[i];
			if(c == '_') {
				char mayus = Character.toUpperCase(letters[i+1]);
				newName += mayus;
				i++;
			}else {
				newName += c;
			}

		}
		return newName;
	}
}
