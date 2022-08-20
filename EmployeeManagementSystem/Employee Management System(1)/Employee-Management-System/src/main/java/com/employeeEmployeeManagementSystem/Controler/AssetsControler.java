package com.employeeEmployeeManagementSystem.Controler;

import com.employeeEmployeeManagementSystem.Model.Assets;
import com.employeeEmployeeManagementSystem.Services.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/assets")

public class AssetsControler {
    @Autowired
    private AssetsService assetsService;
    public AssetsControler(AssetsService assetsService)
    {
        this.assetsService=assetsService;
    }
    @PostMapping
    public ResponseEntity<String> saveAssets(@RequestBody Assets assets)
    {
        if (assets.getEquipment().length()>0&&assets.getComputer().length()>0&&assets.getProductdesign().length()>0){
            Assets ass = assetsService.saveAsset(assets);
            return new ResponseEntity<>("Assets data Created",HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Please Enter valid Data",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity< List<Assets>> getAllAssets(){
        List<Assets>  assets=assetsService.getAllAssets();
        if(assets.size()>0){
            return new ResponseEntity<>(assets,HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getBYID/{id}")
    public  ResponseEntity<Assets> getAssetsById(@PathVariable("id")int id)
    {
        try{
            return new ResponseEntity<Assets>(assetsService.getAssetsById(id),HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Assets>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateBYID/{id}")
    public ResponseEntity<String> updateAssets(@PathVariable("id")int id, @RequestBody Assets assets)
    {
        try {
            if (assets.getEquipment().length()>0&&assets.getComputer().length()>0&&assets.getProductdesign().length()>0) {
                assetsService.updateAssets(assets, id);
                return new ResponseEntity<String>("Assets details updated Successfully", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<String>("Enter valid details for updation",HttpStatus.BAD_REQUEST);
            }
        }
        catch (NoSuchElementException e)
        {

            return new ResponseEntity<String>("Assets details not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteBYID/{id}")
    public ResponseEntity<String> deleteAssets(@PathVariable("id")int id)
    {
        try {
            assetsService.deleteAssets(id);
            return new ResponseEntity<String>("-------Asset deleted Successfully-------",HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {

            return new ResponseEntity<String>("------- Asset not Found -----",HttpStatus.NOT_FOUND);
        }
    }

}
