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
package org.openmrs.module.social.api.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.social.SocialStatus;
import org.openmrs.module.social.api.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

/**
 * It is a default implementation of {@link SocialService}.
 */
public class SocialServiceImpl extends BaseOpenmrsService implements SocialService {

    public static final String USER_PROPERTY_SOCIAL_STATUS = "social.status";
    protected final Log log = LogFactory.getLog(this.getClass());
	
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void postStatusUpdate(SocialStatus status) {
        User user = status.getUser();
        user.setUserProperty(USER_PROPERTY_SOCIAL_STATUS, status.getStatus());
        userService.saveUser(user, null);
    }

    @Override
    public List<SocialStatus> getStatusUpdates() {
        List<SocialStatus> ret = new ArrayList<SocialStatus>();
        for (User user : userService.getAllUsers()) {
            String status = user.getUserProperty(USER_PROPERTY_SOCIAL_STATUS);
            if (StringUtils.isNotEmpty(status)) {
                SocialStatus socialStatus = new SocialStatus(user, status);
                ret.add(socialStatus);
            }
        }
        return ret;
    }
}