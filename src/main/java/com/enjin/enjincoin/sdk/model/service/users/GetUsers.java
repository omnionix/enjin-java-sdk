package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class GetUsers extends GraphQLRequest.Builder {

    public GetUsers withUserId(int userId) {
        withParameter("id", userId);
        return this;
    }

    public GetUsers withName(String name) {
        withParameter("name", name);
        return this;
    }

    public GetUsers withEmail(String email) {
        withParameter("email", email);
        return this;
    }

    public GetUsers withMe(boolean me) {
        withParameter("me", me);
        return this;
    }

}