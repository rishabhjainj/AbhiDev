package com.wireout.events;

import com.wireout.models.Event;
import com.wireout.viewactions.BaseViewAction;

import java.util.List;

public interface EventsViewAction extends BaseViewAction {
    public void setEventsRecyclerView(List<Event> events);
}
