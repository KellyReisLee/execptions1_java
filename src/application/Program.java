package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Program {
    public static void main(String[] args) {

        /*Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
        de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
        dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
        novamente a reserva com os dados atualizados. O programa não deve aceitar dados
        inválidos para a reserva, conforme as seguintes regras:
        - Alterações de reserva só podem ocorrer para datas futuras
        - A data de saída deve ser maior que a data de entrada*/

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("CheckIn date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("CheckOut date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Room number: ");
            number = sc.nextInt();
            System.out.print("CheckIn date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("CheckOut date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);


        }catch (ParseException e){
            System.out.println("Invalid date format!");
        }catch (DomainException e){
            System.out.print("Error in Reservation: " + e.getMessage());
        }

        finally {
            sc.close();
        }




    }
}