package com.thinkconstructive.restapplication.service;

import com.thinkconstructive.restapplication.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    String createCloudVendor(CloudVendor cloudVendor);
    String updateCloudVendor(CloudVendor cloudVendor);
    String deleteCloudVendor(String cloudVendorId);
    CloudVendor getCloudVendor(String cloudVendorId);
    List<CloudVendor> getAllCloudVendors();
}
