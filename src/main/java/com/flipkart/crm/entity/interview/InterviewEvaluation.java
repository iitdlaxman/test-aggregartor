package com.flipkart.crm.entity.interview;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 17/07/17.
 */
@Entity
@Table(name="Interview")
public class InterviewEvaluation {

    @Id
    private String interviewId;

    private String candidateComments;

    private String interviewerComments;

    private int candidateRating;

    private int interviewerRating;

    public InterviewEvaluation() {
    }

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId;
    }

    public String getCandidateComments() {
        return candidateComments;
    }

    public void setCandidateComments(String candidateComments) {
        this.candidateComments = candidateComments;
    }

    public String getInterviewerComments() {
        return interviewerComments;
    }

    public void setInterviewerComments(String interviewerComments) {
        this.interviewerComments = interviewerComments;
    }

    public int getCandidateRating() {
        return candidateRating;
    }

    public void setCandidateRating(int candidateRating) {
        this.candidateRating = candidateRating;
    }

    public int getInterviewerRating() {
        return interviewerRating;
    }

    public void setInterviewerRating(int interviewerRating) {
        this.interviewerRating = interviewerRating;
    }
}
