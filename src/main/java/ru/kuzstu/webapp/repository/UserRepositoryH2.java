package ru.kuzstu.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kuzstu.webapp.exception.NotFoundException;
import ru.kuzstu.webapp.model.User;

import java.util.List;

@Repository
public class UserRepositoryH2 implements UserRepository {

    private static final String CREATE = """
                        insert into users (user_id, user_name, birthday, is_admin)
                        values (:userId, :userName, :birthday, :admin)
            """;

    private final RowMapper<User> rowMapper = new DataClassRowMapper<>(User.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserRepositoryH2(JdbcTemplate jdbcTemplate,
                            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User read(Long id) {
        try {
            return jdbcTemplate.queryForObject("select * from users where user_id = ?", rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("User with id = [" + id + "] not found", e);
        }
    }

    @Override
    public List<User> readAll() {
        return jdbcTemplate.query("select * from users", rowMapper);
    }

    @Override
    public void create(User user) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(CREATE, paramsSource);
    }
}
