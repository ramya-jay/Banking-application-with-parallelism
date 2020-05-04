/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package temp;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinitha
 */
public class Serv3 extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    static int bal=10000;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int amt=Integer.parseInt(request.getParameter("amt"));
        //String wd=request.getParameter("wd");
        //String dp=request.getParameter("dp");
        int op=Integer.parseInt(request.getParameter("op"));
        int accno=Integer.parseInt(request.getParameter("accno"));
         
         int bal1;
        
        try
        {
           // out.print("hlooo");
    Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/sample3","root","root");
           // Statement st=conn.createStatement();
            Connection conn1=DriverManager.getConnection("jdbc:derby://localhost:1527/sample4","root","root");
            Statement st=conn.createStatement();
            Statement st1=conn1.createStatement();
            if(op==1)
            {
                bal=bal-amt;
                
                out.println("<h2>WITHDRAWN SUCCESSFULLY</h2>"+"\n");
                out.print("<h2>BALANCE:</h2>"+bal+"\n");
            }
            else if(op==2)
            {
                bal=bal+amt;
                
                out.println("<h2>DEPOSITED SUCCESSFULLY<h2>"+"\n");
                out.print("<h2>BALANCE:</h2>"+bal+"\n");
            }
            if(op==3)
            {
                
                
                out.println("<h2>BALANCE:</h2>"+bal+"\n");
            }
           String s="update customer set bal="+bal+" where accno="+accno+"";
          // String s1="insert into student values("+regno+",'"+fname+"','"+lname+"',"+mc+","+ip+","+pds+")";
           // boolean status=st.execute(s);
           st.execute(s);
            st1.execute(s);
            
            out.println("<h2>UPDATED SUCCESSFULLY</h2>"+"\n");
           // conn.close();
            conn1.close();
             conn.close();
    }
    catch(SQLException ee)
    {
        System.out.println(ee);
    }}

}