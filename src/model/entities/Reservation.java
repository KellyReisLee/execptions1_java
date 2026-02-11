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

    public void updateDates(Date checkIN, Date checkOut){
        this.checkIN = checkIN;
        this.checkOut = checkOut;

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
