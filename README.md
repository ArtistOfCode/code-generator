# GeneratorSqlMap
逆向工程，根据数据库表生成对应的实体类和MyBatis接口和Mapper文件。

## 一、配置文件
1. `<config>`：根节点。
2. `<jdbcConnection>`：使用JDBC连接数据库的配置。  
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
5. `<javaInterfaceGenerator>`：配置接口生成的路径。  
	- `targetPackage`：生成文件所在的包。  
	- `targetProject`：生成文件的包所在的路径。  
6. `<table>`：配置对应的数据库表，可以设置多个。  
	- `className`：配置生成的实体类名，为空时取用表名。  
	- `tableName`：设置需要生成文件的数据库表。

## 二、逆向工程主函数

```java
public class Main {

	public static void main(String[] args) {
		GenerateFactory factory = new GenerateFactory();
		GenerateFile generateFile = factory.getGenerateFile("MODEL");
		generateFile.generateFile();
		generateFile = factory.getGenerateFile("INTERFACE");
		generateFile.generateFile();
		generateFile = factory.getGenerateFile("MAPPER");
		generateFile.generateFile();
	}

}
```