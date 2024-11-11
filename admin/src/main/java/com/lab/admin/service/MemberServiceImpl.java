package com.lab.admin.service;

import com.lab.admin.dto.MemberQueryDTO;
import com.lab.admin.repository.querydsl.MemberQueryDslRepository;
import com.lab.core.dto.member.MemberDTO;
import com.lab.core.mapper.member.MemberMapper;
import com.lab.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final MemberQueryDslRepository memberQueryDslRepository;

    private final MemberMapper memberMapper;

    @Override
    public ResponseEntity<Map<String, String>> create(MemberDTO memberDTO) {
        try {

            // Member 저장
            memberRepository.save(memberMapper.toEntity(memberDTO));

            // 성공 메시지 반환
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            // 오류 메시지 반환
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


    @Override
    public Page<MemberDTO> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable).map(memberMapper::toDto);
    }

    @Override
    public Page<MemberQueryDTO> findQuerydsl(Pageable pageable) {
        return memberQueryDslRepository.findByQueryList(pageable);
    }

    @Override
    public ResponseEntity<MemberDTO> findById(Long id) {
        return memberRepository.findById(id)
                .map(member -> ResponseEntity.ok(memberMapper.toDto(member)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    @Override
    public ResponseEntity<Map<String, String>> delete(Long id) {
        return memberRepository.findById(id)
                .map(member -> {

                    member.setIsDeleted(true);
                    member.setMemberStateCode("02");
                    memberRepository.save(member);

                    Map<String, String> map = new HashMap<>();
                    map.put("status", "success");
                    return new ResponseEntity<>(map, HttpStatus.OK);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }
}
