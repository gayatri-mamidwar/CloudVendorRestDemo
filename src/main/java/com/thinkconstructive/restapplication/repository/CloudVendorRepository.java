package com.thinkconstructive.restapplication.repository;

import com.thinkconstructive.restapplication.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

    //All basics operations are provided by JPA repository. no need to write explicitly. Only write custom methods
}
