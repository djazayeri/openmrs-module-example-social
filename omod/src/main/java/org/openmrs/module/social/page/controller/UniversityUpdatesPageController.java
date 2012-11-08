package org.openmrs.module.social.page.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.social.SocialStatus;
import org.openmrs.module.social.api.SocialService;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.BindParams;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;

/**
 *
 */
public class UniversityUpdatesPageController {

    public void get(PageModel pageModel,
                    @SpringBean SocialService service) {

        SocialStatus myStatus = null;
        for (SocialStatus candidate : service.getStatusUpdates()) {
            if (candidate.getUser().equals(Context.getAuthenticatedUser())) {
                myStatus = candidate;
            }
        }
        pageModel.addAttribute("myStatus", myStatus);
    }

    public String post(@SpringBean SocialService service,
                       @BindParams SocialStatus socialStatus,
                       UiUtils ui) {

        service.postStatusUpdate(socialStatus);
        return "redirect:" + ui.pageLink("social", "universityUpdates");
    }

}
