package com.aeroparker.test.controller;

import com.aeroparker.test.db.dao.CustomerSiteDAO;
import com.aeroparker.test.db.dao.SiteDAO;
import com.aeroparker.test.db.entity.customer.Customer;
import com.aeroparker.test.db.entity.customer.CustomerTitle;
import com.aeroparker.test.db.entity.site.Site;
import com.aeroparker.test.db.entity_relation.CustomerSiteKey;
import com.aeroparker.test.db.dao.CustomerDAO;
import com.aeroparker.test.feature.storage.Storage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(value = "/ace-park")
public class AceParkController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String title = req.getParameter("title");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String addressLine1 = req.getParameter("addressLine1");
        String addressLine2 = req.getParameter("addressLine2");
        String city = req.getParameter("city");
        String postcode = req.getParameter("postcode");
        String telNumber = req.getParameter("telNumber");


        Customer customer = new Customer();

        customer.setRegistered(Date.valueOf(LocalDate.now()));
        customer.setEmail(email);
        customer.setTitle(CustomerTitle.getEnumFromString(title));
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddressLine1(addressLine1);
        customer.setAddressLine2(addressLine2);
        customer.setCity(city);
        customer.setPostcode(postcode);
        customer.setTelNumber(telNumber);


        Storage storage = Storage.getInstance();
        Connection connection = storage.getConnection();
        CustomerDAO customerDAO = new CustomerDAO(connection);
        String result = customerDAO.insertNewEntity(customer);
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SiteDAO siteDAO = new SiteDAO(connection);
        Site site = new Site();
        site.setName(req.getRequestURI());
        siteDAO.insertNewEntity(site);

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CustomerSiteDAO customerSiteDAO = new CustomerSiteDAO(connection);
        CustomerSiteKey customerSiteKey = new CustomerSiteKey();
        customerSiteKey.setCustomerId(customerDAO.getMaxId());
        customerSiteKey.setSiteId(siteDAO.getMaxId());
        customerSiteDAO.insertNewEntity(customerSiteKey);

        resp.getWriter().print(result);
        resp.getWriter().close();

        super.doPost(req, resp);
    }
}
