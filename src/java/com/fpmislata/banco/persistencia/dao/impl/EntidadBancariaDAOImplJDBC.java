/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.ConnectionFactory;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistencia.impl.ConnectionFactoryImplDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    ConnectionFactory connectionFactory = new ConnectionFactoryImplDataSource();

    @Override
    public EntidadBancaria read(Integer idEntidadBancaria) {
        try {
            EntidadBancaria entidadBancaria;
            Connection conexion = connectionFactory.getConnection();

            String selectSQL = "SELECT * FROM entidadbancaria WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(selectSQL);
            preparedStatement.setInt(1, idEntidadBancaria);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next() == true) {
                entidadBancaria = new EntidadBancaria();

                entidadBancaria.setCodigoEntidad(rs.getString("codigoEntidad"));
                entidadBancaria.setNombre(rs.getString("nombreEntidad"));
                entidadBancaria.setIdEntidadBancaria(rs.getInt("idEntidadBancaria"));

                if (rs.next() == true) {
                    throw new RuntimeException("ERROR. Existe mas de una entidad." + idEntidadBancaria);
                }
                return entidadBancaria;
            } else {

            }

            conexion.close();
            System.out.println("Conexion creada y datos mostrados.");
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public EntidadBancaria update(Integer idEntidadBancaria, EntidadBancaria entidadBancaria) {
        try {

            Connection conexion = connectionFactory.getConnection();

            String updateTableSQL = "UPDATE entidadbancaria SET  nombreEntidad = ? WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(updateTableSQL);

            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getIdEntidadBancaria());
            // execute insert SQL statement
            preparedStatement.executeUpdate();

            conexion.close();
            System.out.println("Conexion creada con exito y datos actualizados.");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return entidadBancaria;
    }

    @Override
    public void delete(Integer idEntidadBancaria) {
        try {

            Connection conexion = connectionFactory.getConnection();

            String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement3 = conexion.prepareStatement(deleteSQL);
            preparedStatement3.setInt(1, idEntidadBancaria);
            // execute delete SQL stetement
            preparedStatement3.executeUpdate();

            conexion.close();
            System.out.println("Conexion creada con exito");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        try {

            Connection conexion = connectionFactory.getConnection();

            String insertTableSQL = "INSERT INTO entidadbancaria"
                    + "(idEntidadBancaria, codigoEntidad, nombreEntidad) VALUES"
                    + "(?,?,?)";

            PreparedStatement preparedStatement2 = conexion.prepareStatement(insertTableSQL);
            preparedStatement2.setInt(1, entidadBancaria.getIdEntidadBancaria());
            preparedStatement2.setString(2, entidadBancaria.getCodigoEntidad());
            preparedStatement2.setString(3, entidadBancaria.getNombre());

        
            preparedStatement2.executeUpdate();

            conexion.close();
            System.out.println("Conexion creada con exito y datos insertados.");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entidadBancaria;
    }

    @Override
    public List<EntidadBancaria> findall() {
        try {
            List<EntidadBancaria> listaEntidades;
            try (Connection conexion = connectionFactory.getConnection()) {
                listaEntidades = new ArrayList();
                EntidadBancaria entidadBancaria;
                String selectSQL = "SELECT * FROM entidadbancaria ";
                PreparedStatement preparedStatement = conexion.prepareStatement(selectSQL);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Integer idEntidadBancaria = rs.getInt("idEntidadBancaria");
                    String codigoEntidad = rs.getString("codigoEntidad");
                    String nombre = rs.getString("nombreEntidad");

                    entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre);
                    listaEntidades.add(entidadBancaria);
                }
            }
            return listaEntidades;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    
   

  


}
