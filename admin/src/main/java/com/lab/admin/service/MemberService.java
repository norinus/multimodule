package com.lab.admin.service;

import com.lab.core.dto.member.MemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

public interface MemberService {

    ResponseEntity<Map<String, String>> create(MemberDTO memberDTO);

    Page<MemberDTO> findAll(Pageable pageable);

    ResponseEntity<MemberDTO> findById(Long id);

    ResponseEntity<Map<String, String>> delete(Long id);
}
