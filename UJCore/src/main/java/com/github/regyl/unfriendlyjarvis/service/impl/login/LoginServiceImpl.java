package com.github.regyl.unfriendlyjarvis.service.impl.login;

import com.github.regyl.unfriendlyjarvis.annotation.SourceSynced;
import com.github.regyl.unfriendlyjarvis.entity.LoginEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import com.github.regyl.unfriendlyjarvis.model.LoginModel;
import com.github.regyl.unfriendlyjarvis.repository.LoginEntityRepository;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import com.github.regyl.unfriendlyjarvis.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final Function<MultipartFile, Collection<LoginModel>> csvParser;
    private final Function<LoginModel, LoginEntity> mapper;
    private final LoginEntityRepository repository;
    private final SecurityContextService securityContextService;

    @Override
    @Transactional
    @SourceSynced(source = Source.GOOGLE_PASSWORD_MANAGER)
    public void save(MultipartFile file) {
        Collection<LoginModel> loginModels = csvParser.apply(file);
        Collection<LoginEntity> loginEntities = loginModels.stream().map(mapper).toList();

        //clear old accounts
        repository.deleteAllByAccountIdAndSource(securityContextService.getUserId(), Source.GOOGLE_PASSWORD_MANAGER);
        repository.saveAll(loginEntities);
    }

    @Override
    public Collection<LoginEntity> findAll() {
        Long accountId = securityContextService.getUserId();
        return repository.findAllByAccountId(accountId);
    }
}
