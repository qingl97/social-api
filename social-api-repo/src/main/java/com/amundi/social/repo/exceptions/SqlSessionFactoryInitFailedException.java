package com.amundi.social.repo.exceptions;

public class SqlSessionFactoryInitFailedException extends RuntimeException {

	private static final long serialVersionUID = 7577863160168346257L;

	public SqlSessionFactoryInitFailedException() {
	}

	public SqlSessionFactoryInitFailedException(String message) {
		super(message);
	}

	public SqlSessionFactoryInitFailedException(Throwable cause) {
		super(cause);
	}

	public SqlSessionFactoryInitFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SqlSessionFactoryInitFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
