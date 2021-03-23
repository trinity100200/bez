package ru.sapteh.DAO;

import java.util.List;

public interface DAO<Entity, Key> {
    void update(Entity entity);
    Entity read(Key key);
    List<Entity> readAll();
    void create(Entity entity);
    void delete(Entity entity);

}
