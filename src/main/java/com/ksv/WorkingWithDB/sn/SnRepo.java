package com.ksv.WorkingWithDB.sn;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SnRepo extends CrudRepository<SnModel, Integer> {
    List<SnModel> findByName(String name);

//    @Procedure(value = "select_sn")
//    List<SnModel> findByName(@Param("name") String name);

    @Query("SELECT s FROM SnModel s WHERE s.sn = :sn")
    List<SnModel> findBySn(Integer sn);

    @Query("SELECT s FROM SnModel s WHERE s.name LIKE CONCAT('%',:name,'%') AND CONCAT(s.sn, '::text') LIKE CONCAT('%',:sn,'%')")
    List<SnModel> findByNameAndSn(String name, Integer sn);

    List<SnModel> findByNameContaining(String name);
}



