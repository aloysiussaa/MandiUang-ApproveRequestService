package coid.bca.MandiUangApproveRequestService.controller;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import coid.bca.MandiUangApproveRequestService.model.BranchAccount;
import coid.bca.MandiUangApproveRequestService.model.BranchReqBudget;
import coid.bca.MandiUangApproveRequestService.model.User;
import coid.bca.MandiUangApproveRequestService.payload.ApiResponse;
import coid.bca.MandiUangApproveRequestService.payload.ReqBudgetRequest;
import coid.bca.MandiUangApproveRequestService.repository.UserRepository;
import coid.bca.MandiUangApproveRequestService.repository.ReqBudgetRepository;
import coid.bca.MandiUangApproveRequestService.repository.BranchRepository;

@RestController
@RequestMapping("/v1/transactionBranch")
public class BranchRequestController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	ReqBudgetRepository reqBudgetRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/requestBudget")
	public ResponseEntity<?> createReqBudget(@Valid @RequestBody ReqBudgetRequest newBudgetRequest){
		Date dateStarted = new Date();
		String verCode = "12345678";
		String status = "Pending";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
    	Optional<User> userOpt = userRepository.findByUsername(userDetail.getUsername()); 
    	User user = userOpt.get();
    	Integer adminCheck = userRepository.findMainAccountIdByUsername(user.getUsername());
    	if (adminCheck!=null) {
    		return new ResponseEntity(new ApiResponse(false, "Super Admin Not Eligible To Do This!"),
                  HttpStatus.BAD_REQUEST);
    	}
    	else {
    	Optional<BranchAccount> branchOpt = branchRepository.findByBranchAccountId(user.getBranchIdWork());
    	BranchAccount branch = branchOpt.get();
    	if (!verCode.equals(newBudgetRequest.getVerificationCode())) {
    		return new ResponseEntity(new ApiResponse(false, "Verification Code False"),
                    HttpStatus.BAD_REQUEST);
    	}
		BranchReqBudget reqBudget = new BranchReqBudget(branch.getBranchAccountId(), branch.getMainAccountId(), user.getUsername(), newBudgetRequest.getPurpose(),
				newBudgetRequest.getRemarks(), status, newBudgetRequest.getRequestAmt(), newBudgetRequest.getRequestType(), dateStarted);
				
    	BranchReqBudget result = reqBudgetRepository.save(reqBudget);
        URI location = ServletUriComponentsBuilder
        		.fromCurrentContextPath().path("/v1/requestBudget")
                .buildAndExpand(result.getReqId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Request Success!"));
	}
}
}