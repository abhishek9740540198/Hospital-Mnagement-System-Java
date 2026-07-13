import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    static int patientId = 1, doctorId = 1, appointmentId = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Patient Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Disease: ");
                    String disease = sc.nextLine();

                    patients.add(new Patient(patientId++, pname, age, gender, disease));
                    System.out.println("Patient Added Successfully.");
                    break;

                case 2:
                    if (patients.isEmpty())
                        System.out.println("No Patients Found.");
                    else
                        for (Patient p : patients)
                            p.display();
                    break;

                case 3:
                    System.out.print("Doctor Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Specialization: ");
                    String spec = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    doctors.add(new Doctor(doctorId++, dname, spec, phone));
                    System.out.println("Doctor Added Successfully.");
                    break;

                case 4:
                    if (doctors.isEmpty())
                        System.out.println("No Doctors Found.");
                    else
                        for (Doctor d : doctors)
                            d.display();
                    break;

                case 5:
                    if (patients.isEmpty() || doctors.isEmpty()) {
                        System.out.println("Please add patients and doctors first.");
                        break;
                    }

                    System.out.println("Select Patient ID:");
                    for (Patient p : patients)
                        System.out.println(p.id + ". " + p.name);

                    int pid = Integer.parseInt(sc.nextLine());

                    System.out.println("Select Doctor ID:");
                    for (Doctor d : doctors)
                        System.out.println(d.id + ". " + d.name);

                    int did = Integer.parseInt(sc.nextLine());

                    Patient patient = null;
                    Doctor doctor = null;

                    for (Patient p : patients)
                        if (p.id == pid)
                            patient = p;

                    for (Doctor d : doctors)
                        if (d.id == did)
                            doctor = d;

                    if (patient == null || doctor == null) {
                        System.out.println("Invalid Selection.");
                        break;
                    }

                    System.out.print("Appointment Date: ");
                    String date = sc.nextLine();

                    System.out.print("Appointment Time: ");
                    String time = sc.nextLine();

                    appointments.add(new Appointment(appointmentId++, patient, doctor, date, time));
                    System.out.println("Appointment Booked Successfully.");
                    break;

                case 6:
                    if (appointments.isEmpty())
                        System.out.println("No Appointments Found.");
                    else
                        for (Appointment a : appointments)
                            a.display();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}

