package com.example.springboot.service;

import com.example.springboot.BoardDao;
import com.example.springboot.model.BoardDto;
import com.example.springboot.model.BoardReq;
import com.example.springboot.model.GetProductRes;
import com.example.springboot.model.PatchProductReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public void registerBoard(BoardReq boardReq) {
        boardDao.create(boardReq);
    }

    public void updateBoard(PatchProductReq patchProductReq) {
        boardDao.update(patchProductReq);
    }

    public void deleteBoard(int id) {
        boardDao.delete(id);
    }

    public GetProductRes showItem(int id) {
        return boardDao.read(id);
    }

    public List<GetProductRes> showItemList() {
        List<GetProductRes> list = boardDao.list();
        return list;
    }
}
