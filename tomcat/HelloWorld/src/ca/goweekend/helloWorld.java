package ca.goweekend;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class helloWorld
 */
@WebServlet("/helloWorld")
public class helloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloWorld() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /* Get IP and Host Name to demonstrate the requests are served from different node in cluster */
		InetAddress ip = null;
        String hostName = null;
        
	try {
            ip = InetAddress.getLocalHost();
            hostName = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostName);
 
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
		
		PrintWriter out = response.getWriter();
		out.println("Welcome to the World V1.0!");
		out.println(hostName);
		out.println(ip);
		response.getWriter().append("\nServed at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
