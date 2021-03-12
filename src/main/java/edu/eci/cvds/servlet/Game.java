package edu.eci.cvds.servlet;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Game")
@SessionScoped
public class Game {
    public final int reduce = 10000;

    public int numero;
    public int intentos;
    public int premio;
    public String estado;
    public String mensaje;
    public ArrayList<Integer> ultimos;

    public Game(){
        numero = (int)(Math.random() * ((20 - 0) + 1)) + 0;
        intentos = 0;
        premio = 100000;
        estado = "none";
        ultimos = new ArrayList<Integer>();
        setMensaje("Sigue intentando");
    }

    public void guess(int num){

        if (estado == "none") {
            setIntentos(getIntentos()+1);
            ultimos.add(num);
            if (num == getNumero()){
            	setEstado("visible");
            	setMensaje("Ganaste");
            }
            else if (premio == 0){
            	setEstado("visible");
            	setMensaje("Perdiste");
            }

            else {
                setPremio(getPremio()-reduce);
            }            
        }
        else{

        }
    }

    public void restart(){
        setNumero((int)(Math.random() * ((20 - 0) + 1)) + 0);
        setIntentos(0);
        setPremio(100000);
        setEstado("none");
        setUltimos(new ArrayList<Integer>());
        setMensaje("Sigue intentando");
    }

    public void setUltimos(ArrayList<Integer> ultimos){
        this.ultimos = ultimos;
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

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

	public String getUltimos(){
		String ult = "";
		for (Integer i: ultimos) {
			ult = ult + ((int)i) + ", ";
		}
		return ult;
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

    public String getMensaje(){
        return mensaje;
    }

    public String getEstado(){
        return estado;
    }
}