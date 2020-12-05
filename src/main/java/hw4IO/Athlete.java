package hw4IO;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.*;

public class Athlete implements Comparable<Athlete>{
    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    public Athlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public Duration getDuration(){
        Duration d;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        String[] input = this.skiTimeResult.split(":");

        if (input.length == 2){
            minutes = Integer.parseInt(input[0]);
            seconds = Integer.parseInt(input[1]);
        }else if(input.length == 3){
            hours = Integer.parseInt(input[0]);
            minutes = Integer.parseInt(input[1]);
            seconds = Integer.parseInt(input[2]);
        } else {
            System.out.println("Invalid value for Ski Time Result!! [has to be hh:mm:ss or mm:ss]");
            return null;
        }

        d = Duration.ZERO.plus(hours, HOURS).plus(minutes, MINUTES).plus(seconds, SECONDS);
        return d;

    }

    public long getPenalties(){
        long penalties = firstShootingRange.toLowerCase().chars().filter(ch -> ch == 'o').count();
        penalties += secondShootingRange.toLowerCase().chars().filter(ch -> ch == 'o').count();
        penalties += thirdShootingRange.toLowerCase().chars().filter(ch -> ch == 'o').count();

        return penalties;
    }

    public Duration getTotalDuration(){
        return getDuration().plus(getPenalties()*10, SECONDS);
    }

    public String getTotalDurationString(){
        String duration = "";
        duration += String.valueOf(getTotalDuration().toHoursPart());
        duration += ":"+getTotalDuration().toMinutesPart();
        duration += ":"+ getTotalDuration().toSecondsPart();

        return duration;

    }

    @Override
    public int compareTo(Athlete a) {
        return this.getTotalDuration().compareTo(a.getTotalDuration());
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteNumber=" + athleteNumber +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResult='" + skiTimeResult + '\'' +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange + '\'' +
                ", Duration='" + getDuration() + '\'' +
                ", getPenalties='" + getPenalties() + '\'' +
                ", TotalDuration='" + getTotalDuration() + '\'' +
                '}';
    }
}
