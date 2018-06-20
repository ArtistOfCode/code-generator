package com.codeartist.mybatis.generator.exceptions;

/**
 * 工程基础异常
 *
 * @author 艾江南
 */
public class GeneratorException extends RuntimeException {

    public GeneratorException() {
    }

    public GeneratorException(String message) {
        super(message);
    }

    public GeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneratorException(Throwable cause) {
        super(cause);
    }

}
