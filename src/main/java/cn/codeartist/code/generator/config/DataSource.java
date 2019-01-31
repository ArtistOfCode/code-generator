package cn.codeartist.code.generator.config;

import lombok.Data;

/**
 * 数据库连接源
 *
 * @author 艾江南
 */
@Data
public class DataSource {

    private String driver;
    private String url;
    private String username;
    private String password;

}
