import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;

public class Resume {

   private static int ID = 0;
   private String firstName = "";
   private String lastName = "";
   private String number = "";
   private String address = "";
   private String email = "";
   private String degree ="";
   private String universityLocation;
   private String studyAbroadlocation;
   private String duration;
   private String workExp = "";
   private String education;
   private String extraCurriculars;
   private String skills;
   private String race;


    public Resume(String race, boolean increment)
    {
        this.race = race;
        if (increment == true)
        {
            ID++;
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
    }

    public void setLastName(String lastName) {

        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSkills(String skills)
    {
        this.skills = skills;
    }

    public void setWorkExp(String workExp) {

        this.workExp += "\n" + workExp;
    }

    public void setExtraCurriculars(String extraCurriculars)
    {
        this.extraCurriculars.concat(extraCurriculars);
    }

    public void setDegree(String degree){
        this.degree = degree;
    }




    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString() {

        return
                    firstName +
                " " + lastName +
                "\n" + number +
                "\n" + address +
                "\n" + email + "\n" +
                        "\nEducation: \n" +
                         education + "\n" +
                        "\nWork Experience:" + workExp + "\n"
                        + "\nSkills: \n \n" + skills + "\n";


    }

    public void setEducation(String education) {

        this.education = education;

    }

    public void print(String n) throws IOException
    {
        FileWriter writer = new FileWriter("Out/" + ID + this.race + n +"_CV.txt");
        PrintWriter printer = new PrintWriter(writer);
        printer.print(this.toString());
        printer.close();

    }
}


