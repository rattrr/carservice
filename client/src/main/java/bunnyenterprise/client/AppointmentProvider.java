package bunnyenterprise.client;

import bunnyenterprise.common.Appointment;
import bunnyenterprise.common.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class AppointmentProvider {

    private static final Logger log = LoggerFactory.getLogger(AppointmentProvider.class);

    public static final String APPOINTMENTS_URL = "http://localhost:8080/appointments";
    private RestTemplate restTemplate = new RestTemplate();

    public void addAppointment() {

        Appointment appointment = new Appointment(new Customer("Jan", "Janusz", "123456789"), "nie działa");
        appointment.setAppointmentDate(LocalDate.of(2018, 10, 30));
        HttpEntity<Appointment> request = new HttpEntity<>(appointment);
        ResponseEntity<Appointment> response = restTemplate.exchange(APPOINTMENTS_URL, HttpMethod.POST, request, Appointment.class);
        log.info("I have created an appointment {}", response.getBody());
    }
}
