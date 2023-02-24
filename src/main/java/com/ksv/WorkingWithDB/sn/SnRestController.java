package com.ksv.WorkingWithDB.sn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SnRestController {
    private final SnService snService;

    @Autowired
    public SnRestController(SnService snService) {
        this.snService = snService;
    }
    //чтение всех записей
    @GetMapping(value = "snAll")
    public ResponseEntity<List<SnModel>> read(){
        final List<SnModel> sn = snService.findAll();

        return sn != null && !sn.isEmpty()
                ? new ResponseEntity<>(sn, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //чтение одной записи по части имени, формат: ?name=name
    @RequestMapping(value = "snName", method = RequestMethod.GET)
    public ResponseEntity<List<SnModel>> searchByPartOfName(@RequestParam(name = "name", required = false) String name){
        final List<SnModel> sn = snService.findByNameContaining(name);

        return sn != null && !sn.isEmpty()
                ? new ResponseEntity<>(sn, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //добавление новой записи
    @PostMapping(value = "/sn")
    public ResponseEntity<?> insert(@RequestBody SnModel snModel){
        snService.insertNewCounter(snModel.getSn(), snModel.getName());
        //snService.create(snModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/sn/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean delete = snService.delete(id);

        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
