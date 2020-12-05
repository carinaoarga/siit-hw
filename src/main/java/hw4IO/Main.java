package hw4IO;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/hw4IO/results.csv"))) {
            String [] nextAthlete;
            List<Athlete> athleteList = new ArrayList<Athlete>();
            while ((nextAthlete = reader.readNext()) != null){
                athleteList.add(new Athlete(Integer.parseInt(nextAthlete[0]), nextAthlete[1], nextAthlete[2], nextAthlete[3], nextAthlete[4], nextAthlete[5], nextAthlete[6]));
            }

            Collections.sort(athleteList);

            Athlete winner = athleteList.get(0);
            Athlete runnerUp = athleteList.get(1);
            Athlete thirdPlace = athleteList.get(2);

            System.out.println("Winner - "+winner.getAthleteName()+" "+winner.getTotalDurationString()+" ("+winner.getSkiTimeResult()+" "+winner.getPenalties()*10+")");
            System.out.println("Runner Up - "+runnerUp.getAthleteName()+" "+runnerUp.getTotalDurationString()+" ("+runnerUp.getSkiTimeResult()+" "+runnerUp.getPenalties()*10+")");
            System.out.println("Third Place - "+thirdPlace.getAthleteName()+" "+thirdPlace.getTotalDurationString()+" ("+thirdPlace.getSkiTimeResult()+" "+thirdPlace.getPenalties()*10+")");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
