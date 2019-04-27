package com.enjin.enjincoin.sdk.service.identities;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentities;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentitiesResult;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentityResult;

import java.io.IOException;

public interface SynchronousIdentitiesService {

    /**
     * @return
     *
     * @throws IOException
     */
    HttpResponse<GraphQLResponse<GetIdentitiesResult>> getAllIdentitiesSync() throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    HttpResponse<GraphQLResponse<GetIdentitiesResult>> getIdentitiesSync(GetIdentities query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    HttpResponse<GraphQLResponse<CreateIdentityResult>> createIdentitySync(CreateIdentity query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    HttpResponse<GraphQLResponse<DeleteIdentityResult>> deleteIdentitySync(DeleteIdentity query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    HttpResponse<GraphQLResponse<UpdateIdentityResult>> updateIdentitySync(UpdateIdentity query) throws IOException;
}
