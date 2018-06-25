# GeneratorSqlMap
代码自动生成工程，根据数据库表生成对应的实体类、数据持续层、业务层、控制层源代码。

## 一、配置文件
1. `<config>`：根节点。
2. `<dataSource>`：使用JDBC连接数据库的配置。  
	- `driver`：数据库JDBC驱动。  
	- `url`：连接数据库的地址。  
	- `username`：连接数据库的用户名。  
	- `password`：连接数据库的密码。  
3. `<javaModelGenerator>`：配置Java实体类生成的路径。  
	- `targetPackage`：生成文件所在的包。  
	- `targetProject`：生成文件的包所在的路径。  
4. `<mapperGenerator>`：配置mapper文件生成的路径。  
	- `targetPackage`：生成文件所在的包。  
	- `targetProject`：生成文件的包所在的路径。  
5. `<javaDaoGenerator>`：配置接口生成的路径。  
	- `targetPackage`：生成文件所在的包。  
	- `targetProject`：生成文件的包所在的路径。  
6. `<table>`：配置对应的数据库表，可以设置多个。  
	- `className`：配置生成的实体类名，为空时取用表名。  
	- `tableName`：设置需要生成文件的数据库表。

## 二、逆向工程主函数

```java
public class GeneratorApplication {

    public static void main(String[] args) {
        GenSessionFactory factory = new BaseGenSessionFactory().build("generatorConfig.xml");
        GenSession session = factory.openSession();
        session.generate();
    }

}
```