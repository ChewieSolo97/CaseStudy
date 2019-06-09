package com.example.CaseStudy.Model;

import java.util.List;

public class DriverStatistics {

    private Series series;

    private Season season;

    private List<Drivers> drivers;

    public void setSeries(Series series) {
        this.series = series;
    }

    public Series getSeries() {
        return this.series;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Season getSeason() {
        return this.season;
    }

    public void setDrivers(List<Drivers> drivers) {
        this.drivers = drivers;
    }

    public List<Drivers> getDrivers() {
        return this.drivers;
    }

    public class Series {
        private String id;

        private String alias;

        private String name;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getAlias() {
            return this.alias;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }


    public class Season {
        private String id;

        private int year;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getYear() {
            return this.year;
        }
    }

    public class Track_type_splits {
        private int starts;

        private int wins;

        private int top_5;

        private int top_10;

        private int poles;

        private int dnf;

        private int running_at_finish;

        private int lead_lap_finish;

        private int laps_completed;

        private int laps_led;

        private int money;

        private double avg_start_position;

        private double avg_finish_position;

        private double miles_completed;

        private String track_type;

        public void setStarts(int starts) {
            this.starts = starts;
        }

        public int getStarts() {
            return this.starts;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getWins() {
            return this.wins;
        }

        public void setTop_5(int top_5) {
            this.top_5 = top_5;
        }

        public int getTop_5() {
            return this.top_5;
        }

        public void setTop_10(int top_10) {
            this.top_10 = top_10;
        }

        public int getTop_10() {
            return this.top_10;
        }

        public void setPoles(int poles) {
            this.poles = poles;
        }

        public int getPoles() {
            return this.poles;
        }

        public void setDnf(int dnf) {
            this.dnf = dnf;
        }

        public int getDnf() {
            return this.dnf;
        }

        public void setRunning_at_finish(int running_at_finish) {
            this.running_at_finish = running_at_finish;
        }

        public int getRunning_at_finish() {
            return this.running_at_finish;
        }

        public void setLead_lap_finish(int lead_lap_finish) {
            this.lead_lap_finish = lead_lap_finish;
        }

        public int getLead_lap_finish() {
            return this.lead_lap_finish;
        }

        public void setLaps_completed(int laps_completed) {
            this.laps_completed = laps_completed;
        }

        public int getLaps_completed() {
            return this.laps_completed;
        }

        public void setLaps_led(int laps_led) {
            this.laps_led = laps_led;
        }

        public int getLaps_led() {
            return this.laps_led;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getMoney() {
            return this.money;
        }

        public void setAvg_start_position(double avg_start_position) {
            this.avg_start_position = avg_start_position;
        }

        public double getAvg_start_position() {
            return this.avg_start_position;
        }

        public void setAvg_finish_position(double avg_finish_position) {
            this.avg_finish_position = avg_finish_position;
        }

        public double getAvg_finish_position() {
            return this.avg_finish_position;
        }

        public void setMiles_completed(double miles_completed) {
            this.miles_completed = miles_completed;
        }

        public double getMiles_completed() {
            return this.miles_completed;
        }

        public void setTrack_type(String track_type) {
            this.track_type = track_type;
        }

        public String getTrack_type() {
            return this.track_type;
        }
    }


    public class Track_splits {
        private int starts;

        private int wins;

        private int top_5;

        private int top_10;

        private int poles;

        private int dnf;

        private int running_at_finish;

        private int lead_lap_finish;

        private int laps_completed;

        private int laps_led;

        private int money;

        private double avg_start_position;

        private double avg_finish_position;

        private double miles_completed;

        private String id;

        private String name;

        public void setStarts(int starts) {
            this.starts = starts;
        }

        public int getStarts() {
            return this.starts;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getWins() {
            return this.wins;
        }

        public void setTop_5(int top_5) {
            this.top_5 = top_5;
        }

        public int getTop_5() {
            return this.top_5;
        }

        public void setTop_10(int top_10) {
            this.top_10 = top_10;
        }

        public int getTop_10() {
            return this.top_10;
        }

        public void setPoles(int poles) {
            this.poles = poles;
        }

        public int getPoles() {
            return this.poles;
        }

        public void setDnf(int dnf) {
            this.dnf = dnf;
        }

        public int getDnf() {
            return this.dnf;
        }

        public void setRunning_at_finish(int running_at_finish) {
            this.running_at_finish = running_at_finish;
        }

        public int getRunning_at_finish() {
            return this.running_at_finish;
        }

        public void setLead_lap_finish(int lead_lap_finish) {
            this.lead_lap_finish = lead_lap_finish;
        }

        public int getLead_lap_finish() {
            return this.lead_lap_finish;
        }

        public void setLaps_completed(int laps_completed) {
            this.laps_completed = laps_completed;
        }

        public int getLaps_completed() {
            return this.laps_completed;
        }

        public void setLaps_led(int laps_led) {
            this.laps_led = laps_led;
        }

        public int getLaps_led() {
            return this.laps_led;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getMoney() {
            return this.money;
        }

        public void setAvg_start_position(double avg_start_position) {
            this.avg_start_position = avg_start_position;
        }

        public double getAvg_start_position() {
            return this.avg_start_position;
        }

        public void setAvg_finish_position(double avg_finish_position) {
            this.avg_finish_position = avg_finish_position;
        }

        public double getAvg_finish_position() {
            return this.avg_finish_position;
        }

        public void setMiles_completed(double miles_completed) {
            this.miles_completed = miles_completed;
        }

        public double getMiles_completed() {
            return this.miles_completed;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }


    public class Race_splits {
        private int starts;

        private int wins;

        private int top_5;

        private int top_10;

        private int poles;

        private int dnf;

        private int running_at_finish;

        private int lead_lap_finish;

        private int laps_completed;

        private int laps_led;

        private int money;

        private double avg_start_position;

        //private int avg_finish_position;

        //private int miles_completed;

        private String race_name;

        public void setStarts(int starts) {
            this.starts = starts;
        }

        public int getStarts() {
            return this.starts;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getWins() {
            return this.wins;
        }

        public void setTop_5(int top_5) {
            this.top_5 = top_5;
        }

        public int getTop_5() {
            return this.top_5;
        }

        public void setTop_10(int top_10) {
            this.top_10 = top_10;
        }

        public int getTop_10() {
            return this.top_10;
        }

        public void setPoles(int poles) {
            this.poles = poles;
        }

        public int getPoles() {
            return this.poles;
        }

        public void setDnf(int dnf) {
            this.dnf = dnf;
        }

        public int getDnf() {
            return this.dnf;
        }

        public void setRunning_at_finish(int running_at_finish) {
            this.running_at_finish = running_at_finish;
        }

        public int getRunning_at_finish() {
            return this.running_at_finish;
        }

        public void setLead_lap_finish(int lead_lap_finish) {
            this.lead_lap_finish = lead_lap_finish;
        }

        public int getLead_lap_finish() {
            return this.lead_lap_finish;
        }

        public void setLaps_completed(int laps_completed) {
            this.laps_completed = laps_completed;
        }

        public int getLaps_completed() {
            return this.laps_completed;
        }

        public void setLaps_led(int laps_led) {
            this.laps_led = laps_led;
        }

        public int getLaps_led() {
            return this.laps_led;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getMoney() {
            return this.money;
        }

        public void setAvg_start_position(double avg_start_position) {
            this.avg_start_position = avg_start_position;
        }

        public double getAvg_start_position() {
            return this.avg_start_position;
        }

//        public void setAvg_finish_position(int avg_finish_position) {
//            this.avg_finish_position = avg_finish_position;
//        }
//
//        public int getAvg_finish_position() {
//            return this.avg_finish_position;
//        }

//        public void setMiles_completed(int miles_completed) {
//            this.miles_completed = miles_completed;
//        }
//
//        public int getMiles_completed() {
//            return this.miles_completed;
//        }

        public void setRace_name(String race_name) {
            this.race_name = race_name;
        }

        public String getRace_name() {
            return this.race_name;
        }
    }

    public class Drivers {
        private String id;

        private String first_name;

        private String last_name;

        private String full_name;

        private String birthday;

        private int rookie_year;

        private String gender;

        private String status;

        private String country;

        private String residence;

        private String birth_place;

        private String twitter;

        private List<Track_type_splits> track_type_splits;

        private List<Track_splits> track_splits;

        private List<Race_splits> race_splits;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getFirst_name() {
            return this.first_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getLast_name() {
            return this.last_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getFull_name() {
            return this.full_name;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getBirthday() {
            return this.birthday;
        }

        public void setRookie_year(int rookie_year) {
            this.rookie_year = rookie_year;
        }

        public int getRookie_year() {
            return this.rookie_year;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return this.gender;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountry() {
            return this.country;
        }

        public void setResidence(String residence) {
            this.residence = residence;
        }

        public String getResidence() {
            return this.residence;
        }

        public void setBirth_place(String birth_place) {
            this.birth_place = birth_place;
        }

        public String getBirth_place() {
            return this.birth_place;
        }

        public void setTwitter(String twitter) {
            this.twitter = twitter;
        }

        public String getTwitter() {
            return this.twitter;
        }

        public void setTrack_type_splits(List<Track_type_splits> track_type_splits) {
            this.track_type_splits = track_type_splits;
        }

        public List<Track_type_splits> getTrack_type_splits() {
            return this.track_type_splits;
        }

        public void setTrack_splits(List<Track_splits> track_splits) {
            this.track_splits = track_splits;
        }

        public List<Track_splits> getTrack_splits() {
            return this.track_splits;
        }

        public void setRace_splits(List<Race_splits> race_splits) {
            this.race_splits = race_splits;
        }

        public List<Race_splits> getRace_splits() {
            return this.race_splits;
        }
    }

}
