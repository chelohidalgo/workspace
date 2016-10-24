package com.hidalgo.financial.chat.service;

import java.io.Serializable;
import java.util.List;

import com.hidalgo.financial.chat.entity.Profile;
import com.hidalgo.financial.chat.exception.FinancialChatException;

/**
 * Interface with services allowed with profile
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface IProfileService extends Serializable {

	/**
	 * Save the profile in the database
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @param profile
	 *            : profile to save
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public void saveProfile(Profile profile) throws FinancialChatException;

	/**
	 * Delete all the profiles stored
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public void deleteAll() throws FinancialChatException;

	/**
	 * Find profiles stored in database
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @return List<Profile> : profiles founded           
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public List<Profile> findProfiles() throws FinancialChatException;
}
