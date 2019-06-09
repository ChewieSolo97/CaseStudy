package com.example.CaseStudy.Model;

import java.util.List;

public class RaceStandings {

    private String id;

    private String name;

    private String status;

    private String condition;

    private int number;

    private int distance;

    private int laps;

    private int actual_distance;

    private boolean chase_race;

    private int purse;

    private int laps_completed;

    private double avg_speed;

    private String victory_margin;

    private String elapsed_time;

    private int lead_changes;

    private String cautions;

    private int caution_laps;

    private String scheduled;

    private String start_time;

    private String end_time;

    private Track track;

    private String comments;

    private List<Flags> flags;

    private List<Results> results;

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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public int getLaps() {
        return this.laps;
    }

    public void setActual_distance(int actual_distance) {
        this.actual_distance = actual_distance;
    }

    public int getActual_distance() {
        return this.actual_distance;
    }

    public void setChase_race(boolean chase_race) {
        this.chase_race = chase_race;
    }

    public boolean getChase_race() {
        return this.chase_race;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public int getPurse() {
        return this.purse;
    }

    public void setLaps_completed(int laps_completed) {
        this.laps_completed = laps_completed;
    }

    public int getLaps_completed() {
        return this.laps_completed;
    }

    public void setAvg_speed(double avg_speed) {
        this.avg_speed = avg_speed;
    }

    public double getAvg_speed() {
        return this.avg_speed;
    }

    public void setVictory_margin(String victory_margin) {
        this.victory_margin = victory_margin;
    }

    public String getVictory_margin() {
        return this.victory_margin;
    }

    public void setElapsed_time(String elapsed_time) {
        this.elapsed_time = elapsed_time;
    }

    public String getElapsed_time() {
        return this.elapsed_time;
    }

    public void setLead_changes(int lead_changes) {
        this.lead_changes = lead_changes;
    }

    public int getLead_changes() {
        return this.lead_changes;
    }

    public void setCautions(String cautions) {
        this.cautions = cautions;
    }

    public String getCautions() {
        return this.cautions;
    }

    public void setCaution_laps(int caution_laps) {
        this.caution_laps = caution_laps;
    }

    public int getCaution_laps() {
        return this.caution_laps;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public String getScheduled() {
        return this.scheduled;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStart_time() {
        return this.start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getEnd_time() {
        return this.end_time;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Track getTrack() {
        return this.track;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return this.comments;
    }

    public void setFlags(List<Flags> flags) {
        this.flags = flags;
    }

    public List<Flags> getFlags() {
        return this.flags;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public List<Results> getResults() {
        return this.results;
    }


    public class Track {
        private String name;

        private double distance;

        private String shape;

        private String banking;

        private int frontstretch;

        private int backstretch;

        private int seating;

        private String id;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public double getDistance() {
            return this.distance;
        }

        public void setShape(String shape) {
            this.shape = shape;
        }

        public String getShape() {
            return this.shape;
        }

        public void setBanking(String banking) {
            this.banking = banking;
        }

        public String getBanking() {
            return this.banking;
        }

        public void setFrontstretch(int frontstretch) {
            this.frontstretch = frontstretch;
        }

        public int getFrontstretch() {
            return this.frontstretch;
        }

        public void setBackstretch(int backstretch) {
            this.backstretch = backstretch;
        }

        public int getBackstretch() {
            return this.backstretch;
        }

        public void setSeating(int seating) {
            this.seating = seating;
        }

        public int getSeating() {
            return this.seating;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }
    }


    public class Flags {
        private int sequence;

        private int lap;

        private String flag_state;

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public int getSequence() {
            return this.sequence;
        }

        public void setLap(int lap) {
            this.lap = lap;
        }

        public int getLap() {
            return this.lap;
        }

        public void setFlag_state(String flag_state) {
            this.flag_state = flag_state;
        }

        public String getFlag_state() {
            return this.flag_state;
        }
    }


    public class Pit_stops {
        private int sequence;

        private int lap;

        private int leader_lap;

        private int positions_gained;

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public int getSequence() {
            return this.sequence;
        }

        public void setLap(int lap) {
            this.lap = lap;
        }

        public int getLap() {
            return this.lap;
        }

        public void setLeader_lap(int leader_lap) {
            this.leader_lap = leader_lap;
        }

        public int getLeader_lap() {
            return this.leader_lap;
        }

        public void setPositions_gained(int positions_gained) {
            this.positions_gained = positions_gained;
        }

        public int getPositions_gained() {
            return this.positions_gained;
        }
    }


    public class Manufacturer {
        private String id;

        private String name;

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


    public class Owner {
        private String id;

        private String name;

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


    public class Team {
        private String id;

        private String name;

        private Owner owner;

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

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public Owner getOwner() {
            return this.owner;
        }
    }


    public class Car {
        private String number;

        private String sponsors;

        private String crew_chief;

        private String id;

        private Manufacturer manufacturer;

        private Owner owner;

        private Team team;

        public void setNumber(String number) {
            this.number = number;
        }

        public String getNumber() {
            return this.number;
        }

        public void setSponsors(String sponsors) {
            this.sponsors = sponsors;
        }

        public String getSponsors() {
            return this.sponsors;
        }

        public void setCrew_chief(String crew_chief) {
            this.crew_chief = crew_chief;
        }

        public String getCrew_chief() {
            return this.crew_chief;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public void setManufacturer(Manufacturer manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Manufacturer getManufacturer() {
            return this.manufacturer;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public Owner getOwner() {
            return this.owner;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public Team getTeam() {
            return this.team;
        }
    }


    public class Driver {
        private String first_name;

        private String last_name;

        private String full_name;

        private boolean points_eligible;

        private boolean in_chase;

        private String id;

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

        public void setPoints_eligible(boolean points_eligible) {
            this.points_eligible = points_eligible;
        }

        public boolean getPoints_eligible() {
            return this.points_eligible;
        }

        public void setIn_chase(boolean in_chase) {
            this.in_chase = in_chase;
        }

        public boolean getIn_chase() {
            return this.in_chase;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }
    }


    public class Leads {
        private int sequence;

        private int start_lap;

        private int end_lap;

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public int getSequence() {
            return this.sequence;
        }

        public void setStart_lap(int start_lap) {
            this.start_lap = start_lap;
        }

        public int getStart_lap() {
            return this.start_lap;
        }

        public void setEnd_lap(int end_lap) {
            this.end_lap = end_lap;
        }

        public int getEnd_lap() {
            return this.end_lap;
        }
    }


    public class Results {
        private int start_position;

        private int position;

        private String status;

        private double driver_rating;

        private List<Pit_stops> pit_stops;

        private int best_lap;

        private double best_lap_speed;

        private double best_lap_time;

        private double elapsed_time;

        private int fastest_laps;

        private double avg_position;

        private double avg_speed;

        private int passes_made;

        private int quality_passes;

        private int times_passed;

        private int passing_differential;

        private int points;

        private int bonus_points;

        private int penalty_points;

        private int money;

        private int laps_led;

        private int times_led;

        private int laps_completed;

        private Car car;

        private Driver driver;

        private List<Leads> leads;

        public void setStart_position(int start_position) {
            this.start_position = start_position;
        }

        public int getStart_position() {
            return this.start_position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getPosition() {
            return this.position;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return this.status;
        }

        public void setDriver_rating(double driver_rating) {
            this.driver_rating = driver_rating;
        }

        public double getDriver_rating() {
            return this.driver_rating;
        }

        public void setPit_stops(List<Pit_stops> pit_stops) {
            this.pit_stops = pit_stops;
        }

        public List<Pit_stops> getPit_stops() {
            return this.pit_stops;
        }

        public void setBest_lap(int best_lap) {
            this.best_lap = best_lap;
        }

        public int getBest_lap() {
            return this.best_lap;
        }

        public void setBest_lap_speed(double best_lap_speed) {
            this.best_lap_speed = best_lap_speed;
        }

        public double getBest_lap_speed() {
            return this.best_lap_speed;
        }

        public void setBest_lap_time(double best_lap_time) {
            this.best_lap_time = best_lap_time;
        }

        public double getBest_lap_time() {
            return this.best_lap_time;
        }

        public void setElapsed_time(double elapsed_time) {
            this.elapsed_time = elapsed_time;
        }

        public double getElapsed_time() {
            return this.elapsed_time;
        }

        public void setFastest_laps(int fastest_laps) {
            this.fastest_laps = fastest_laps;
        }

        public int getFastest_laps() {
            return this.fastest_laps;
        }

        public void setAvg_position(double avg_position) {
            this.avg_position = avg_position;
        }

        public double getAvg_position() {
            return this.avg_position;
        }

        public void setAvg_speed(double avg_speed) {
            this.avg_speed = avg_speed;
        }

        public double getAvg_speed() {
            return this.avg_speed;
        }

        public void setPasses_made(int passes_made) {
            this.passes_made = passes_made;
        }

        public int getPasses_made() {
            return this.passes_made;
        }

        public void setQuality_passes(int quality_passes) {
            this.quality_passes = quality_passes;
        }

        public int getQuality_passes() {
            return this.quality_passes;
        }

        public void setTimes_passed(int times_passed) {
            this.times_passed = times_passed;
        }

        public int getTimes_passed() {
            return this.times_passed;
        }

        public void setPassing_differential(int passing_differential) {
            this.passing_differential = passing_differential;
        }

        public int getPassing_differential() {
            return this.passing_differential;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getPoints() {
            return this.points;
        }

        public void setBonus_points(int bonus_points) {
            this.bonus_points = bonus_points;
        }

        public int getBonus_points() {
            return this.bonus_points;
        }

        public void setPenalty_points(int penalty_points) {
            this.penalty_points = penalty_points;
        }

        public int getPenalty_points() {
            return this.penalty_points;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getMoney() {
            return this.money;
        }

        public void setLaps_led(int laps_led) {
            this.laps_led = laps_led;
        }

        public int getLaps_led() {
            return this.laps_led;
        }

        public void setTimes_led(int times_led) {
            this.times_led = times_led;
        }

        public int getTimes_led() {
            return this.times_led;
        }

        public void setLaps_completed(int laps_completed) {
            this.laps_completed = laps_completed;
        }

        public int getLaps_completed() {
            return this.laps_completed;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public Car getCar() {
            return this.car;
        }

        public void setDriver(Driver driver) {
            this.driver = driver;
        }

        public Driver getDriver() {
            return this.driver;
        }

        public void setLeads(List<Leads> leads) {
            this.leads = leads;
        }

        public List<Leads> getLeads() {
            return this.leads;
        }
    }

}
