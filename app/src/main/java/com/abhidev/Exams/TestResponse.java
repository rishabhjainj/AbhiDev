package com.abhidev.Exams;

import com.abhidev.apiservices.Repository;
import com.abhidev.common.EntityLoader;
import com.abhidev.listeners.OnEntityReceivedListener;

import java.io.Serializable;
import java.util.List;

public class TestResponse implements Serializable
{

    private Integer test;
    private String classCode;
    private List<QuestionResponse> questionResponses;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public List<QuestionResponse> getQuestionResponses() {
        return questionResponses;
    }

    public void setQuestionResponses(List<QuestionResponse> questionResponses) {
        this.questionResponses = questionResponses;
    }
    public void submit(OnEntityReceivedListener<TestResponse> listener){
        Repository repository = new Repository();
        repository.postTestResponse(this,new EntityLoader(listener));
    }

}