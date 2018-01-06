package sokker.utils;

public class StringFormater {
	
	public static String parseMoney(int amount) {	
		String svalue = String.valueOf(amount);
		StringBuilder sb = new StringBuilder();
		sb.append("³z ");
		int index = 0;
		while (svalue.length() > 0) {
			if (index > 2) {
				sb.append(".");
				index = 0;
			}
			index++;
			sb.append(svalue.charAt(svalue.length()-1));
			svalue = svalue.substring(0, svalue.length()-1);
		}
		return sb.reverse().toString();
	}
	
	public static String parseWeight(double d) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(d));
		sb.append(" kg");
		return sb.toString();
	}
	
	public static String parseCmDistance(int amount) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(amount));
		sb.append(" cm");
		return sb.toString();
	}
	
	public static String parseSkill(int skill) {
		switch (skill) {
		case 0: return "0 - Tragiczny";
		case 1: return "1 - Beznadziejny";
		case 2: return "2 - Niedostateczny";
		case 3: return "3 - Mierny";
		case 4: return "4 - S³aby";
		case 5: return "5 - Przeciêtny";
		case 6: return "6 - Dostateczny";
		case 7: return "7 - Dobry";
		case 8: return "8 - Solidny";
		case 9: return "9 - Bardzo dobry";
		case 10: return "10 - Celuj¹cy";
		case 11: return "11 - Œwietny";
		case 12: return "12 - Znakomity";
		case 13: return "13 - Niesamowity";
		case 14: return "14 - Olœniewaj¹cy";
		case 15: return "15 - Magiczny";
		case 16: return "16 - Nieziemski";
		case 17: return "17 - Boski";
		case 18: return "18 - Nadboski";	
		default: return "Skill nie istnieje";
		}		
	}
}
