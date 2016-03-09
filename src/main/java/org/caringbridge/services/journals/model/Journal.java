package org.caringbridge.services.journals.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="audit")
public class Journal {
    @Id
    @Field("_id")
    private String journalId;
    private String title;
    private String body;
    private int userId;
    private int siteId;
    private boolean isDeleted;
    private boolean isDraft;
    public String getJournalId() {
        return journalId;
    }
    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getSiteId() {
        return siteId;
    }
    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
    }
    public void setDeleted(String isDeleted) {
        this.isDeleted = ("1".equals(isDeleted));
    }
    public boolean isDraft() {
        return isDraft;
    }
    public void setDraft(boolean isDraft) {
	this.isDraft = isDraft;
    }
    public void setDraft(String isDraft) {
        this.isDraft = ("1".equals(isDraft));
    }

}
