package com.se.goBears.payload.request;

import com.se.goBears.entity.Room;

import java.util.List;

public class ScheduleRequest {

        private Long roomId;

        private Frequency selectedFrequency;

        private List<Custom> custom;

        public enum Frequency{
                Once,Repeat,Custom
        }
        public enum Custom{
                M,T,W,TR,F
        }
        private String selectedFromTime;
        private String selectedToTime;
        private String selectedFromDate;

        private String selectedToDate;
        private String name;

        public String getSelectedFromDate() {
                return selectedFromDate;
        }

        public void setSelectedFromDate(String selectedFromDate) {
                this.selectedFromDate = selectedFromDate;
        }

        public String getSelectedToDate() {
                return selectedToDate;
        }

        public void setSelectedToDate(String selectedToDate) {
                this.selectedToDate = selectedToDate;
        }

        public Long getRoomId() {
                return roomId;
        }

        public void setRoomId(Long roomId) {
                this.roomId = roomId;
        }

        public Frequency getSelectedFrequency() {
                return selectedFrequency;
        }

        public void setSelectedFrequency(Frequency selectedFrequency) {
                this.selectedFrequency = selectedFrequency;
        }

        public List<Custom> getCustom() {
                return custom;
        }

        public void setCustom(List<Custom> custom) {
                this.custom = custom;
        }

        public String getSelectedFromTime() {
                return selectedFromTime;
        }

        public void setSelectedFromTime(String selectedFromTime) {
                this.selectedFromTime = selectedFromTime;
        }

        public String getSelectedToTime() {
                return selectedToTime;
        }

        public void setSelectedToTime(String selectedToTime) {
                this.selectedToTime = selectedToTime;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
}
