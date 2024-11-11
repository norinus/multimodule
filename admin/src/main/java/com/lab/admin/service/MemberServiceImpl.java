package com.lab.admin.service;

import com.lab.core.domain.Member;
import com.lab.core.dto.member.MemberDTO;
import com.lab.core.mapper.member.MemberMapper;
import com.lab.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    @Override
    public Page<MemberDTO> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable).map(memberMapper::toDto);
    }
}
