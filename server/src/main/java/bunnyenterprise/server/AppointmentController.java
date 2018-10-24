package bunnyenterprise.server;

import bunnyenterprise.common.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private Logger log = LoggerFactory.getLogger(AppointmentController.class);
    private List<Appointment> appointments = new ArrayList<>();

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Appointment> getAppointments(){
        log.info("Retrieved appointments {}", appointments);
        return appointments;
    }

    @GetMapping("/{id}")
    public Appointment getOne(@PathVariable Integer id){
        Appointment appointment = findAppointment(id);
        log.info("Retrieved appointment {}", appointment);
        return appointment;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        appointment.setId(appointments.size()+1);
        appointment.setReservationDate(LocalDate.now());
        appointments.add(appointment);
        log.info("New appointment {}", appointment);
        return appointment;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity cancelAppointment(@PathVariable Integer id){
        Appointment appointment = findAppointment(id);
        appointments.remove(appointment);
        log.info("Deleteded appointment {}", appointment);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private Appointment findAppointment(Integer id){
        Optional<Appointment> appointment = appointments.stream().filter(it -> it.getId() == id).findFirst();
        if(appointment.isPresent()){
            return appointment.get();
        }
        return null;
    }
}
