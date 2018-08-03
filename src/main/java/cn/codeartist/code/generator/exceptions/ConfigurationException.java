package cn.codeartist.code.generator.exceptions;

/**
 * 配置异常
 *
 * @author 艾江南
 */
public class ConfigurationException extends GeneratorException {

    public ConfigurationException() {
        super();
    }

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(Throwable cause) {
        super(cause);
    }
}
