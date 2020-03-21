package com.enjin.sdk.model.service.identities;

import com.enjin.sdk.graphql.GraphQLRequest;

public class UnlinkIdentity extends GraphQLRequest<UnlinkIdentity> {

    public UnlinkIdentity id(int userId) {
        withVariable("id", userId);
        return this;
    }

}
