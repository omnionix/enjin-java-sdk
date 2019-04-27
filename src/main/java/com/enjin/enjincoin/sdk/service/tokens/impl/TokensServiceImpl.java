package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.tokens.CreateTokenResult;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokens;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokensResult;
import com.enjin.enjincoin.sdk.model.service.tokens.ImportToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateTokenResult;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class TokensServiceImpl extends GraphQLServiceBase implements TokensService {

    private final TokensRetrofitService service;

    public TokensServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(TokensRetrofitService.class);
    }

    @Override
    public void getAllTokensAsync(HttpCallback<GraphQLResponse<GetTokensResult>> callback) {
        enqueueGraphQLCall(getAllTokensCall(), callback);
    }

    @Override
    public void getTokensAsync(GetTokens query,
                               HttpCallback<GraphQLResponse<GetTokensResult>> callback) {
        enqueueGraphQLCall(getTokensCall(query), callback);
    }

    @Override
    public void importTokenAsync(ImportToken query,
                                 HttpCallback<GraphQLResponse<CreateTokenResult>> callback) {
        enqueueGraphQLCall(getImportTokenCall(query), callback);
    }

    @Override
    public void updateTokenAsync(UpdateToken query,
                                 HttpCallback<GraphQLResponse<UpdateTokenResult>> callback) {
        enqueueGraphQLCall(getUpdateTokenCall(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<GetTokensResult>> getAllTokensSync() throws IOException {
        return executeGraphQLCall(getAllTokensCall());
    }

    @Override
    public HttpResponse<GraphQLResponse<GetTokensResult>> getTokensSync(GetTokens query) throws IOException {
        return executeGraphQLCall(getTokensCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<CreateTokenResult>> importTokenSync(ImportToken query) throws IOException {
        return executeGraphQLCall(getImportTokenCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<UpdateTokenResult>> updateTokenSync(UpdateToken query) throws IOException {
        return executeGraphQLCall(getUpdateTokenCall(query));
    }

    private Call<GraphQLResponse<GetTokensResult>> getAllTokensCall() {
        return this.service.getAllTokens(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<GetTokensResult>> getTokensCall(GetTokens query) {
        return this.service.getTokens(query);
    }

    private Call<GraphQLResponse<CreateTokenResult>> getImportTokenCall(ImportToken query) {
        return this.service.importToken(query);
    }

    private Call<GraphQLResponse<UpdateTokenResult>> getUpdateTokenCall(UpdateToken query) {
        return this.service.updateToken(query);
    }

}
