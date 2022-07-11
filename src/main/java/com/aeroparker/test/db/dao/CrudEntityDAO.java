package com.aeroparker.test.db.dao;

public interface CrudEntityDAO<T> {
    String insertNewEntity(T element); //create

}
