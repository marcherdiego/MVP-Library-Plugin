package com.nerdscorner.mvp.domain.manifest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Application {
    private Activity[] activity;

    public Activity[] getActivity() {
        return activity;
    }

    @XmlElement
    public void setActivity(Activity[] activity) {
        this.activity = activity;
    }
}
