package com.example.springboot.controller;

import com.example.springboot.model.BoardDto;
import com.example.springboot.model.BoardReq;
import com.example.springboot.model.GetProductRes;
import com.example.springboot.model.PatchProductReq;
import com.example.springboot.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<Object> search() {
        List<GetProductRes> getProductRes = boardService.showItemList();
        return ResponseEntity.ok().body(getProductRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<Object> search(int id) {
        GetProductRes getProductRes =  boardService.showItem(id);
        return ResponseEntity.ok().body(getProductRes);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<Object> register(@RequestBody BoardReq boardReq) {
        boardService.registerBoard(boardReq);
        return ResponseEntity.ok().body("상품 등록 성공");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update'")
    public ResponseEntity<Object> update(@RequestBody PatchProductReq patchProductReq) {
        boardService.updateBoard(patchProductReq);
        return ResponseEntity.ok().body("상품 정보가 변경되었습니다.");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<Object> delete(int id) {
        boardService.deleteBoard(id);
        return ResponseEntity.badRequest().body("상품 삭제를 완료했습니다.");
    }
}

