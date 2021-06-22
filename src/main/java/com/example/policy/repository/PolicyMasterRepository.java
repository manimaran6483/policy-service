package com.example.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.policy.models.PolicyMaster;

@Repository
@Transactional
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster, Long> {

	PolicyMaster findByPid(Long policyid);

	Boolean existsByPid(Long policyid);

	PolicyMaster findByBusinessvalue(long businessvalue);

}