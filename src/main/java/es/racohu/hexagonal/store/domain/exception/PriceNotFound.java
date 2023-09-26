package es.racohu.hexagonal.store.domain.exception;

@SuppressWarnings("serial")
public class PriceNotFound extends RuntimeException {

	public PriceNotFound(String message) {
		super(message);
	}
}
