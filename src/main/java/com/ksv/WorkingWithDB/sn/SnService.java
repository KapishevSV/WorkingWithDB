package com.ksv.WorkingWithDB.sn;

import java.util.List;

public interface SnService {
    List<SnModel> findAll();

    List<SnModel> findByName(String name);

    List<SnModel> findBySn(Integer sn);

    List<SnModel> findByNameAndSn(String name, Integer sn);

    List<SnModel> findByNameContaining(String name);

    void insertNewCounter(Integer sn, String namec);

    boolean delete(int id);
}