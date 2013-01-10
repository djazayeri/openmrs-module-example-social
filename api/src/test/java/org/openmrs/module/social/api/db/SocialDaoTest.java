package org.openmrs.module.social.api.db;


import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.social.SocialStatus;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

public class SocialDaoTest extends BaseModuleContextSensitiveTest {
	
	@Autowired
	SocialStatusDao dao;
	
	/**
	 * @see SocialStatusDao#saveSocialStatus(SocialStatus)
	 * @verifies save status
	 */
	@Test
	public void saveSocialStatus_shouldSaveStatus() throws Exception {
		User user = Context.getAuthenticatedUser();
		
		SocialStatus status = new SocialStatus(user , "some status");
		
		dao.saveSocialStatus(status);
		
		Context.flushSession();
		Context.clearSession();
		
		SocialStatus persistedStatus = dao.getSocialStatus(status.getId());
		Assert.assertThat(persistedStatus.getUser().getId(), is(status.getUser().getId()));
		Assert.assertThat(persistedStatus.getStatus(), is(status.getStatus()));
		Assert.assertThat(persistedStatus.getUuid(), is(status.getUuid()));
	}
}