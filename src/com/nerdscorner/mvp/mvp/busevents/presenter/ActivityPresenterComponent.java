package com.nerdscorner.mvp.mvp.busevents.presenter;

import com.nerdscorner.mvp.mvp.busevents.base.MvpComponent;

import java.io.File;

public class ActivityPresenterComponent extends MvpComponent {
    private static final String PRESENTER_TEMPLATE = "/templates/busevents/activity_presenter_template";
    private static final String PRESENTER_JAVA = "Presenter.java";

    private static final String RELATIVE_PATH = File.separator + "ui" + File.separator + "mvp" + File.separator + "presenter";

    public ActivityPresenterComponent(String basePath, String basePackage, String screenName) {
        super(basePath, basePackage, screenName, PRESENTER_TEMPLATE, screenName + PRESENTER_JAVA);
    }

    @Override
    protected String relativePath() {
        return RELATIVE_PATH;
    }
}
