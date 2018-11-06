package com.nerdscorner.mvp.domain.manifest;

public class Fragment extends ScreenComponent {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public Fragment setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
