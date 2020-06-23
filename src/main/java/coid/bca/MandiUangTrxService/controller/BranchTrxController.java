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

import coid.bca.MandiUangTrxService.repository.UserRepository;
import coid.bca.MandiUangTrxService.model.BranchAccount;
import coid.bca.MandiUangTrxService.model.BranchTrxToBCA;
import coid.bca.MandiUangTrxService.model.BranchTrxToNonBCA;
import coid.bca.MandiUangTrxService.model.MainAccount;
import coid.bca.MandiUangTrxService.model.User;
import coid.bca.MandiUangTrxService.payload.ApiResponse;
import coid.bca.MandiUangTrxService.payload.TrxToBCARequest;
import coid.bca.MandiUangTrxService.payload.TrxToNonBCARequest;
import coid.bca.MandiUangTrxService.repository.BranchRepository;
import coid.bca.MandiUangTrxService.repository.MainRepository;
import coid.bca.MandiUangTrxService.repository.TransBCARepository;
import coid.bca.MandiUangTrxService.repository.TransNONRepository;


@RestController
@RequestMapping("/v1/transactionBranch")
public class BranchTrxController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	MainRepository mainRepository;
	
	@Autowired
    TransBCARepository transBCARepository;
	
	@Autowired
	TransNONRepository transNONRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/transToBCA")
    public ResponseEntity<?> createTrans(@Valid @RequestBody TrxToBCARequest newTrxBCARequest){
		Date dateStarted = new Date();
		String verCode = "12345678";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
    	Optional<User> userOpt = userRepository.findByUsername(userDetail.getUsername()); 
    	User user = userOpt.get();
    	Optional<BranchAccount> branchOpt = branchRepository.findByBranchAccountId(user.getBranchIdWork());
    	BranchAccount branch = branchOpt.get();
    	Optional<MainAccount> mainOpt = mainRepository.findByMainAccountId(branch.getMainAccountId());
    	MainAccount main = mainOpt.get();
    	if (!verCode.equals(newTrxBCARequest.getVerificationCode())) {
    		return new ResponseEntity(new ApiResponse(false, "Verification Code False"),
                    HttpStatus.BAD_REQUEST);
    	}
		BranchTrxToBCA transToBCA = new BranchTrxToBCA(newTrxBCARequest.getAcctRecNo(), user.getBranchIdWork(), newTrxBCARequest.getTransferType(), 
				newTrxBCARequest.getBeneficiaryId(), newTrxBCARequest.getTrxAmount(), dateStarted, user.getUsername());
		branch.setBranchBalance(branch.getBranchBalance() - newTrxBCARequest.getTrxAmount());
		main.setMainBalance(main.getMainBalance() - newTrxBCARequest.getTrxAmount());
		BranchTrxToBCA result = transBCARepository.save(transToBCA);
        URI location = ServletUriComponentsBuilder
        		.fromCurrentContextPath().path("/v1/transactionBranch")
                .buildAndExpand(result.getBranchBcaTrxId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Transaction Success!"));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/transToNonBCA")
    public ResponseEntity<?> createTransNon(@Valid @RequestBody TrxToNonBCARequest newTrxNonBCARequest){
		Date dateStarted = new Date();
		String verCode = "12345678";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
    	Optional<User> userOpt = userRepository.findByUsername(userDetail.getUsername()); 
    	User user = userOpt.get();
    	Optional<BranchAccount> branchOpt = branchRepository.findByBranchAccountId(user.getBranchIdWork());
    	BranchAccount branch = branchOpt.get();
    	Optional<MainAccount> mainOpt = mainRepository.findByMainAccountId(branch.getMainAccountId());
    	MainAccount main = mainOpt.get();
    	if (!verCode.equals(newTrxNonBCARequest.getVerificationCode())) {
    		return new ResponseEntity(new ApiResponse(false, "Verification Code False"),
                    HttpStatus.BAD_REQUEST);
    	}
		BranchTrxToNonBCA transToNonBCA = new BranchTrxToNonBCA(newTrxNonBCARequest.getTransferToNonAcct(), user.getBranchIdWork(), newTrxNonBCARequest.getTransferType(),
    			newTrxNonBCARequest.getBeneficiaryId(), newTrxNonBCARequest.getTrxAmount(), dateStarted, user.getUsername(), newTrxNonBCARequest.getBankName());
		branch.setBranchBalance(branch.getBranchBalance() - newTrxNonBCARequest.getTrxAmount());
		main.setMainBalance(main.getMainBalance() - newTrxNonBCARequest.getTrxAmount());
		BranchTrxToNonBCA result = transNONRepository.save(transToNonBCA);
        URI location = ServletUriComponentsBuilder
        		.fromCurrentContextPath().path("/v1/transactionBranch")
                .buildAndExpand(result.getBranchNonTrxId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Transaction Success!"));
	}
}
