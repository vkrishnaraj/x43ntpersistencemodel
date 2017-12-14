package aero.nettracer.commons.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class GenericStringUtils {

	private static final Logger logger = Logger
			.getLogger(GenericStringUtils.class);

	// DO NOT CHANGE SALT VALUE
	private static final String salt = "qze5791K";

	public static String removePronouns(String s) {
		if (s == null)
			return "";
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(" a ");
		ar.add(" an ");
		ar.add(" the ");
		ar.add(" that ");
		ar.add(" and ");
		ar.add(" none ");
		ArrayList<String> headar = new ArrayList<String>();
		headar.add("a ");
		headar.add("an ");
		headar.add("the ");
		headar.add("that ");
		headar.add("and ");
		headar.add("none ");
		ArrayList<String> endar = new ArrayList<String>();
		endar.add(" a");
		endar.add(" an");
		endar.add(" the");
		endar.add(" that");
		endar.add(" and");
		endar.add(" none");
		String temps = null;
		int index = 0;
		try {
			for (int i = 0; i < ar.size(); i++) {
				temps = (String) ar.get(i);
				while ((index = s.indexOf(temps)) >= 0) {
					s = s.substring(0, index) + " "
							+ s.substring(index + temps.length());
				}
			}
			// head
			for (int i = 0; i < headar.size(); i++) {
				temps = (String) headar.get(i);
				if ((index = s.indexOf(temps)) == 0)
					s = s.substring(index + temps.length());
			}
			// end
			for (int i = 0; i < endar.size(); i++) {
				temps = (String) endar.get(i);
				if ((index = s.indexOf(temps)) == (s.length() - temps.length())
						&& index >= 0) {
					s = s.substring(0, s.length() - temps.length());
				}
			}
		} catch (Exception e) {
			System.out.println("s1: " + s + e);
		}
		return s;
	}

	public static String removeNonNumeric(String s) {
		if (s == null)
			return s;
		StringBuffer sb = new StringBuffer(100);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static boolean isAlphanumeric(String s) {
		final char[] chars = s.toCharArray();
		for (int x = 0; x < chars.length; x++) {
			final char c = chars[x];
			if ((c >= 'a') && (c <= 'z'))
				continue; // lowercase
			if ((c >= 'A') && (c <= 'Z'))
				continue; // uppercase
			if ((c >= '0') && (c <= '9'))
				continue; // numeric
			return false;
		}
		return true;
	}

	public static <T extends Appendable> T join(
			Iterable<? extends CharSequence> src, CharSequence pattern, T dst)
			throws IOException {
		Iterator<? extends CharSequence> it = src.iterator();
		if (it.hasNext()) {
			dst.append(it.next());
		}
		while (it.hasNext()) {
			dst.append(pattern).append(it.next());
		}
		return dst;
	}

	public static String join(Iterable<? extends CharSequence> src,
			CharSequence pattern) {
		try {
			return join(src, pattern, new StringBuilder()).toString();
		} catch (IOException excpt) {
			throw new Error("StringBuilder should not throw IOExceptions!");
		}
	}

	public static String join(String pattern, String... strings) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strings.length; ++i) {
			if (strings[i] != null) {
				sb.append(strings[i].trim());
				if (i < strings.length - 1) {
					sb.append(pattern);
				}
			}
		}
		return sb.toString();
	}

	public static <T extends Appendable> T joinIntegers(
			Iterable<? extends Number> src, CharSequence pattern, T dst)
			throws IOException {
		Iterator<? extends Number> it = src.iterator();
		if (it.hasNext()) {
			dst.append(it.next().toString());
		}
		while (it.hasNext()) {
			dst.append(pattern).append(it.next().toString());
		}
		return dst;
	}

	public static String joinIntegers(Iterable<? extends Number> src,
			CharSequence pattern) {
		try {
			return joinIntegers(src, pattern, new StringBuilder()).toString();
		} catch (IOException excpt) {
			throw new Error("StringBuilder should not throw IOExceptions!");
		}
	}

	public static ArrayList<String> splitOnWordBreak(String srcWord,
			int maxLength) {
		ArrayList<String> list = new ArrayList<String>();
		maxLength += 1;
		int divide = 0;
		int endIndex = 0;
		for (int i = 0; i < srcWord.length();) {
			endIndex = java.lang.Math.min(i + maxLength, srcWord.length());
			divide = getIndexToDivide(srcWord.trim().substring(i, endIndex),
					" ", maxLength - 1);
			list.add(srcWord.trim().substring(i, i + divide).trim());
			i += divide;
		}

		return list;
	}

	public static void appendIfNotNull(StringBuilder sb, String x) {
		if (x != null && x.trim().length() > 0) {
			sb.append(x + " ");
		}
	}

	public static int[] convertStringArray2IntArray(String[] sArray)
			throws Exception {
		int result[] = null;
		if (sArray != null) {
			result = new int[sArray.length];
			for (int i = 0; i < sArray.length; i++) {
				result[i] = Integer.parseInt(sArray[i]);
			}
		}

		return result;
	}

	public static List<Integer> convertStringArrayList2IntegerArrayList(
			List<String> sArrayList) throws Exception {
		List<Integer> result = null;
		if (sArrayList != null) {
			result = new ArrayList<Integer>(sArrayList.size());
			for (String myStr : sArrayList) {
				result.add(Integer.parseInt(myStr));
			}
		}

		return result;
	}

	public boolean isNotNullAndEmpty(String str) {

		if ((null != str) && (str.length() == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static double compareStrings(String str1, String str2) {
		if (StringUtils.isBlank(str1) || StringUtils.isBlank(str2)) {
			return 0;
		}
		double result = doCompare(str1, str2);
		if (result <= 0) {
			return 0;
		} else {
			return result;
		}
	}

	private static double doCompare(String s1, String s2) {
		s1 = s1.toUpperCase().trim();
		s1 = s1.replaceAll("\\s+","");
		s2 = s2.toUpperCase().trim();
		s2 = s2.replaceAll("\\s+","");
		String longer = s1, shorter = s2;
		if (s1.length() < s2.length()) { // longer should always have greater length, if equal then proceed
		    longer = s2; shorter = s1;
		}
		int longerLength = longer.length();
		return ((longerLength - StringUtils.getLevenshteinDistance(longer, shorter)) / (double) longerLength) * 100.0;
	}

	public static ArrayList<String> divideUpBigString(String srcWord,
			int maxLength, String delimiter) {
		ArrayList<String> list = new ArrayList<String>();

		maxLength += 1;

		int divide = 0;
		int endIndex = 0;
		for (int i = 0; i < srcWord.length();) {
			endIndex = java.lang.Math.min(i + maxLength, srcWord.length());

			divide = getIndexToDivide(srcWord.trim().substring(i, endIndex),
					delimiter, maxLength - 1, true, 88);
			list.add(srcWord.trim().substring(i, i + divide).trim());
			i += divide;
		}

		return list;
	}

	public static String convertToRegexSafe(String str) {
		if (str == null) {
			return null;
		}

		String[] regexChars = { ".", "{", "}", "[", "]", "&", "|", "^", "?",
				"*", "+", "(", ")" };
		str = Matcher.quoteReplacement(str);
		for (int i = 0; i < regexChars.length; ++i) {
			if (str.contains(regexChars[i])) {
				str = str.replace(regexChars[i], ("\\" + regexChars[i]));
			}
		}
		return str;
	}

	private static String getHex(byte[] raw) {
		String HEXES = "0123456789ABCDEF";
		if (raw == null) {
			return null;
		}
		final StringBuilder hex = new StringBuilder(2 * raw.length);
		for (final byte b : raw) {
			hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(
					HEXES.charAt((b & 0x0F)));
		}
		return hex.toString();
	}

	public static String sha1(String pass, boolean useSalt) {
		try {
			if (useSalt) {
				pass = salt + pass;
			}
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] h = md.digest(pass.getBytes());
			return getHex(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String sha1(String pass) {
		return sha1(pass, false);
	}

	public static String sha1_256(String pass, boolean useSalt) {
		if (useSalt) {
			pass = salt + pass;
		}
		pass = sha1(pass);
		return sha256(pass);
	}

	public static String sha1_256(String pass) {
		return sha1_256(pass, false);
	}

	public static String sha256(String pass, boolean useSalt) {
		try {
			if (useSalt) {
				pass = salt + pass;
			}
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] h = md.digest(pass.getBytes());
			return getHex(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String sha256(String pass) {
		return sha256(pass, false);
	}

	public static String keyGen() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		Random ran = new Random();
		int i = ran.nextInt(Integer.MAX_VALUE);
		return df.format(d)
				+ String.format("%8s", Integer.toHexString(i))
						.replace(' ', '0').toUpperCase();
	}

	public static String hmacHash(String key, String pass) {
		try {
			return sha1(key + sha1(pass));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static long getLong(String longString) {
		try {
			return Long.parseLong(longString);

		} catch (NumberFormatException nfe) {
			logger.error(nfe.getMessage());
			return -1;
		}
	}

	public static String sanitizeForSingleQuoteJavascript(String toSanitize) {
		if (toSanitize != null) {
			return toSanitize.replace("'", "\\\\'").replace("/", "\\\\/");
		}
		return "";
	}

	public static String sanitizeForDoubleQuoteJavascript(String toSanitize) {
		if (toSanitize != null) {
			return toSanitize.replace("\"", "\\\\\"").replace("/", "\\\\/");
		}
		return "";
	}

	public static String replaceNewLines(String s) {
		if (s != null) {
			return s.replaceAll("\n", "<br/>");
		}
		return "";
	}

	public static String replaceNewLinesReturns(String s) {
		if (s != null) {
			return s.replaceAll("\r\n", "<br/>");
		}
		return "";
	}

	private static int getIndexToDivide(String srcStr, String delimiter,
			int maxLength) {
		return getIndexToDivide(srcStr, delimiter, maxLength, false, 0);
	}

	private static int getIndexToDivide(String srcStr, String delimiter,
			int maxLength, boolean useSpace, int minimumPercentage) {
		if (srcStr.length() < maxLength) {
			return srcStr.length();
		}
		int myMinimum = maxLength * minimumPercentage / 100;

		int index = srcStr.lastIndexOf(delimiter);
		if (index > myMinimum) {
			return index;
		} else {
			if (useSpace) {
				index = srcStr.lastIndexOf(" ");
				if (index > myMinimum) {
					return index;
				}

			}
			return srcStr.length() - 1;
		}
	}
	
	public static String replaceNull(String string) {
		return string != null ? string.trim() : "";
	}

	public static String convertToString(Object object) {
		return object != null ? object.toString().trim() : "";
	}
	
	public static boolean isDifferentIgnoreEmpty(String a, String b) {
		if(a != null && !a.isEmpty() && b != null && !b.isEmpty() && !a.equalsIgnoreCase(b)){
			return true;
		}
		return false;
	}
	
	public static boolean anyBlank(String... strings) {
		for (String string: strings) {
			if (StringUtils.isBlank(string)) {
				return true;
			}
		}
		return false;
	}


}
