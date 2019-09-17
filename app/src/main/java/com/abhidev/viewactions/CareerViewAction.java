package com.abhidev.viewactions;

import com.abhidev.models.Career;
import com.abhidev.models.CareerList;

import java.util.List;

public interface CareerViewAction extends BaseViewAction {
    void initUi(Career career);
    void initUi(Career career,Boolean hide);
    void addToRecyclerView(List<CareerList> careers);
}
