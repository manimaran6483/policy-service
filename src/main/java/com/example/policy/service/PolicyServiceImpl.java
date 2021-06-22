package com.example.policy.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.policy.models.ConsumerPolicy;
import com.example.policy.models.PolicyMaster;
import com.example.policy.response.Property;
import com.example.policy.repository.*;
import com.example.policy.request.CreatePolicyRequest;
import com.example.policy.request.IssuePolicyRequest;
import com.example.policy.request.QuoteRequest;
import com.example.policy.response.ConsumerBusinessDetails;
import com.example.policy.response.PolicyDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import com.example.policy.exception.ConsumerNotFoundException;
import com.example.policy.exception.PolicyNotFoundException;
import com.example.policy.feign.*;

@Service
@Slf4j
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private ConsumerPolicyRepository consumerPolicyRepository;

	@Autowired
	private PolicyMasterRepository policyMasterRepository;

	@Autowired
	ConsumerClient consumerClient;
	
	@Autowired
	QuotesClient quotesClient;

	@Override
	public PolicyDetailsResponse viewPolicy(String token, Long consumerid, Long policyid)
			throws PolicyNotFoundException, ConsumerNotFoundException {
		log.info("Start viewPolicyService");
		if (!policyMasterRepository.existsByPid(policyid)) {
			throw new PolicyNotFoundException("Policy Not Found");
		}
		if (!consumerPolicyRepository.existsByConsumerid(consumerid)) {
			throw new ConsumerNotFoundException("Sorry!!, No Consumer Found!!");
		}
		PolicyMaster policyMaster = policyMasterRepository.findByPid(policyid);
		log.debug("policyMaster : {}", policyMaster);
		ConsumerPolicy consumerPolicy = consumerPolicyRepository.findByConsumerid(consumerid);
		log.debug("consumerPolicy : {}", consumerPolicy);
		PolicyDetailsResponse policyDetailsResponse = new PolicyDetailsResponse(consumerid, policyMaster.getPid(),
				policyMaster.getPropertytype(), policyMaster.getConsumertype(), policyMaster.getAssuredsum(),
				policyMaster.getTenure(), policyMaster.getBusinessvalue(), policyMaster.getPropertyvalue(),
				policyMaster.getBaselocation(), policyMaster.getType(), consumerPolicy.getBusinessid(),
				consumerPolicy.getPaymentdetails(), consumerPolicy.getAcceptancestatus(),
				consumerPolicy.getPolicystatus(), consumerPolicy.getEffectivedate(), consumerPolicy.getCovered_sum(),
				consumerPolicy.getDuration(), consumerPolicy.getAcceptedquote());
		log.info("policyDetailsResponse : {}", policyDetailsResponse);
		log.info("End viewPolicyService");
		return policyDetailsResponse;
	}

	@Override
	public String createPolicy(String token, CreatePolicyRequest createPolicyRequest) throws ConsumerNotFoundException {
		log.info("Start createPolicyService");

		ConsumerBusinessDetails consumerBusinessDetails = getConsumerBusiness(token,
				createPolicyRequest.getConsumerid());
		if (consumerBusinessDetails == null) {
			throw new ConsumerNotFoundException("Sorry!!, No Consumer Found with given id!!");
		}
		PolicyMaster policyM = policyMasterRepository.findByBusinessvalue(8);
		log.info("policyMaster", policyM);
		
		log.info("consumerBusinessDetails : {}", consumerBusinessDetails);
		ConsumerPolicy consumerPolicy = new ConsumerPolicy(consumerBusinessDetails.getConsumerId(),
				consumerBusinessDetails.getBusinessid(), "Initiated", createPolicyRequest.getAcceptedquotes());
		
		log.info("consumerPolicy : {}", consumerPolicy);
		ConsumerPolicy consumerPolicysave = consumerPolicyRepository.save(consumerPolicy);
		log.info("consumerPolicysave : {}", consumerPolicysave);
		

		consumerPolicy.setQuotation(35000);
		consumerPolicysave = consumerPolicyRepository.save(consumerPolicy);
		log.info("End createPolicyService");
		long quote = getQuotes(token, consumerBusinessDetails.getConsumerId());
		log.info("quote :"+quote);
		return "Policy Has been Created with Policyconsumer Id : " + consumerPolicysave.getId()
				+ " .Thank You Very Much!!";
	}

	@Override
	public String issuePolicy(String token, IssuePolicyRequest issuePolicyRequest) throws ConsumerNotFoundException {
		log.info("Start issuePolicyService");
		log.info("issueRequest:", issuePolicyRequest.getConsumerid());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		if (!consumerPolicyRepository.existsByConsumerid(issuePolicyRequest.getConsumerid())) {
			throw new ConsumerNotFoundException("Sorry!!, No Consumer Found!!");
		}
		ConsumerPolicy consumerPolicy = consumerPolicyRepository.findByConsumerid(issuePolicyRequest.getConsumerid());
		log.info("consumerPolicy : {}", consumerPolicy);

		PolicyMaster policyMaster = policyMasterRepository.findByPid(issuePolicyRequest.getPolicyid());
		log.info("policyMaster : {}", policyMaster);
		consumerPolicy.setPolicyid(issuePolicyRequest.getPolicyid());
		consumerPolicy.setPaymentdetails(issuePolicyRequest.getPaymentdetails());
		consumerPolicy.setAcceptancestatus(issuePolicyRequest.getAcceptancestatus());
		consumerPolicy.setPolicystatus("Issued");
		consumerPolicy.setEffectivedate(dtf.format(now));
		consumerPolicy.setDuration(policyMaster.getTenure());
		consumerPolicy.setCovered_sum(policyMaster.getAssuredsum());

		ConsumerPolicy consumerPolicySave = consumerPolicyRepository.save(consumerPolicy);
		log.info("consumerPolicySave : {}", consumerPolicySave);
		log.info("End issuePolicyService");
		return "Policy has Issued to PolicyConsumer Id : " + consumerPolicySave.getId() + " .Thank You Very Much!!";
	}

	@Override
	public ConsumerBusinessDetails getConsumerBusiness(String token, Long consumerid) {
		log.info("Start getConsumerBusiness");
		ConsumerBusinessDetails consumerBusinessDetails = consumerClient.viewConsumerBusiness(token, consumerid);
		log.info("consumerBusinessDetails : {}", consumerBusinessDetails);
		log.info("End getConsumerBusiness");
		return consumerBusinessDetails;
	}

	@Override
	public long getQuotes(String token, long id) {

		ConsumerPolicy policy = consumerPolicyRepository.findByConsumerid(id);
		ConsumerBusinessDetails cb = consumerClient.viewConsumerBusiness(token, id);
		Property bp = consumerClient.viewBusinessProperty(token,id);
		log.info("inside getQuotes");

		long quotation = quotesClient.getQuotesForPolicy(token, cb.getBusinessvalue(),bp.getPropertyvalue(),bp.getPropertytype()
				,policy.getId());
		log.info("quotation: " + quotation);
		return quotation;
	}

}