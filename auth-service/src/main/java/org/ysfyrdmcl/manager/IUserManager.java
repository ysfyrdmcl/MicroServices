package org.ysfyrdmcl.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.ysfyrdmcl.dto.request.NewUserCreateDto;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@FeignClient(url="http://localhost:9091/v1/api/user",name = "user-service-userprofile",decode404 = true)
public interface IUserManager {
    @PostMapping(NEW_CREATE_USER)
    ResponseEntity<Boolean> NewUserCreate(NewUserCreateDto dto);
}
