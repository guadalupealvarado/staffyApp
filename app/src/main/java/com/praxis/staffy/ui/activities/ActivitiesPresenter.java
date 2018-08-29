package com.praxis.staffy.ui.activities;

public class ActivitiesPresenter implements ActivitiesMvp.presenter {
    ActivitiesMvp.view view;
    public ActivitiesPresenter(ActivitiesMvp.view view)
    {
        this.view=view;
    }
}
