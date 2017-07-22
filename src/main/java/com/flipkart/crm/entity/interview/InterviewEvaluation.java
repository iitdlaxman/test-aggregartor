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




}
