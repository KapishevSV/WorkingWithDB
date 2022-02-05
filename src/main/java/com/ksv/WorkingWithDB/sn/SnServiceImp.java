package com.ksv.WorkingWithDB.sn;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnServiceImp implements SnService {
    private final SnRepo snRepo;

    public SnServiceImp(SnRepo snRepo) {
        this.snRepo = snRepo;
    }

    @Override
    public List<SnModel> findAll() {
        return (List<SnModel>) snRepo.findAll();
    }

    @Override
    public List<SnModel> findByName(String name) {
        return snRepo.findByName(name);
    }

    @Override
    public List<SnModel> findBySn(Integer sn) {
        return snRepo.findBySn(sn);
    }

    @Override
    public List<SnModel> findByNameAndSn(String name, Integer sn) {
        return snRepo.findByNameAndSn(name, sn);
    }

    @Override
    public List<SnModel> findByNameContaining(String name) {
        return snRepo.findByNameContaining(name);
    }

    @Override
    public void create(SnModel snModel) {
        snRepo.save(snModel);
    }

    @Override
    public void insertNewCounter(Integer sn, String namec) {
        snRepo.insertNewCounter(sn, namec);
    }

    @Override
    public boolean update(SnModel snModel, int id) {
        if (snRepo.existsById(id)) {
            snModel.setId(id);
            snRepo.save(snModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (snRepo.existsById(id)) {
            snRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

