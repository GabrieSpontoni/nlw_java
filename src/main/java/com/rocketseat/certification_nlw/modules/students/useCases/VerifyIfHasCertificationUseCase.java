package com.rocketseat.certification_nlw.modules.students.useCases;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import org.springframework.stereotype.Service;

@Service

public class VerifyIfHasCertificationUseCase {

    public boolean execute(VerifyHasCertificationDTO dto) {
        return dto.getEmail().equals("test@gmail.com") && dto.getTechnology().equals("java");
    }
}
