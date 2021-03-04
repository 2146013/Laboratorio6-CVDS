package edu.eci.cvds.servlet;

import java.io.IOException;
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
    urlPatterns = "/BuscarItems"
)
public class ItemServlet extends HttpServlet{
    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,NumberFormatException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
        if (!optId.isPresent()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        else {
            String id1 = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
            try{
                int id = Integer.parseInt(id1);
                Todo todo = Service.getTodo(id);
            }
            catch(NumberFormatException e){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);  
            }
            catch(MalformedURLException e1){
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            ArrayList<Todo> todoList = new ArrayList<Todo>();
            todoList.add(todo); 
            String itemTable = Service.todosToHTMLTable(todoList);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(itemTable);
            responseWriter.flush();
       }
       
   }
}