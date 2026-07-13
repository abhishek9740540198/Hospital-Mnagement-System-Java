public class Doctor {
    int id;
    String name;
    String specialization;
    String phone;

    public Doctor(int id, String name, String specialization, String phone) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
    }

    public void display() {
        System.out.println("--------------------------------");
        System.out.println("Doctor ID      : " + id);
        System.out.println("Doctor Name    : " + name);
        System.out.println("Specialization : " + specialization);
        System.out.println("Phone Number   : " + phone);
    }
}
