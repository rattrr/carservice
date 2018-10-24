package bunnyenterprise.common;

import java.time.LocalDate;

public class Appointment {
    private Integer id;
    private Customer customer;

    private LocalDate reservationDate;

    private LocalDate appointmentDate;
    String cause;

    public Appointment(Customer customer, String cause) {
        this.customer = customer;
        this.cause = cause;
    }

    public Appointment(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setAppointmentDate(LocalDate appointmentDate){
        this.appointmentDate = appointmentDate;
    }

    public LocalDate getAppointmentDate(){
        return appointmentDate;
    }

    public void setReservationDate(LocalDate reservationDate){
        this.reservationDate = reservationDate;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }
}
