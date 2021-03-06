package edu.eci.cvds.servlet;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Game")
@SessionScoped
public class Game {
    public final int reduce = 10000;

    public int numero = (int)Math.random() * (50 - 0 + 1) + 0;
    public int intentos;
    public int premio;
    public boolean estado;

    public Game(){
        numero = (int)Math.random() * (50 - 0 + 1) + 0;
        intentos = 0;
        premio = 100000;
        estado = false;
    }

    public void guess(int num){

        if (!estado) {
            setIntentos(getIntentos()+1);
            if (num == getNumero() || premio == 0){
                setEstado(true);
            }
            else {
                setPremio(getPremio()-reduce);
            }            
        }
    }

    public void restart(){
        setNumero((int)Math.random() * (50 - 0 + 1) + 0);
        setIntentos(0);
        setPremio(100000);
        setEstado(false);
    }


    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setIntentos(int intentos){
        this.intentos = intentos;
    }

    public void setPremio( int premio){
        this.premio = premio;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public int getNumero(){
        return numero;
    }

    public int getIntentos(){
        return intentos;
    }

    public int getPremio(){
        return premio;
    }

    public boolean getEstado(){
        return estado;
    }
}