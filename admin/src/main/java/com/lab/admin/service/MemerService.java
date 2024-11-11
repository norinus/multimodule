package com.lab.admin.service;

import com.lab.core.dto.member.MemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemerService {

    Page<MemberDTO> findAll(Pageable pageable);

}
