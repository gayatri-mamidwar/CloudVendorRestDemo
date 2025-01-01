package com.thinkconstructive.restapplication.service.impl;

import com.thinkconstructive.restapplication.exception.CloudVendorNotFoundException;
import com.thinkconstructive.restapplication.model.CloudVendor;
import com.thinkconstructive.restapplication.repository.CloudVendorRepository;
import com.thinkconstructive.restapplication.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        //More Business Logic
        cloudVendorRepository.save(cloudVendor);
        return "Successfully created..";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        //More Business Logic
        cloudVendorRepository.save(cloudVendor);
        return "Successfully updated";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        //More Business Logic
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){
            throw  new CloudVendorNotFoundException("Requested Cloud Vendor Doesn't exist");
        }

        cloudVendorRepository.deleteById(cloudVendorId);
        return "Successfully deleted.";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        //More Business Logic
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Doesn't exist");
        }

        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        //More Business Logic
        if(cloudVendorRepository.findAll().isEmpty()){
            throw new CloudVendorNotFoundException("No Cloud Vendors present in database");
        }

        return cloudVendorRepository.findAll();
    }
}
