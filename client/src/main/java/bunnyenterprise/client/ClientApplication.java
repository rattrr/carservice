package bunnyenterprise.client;

public class ClientApplication {

    public static void main(String[] args) {
        AppointmentProvider appointmentProvider = new AppointmentProvider();
        appointmentProvider.addAppointment();
    }
}
