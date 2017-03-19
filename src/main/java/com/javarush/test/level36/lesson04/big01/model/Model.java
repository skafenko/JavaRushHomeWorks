package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Mykhailo on 27.11.2016.
 */
public interface Model {

    ModelData getModelData();

    void loadUsers();

    void changeUserData(String name, long id, int level);

    void loadDeletedUsers();

    void loadUserById(long userId);

    void deleteUserById(long id);
}
