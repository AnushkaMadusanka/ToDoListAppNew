package com.example.todolistappnew.data;

public class ToDoListItem {


    private int toDoListItemId;

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    private int goalId;
    private String toDoListItemName;
    private String toDoListItemDescription;
    private String toDoListItemBackgroundColor;
    private String toDoListItemMoreInfo;
    private String toDoListItemCreatedDate;
    private String toDoListItemLatUpdatedDate;
    private String toDoListItemPlanedAchievDate;
    private String toDoListItemAchievedDate;
    private String toDoListItemStatus;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ToDoListItem() {

    }

    public ToDoListItem(String toDoListItemName, String toDoListItemDescription, String toDoListItemCreatedDate, String toDoListItemLatUpdatedDate, String toDoListItemStatus, String toDoListItemPlanedAchievDate, int goalId) {
        this.toDoListItemName = toDoListItemName;
        this.toDoListItemDescription = toDoListItemDescription;
        this.toDoListItemCreatedDate = toDoListItemCreatedDate;
        this.toDoListItemLatUpdatedDate = toDoListItemLatUpdatedDate;
        this.toDoListItemPlanedAchievDate = toDoListItemPlanedAchievDate;

        this.toDoListItemStatus = toDoListItemStatus;
        this.goalId = goalId;
    }

    public ToDoListItem(int toDoListItemId, String toDoListItemName, String toDoListItemDescription, String toDoListItemCreatedDate, String toDoListItemPlanedAchievDate, String toDoListItemStatus, String toDoListItemLatUpdatedDate, int goalId) {
        this.toDoListItemId = toDoListItemId;
        this.toDoListItemName = toDoListItemName;
        this.toDoListItemDescription = toDoListItemDescription;
        this.toDoListItemCreatedDate = toDoListItemCreatedDate;
        this.toDoListItemLatUpdatedDate = toDoListItemLatUpdatedDate;
        this.toDoListItemPlanedAchievDate = toDoListItemPlanedAchievDate;
        this.toDoListItemStatus = toDoListItemStatus;
        this.goalId = goalId;
    }

    public int getToDoListItemId() {
        return toDoListItemId;
    }

    public void setToDoListItemId(int toDoListItemId) {
        this.toDoListItemId = toDoListItemId;
    }

    public String getToDoListItemName() {
        return toDoListItemName;
    }

    public void setToDoListItemName(String toDoListItemName) {
        this.toDoListItemName = toDoListItemName;
    }

    public String getToDoListItemDescription() {
        return toDoListItemDescription;
    }

    public void setToDoListItemDescription(String toDoListItemDescription) {
        this.toDoListItemDescription = toDoListItemDescription;
    }

    public String getToDoListItemBackgroundColor() {
        return toDoListItemBackgroundColor;
    }

    public void setToDoListItemBackgroundColor(String toDoListItemBackgroundColor) {
        this.toDoListItemBackgroundColor = toDoListItemBackgroundColor;
    }

    public String getToDoListItemMoreInfo() {
        return toDoListItemMoreInfo;
    }

    public void setToDoListItemMoreInfo(String toDoListItemMoreInfo) {
        this.toDoListItemMoreInfo = toDoListItemMoreInfo;
    }

    public String getToDoListItemCreatedDate() {
        return toDoListItemCreatedDate;
    }

    public void setToDoListItemCreatedDate(String toDoListItemCreatedDate) {
        this.toDoListItemCreatedDate = toDoListItemCreatedDate;
    }

    public String getToDoListItemLatUpdatedDate() {
        return toDoListItemLatUpdatedDate;
    }

    public void setToDoListItemLatUpdatedDate(String toDoListItemLatUpdatedDate) {
        this.toDoListItemLatUpdatedDate = toDoListItemLatUpdatedDate;
    }

    public String getToDoListItemPlanedAchievDate() {
        return toDoListItemPlanedAchievDate;
    }

    public void setToDoListItemPlanedAchievDate(String toDoListItemPlanedAchievDate) {
        this.toDoListItemPlanedAchievDate = toDoListItemPlanedAchievDate;
    }

    public String getToDoListItemAchievedDate() {
        return toDoListItemAchievedDate;
    }

    public void setToDoListItemAchievedDate(String toDoListItemAchievedDate) {
        this.toDoListItemAchievedDate = toDoListItemAchievedDate;
    }

    public String getToDoListItemStatus() {
        return toDoListItemStatus;
    }

    public void setToDoListItemStatus(String toDoListItemStatus) {
        this.toDoListItemStatus = toDoListItemStatus;
    }
}

