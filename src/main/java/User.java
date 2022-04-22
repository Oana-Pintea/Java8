import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.concurrent.ConcurrentMap;

@Data
public class User  {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public User(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + dateOfBirth + "\n";
    }
}
