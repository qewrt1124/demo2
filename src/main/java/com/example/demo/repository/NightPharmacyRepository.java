package com.example.demo.repository;

import com.example.demo.model.NightPharmacy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NightPharmacyRepository extends JpaRepository<NightPharmacy, Integer> {
//    List<Night>

    List<NightPharmacy> findByRoadAddressContainingOrJibunAddressContainingOrderByIdDesc(String address1, String address2, Pageable pageable);

    List<NightPharmacy> findByRoadAddressContainingOrJibunAddressContaining(String address1, String address2);

}
