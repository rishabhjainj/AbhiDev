package com.abhidev.events;

import com.abhidev.models.Event;
import com.abhidev.viewactions.BaseViewAction;

import java.util.List;

public interface EventsViewAction extends BaseViewAction {
    public void setEventsRecyclerView(List<Event> events);
}
