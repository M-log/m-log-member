package com.midasin.bp.mlogmember.infra;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * 커스텀 예외 반환 DTO
 */
@Schema(description = "예외 핸들러 객체")
public record ErrorDto(
        @Schema(description = "발생 시간") LocalDateTime timestamp,
        @Schema(description = "상태") HttpStatus status,
        @Schema(description = "에러 메시지") String error
) {

    public ErrorDto(HttpStatus status, String error) {
        this(LocalDateTime.now(), status, error);
    }

}

