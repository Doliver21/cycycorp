/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import com.fpmislata.banco.presentacion.json.JsonConverter;
import com.fpmislata.banco.presentacion.json.impl.JsonConverterImplJackson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alumno
 */
@Controller
public class EntidadBancariaController {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;
    @Autowired
    JsonConverter jsonSalida;
    //Estas son las dos entidades creadas con Autowired , se hace con autowired applicationContext
    // estas son las dos entidades entidadBancaria que he comentado en la clase delete y read

    @RequestMapping(value = {"/EntidadBancaria/{idEntidad}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidad") int idEntidadBancaria) throws IOException, SQLException {

        try {

            EntidadBancaria entidadBancaria = entidadBancariaDAO.read(idEntidadBancaria); //creo variable para pasarla abajo
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonSalida.toJson(entidadBancaria);
            //ObjectMapper objectMapper = new ObjectMapper(); Con esto se haria sin nuetro clase JsonConver..
            //objectMapper.writeValueAsString(entidadBancaria);
            //Aqui la variable creada
            httpServletResponse.getWriter().println(json);

        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {

                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidad}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidad") int idEntidad) {

        try {
            //EntidadBancariaDAOImpHibernate entidadBancariaDAO = new EntidadBancariaDAOImpHibernate(); 
            entidadBancariaDAO.delete(idEntidad);
            /*ObjectMapper objectMapper = new ObjectMapper();
             String json = objectMapper.writeValueAsString(null);
             httpServletResponse.setContentType("application/json; charset=UTF-8");
             httpServletResponse.getWriter().println(json);*/
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.GET)
    public void find(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse/*, @PathVariable("idEntidad") int idEntidad*/) throws IOException {

        try {
            List<EntidadBancaria> entidadBancaria = entidadBancariaDAO.findall();

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonSalida.toJson(entidadBancaria);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {

        try {

            EntidadBancaria entidadBancaria = (EntidadBancaria) jsonSalida.fromJson(json, EntidadBancaria.class);

            entidadBancariaDAO.insert(entidadBancaria);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonSalida.toJson(entidadBancaria);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidad}"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidad") int idEntidad, @RequestBody String json) {

        try {
            //Aqui transformo el json de la cabecera en un objeto java para poder insertarlo en la BBDD

            EntidadBancaria entidadBancaria = (EntidadBancaria) jsonSalida.fromJson(json, EntidadBancaria.class);

            //Leo la entidad que voy a actualizar y la guardo en un objeto
            EntidadBancaria entidadBancariaUpdate = entidadBancariaDAO.read(idEntidad);

            //Cambio los valores que ya estan guardados por los que me han pasado en le json
            entidadBancariaUpdate.setNombre(entidadBancaria.getNombre());

            entidadBancariaUpdate.setCodigoEntidad(entidadBancaria.getCodigoEntidad());

            entidadBancariaDAO.update(idEntidad, entidadBancariaUpdate);  //Actualizo la entidad

            //Casteo el objeto creado de nuevo a formato json para poder devolverlo
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonSalida.toJson(entidadBancariaUpdate); //Aqui la variable creada
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }

    }
}
