package com.enjin.sdk.schemas.player;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.player.queries.GetWallet;
import com.enjin.sdk.services.PlayerService;
import com.enjin.sdk.schemas.player.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.player.queries.GetPlayer;
import com.enjin.sdk.schemas.shared.SharedSchema;
import com.enjin.sdk.services.WalletService;
import com.enjin.sdk.utils.LoggerProvider;

import java.io.IOException;

/**
 * Class for sending requests in the player schema.
 */
public class PlayerSchema extends SharedSchema implements IPlayerSchema {

    /**
     * The name of the schema.
     */
    public static final String SCHEMA = "player";

    protected final PlayerService playerService;
    protected final WalletService walletService;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware the middleware
     * @param loggerProvider the logger provider
     */
    public PlayerSchema(TrustedPlatformMiddleware middleware, LoggerProvider loggerProvider) {
        super(middleware, SCHEMA, loggerProvider);
        playerService = (PlayerService) createService(PlayerService.class);
        walletService = (WalletService) createService(WalletService.class);
    }

    /**
     * Sends {@link GetPlayer} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Player> getPlayer(GetPlayer request) {
        return sendRequest(playerService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetPlayer} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    @Override
    public void getPlayer(GetPlayer request,
                          HttpCallback<GraphQLResponse<Player>> callback) {
        sendRequest(playerService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends the {@link GetWallet} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Wallet> getWallet(GetWallet request) {
        return sendRequest(walletService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends the {@link GetWallet} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    @Override
    public void getWallet(GetWallet request,
                          HttpCallback<GraphQLResponse<Wallet>> callback) {
        sendRequest(walletService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link UnlinkWallet} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link UnlinkWallet} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    @Override
    public void unlinkWallet(UnlinkWallet request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(playerService.delete(schema, createRequestBody(request)), callback);
    }

}