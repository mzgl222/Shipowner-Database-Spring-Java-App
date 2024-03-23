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
public class PracownikDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public PracownikDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownik> listPracownik = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pracownik.class));
        return listPracownik;
    }

    public void save(Pracownik pracownik){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PRACOWNICY").usingColumns("id_pracownika","imie","nazwisko","pesel","data_zatrudnienia","nr_konta","email","nr_telefonu","plec","nr_armatora","nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }
    public Pracownik get(int id_pracownika ){
        String sql = "SELECT * FROM PRACOWNICY WHERE id_pracownika = ?";
        Object[] args = {id_pracownika};
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }
    public void update(Pracownik pracownik){
        String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, pesel=:pesel, nr_konta=:nr_konta, email=:email, nr_telefonu=:nr_telefonu, plec=:plec, nr_armatora=:nr_armatora, nr_adresu=:nr_adresu WHERE id_pracownika=:id_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void delete(int id_pracownika){
        String sql = "DELETE FROM PRACOWNICY WHERE id_pracownika = ?";
        jdbcTemplate.update(sql,id_pracownika);
    }
}
