import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;



public class Fabricator {

    private int length;
    private String[] emails = new String[2];
    private String[] firstNames1 = new String[2];
    private String[] firstNames2 = new String[2];
    private String[] lastNames = new String[2];
    private String university = new String();
    private String address[];
    private String duration[];
    private String locations[];
    private String[] race = {"b","w","h","a"};
    private String[] gender = {"m","f"};
    private String selecter;
    private String skillsSection[];

    private String[] numbers = {
            "479-437-9394",
            "479-274-8883"};

    private String[] major= {
            "Business Administration",
            "Marketing",
            "Finance",
            "Supply Chain Management",
    };

    private Resume[] jobApplicants = new Resume[2];



    public Fabricator(String university) throws IOException {

        String race = new String();
        String gender = new String();
        String uniID = "";

        Random r = new Random();
        int jobseed =  Math.abs((r.nextInt() % 15));
        if (jobseed <= 0)
        {
            jobseed = 1;
        }
        race = this.race[Math.abs((r.nextInt()) % 4)];
        jobApplicants[0] = new Resume(race, false);
        jobApplicants[1] = new Resume(race, true);
        gender = this.gender[(Math.abs(jobseed % 2))];
        this.university = university;
        Reader countries = new Reader("variables/countries.txt");
        if (this.university.substring(0,3).equals("the"))
        {
            uniID = this.university.substring( this.university.length() - 3 ,this.university.length());
        }
        else
        {
            uniID = university.substring(0,3);
        }

        File path = new File("Resources/jobs/" + uniID + "jobs" + 0 + ".txt");
        while(path.exists())
        {
            length++;
            path = new File("Resources/jobs/" + uniID + "jobs" + (length + 1) + ".txt");
            System.out.println(length);
        }
        length++;

        Reader job1 = new Reader("jobs/" + uniID + "jobs" + (jobseed % length) + ".txt" );
        Reader job2= new Reader("jobs/" + uniID + "jobs"  + ((jobseed + 1) % length) + ".txt" );
        Reader job3 = new Reader("jobs/" + uniID + "jobs"+ ((jobseed + 2) % length) +".txt" );
        Reader job4 = new Reader("jobs/" + uniID + "jobs"+ ((jobseed + 3) % length) + ".txt" );
        Reader durations = new Reader("variables/durations.txt");
        Reader emails = new Reader("emails/" + race + "email.txt");
        Reader addresses = new Reader( "schools/" + uniID + ".txt");
        Reader skills = new Reader("skills/skills.txt");

        this.skillsSection = skills.randomizer();
        this.locations = countries.randomizer();
        this.duration = durations.randomizer();
        this.emails = emails.randomizer();
        this.lastNames[0] = (this.emails[0].subSequence(2, this.emails[0].length() - 16)).toString();
        this.lastNames[1] = (this.emails[1].subSequence(2, this.emails[1].length() - 16)).toString();

        Reader firstNames1 = new Reader("names/" + gender + this.emails[0].charAt(0) + race + "names.txt");
        Reader firstNames2 = new Reader("names/" + gender + this.emails[1].charAt(0) + race + "names.txt");


        this.firstNames1 = firstNames1.randomizer();
        this.firstNames2 = firstNames2.randomizer();
        this.address = addresses.randomizer();

        jobApplicants[0].setFirstName(this.firstNames1[0]);
        jobApplicants[1].setFirstName(this.firstNames2[0]);



        for (int i = 0; i <= 1; i++) {

            if (this.lastNames[i].equals("obinson"))
            {
                this.lastNames[i] = "robinson";
            }

            jobApplicants[i].setLastName(this.lastNames[i]);
            jobApplicants[i].setEmail(this.emails[i]);
            jobApplicants[i].setNumber(this.numbers[i]);
            jobApplicants[i].setAddress(address[i]);
            jobApplicants[i].setSkills(skillsSection[i]);
        }

        String edu = new String("Graduated with a B.S. in " + major[jobseed % 4] + " " + this.university);
        jobApplicants[1].setEducation("Graduated from " + this.university + " with a Bachelor's degree in " + major[jobseed % 4]);
        jobApplicants[0].setEducation(edu + "\n" + "Studied abroad at " + locations[0] + " " + duration[0]);
        jobApplicants[0].setWorkExp(job1.toParagraph());
        jobApplicants[1].setWorkExp(job3.toParagraph());



    }

    public String printResult() throws IOException{
        jobApplicants[0].print("");
        jobApplicants[1].print("n");
        return (jobApplicants[0].toString() + jobApplicants[1].toString());
    }

}