package com.ies.data.collection.DcServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.data.collection.binding.EducationDetails;
import com.ies.data.collection.binding.IncomeDetails;
import com.ies.data.collection.binding.Kid;
import com.ies.data.collection.binding.Kids;
import com.ies.data.collection.binding.PlanSelection;
import com.ies.data.collection.binding.Summery;
import com.ies.data.collection.entity.CititzenAppEntity;
import com.ies.data.collection.entity.DcEducationEntity;
import com.ies.data.collection.entity.DcIncomeEntity;
import com.ies.data.collection.entity.DcKidEntity;
import com.ies.data.collection.entity.Plan;
import com.ies.data.collection.entity.UserInfo;
import com.ies.data.collection.repo.CitizenAppRepo;
import com.ies.data.collection.repo.EducationRepo;
import com.ies.data.collection.repo.IncomeRepo;
import com.ies.data.collection.repo.KidRepo;
import com.ies.data.collection.repo.PlanRepo;
import com.ies.data.collection.repo.UserInfoRepo;
import com.ies.data.collection.service.DcService;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	PlanRepo planRepo;
	
	@Autowired
	CitizenAppRepo citizenAppRepo;
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	@Autowired
	IncomeRepo incomeRepo;
	
	@Autowired
	EducationRepo eduRepo;
	
	@Autowired
	KidRepo kidRepo;

	@Override
	public Map<Integer, String> getPlans() {
		List<Plan> plans = planRepo.findAll();
		Map<Integer, String> map = new HashMap<>();

		for (Plan plan : plans) {
			map.put(plan.getId(), plan.getPlanName());
		}
		
		return map;
	}

	@Override
	public Object updatePlnSelction(PlanSelection planSelection) {
		Optional<CititzenAppEntity> cititzenAppEntity = citizenAppRepo.findById(planSelection.getCaseNumber());
		UserInfo userInfo = userInfoRepo.findById(planSelection.getUserId()).get();
		if (cititzenAppEntity.isPresent()) {
			CititzenAppEntity 	appEntity = cititzenAppEntity.get();
			appEntity.setPlanId(planSelection.getPlanId());
			appEntity.setUserInfo(userInfo);
			citizenAppRepo.save(appEntity);
			return appEntity;
		}
		return null;
	}

	@Override
	public Object setIncomeDetails(IncomeDetails incomeDetails) {
		DcIncomeEntity dcIncomeEntity = new DcIncomeEntity();
		BeanUtils.copyProperties(incomeDetails, dcIncomeEntity);
		
		CititzenAppEntity cititzenAppEntity = citizenAppRepo.findById(incomeDetails.getCaseNumber()).get();
		UserInfo userInfo = userInfoRepo.findById(incomeDetails.getUserId()).get();
		
		dcIncomeEntity.setCititzenAppEntity(cititzenAppEntity);
		dcIncomeEntity.setUser(userInfo);
		
		incomeRepo.save(dcIncomeEntity);
		return dcIncomeEntity;
	}

	@Override
	public Object setEducationDetails(EducationDetails educationDetails) {
		DcEducationEntity dcEducationEntity = new DcEducationEntity();
		BeanUtils.copyProperties(educationDetails, dcEducationEntity);
		
		CititzenAppEntity cititzenAppEntity = citizenAppRepo.findById(educationDetails.getCaseNumber()).get();
		UserInfo userInfo = userInfoRepo.findById(educationDetails.getUserId()).get();
		
		dcEducationEntity.setCititzenAppEntity(cititzenAppEntity);
		dcEducationEntity.setUser(userInfo);
		
		eduRepo.save(dcEducationEntity);
		return dcEducationEntity;
	}

	@Override
	public Object setKidsDetails(Kids kids) {
		Integer caseNumber = kids.getCaseNumber();
		Integer userId = kids.getUserId();
		
		CititzenAppEntity cititzenAppEntity = citizenAppRepo.findById(caseNumber).get();
		UserInfo userInfo = userInfoRepo.findById(userId).get();
		DcKidEntity dcKidEntity = null;
		
		for (Kid kid : kids.getKids()) {
			dcKidEntity = new DcKidEntity();
			BeanUtils.copyProperties(kid, dcKidEntity);
			dcKidEntity.setCititzenAppEntity(cititzenAppEntity);
			dcKidEntity.setUser(userInfo);
			
			kidRepo.save(dcKidEntity);
		}
		
		return dcKidEntity;
	}

	@Override
	public Object getSummery(Integer caseNumber) {
		CititzenAppEntity cititzenAppEntity = citizenAppRepo.findById(caseNumber).get();
		Plan plan = planRepo.findById(cititzenAppEntity.getPlanId()).get();
		DcIncomeEntity incomeEntity = incomeRepo.findByCaseNo(caseNumber);
		DcEducationEntity educationEntity = eduRepo.findByCaseNo(caseNumber);
		List<DcKidEntity> dcKidEntities = kidRepo.findByCaseNo(caseNumber);
		
		Summery summery = new Summery();
		summery.setPlan(plan);
		summery.setIncomeEntity(incomeEntity);
		summery.setEducationEntity(educationEntity);
		summery.setKids(dcKidEntities);
		
		return summery;
	}

}
