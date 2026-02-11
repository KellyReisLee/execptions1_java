package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIN;
    private  Date checkOut;

    //É "static" para que não seja instanciado um novo sdf pra casa objeto reservation;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public  Reservation(){}
    public Reservation(Integer roomNumber, Date checkIN, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIN = checkIN;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIN() {
        return checkIN;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    // Return the number of days for the reservation:
    public Long duration(){
        //Difference entre data em milliseconds
        long diff = checkOut.getTime() - checkIN.getTime();
        //Convert milliseconds in Days:
        return  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }

    public String updateDates(Date checkIN, Date checkOut){

        Date now = new Date();

        if(checkIN.before(now) || checkOut.before(now)){
           return "Error in Reservation: Reservation dates for update must be future dates.";
        }
        if (!checkOut.after(checkIN)) {
           return "Error in Reservation: Check-out date must be after Check-in date. ";
        }
        this.checkIN = checkIN;
        this.checkOut = checkOut;

        return null;

    }


    @Override
    public String toString() {
        return "Reservation " +
                "Room: " + roomNumber +
                ", checkIN: " + sdf.format(checkIN) +
                ", checkOut: " + sdf.format(checkOut) +
                ", " + duration() + " nights" ;
    }
}
