
package com.fpmislata.banco.persistencia;

import java.sql.Connection;

public interface ConnectionFactory {

    Connection getConnection();

    public void close(Connection connection);
}
