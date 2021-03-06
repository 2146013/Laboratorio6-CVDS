package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.Service;
import edu.eci.cvds.servlet.model.Todo;
import java.util.ArrayList;

@WebServlet(
    urlPatterns = "/Items"
)
public class ItemServlet extends HttpServlet{
    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
        
        int id = 0;
        ArrayList<Todo> todoList = new ArrayList<Todo>();
        Writer responseWriter = resp.getWriter();
        Optional<String> optId = Optional.ofNullable(req.getParameter("id"));


        if (!optId.isPresent()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        else {
            String id1 = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
            try{
                id = Integer.parseInt(id1);
                Todo todo = Service.getTodo(id);
                todoList.add(todo);
	            String itemsTable = Service.todosToHTMLTable(todoList);
	            resp.setStatus(HttpServletResponse.SC_OK);
	            responseWriter.write(itemsTable);
	            responseWriter.flush();
            }

            catch(NumberFormatException e0){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

            catch(MalformedURLException e1){
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

            catch(FileNotFoundException e3){
            	resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            	responseWriter.write("Id: " + id + " No encontrado");
            }

            finally{
	           	resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);	           	
            }  
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
        String id1 = req.getParameter("id");
        int id = 0;
        ArrayList<Todo> todoList = new ArrayList<Todo>();
        Writer responseWriter = resp.getWriter();
        
        try{
            id = Integer.parseInt(id1);
            Todo todo = Service.getTodo(id);
            todoList.add(todo);
            String itemsTable = Service.todosToHTMLTable(todoList);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(itemsTable);
            responseWriter.flush();
        }

        catch(NumberFormatException e0){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        catch(MalformedURLException e1){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }

        catch(FileNotFoundException e3){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("NO ENCONTRADO");
        }

        finally{
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);             
        }
    }
}