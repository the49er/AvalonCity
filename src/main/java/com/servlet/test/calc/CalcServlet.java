package com.servlet.test.calc;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
    private CalcService calcService;

    @Override
    public void init() throws ServletException {
        calcService = new CalcService();
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalcRequest calcRequest = mapToCalcRequest(req);
        CalcResponse calcResponse = calcService.calculate(calcRequest);

        resp.setContentType("application/json");
        resp.getWriter().write(new Gson().toJson(calcResponse));
        resp.getWriter().close();
        super.doPost(req, resp);
    }

    private CalcRequest mapToCalcRequest(HttpServletRequest request){
        String body = null;
        try {
            body = request
                    .getReader()
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(body, CalcRequest.class);

//        Map<String, String> params = new Gson().fromJson(
//                body,
//                TypeToken.getParameterized(Map.class, String.class, String.class).getType()
//        );

    }
}
