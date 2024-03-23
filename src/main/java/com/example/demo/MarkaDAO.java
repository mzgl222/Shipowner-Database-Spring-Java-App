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
public class MarkaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public MarkaDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Marka> list(){
        String sql = "SELECT * FROM MARKI";
        List<Marka> listMarka = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Marka.class));
        return listMarka;
    }

    public void save(Marka marka){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("MARKI").usingColumns("id_marki","nazwa_marki");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(marka);
        insertActor.execute(param);
    }
    public Marka get(int id_marki ){
        String sql = "SELECT * FROM MARKI WHERE id_marki = ?";
        Object[] args = {id_marki};
        Marka marka = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Marka.class));
        return marka;
    }
    public void update(Marka marka){
        String sql = "UPDATE MARKI SET nazwa_marki=:nazwa_marki WHERE id_marki=:id_marki";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(marka);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void delete(int id_marki){
        String sql = "DELETE FROM MARKI WHERE id_marki = ?";
        jdbcTemplate.update(sql,id_marki);
    }
}
