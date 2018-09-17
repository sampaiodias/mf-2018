import java.time.*;
import java.util.Locale;
import java.time.format.TextStyle;

public class Aplicacao {
	public static void main (String[] args) {
		System.out.println(LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
	}
}
