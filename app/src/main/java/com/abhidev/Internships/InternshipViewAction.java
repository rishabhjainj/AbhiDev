package com.abhidev.Internships;

import com.abhidev.models.Internships;
import com.abhidev.viewactions.BaseViewAction;

import java.util.List;

public interface InternshipViewAction extends BaseViewAction {
    public void clearRecyclerView();
    public void initUi(Internships internships);
    public void setInternshipRecyclerView(List<Internships> internships);
}
