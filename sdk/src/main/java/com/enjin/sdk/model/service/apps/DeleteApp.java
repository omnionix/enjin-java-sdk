package com.enjin.sdk.model.service.apps;

import com.enjin.sdk.graphql.GraphQLRequest;

public class DeleteApp extends GraphQLRequest<DeleteApp> {

    public DeleteApp id(int id) {
        withVariable("id", id);
        return this;
    }

}
