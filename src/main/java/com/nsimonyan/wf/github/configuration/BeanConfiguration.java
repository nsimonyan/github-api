package com.nsimonyan.wf.github.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nsimonyan.wf.github.dataprovider.CommitDataProviderImpl;
import com.nsimonyan.wf.github.dataprovider.RepositoryDataProviderImpl;
import com.nsimonyan.wf.github.dataprovider.interfaces.CommitDataProvider;
import com.nsimonyan.wf.github.dataprovider.interfaces.RepositoryDataProvider;
import com.nsimonyan.wf.github.usecase.ListUniqueUsersUseCaseImpl;
import com.nsimonyan.wf.github.usecase.ProjectionOfCommitsUseCaseImpl;
import com.nsimonyan.wf.github.usecase.SearchRepositoriesUseCaseImpl;
import com.nsimonyan.wf.github.usecase.UserImpactUseCaseImpl;
import com.nsimonyan.wf.github.usecase.interfaces.ListUniqueUsersUseCase;
import com.nsimonyan.wf.github.usecase.interfaces.ProjectionOfCommitsUseCase;
import com.nsimonyan.wf.github.usecase.interfaces.SearchRepositoriesUseCase;
import com.nsimonyan.wf.github.usecase.interfaces.UsersImpactUseCase;

@Configuration
public class BeanConfiguration {
    @Bean
    public SearchRepositoriesUseCase searchRepositoriesUseCase() {
        return new SearchRepositoriesUseCaseImpl();
    }
    @Bean
    public ListUniqueUsersUseCase listUniqueUsersUseCase() {
        return new ListUniqueUsersUseCaseImpl();
    }
    @Bean
    public UsersImpactUseCase usersImpactUseCase() {
    	return new UserImpactUseCaseImpl();
    }
    
    @Bean
    public ProjectionOfCommitsUseCase commitBusinessLogic() {
    	return new ProjectionOfCommitsUseCaseImpl();
    }
    
    @Bean
    public RepositoryDataProvider RepositoryDataProvider() {
    	return new RepositoryDataProviderImpl();
    }
    @Bean
    public CommitDataProvider commitDataProvider() {
    	return new CommitDataProviderImpl();
    }
    
    
}