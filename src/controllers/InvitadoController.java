package controllers;

import java.util.ArrayList;
import models.Invitado;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class InvitadoController {

    private ArrayList<Invitado> invitados = new ArrayList<>();

    public void registrarInvitado(String nombre, String celular, String genero, String fecha, String direccion) {

        Invitado i = new Invitado(nombre, celular, genero);
        invitados.add(i);

        // aquí podrías guardar en archivo si quieres

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("invitados.txt", true));
            writer.write(nombre + ";" + celular + ";" + genero);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}