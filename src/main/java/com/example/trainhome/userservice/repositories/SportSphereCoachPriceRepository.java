package com.example.trainhome.userservice.repositories;

import com.example.trainhome.userservice.entities.SportSphereCoachPrice;
import com.example.trainhome.userservice.entities.compositeKeys.SportSphereCoachPriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportSphereCoachPriceRepository extends JpaRepository<SportSphereCoachPrice, SportSphereCoachPriceId> {
}
