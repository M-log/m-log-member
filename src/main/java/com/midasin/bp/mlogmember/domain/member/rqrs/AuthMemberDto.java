package com.midasin.bp.mlogmember.domain.member.rqrs;

import com.midasin.bp.mlogmember.domain.member.Member;
import com.midasin.bp.mlogmember.domain.role.Role;
import com.midasin.bp.mlogmember.domain.role.enums.RoleType;
import com.midasin.bp.mlogmember.infra.ErrorMessage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class AuthMemberDto {

    @Schema(description = "회원 ID")
    private Long id;

    @NotNull
    @Schema(description = "이메일")
    private String email;

    @NotNull
    @Schema(description = "닉네임")
    private String nickName;

    @NotNull
    @Schema(description = "권한")
    private List<RoleType> authorities;

    public static AuthMemberDto from(Member member) {
        Assert.notNull(member, ErrorMessage.INVALID_PARAM.name());

        return AuthMemberDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickName(member.getNickName())
                .authorities(member.getRoles()
                        .stream()
                        .map(Role::getRoleType)
                        .collect(Collectors.toList()))
                .build();

    }


}
