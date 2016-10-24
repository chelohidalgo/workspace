package com.hidalgo.financial.chat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidalgo.financial.chat.entity.Profile;
import com.hidalgo.financial.chat.exception.FinancialChatException;
import com.hidalgo.financial.chat.repository.ProfileRepository;
import com.hidalgo.financial.chat.service.IProfileService;

/**
 * Services allowed with profile
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
@Service
public class ProfileService implements IProfileService {

	private ProfileRepository profileRepository;

	@Autowired
	public ProfileService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Override
	public void saveProfile(Profile profile) throws FinancialChatException {
		try {
			this.profileRepository.save(profile);
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to save a profile");
		}
	}

	@Override
	public void deleteAll() throws FinancialChatException {
		try {
			this.profileRepository.deleteAll();
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to delete all profiles");
		}
	}

	@Override
	public List<Profile> findProfiles() throws FinancialChatException {
		try {
			return this.profileRepository.findAll();
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to find all profiles");
		}
	}

}
