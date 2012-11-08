package org.openmrs.module.social.fragment.controller;

import org.openmrs.module.social.SocialStatus;
import org.openmrs.module.social.api.SocialService;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.BindParams;
import org.openmrs.ui.framework.annotation.SpringBean;

import java.util.List;

/**
 *
 */
public class StatusUpdateFragmentController {

    public void controller() {
    }

    public SimpleObject postStatusUpdate(@SpringBean SocialService service,
                                         UiUtils ui,
                                         @BindParams SocialStatus status) {
        service.postStatusUpdate(status);
        return SimpleObject.fromObject(status, ui, "user.username", "user.person.personName", "status");
    }

    public List<SimpleObject> getStatusUpdates(@SpringBean SocialService service,
                                               UiUtils ui) {
        List<SocialStatus> updates = service.getStatusUpdates();
        return SimpleObject.fromCollection(updates, ui, "user.username", "user.person.personName", "status");
    }

}
