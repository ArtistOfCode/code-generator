package com.codeartist.mybatis.generator.config;

/**
 * 配置里面的设置实体
 *
 * @author 艾江南
 */
public class Settings {

    private boolean enableSerializable = true;

    public boolean isEnableSerializable() {
        return enableSerializable;
    }

    public void setEnableSerializable(boolean enableSerializable) {
        this.enableSerializable = enableSerializable;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "enableSerializable=" + enableSerializable +
                '}';
    }
}
