package com.example.springboot;

import com.example.springboot.model.BoardReq;
import com.example.springboot.model.GetProductRes;
import com.example.springboot.model.PatchProductReq;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BoardDao {

    private final JdbcTemplate jdbcTemplate;

    public BoardDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(BoardReq boardReq) {
        String sql = "INSERT INTO Product (product_ID, Image, Name, Information) VALUES(?, ?, ?, ?)";
        Object[] sqlParams = new Object[]{
                boardReq.getBoardId(),
                boardReq.getImage(),
                boardReq.getBoardName(),
                boardReq.getInfo(),
        };
        jdbcTemplate.update(sql, sqlParams);
    }

    public List<GetProductRes> list() {
        String sql = "SELECT * FROM Product";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> GetProductRes.builder()
                        .boardId(rs.getInt("Product_ID"))
                        .boardName(rs.getString("ProductName"))
                        .info(rs.getString("Information"))
                        .image(rs.getString("Image"))
                        .build()
        );
    }

    public GetProductRes read(int id) {
        String sql = "SELECT * FROM course WHERE id=?";

        return jdbcTemplate.queryForObject(
                sql,
                BeanPropertyRowMapper.newInstance(GetProductRes.class)
                ,id
        );
    }

    public void update(PatchProductReq patchProductReq) {
        String sql = "UPDATE Product SET ";
//        Object[] sqlParams = new Object[]{
//                boardReq.getBoardId()
//        };
//        jdbcTemplate.update(sql, sqlParams);
    }

    public void delete(int id) {
        String sql = "DELETE FROM Product WHERE (?) = 1";
        jdbcTemplate.update(sql);
    }
}
