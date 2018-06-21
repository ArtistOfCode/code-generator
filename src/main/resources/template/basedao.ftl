package ${packageName};

import java.util.List;

public interface BaseDao
<T> {

    int insert(T entity);

    List
    <T> select(T entity);

        T selectById(Object id);

        int delectById(Object id);

        int updateById(T entity);

        }