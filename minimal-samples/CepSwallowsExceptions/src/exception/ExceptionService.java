package exception;

public class ExceptionService {

	public static void throwNullPointerException() {
		throw new NullPointerException("Catch it, CEP!");
	}
	
	public static void throwsClassCastException() {
		throw new ClassCastException("Auuch!");
	}
	
}
