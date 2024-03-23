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
public class ModelDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ModelDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Moodel> list(){
        String sql = "SELECT * FROM MODELE";
        List<Moodel> listModel = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Moodel.class));
        return listModel;
    }

    public void save(Moodel model){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("MODELE").usingColumns("id_modelu","nazwa","nr_marki");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(model);
        insertActor.execute(param);
    }
    public Moodel get(int id_modelu ){
        String sql = "SELECT * FROM MODELE WHERE id_modelu = ?";
        Object[] args = {id_modelu};
        Moodel model = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Moodel.class));
        return model;
    }
    public void update(Moodel model){
        String sql = "UPDATE MODELE SET nazwa=:nazwa, nr_marki=:nr_marki WHERE id_modelu=:id_modelu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(model);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void delete(int id_modelu){
        String sql = "DELETE FROM MODELE WHERE id_modelu = ?";
        jdbcTemplate.update(sql,id_modelu);
    }
}
