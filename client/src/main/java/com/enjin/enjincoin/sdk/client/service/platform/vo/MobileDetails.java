package com.enjin.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Mobile Details class.
 * </p>
 */
public class MobileDetails {

    @SerializedName("type")
    private String type;

    public MobileDetails(final String type) {
        super();
        this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MobileDetails [type=" + this.type + "]";
    }
}
