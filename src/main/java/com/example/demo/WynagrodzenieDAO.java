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
public class WynagrodzenieDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public WynagrodzenieDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Wynagrodzenie> list(){
        String sql = "SELECT * FROM WYNAGRODZENIA";
        List<Wynagrodzenie> listWynagrodzenie = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Wynagrodzenie.class));
        return listWynagrodzenie;
    }

    public void save(Wynagrodzenie wynagrodzenie){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("WYNAGRODZENIA").usingColumns("id_wynagrodzenia","data","kwota","premia","id_pracownika");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenie);
        insertActor.execute(param);
    }
    public Wynagrodzenie get(int id_wynagrodzenia ){
        String sql = "SELECT * FROM WYNAGRODZENIA WHERE id_wynagrodzenia = ?";
        Object[] args = {id_wynagrodzenia};
        Wynagrodzenie wynagrodzenie = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Wynagrodzenie.class));
        return wynagrodzenie;
    }
    public void update(Wynagrodzenie wynagrodzenie){
        String sql = "UPDATE WYNAGRODZENIA SET kwota=:kwota, premia=:premia, id_pracownika=:id_pracownika WHERE id_wynagrodzenia=:id_wynagrodzenia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenie);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void delete(int id_wynagrodzenia){
        String sql = "DELETE FROM WYNAGRODZENIA WHERE id_wynagrodzenia = ?";
        jdbcTemplate.update(sql,id_wynagrodzenia);
    }
}
