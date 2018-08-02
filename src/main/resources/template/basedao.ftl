package ${daoPackage};

import java.util.List;

public interface BaseMapper<T> {

    int insert(T entity);

    List<T> select(T entity);

    T selectById(Object id);

    int deleteById(Object id);

    int updateById(T entity);

}