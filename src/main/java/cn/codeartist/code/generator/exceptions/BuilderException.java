package cn.codeartist.code.generator.exceptions;

/**
 * 构建异常
 *
 * @author 艾江南
 */
public class BuilderException extends GeneratorException {

    public BuilderException() {
    }

    public BuilderException(String message) {
        super(message);
    }

    public BuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuilderException(Throwable cause) {
        super(cause);
    }
}
