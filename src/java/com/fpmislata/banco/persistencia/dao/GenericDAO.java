
package com.fpmislata.banco.persistencia.dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    public T read(ID id);

    public T insert(T t);

    public T update(ID id, T t);

    public void delete(ID id);
    
    public List<T> findall();
}
