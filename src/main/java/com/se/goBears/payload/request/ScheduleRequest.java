package com.se.goBears.payload.request;



import java.util.List;


/**
 * This class handles the schedule request from a user and gets all the schedule.
 */
public class ScheduleRequest {

    /**
     * This variable defines the room id.
     */
    private Long roomId;

    /**
     * This variable defines the frequency for the schedule.
     */
    private Frequency selectedFrequency;

    /**
     * This variable defines the custom days for the schedule.
     */
    private List<Custom> custom;


    /**
     * This enum class defines the custom frequency values.
     */
    public enum Frequency {
        Once, Repeat, Custom
    }

    /**
     * This enum class defines the custom days values.
     */
    public enum Custom {
        M, T, W, TR, F
    }

    /**
     * This variable defines the user selected start time for the schedule.
     */
    private String selectedFromTime;

    /**
     * This variable defines the user selected end time for a schedule.
     */
    private String selectedToTime;
    /**
     * This variable defines the user selected start date for a schedule.
     */
    private String selectedFromDate;

    /**
     * This variable defines the user selected end date for a schedule.
     */
    private String selectedToDate;
    /**
     * This variable defines a name for the schedule.
     */
    private String name;

    /**
     * This method returns the user selected start date.
     *
     * @return selected start date.
     */
    public String getSelectedFromDate() {
        return selectedFromDate;
    }

    /**
     * This method sets the user selected started date.
     *
     * @param selectedFromDate is the selected start date.
     */
    public void setSelectedFromDate(String selectedFromDate) {
        this.selectedFromDate = selectedFromDate;
    }

    /**
     * This method returns the user selected end date.
     *
     * @return the selected end date.
     */
    public String getSelectedToDate() {
        return selectedToDate;
    }

    /**
     * This method sets the user selected end date.
     *
     * @param selectedToDate is the selected end date
     */
    public void setSelectedToDate(String selectedToDate) {
        this.selectedToDate = selectedToDate;
    }

    /**
     * This method returns the room id.
     *
     * @return the room id.
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * THis method sets the room id.
     *
     * @param roomId is the room id.
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * This method returns the frequency of the schedule.
     *
     * @return the frequency value.
     */
    public Frequency getSelectedFrequency() {
        return selectedFrequency;
    }

    /**
     * This method sets the frequency value.
     *
     * @param selectedFrequency is the frequency to be set.
     */
    public void setSelectedFrequency(Frequency selectedFrequency) {
        this.selectedFrequency = selectedFrequency;
    }

    /**
     * This method returns a list of selected custom values for days.
     *
     * @return a list of custom values
     */
    public List<Custom> getCustom() {
        return custom;
    }

    /**
     * This method sets the custom values for the schedule.
     *
     * @param custom is the custom values to be set.
     */
    public void setCustom(List<Custom> custom) {
        this.custom = custom;
    }

    /**
     * This method returns the user selected time.
     *
     * @return user selected time.
     */
    public String getSelectedFromTime() {
        return selectedFromTime;
    }

    /**
     * This method sets the start time selected by the user.
     *
     * @param selectedFromTime selected start time to be set.
     */
    public void setSelectedFromTime(String selectedFromTime) {
        this.selectedFromTime = selectedFromTime;
    }

    /**
     * This method returns the selected end time.
     *
     * @return the selected end time.
     */
    public String getSelectedToTime() {
        return selectedToTime;
    }

    /**
     * This method set the selected time for the schedule.
     *
     * @param selectedToTime selected time to be set.
     */
    public void setSelectedToTime(String selectedToTime) {
        this.selectedToTime = selectedToTime;
    }

    /**
     * This method returns the schedule name.
     *
     * @return name of the schedule.
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name for the schedule.
     *
     * @param name is the name of the schedule.
     */
    public void setName(String name) {
        this.name = name;
    }
}
