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
public class KlientDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public KlientDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Klient> list(){
        String sql = "SELECT * FROM KLIENCI";
        List<Klient> listKlient = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Klient.class));
        return listKlient;
    }

    public void save(Klient klient){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KLIENCI").usingColumns("id_klienta","email","nr_telefonu","nr_armatora","nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        insertActor.execute(param);
    }
    public Klient get(int id_klienta ){
        String sql = "SELECT * FROM KLIENCI WHERE id_klienta = ?";
        Object[] args = {id_klienta};
        Klient klient = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }
    public void update(Klient klient){
        String sql = "UPDATE KLIENCI SET email=:email, nr_telefonu=:nr_telefonu, nr_armatora=:nr_armatora, nr_adresu=:nr_adresu WHERE id_klienta=:id_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void delete(int id_klienta){
        String sql = "DELETE FROM KLIENCI WHERE id_klienta = ?";
        jdbcTemplate.update(sql,id_klienta);
    }
}
