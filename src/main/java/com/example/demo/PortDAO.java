package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class PortDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public PortDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Port> list(){
        String sql = "SELECT * FROM PORTY";
        List<Port> listPort = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Port.class));
        return listPort;
    }

    public void save(Port port){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PORTY").usingColumns("id_portu","nazwa_portu","miasto","liczba_miejsc","nr_armatora");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(port);
        insertActor.execute(param);
    }
    public Port get(int id_portu ){
        String sql = "SELECT * FROM PORTY WHERE id_portu = ?";
        Object[] args = {id_portu};
        Port port = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Port.class));
        return port;
    }
    public void update(Port port){
        String sql = "UPDATE PORTY SET nazwa_portu=:nazwa_portu, miasto=:miasto, nr_armatora=:nr_armatora WHERE id_portu=:id_portu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(port);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void delete(int id_portu){
        String sql = "DELETE FROM PORTY WHERE ID_PORTU = ?";
        jdbcTemplate.update(sql,id_portu);
    }
}
