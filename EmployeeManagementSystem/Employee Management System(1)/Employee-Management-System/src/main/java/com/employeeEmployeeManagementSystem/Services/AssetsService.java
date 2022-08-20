package com.employeeEmployeeManagementSystem.Services;

import com.employeeEmployeeManagementSystem.Model.Assets;

import java.util.List;

public interface AssetsService {


    List<Assets> getAllAssets();

    Assets getAssetsById(int id);

    Assets updateAssets(Assets assets, int id);

    void deleteAssets(int id);

    Assets saveAsset(Assets assets);
}
