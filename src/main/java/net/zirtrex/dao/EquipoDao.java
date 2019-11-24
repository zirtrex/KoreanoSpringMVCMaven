package net.zirtrex.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import net.zirtrex.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class EquipoDao {    
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List obtenerEquipos(){  
        String query="select * from equipo";  
        return jdbcTemplate.queryForList(query);  
    }
    
    public Equipo obtenerEquipo(int codEquipo){
        final Equipo e = new Equipo();
        String query = String.format( "select * from equipo where codEquipo=%d", codEquipo );  
        return (Equipo) jdbcTemplate.query(query, new ResultSetExtractor<Equipo>(){
            @Override
            public Equipo extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    e.setCodEquipo(rs.getInt("codEquipo"));
                    e.setNombre(rs.getString("nombre"));
                    e.setMarca(rs.getString("marca"));
                    e.setModelo(rs.getString("modelo"));
                }
                return e;
            }            
        });
    }

    public int guardarEquipo(Equipo e){  
        String query = String.format( "insert into equipo (nombre, marca, modelo) values('%s', '%s', '%s')", e.getNombre(), e.getMarca(), e.getModelo() );  
        return jdbcTemplate.update(query);  
    }  
    public int actualizarEquipo(Equipo e){  
        String query = String.format( "update equipo set nombre='%s', marca='%s' where codEquipo=%d", e.getNombre(), e.getMarca(), e.getCodEquipo() );
        return jdbcTemplate.update(query);
    }  
    public int eliminarEquipo(Equipo e){
        String query = String.format( "delete from equipo where codEquipo=%s ",e.getCodEquipo() );  
        return jdbcTemplate.update(query);  
    }  
    
}
