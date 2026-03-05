package model.dao_csv;

public interface  IDAO<T> {
    void create(T entity);
    T read(Integer id);
    void update(T entity);
    void delete(Integer id);
    void getById(String s);
}