/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.persistencia.impl;

import com.fpmislata.banco.persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory {
    DataSource dataSource;
    Connection connection;
   

    public Connection getConnection() {
        InitialContext initialContext;

        try {
            initialContext = new InitialContext();

            Context envCtx = (Context) initialContext.lookup("java:comp/env");

            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/cycybank");
            connection = dataSource.getConnection();
            
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
     return connection;
        
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
