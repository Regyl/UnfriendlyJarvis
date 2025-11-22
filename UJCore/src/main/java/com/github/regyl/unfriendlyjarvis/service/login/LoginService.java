package com.github.regyl.unfriendlyjarvis.service.login;

import com.github.regyl.unfriendlyjarvis.entity.LoginEntity;
import com.github.regyl.unfriendlyjarvis.service.CrudService;
import org.springframework.web.multipart.MultipartFile;

public interface LoginService extends CrudService<LoginEntity> {

    void save(MultipartFile file);
}
