package com.project.bookstore.exception;

public class ProductsNotFoundException extends RuntimeException{

	public ProductsNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProductsNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductsNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductsNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
