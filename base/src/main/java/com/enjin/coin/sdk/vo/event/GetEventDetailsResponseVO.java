package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>
 * Get Event Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetEventDetailsResponseVO {

    /**
     * Method to get the data.
     * @return Optional
     */
    @SerializedName("data")
    public abstract Optional<GetEventDataVO> getData();

    /**
     * Method to get the eventId.
     * @return Optional
     */
    @SerializedName("event_id")
    public abstract Optional<String> getEventId();

    /**
     * Method to get the eventType.
     * @return Optional
     */
    @SerializedName("event_type")
    public abstract Optional<String> getEventType();

    /**
     * Method to get the timestamp.
     * @return Optional
     */
    @SerializedName("timestamp")
    public abstract Optional<String> getTimestamp();

    /**
     * Method to get the appId.
     * @return Optional
     */
    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "GetEventResponseVO [eventId=" + getEventId().orElse(null) + ", eventType=" + getEventType().orElse(null) + ", timestamp="
                + getTimestamp().orElse(null) + ", appId=" + getAppId().orElse(null) + "]";
    }

}
