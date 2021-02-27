package edu.eci.cvds.servlet.model;

public class Todo{
    int userid;
    int id;
    String title;
    boolean completed;

    public Todo(){

    }
    public int getUserId(){
        return userid;

    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean getCompleted(){
        return completed;
    }
    public void setUserId(int userid){
        this.userid=userid;

    }
    public void setId(int id){
        this.id=id;

    }
    public void setTitle(String title){
        this.title=title;

    }
    public void setCompleted(boolean completed){
        this.completed=completed;

    }
   

}

