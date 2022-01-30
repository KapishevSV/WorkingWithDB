package com.ksv.WorkingWithDB.sn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SnRestController {
    private final SnService snService;

    @Autowired
    public SnRestController(SnService snService) {
        this.snService = snService;
    }

    @GetMapping(value = "sn")
    public ResponseEntity<List<SnModel>> read(){
        final List<SnModel> sn = snService.findAll();

        return sn != null && !sn.isEmpty()
                ? new ResponseEntity<>(sn, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/sn/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean delete = snService.delete(id);

        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
