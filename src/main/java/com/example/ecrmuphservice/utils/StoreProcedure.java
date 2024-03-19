package com.example.ecrmuphservice.utils;


import com.example.commonapi.utils.XmlUtils;
import com.example.loggerapi.utils.LoggerUtils2;
import oracle.jdbc.OracleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class StoreProcedure {
    @Autowired
    private DataSource dataSource;

    public String callStore(String storeName, String xmlInput) throws SQLException, JAXBException {
        Connection connection = null;
        CallableStatement callableStatement = null;
        String xmlOutPut = "";
        LoggerUtils2.info(this.getClass(), "callStore", "pre", xmlInput);
        try {
            connection = dataSource.getConnection();
            String queryString = "{ call " + storeName + "(?,?)}";
            LoggerUtils2.info(this.getClass(), "callStore", "queryString", queryString);
            callableStatement = connection.prepareCall(queryString);
            if (dataSource != null) {
                callableStatement.setString(1, xmlInput);
                callableStatement.registerOutParameter(2, OracleType.NVARCHAR);
            }
            callableStatement.execute();
            xmlOutPut = callableStatement.getString(2);
            LoggerUtils2.info(this.getClass(), "callStore", "post", xmlOutPut);
        } catch (Exception e) {
            LoggerUtils2.error(this.getClass(), "callStore", "exception", e.getMessage());
            throw e;

        } finally {
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        }
        return xmlOutPut;
    }
}
