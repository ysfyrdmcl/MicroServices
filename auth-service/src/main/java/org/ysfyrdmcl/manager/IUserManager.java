package org.ysfyrdmcl.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.ysfyrdmcl.dto.request.NewUserCreateDto;

import javax.validation.Valid;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@FeignClient(url = "${raceapplication.url.user}/v1/api/user",name = "user-service-userprofile",decode404 = true)
public interface IUserManager {
    //http://localhost:9091/v1/api/user/newcreateuser
    @PostMapping(NEW_CREATE_USER)
    ResponseEntity<Void> NewUserCreate(@RequestBody @Valid NewUserCreateDto dto);
}
