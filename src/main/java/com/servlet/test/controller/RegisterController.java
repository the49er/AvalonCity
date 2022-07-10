package com.servlet.test.controller;

import com.servlet.test.db.entity.customer.Customer;
import com.servlet.test.db.entity.customer.CustomerTitle;
import com.servlet.test.db.entity.customer.dao.CustomerDAO;
import com.servlet.test.feature.storage.Storage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.StringJoiner;

@WebServlet(value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Register was submit");
        resp.getWriter().close();
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("id");
        String registered = req.getParameter("registered");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String title = req.getParameter("title");

        Customer customer = new Customer();

        customer.setRegistered(Date.valueOf(LocalDate.now()));
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setTitle(CustomerTitle.getEnumFromString(title));


        Storage storage = Storage.getInstance();
        Connection connection = storage.getConnection();
        CustomerDAO customerDAO = new CustomerDAO(connection);
        long result = customerDAO.insertNewEntity(customer);

        resp.getWriter().print(result);
        resp.getWriter().write("Register was submit");
        resp.getWriter().close();

        super.doPost(req, resp);
    }

    private String getAllParameters(HttpServletRequest request) {
        StringJoiner result = new StringJoiner("<br>");

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValues = Arrays.toString(request.getParameterValues(parameterName));
            result.add(parameterName + " = " + parameterValues);
        }
        return result.toString();
    }
}
