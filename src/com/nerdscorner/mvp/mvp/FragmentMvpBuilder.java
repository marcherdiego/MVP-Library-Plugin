package com.nerdscorner.mvp.mvp;

import com.intellij.openapi.vfs.VirtualFile;
import com.nerdscorner.mvp.mvp.busevents.fragment.FragmentComponent;
import com.nerdscorner.mvp.mvp.busevents.model.ModelComponent;
import com.nerdscorner.mvp.mvp.busevents.presenter.FragmentPresenterComponent;
import com.nerdscorner.mvp.mvp.busevents.view.FragmentViewComponent;
import com.nerdscorner.mvp.utils.GradleUtils;


import static com.nerdscorner.mvp.utils.GradleUtils.MVP_LIB_EVENTS_DEPENDENCY;

public class FragmentMvpBuilder extends MvpBuilder {

    public FragmentMvpBuilder(boolean shouldIncludeLibraryDependency, boolean isJava) {
        super(shouldIncludeLibraryDependency, isJava);
    }

    @Override
    public boolean build(VirtualFile rootFolder, String fullPath, String packageName, String screenName, boolean isExistingScreen) {
        FragmentComponent fragmentComponent = new FragmentComponent(fullPath, packageName, screenName);
        ModelComponent modelComponent = new ModelComponent(fullPath, packageName, screenName);
        FragmentViewComponent fragmentViewComponent = new FragmentViewComponent(fullPath, packageName, screenName);
        FragmentPresenterComponent fragmentPresenterComponent = new FragmentPresenterComponent(fullPath, packageName, screenName);
        boolean success = !isExistingScreen && fragmentComponent.build(isJava);
        success = success && modelComponent.build(isJava)
                && fragmentViewComponent.build(isJava)
                && fragmentPresenterComponent.build(isJava);
        success = updateGradle(rootFolder, success);
        checkSuccessOrRollback(rootFolder, success, fragmentComponent, modelComponent, fragmentViewComponent, fragmentPresenterComponent);
        return success;
    }

    private boolean updateGradle(VirtualFile rootFolder, boolean success) {
        if (shouldIncludeLibraryDependency) {
            savedGradleFile = GradleUtils.getGradleFileContent(rootFolder);
            success = success && GradleUtils.addDependency(rootFolder, MVP_LIB_EVENTS_DEPENDENCY);
        }
        return success;
    }

    private void checkSuccessOrRollback(VirtualFile rootFolder, boolean success, BaseComponent activityComponent,
                                        BaseComponent modelComponent, BaseComponent viewComponent, BaseComponent presenterComponent) {
        if (!success) {
            activityComponent.rollback();
            modelComponent.rollback();
            viewComponent.rollback();
            presenterComponent.rollback();
            GradleUtils.restoreGradleFile(savedGradleFile, rootFolder);
        }
    }
}

