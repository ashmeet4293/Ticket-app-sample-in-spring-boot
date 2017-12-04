package com.ticket.TicketApplication.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ticket_Data")
public class TicketEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TICKET_ID")
    private Integer ticketId;

    @Column(name = "TICKET_TYPE")
    private String ticketType;

    @Column(name = "ASSIGNED_TO")
    private String assignedTo;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "FOLLOWED_UP_BY")
    private String followedUpBy;

    @Column(name = "REVIEWED_BY")
    private String reviewedBy;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "IS_ACTIVE")
    private String isActive;

    @Column(name = "CREATED_DATE")
    private String createdDate;

    @Column(name = "TIME_TO_COMPLETE")
    private Date timeToComplete;

    public TicketEntity() {
    }

    public TicketEntity(String ticketType, String assignedTo, String notes, String followedUpBy,
                        String reviewedBy, String createdBy, String isActive, String createdDate, Date timeToComplete) {
        this.ticketType = ticketType;
        this.assignedTo = assignedTo;
        this.notes = notes;
        this.followedUpBy = followedUpBy;
        this.reviewedBy = reviewedBy;
        this.createdBy = createdBy;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.timeToComplete = timeToComplete;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFollowedUpBy() {
        return followedUpBy;
    }

    public void setFollowedUpBy(String followedUpBy) {
        this.followedUpBy = followedUpBy;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Date getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Date timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
}