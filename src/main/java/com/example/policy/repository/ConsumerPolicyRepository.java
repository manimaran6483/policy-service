package com.example.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.policy.models.ConsumerPolicy;

@Repository

public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy, Long> {

	Boolean existsByConsumerid(Long consumerid);

	ConsumerPolicy findByConsumerid(Long consumerid);

	ConsumerPolicy findByConsumeridAndBusinessid(Long consumerid, Long businessid);

}