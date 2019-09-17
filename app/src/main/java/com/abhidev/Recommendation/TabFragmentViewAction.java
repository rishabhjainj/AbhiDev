package com.abhidev.Recommendation;



import com.abhidev.models.University;
import com.abhidev.viewactions.BaseViewAction;

import java.util.List;

/**
 * Created by Paras on 8/19/2017.
 */

public interface TabFragmentViewAction extends BaseViewAction{

    public void startAnalysisNotDone();
    void confirmVisible();
    public void setUniversitiesRecyclerView(List<University> universities);

}
