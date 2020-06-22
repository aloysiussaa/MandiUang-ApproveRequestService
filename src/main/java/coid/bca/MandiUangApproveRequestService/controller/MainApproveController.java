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
import coid.bca.MandiUangApproveRequestService.model.MainAccount;
import coid.bca.MandiUangApproveRequestService.model.MainApproveBudget;
import coid.bca.MandiUangApproveRequestService.model.User;
import coid.bca.MandiUangApproveRequestService.payload.ApiResponse;
import coid.bca.MandiUangApproveRequestService.payload.ApproveBudgetRequest;
import coid.bca.MandiUangApproveRequestService.repository.ApproveBudgetRepository;
import coid.bca.MandiUangApproveRequestService.repository.BranchRepository;
import coid.bca.MandiUangApproveRequestService.repository.MainRepository;
import coid.bca.MandiUangApproveRequestService.repository.ReqBudgetRepository;
import coid.bca.MandiUangApproveRequestService.repository.UserRepository;

@RestController
@RequestMapping("/v1/transactionMain")
public class MainApproveController {
	
	@Autowired
	ReqBudgetRepository reqBudgetRepository;
	
	@Autowired
	ApproveBudgetRepository appBudgetRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	MainRepository mainRepository;
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/approveBudget")
	public ResponseEntity<?> createApproveBudget(@Valid @RequestBody ApproveBudgetRequest newApproveBudgetRequest){
		Date dateStarted = new Date();
		String verCode = "12345678";
		String status = "Approved";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
    	Optional<User> userOpt = userRepository.findByUsername(userDetail.getUsername()); 
    	User user = userOpt.get();
    	Optional<BranchReqBudget> reqOpt = reqBudgetRepository.findByReqId(newApproveBudgetRequest.getReqId());
    	BranchReqBudget reqBudget = reqOpt.get();
    	Optional<BranchAccount> branchOpt = branchRepository.findByBranchAccountId(reqBudget.getBranchAcctIdSubmit());
    	BranchAccount branch = branchOpt.get();
    	Optional<MainAccount> mainOpt = mainRepository.findByMainAccountId(user.getMainIdWork());
    	MainAccount main = mainOpt.get();
    	if (!verCode.equals(newApproveBudgetRequest.getVerificationCode())) {
    		return new ResponseEntity(new ApiResponse(false, "Verification Code False"),
                    HttpStatus.BAD_REQUEST);
    	}
    	if (newApproveBudgetRequest.getApprovedAmt() > main.getMainBalance()) {
    		return new ResponseEntity(new ApiResponse(false, "Balance Is Not Enough"),
                    HttpStatus.BAD_REQUEST);
    	}
    	if(reqBudget.getStatus().equals(status)) {
    		return new ResponseEntity(new ApiResponse(false, "Request Has Been Approved"),
                    HttpStatus.BAD_REQUEST);
    	}
    	Integer adminCheck = userRepository.findMainAccountIdByUsername(user.getUsername());
    	if (adminCheck==null) {
    		
    		return new ResponseEntity(new ApiResponse(false, "Branch Admin Not Eligible To Do This!"),
                  HttpStatus.BAD_REQUEST);
    	}
		MainApproveBudget approveBudget = new MainApproveBudget(newApproveBudgetRequest.getReqId(), newApproveBudgetRequest.getApprovedAmt(),
		reqBudget.getBranchAcctIdSubmit(), user.getUsername(), dateStarted, newApproveBudgetRequest.getRemarks(), status);
		reqBudget.setStatus(status);
		branch.setBranchBalance(branch.getBranchBalance() + newApproveBudgetRequest.getApprovedAmt());
    	MainApproveBudget result = appBudgetRepository.save(approveBudget);
        URI location = ServletUriComponentsBuilder
        		.fromCurrentContextPath().path("/v1/approveBudget")
                .buildAndExpand(result.getApproveId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Approve Success!"));
	}
}
