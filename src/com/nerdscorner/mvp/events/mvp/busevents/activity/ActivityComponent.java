package com.nerdscorner.mvp.events.mvp.busevents.activity;

import com.nerdscorner.mvp.events.mvp.busevents.base.MvpComponent;

import java.io.File;

public class ActivityComponent extends MvpComponent {
    public static final String PACKAGE_SUFFIX = ".ui.activities";
    public static final String ACTIVITY_SUFFIX = "Activity";

    private static final String ACTIVITY_TEMPLATE = "/templates/busevents/activity_template";
    private static final String ACTIVITY_JAVA = "Activity.java";

    private static final String RELATIVE_PATH = File.separator + "ui" + File.separator + "activities";

    public ActivityComponent(String basePath, String basePackage, String screenName) {
        super(basePath, basePackage, screenName, ACTIVITY_TEMPLATE, screenName + ACTIVITY_JAVA);
    }

    @Override
    protected String relativePath() {
        return RELATIVE_PATH;
    }
}
