package cn.codeartist.code.generator.builder;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.InputStream;

/**
 * 使用dtd文件来检验xml配置文件
 *
 * @author 艾江南
 */
public class XmlConfigEntityResolver implements EntityResolver {

    private static final String GENERATOR_CONFIG_DTD = "cn/codeartist/code/generator/builder/code-generator.dtd";

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
        try {
            if (systemId != null) {
                InputStream is = this.getResourceAsStream(GENERATOR_CONFIG_DTD, getClassLoaders());
                InputSource inputSource = new InputSource(is);
                inputSource.setPublicId(publicId);
                inputSource.setSystemId(systemId);
                return inputSource;
            }
            return null;
        } catch (Exception e) {
            throw new SAXException(e.toString());
        }
    }

    private InputStream getResourceAsStream(String resource, ClassLoader[] classLoader) {
        for (ClassLoader cl : classLoader) {
            if (null != cl) {
                InputStream returnValue = cl.getResourceAsStream(resource);
                if (null == returnValue) {
                    returnValue = cl.getResourceAsStream("/" + resource);
                }
                if (null != returnValue) {
                    return returnValue;
                }
            }
        }
        return null;
    }

    private ClassLoader[] getClassLoaders() {
        return new ClassLoader[]{
                Thread.currentThread().getContextClassLoader(),
                getClass().getClassLoader(),
                ClassLoader.getSystemClassLoader()};
    }

}
