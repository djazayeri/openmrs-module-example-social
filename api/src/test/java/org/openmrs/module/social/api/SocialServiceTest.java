/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.social.api;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.module.social.SocialStatus;
import org.openmrs.module.social.api.db.SocialStatusDao;
import org.openmrs.module.social.api.impl.SocialServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests {@link ${SocialService}}.
 */
public class SocialServiceTest {

    private SocialService service;
    private SocialStatusDao dao;
    private UserService userService;
    

    @Before
    public void setUp() {
        userService = mock(UserService.class);
        dao = mock(SocialStatusDao.class);
        
        service = new SocialServiceImpl();
        SocialServiceImpl serviceImpl = (SocialServiceImpl) service;
		serviceImpl.setUserService(userService);
		serviceImpl.setDao(dao);
    }

	@Test
	public void shouldSetStatus() {
        User myself = new User();

        SocialStatus status = new SocialStatus();
        status.setUser(myself);
        status.setStatus("I am building a module");
        service.postStatusUpdate(status);

        verify(userService).saveUser(myself, null);
        verify(dao).saveSocialStatus(status);
	}

    @Test
    public void shouldGetStatusUpdates() {
        User one = new User();
        User two = new User();
        User three = new User();
        service.postStatusUpdate(new SocialStatus(one, "Watching TV."));
        service.postStatusUpdate(new SocialStatus(three, "Doing Homework"));

        when(userService.getAllUsers()).thenReturn(Arrays.asList(one, two, three));

        List<SocialStatus> statuses = service.getStatusUpdates();

        assertNotNull(statuses);
        assertThat(statuses.size(), is(2));
    }
}
