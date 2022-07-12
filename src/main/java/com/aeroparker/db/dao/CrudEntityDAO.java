package com.aeroparker.db.dao;

public interface CrudEntityDAO<T> {
    String insertNewEntity(T element); //create

}
