package com.thinkconstructive.restapplication.controller;

import com.thinkconstructive.restapplication.model.CloudVendor;
import com.thinkconstructive.restapplication.response.ResponseHandler;
import com.thinkconstructive.restapplication.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //    / is not necessery in rest endpoints

    /*
    //Get single cloud vendor details from db
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return cloudVendorService.getCloudVendor(vendorId);
    }
     */

    // get single cloud vendor details in Custom Response format. using ResponseEntity
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested Cloud Vendor details are here", HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }

    //get list of cloud vendors present in db
    @GetMapping
    public List<CloudVendor> getCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    //create new cloud vendor and save in db
    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully..";
    }

    //update cloud vendor details
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    //delete cloud vendor from db
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}
