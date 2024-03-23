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
public class StatekDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public StatekDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Statek> list(){
        String sql = "SELECT * FROM STATKI";
        List<Statek> listStatek = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Statek.class));
        return listStatek;
    }

    public void save(Statek statek){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("STATKI").usingColumns("id_statku","nazwa","rok_produkcji","zasieg","nr_armatora","id_modelu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(statek);
        insertActor.execute(param);
    }
    public Statek get(int id_statku ){
        String sql = "SELECT * FROM STATKI WHERE ID_STATKU = ?";
        Object[] args = {id_statku};
        Statek statek = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Statek.class));
        return statek;
    }
    public void update(Statek statek){
        String sql = "UPDATE STATKI SET nazwa=:nazwa, rok_produkcji=:rok_produkcji, zasieg=:zasieg, nr_armatora=:nr_armatora, id_modelu=:id_modelu WHERE id_statku=:id_statku";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(statek);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void delete(int id_statku){
        String sql = "DELETE FROM STATKI WHERE ID_STATKU = ?";
        jdbcTemplate.update(sql,id_statku);
    }
}
