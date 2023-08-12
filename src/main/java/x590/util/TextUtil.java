package x590.util;

public final class TextUtil {

	private TextUtil() {}

	/**
	 * Форматирует строку в зависимости от числа. Если число оканчивается на 1,
	 * то добавляет {@code singularEnding} после слова, иначе добавляет {@code pluralEnding}.
	 * @return Строку, содержащую число и слово в единственном или множественном числе, отделённое пробелом
	 * @param num число для форматирования
	 * @param word слово в единственном числе без пробелов в начале и в конце
	 * @param singularEnding окончание для слова в единственном числе
	 * @param pluralEnding окончание для слова во множественном числе
	 */
	public static String formatSingularOrPlural(int num, String word, String singularEnding, String pluralEnding) {
		String ending = Math.abs(num) % 10 == 1 ? singularEnding : pluralEnding;

		return new StringBuilder(IntegerUtil.getDecimalLength(num) + 1 + word.length() + ending.length())
				.append(num).append(' ').append(word).append(ending).toString();
	}

	/**
	 * Форматирует строку в зависимости от числа. Если число оканчивается не на 1,
	 * то добавляет {@code pluralEnding} после слова, иначе ничего не добавляет.
	 * @see #formatSingularOrPlural(int, String, String, String)
	 */
	public static String formatSingularOrPlural(int num, String word, String pluralEnding) {
		return formatSingularOrPlural(num, word, "", pluralEnding);
	}

	/**
	 * Форматирует строку в зависимости от числа. Если число оканчивается не на 1,
	 * то добавляет "s" после слова, иначе ничего не добавляет.
	 * @see #formatSingularOrPlural(int, String, String, String)
	 */
	public static String formatSingularOrPlural(int num, String word) {
		return formatSingularOrPlural(num, word, "", "s");
	}
}
