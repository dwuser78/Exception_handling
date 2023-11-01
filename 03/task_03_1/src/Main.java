import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

public class Main {
    static final int MIN_NUM_PARAMS = 6;
    public static String[] get_data() throws Exception {
        String user_data_str;

        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter (separated by spaces) last name, " +
                             "first name, middle name, date of birth " +
                             "(dd.mm.yyyy), phone number, gender: ");

            user_data_str = reader.readLine();
        } catch (IOException e) {
            throw new Exception("I/O error");
        }

        String[] user_data_arr = user_data_str.split("\\s+");

        if (user_data_arr.length != MIN_NUM_PARAMS){
            throw new Exception("Incorrect number of parameters entered");
        }

        return user_data_arr;
    }

    public static Person parse_data(String[] user_data_arr) throws Exception {
        String first_name = "";
        String last_name = "";
        String middle_name = "";
        Date birth_date = null;
        int phone = 0;
        String gender = "";
        int param_num = MIN_NUM_PARAMS;
        SimpleDateFormat dob_fmt = new SimpleDateFormat("dd.mm.yyyy");

        for (String param_val: user_data_arr) {
            if (Pattern.matches("[А-Яа-яA-Za-z]{2,}", param_val)) {
                if (Objects.equals(last_name, "")) {
                    last_name = param_val;
                    param_num -= 1;
                } else if (Objects.equals(first_name, "")) {
                    first_name = param_val;
                    param_num -= 1;
                } else if (Objects.equals(middle_name, "")) {
                    middle_name = param_val;
                    param_num -= 1;
                }
            } else if (Pattern.matches("\\d{2}.\\d{2}.\\d{4}", param_val)) {
                try {
                    birth_date = dob_fmt.parse(param_val);
                    param_num -= 1;
                } catch (ParseException e) {
                    throw new ParseException("Invalid date of birth format",
                                             e.getErrorOffset());
                }
            } else if (Pattern.matches("\\d+", param_val)) {
                try {
                    phone = Integer.parseInt(param_val);
                    param_num -= 1;
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Invalid phone number " +
                                                    "format");
                }
            } else if (param_val.equalsIgnoreCase("m") ||
                       param_val.equalsIgnoreCase("f")) {
                gender = param_val;
                param_num -= 1;
            }
        }

        if (param_num != 0) {
            throw new Exception("Not all parameters have been handled");
        }

        return new Person(last_name, first_name, middle_name, birth_date,
                          phone, gender);
    }

    public static void save_file(Person new_person) throws IOException {
        String file_name = new_person.getLast_name() + ".txt";
        SimpleDateFormat dob_fmt = new SimpleDateFormat("dd.mm.yyyy");

        try (FileWriter writer = new FileWriter(file_name, true)) {
            writer.write(String.format("%s %s %s %s %s %s\n",
                                     new_person.getLast_name(),
                                     new_person.getFirst_name(),
                                     new_person.getMiddle_name(),
                                     dob_fmt.format(new_person.getBirth_date()),
                                     new_person.getPhone(),
                                     new_person.getGender()));
        } catch (IOException e) {
            throw new FileSystemException("Error writing to file: " +
                                          e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        String[] user_data_arr;
        Person new_person;

        try {
            user_data_arr = get_data();
            new_person = parse_data(user_data_arr);
            save_file(new_person);
        } catch (FileSystemException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}