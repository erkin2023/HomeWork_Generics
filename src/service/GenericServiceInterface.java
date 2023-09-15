package service;

import java.util.List;

public interface GenericServiceInterface<T> {
        String add(T t);
        T getById(Long id);
        List<T> getAll();
        List<T> sortByName(int order);
        List<T> clear();

}
