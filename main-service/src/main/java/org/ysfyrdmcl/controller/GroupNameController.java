package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ysfyrdmcl.dto.request.GroupNameRequestDto;
import org.ysfyrdmcl.exception.ErrorType;
import org.ysfyrdmcl.exception.UserManagerException;
import org.ysfyrdmcl.repository.entity.GroupNameClass;
import org.ysfyrdmcl.services.GroupNameClassService;
import org.ysfyrdmcl.services.JwtTokenManager;

import javax.validation.Valid;
import java.util.Optional;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+MAIN+GROUP_NAME)
@RequiredArgsConstructor
public class GroupNameController {
    private final JwtTokenManager jwtTokenManager;
    private GroupNameClassService groupNameClassService;
    @PostMapping(CREATE_GROUP_NAME)
    public ResponseEntity<GroupNameClass> createGroupName(@RequestBody @Valid GroupNameRequestDto dto){
        try{
            Optional<Long> userid = jwtTokenManager.getUserId(dto.getToken());
            if(userid.isEmpty()){
                throw new UserManagerException(ErrorType.INVALID_TOKEN);}
            return ResponseEntity.ok(groupNameClassService.save(GroupNameClass.builder()
                            .name(dto.getGroupName())
                    .build()));
        }

            catch (Exception e){
                return ResponseEntity.badRequest().build();
            }

    }
}
