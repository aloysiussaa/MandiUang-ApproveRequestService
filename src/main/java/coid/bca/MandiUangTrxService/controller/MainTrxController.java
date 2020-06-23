package coid.bca.MandiUangTrxService.controller;

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

import coid.bca.MandiUangTrxService.model.BranchAccount;
import coid.bca.MandiUangTrxService.model.MainAccount;
import coid.bca.MandiUangTrxService.model.MainTrxToBranch;
import coid.bca.MandiUangTrxService.model.User;
import coid.bca.MandiUangTrxService.payload.ApiResponse;
import coid.bca.MandiUangTrxService.payload.TrxToBranchRequest;
import coid.bca.MandiUangTrxService.repository.BranchRepository;
import coid.bca.MandiUangTrxService.repository.MainRepository;
import coid.bca.MandiUangTrxService.repository.MainTrxRepository;
import coid.bca.MandiUangTrxService.repository.UserRepository;

	@RestController
	@RequestMapping("/v1/transactionMain")
	public class MainTrxController {
		
		@Autowired
		UserRepository userRepository;
		
		@Autowired
		BranchRepository branchRepository;
		
		@Autowired
		MainRepository mainRepository;
		
		@Autowired
		MainTrxRepository mainTrxRepository;
		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@PostMapping("/transToBranch")
	    public ResponseEntity<?> createMainTrans(@Valid @RequestBody TrxToBranchRequest newTrxBranchRequest){
			Date dateStarted = new Date();
			String verCode = "12345678";
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    	Optional<User> userOpt = userRepository.findByUsername(userDetail.getUsername()); 
	    	User user = userOpt.get();
	    	Optional<BranchAccount> branchOpt = branchRepository.findByBranchAccountNo(newTrxBranchRequest.getTransferToAcct());
	    	BranchAccount branch = branchOpt.get();
	    	Optional<MainAccount> mainOpt = mainRepository.findByMainAccountId(user.getMainIdWork());
	    	MainAccount main = mainOpt.get();
	    	if (!verCode.equals(newTrxBranchRequest.getVerificationCode())) {
	    		return new ResponseEntity(new ApiResponse(false, "Verification Code False"),
	                    HttpStatus.BAD_REQUEST);
	    	}
	    	if (main.getMainBalance() < newTrxBranchRequest.getTrxAmount()) {
	    		return new ResponseEntity(new ApiResponse(false, "Balance Is Not Enough"),
	                    HttpStatus.BAD_REQUEST);
	    	}
	    	MainTrxToBranch transToBranch = new MainTrxToBranch (user.getMainIdWork(), newTrxBranchRequest.getTransferToAcct(), newTrxBranchRequest.getTransferType(), newTrxBranchRequest.getTrxAmount(), dateStarted, user.getUsername());
			branch.setBranchBalance(branch.getBranchBalance() + newTrxBranchRequest.getTrxAmount());
			MainTrxToBranch result = mainTrxRepository.save(transToBranch);
	        URI location = ServletUriComponentsBuilder
	        		.fromCurrentContextPath().path("/v1/transactionMain")
	                .buildAndExpand(result.getMainAcctTrxId()).toUri();

	        return ResponseEntity.created(location).body(new ApiResponse(true, "Transaction Success!"));
		}
	}
