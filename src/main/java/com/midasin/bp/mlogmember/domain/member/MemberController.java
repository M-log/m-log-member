package com.midasin.bp.mlogmember.domain.member;

import com.midasin.bp.mlogmember.domain.member.rqrs.AuthMemberDto;
import com.midasin.bp.mlogmember.domain.member.rqrs.MemberDto;
import com.midasin.bp.mlogmember.infra.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;


@Tag(name = "회원 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class MemberController implements BaseController {

    private final MemberService memberService;
    
    @Operation(summary = "회원 가입")
    @PostMapping(value = "/signup")
    public MemberDto createMember(@RequestBody MemberDto memberDto) {
        return memberService.createMember(memberDto);
    }
    
    @Operation(summary = "이메일 중복 확인")
    @GetMapping(value = "/email/{email}/exists")
    public boolean checkEmailDuplicate(@PathVariable String email) {
        return memberService.checkEmailDuplicate(email);
    }
    
    @Operation(summary = "닉네임 중복 확인")
    @GetMapping(value = "/nickname/{nickname}/exists")
    public boolean checkNickNameDuplicate(@PathVariable String nickname) {
        return memberService.checkNickNameDuplicate(nickname);
    }

    @Operation(summary = "사용자 인증 정보 조회")
    @GetMapping(value = "/auth/{email}/{password}")
    public AuthMemberDto findAuthMember(@PathVariable String email, @PathVariable String password){
        return memberService.findAuthMember(email, password);
    }

    @Operation(summary = "사용자 프로필 조회")
    @GetMapping(value = "/profile")
    public MemberDto findMemberProfile(@NotNull Authentication authentication) {
        return null;
    }

    @Operation(summary = "사용자 정보 수정")
    @PutMapping(value = "/edit")
    public MemberDto editProfile(@RequestBody MemberDto memberDto, @NotNull Authentication authentication) {
        return null;
    }

    @Operation(summary = "사용자 프로필 사진 등록")
    @PostMapping(value = "/profile/image")
    public ResponseEntity<String> editProfileImage(MultipartFile multipartFile) {
        return null;
    }



}
