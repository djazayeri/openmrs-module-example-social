package org.openmrs.module.social.page.controller;

import org.openmrs.module.social.SocialStatus;
import org.openmrs.module.social.api.SocialService;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.BindParams;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;

import java.util.List;

/**
 *
 */
public class StatusesPageController {

    public void get(@SpringBean SocialService service,
                    PageModel pageModel) {
        List<SocialStatus> updates = service.getStatusUpdates();
        pageModel.put("statusUpdates", updates);
    }

    public String post(@SpringBean SocialService service,
                       @BindParams SocialStatus socialStatus,
                       UiUtils ui) {
        service.postStatusUpdate(socialStatus);
        return "redirect:" + ui.pageLink("social", "statuses");
    }

}
