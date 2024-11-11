package com.lab.admin.service;

import com.lab.core.dto.member.MemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    Page<MemberDTO> findAll(Pageable pageable);

}
