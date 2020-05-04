/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package temp;

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
public class Serv2 extends HttpServlet {
    //public static void main(String args[]){
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int accno=Integer.parseInt(request.getParameter("accno"));
    //    String fname=request.getParameter("fname");
       // String lname=request.getParameter("lname");
     //   int mc=Integer.parseInt(request.getParameter("mc"));
       // int ip=Integer.parseInt(request.getParameter("ip"));
       // int pds=Integer.parseInt(request.getParameter("pds"));
       
        try
        {
            //out.print("hlooo");
    Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/sample3","root","root");
           // Statement st=conn.createStatement();
            Connection conn1=DriverManager.getConnection("jdbc:derby://localhost:1527/sample4","root","root");
            Statement st=conn.createStatement();
            Statement st1=conn1.createStatement();
            String s="delete from customer where accno="+accno;
        //   String s="insert into student values("+regno+",'"+fname+"','"+lname+"',"+mc+","+ip+","+pds+")";
          // String s1="insert into student values("+regno+",'"+fname+"','"+lname+"',"+mc+","+ip+","+pds+")";
            boolean status=st.execute(s);
            st1.execute(s);
            out.println("<h2>DELETED SUCCESSFULLY</h2>");
           // out.print(status);
           // conn.close();
            conn1.close();
             conn.close();
    }
    catch(SQLException ee)
    {
        System.out.println(ee);
    }}

}
