package com.thinkconstructive.restapplication.controller;

import com.thinkconstructive.restapplication.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    CloudVendor cloudVendor;

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable String vendorId){
        return cloudVendor;
//        return new CloudVendor("C1", "vendor1",
//                "vendor1's address", "xyxz" );
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return "Cloud Vendor Created Successfully..";
    }

    @PutMapping("{vendorId}")
    public String updateCloudVendorDetails(@PathVariable String vendorId, @RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId){
        this.cloudVendor = null;
        return "Cloud Vendor Deleted Successfully";
    }
}
