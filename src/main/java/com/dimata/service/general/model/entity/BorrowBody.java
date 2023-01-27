package com.dimata.service.general.model.entity;

import java.time.LocalDate;

public record BorrowBody(
        Long bukuId,
        Long memberId,
        Double lateFee
) {
}
