package com.lab.admin.controller;

import com.lab.admin.dto.MemberQueryDTO;
import com.lab.admin.service.MemberService;
import com.lab.core.dto.member.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("admin/members")
public class MemberController {

    private final MemberService memberService;



    /**
     * 사용자 리스트 페이지 객체
     * @param pageable
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Map<String,String>> create( @RequestBody MemberDTO memberDTO) {
        return memberService.create(memberDTO);
    }

    /**
     * 사용자 리스트 페이지 객체
     * @param pageable
     * @return
     */
    @GetMapping("")
    public Page<MemberDTO> findAll( @PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return memberService.findAll(pageable);
    }

    /**
     * 사용자 리스트 페이지 객체
     * @param pageable
     * @return
     */
    @GetMapping("/query")
    public Page<MemberQueryDTO> findQuerydsl(@PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return memberService.findQuerydsl(pageable);
    }


    /**
     * 사용자 상세 정보 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable Long id) {
        return memberService.findById(id);
    }
    /**
     * 사용자 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable Long id) {
        return memberService.delete(id);
    }
}
