package com.midasin.bp.mlogmember.domain.member.rqrs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.midasin.bp.mlogmember.domain.member.Member;
import com.midasin.bp.mlogmember.utils.ModelMapperUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Schema(description = "회원 정보 DTO")
public class MemberDto {

    @NotNull
    @Schema(description = "이메일")
    private String email;

    @NotNull
    @Schema(description = "비밀번호")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    @Schema(description = "회원 명")
    private String memberName;

    @NotNull
    @Schema(description = "닉네임")
    private String nickName;

    @Schema(description = "전화번호")
    private String phone;

    @Schema(description = "부서")
    private String department;

    public static MemberDto from(Member member) {
        return ModelMapperUtil.map(member, MemberDto.class);
    }

    public Member toEntity() {
        return ModelMapperUtil.map(this, Member.class);
    }

}
