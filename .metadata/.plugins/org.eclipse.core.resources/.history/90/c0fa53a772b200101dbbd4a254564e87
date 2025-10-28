package com.ofss.repository;

import com.ofss.model.KycDocument;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KycDocumentRepository extends CrudRepository<KycDocument, Long> {
    List<KycDocument> findByCustomerId(Long customerId); 

    @Query("SELECT k.kycId FROM KycDocument k WHERE k.customerId = :cusId")
    Long findKycIdByCustomerId(@Param("cusId") Long cusId);

}
