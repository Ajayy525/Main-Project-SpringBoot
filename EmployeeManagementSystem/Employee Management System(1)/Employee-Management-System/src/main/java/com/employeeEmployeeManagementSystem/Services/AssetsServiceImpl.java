package com.employeeEmployeeManagementSystem.Services;

import com.employeeEmployeeManagementSystem.Model.Assets;
import com.employeeEmployeeManagementSystem.Repository.AssetsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsServiceImpl implements AssetsService {

    @Autowired
    private AssetsRepo assetsRepo;
    public AssetsServiceImpl(AssetsRepo assetsRepo)
    {
        this.assetsRepo=assetsRepo;
    }
    @Override
    public List<Assets> getAllAssets()
    {
        return assetsRepo.findAll();
    }
    @Override
    public Assets getAssetsById(int id) {
        return assetsRepo.findById(id).orElseThrow();
    }
    @Override
    public Assets saveAsset(Assets assets) {
        return assetsRepo.save(assets);
    }

    @Override
    public Assets updateAssets(Assets assets,int id)
    {
        Assets existingAssets =assetsRepo.findById(id).orElseThrow();
        existingAssets.setEquipment(assets.getEquipment());
        existingAssets.setComputer(assets.getComputer());
        existingAssets.setProductdesign(assets.getProductdesign());
        assetsRepo.save(existingAssets);
        return existingAssets;
    }
    @Override
    public void deleteAssets(int id)
    {
        assetsRepo.findById(id).orElseThrow();
        assetsRepo.deleteById(id);
    }



}
