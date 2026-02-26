package com.braze.events;

import bo.app.cp;
import bo.app.l00;
import bo.app.mn;
import bo.app.tg;
import bo.app.w00;
import java.util.Map;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeNetworkFailureEvent {
    private final l00 brazeRequest;
    private final w00 httpConnectorResult;
    private final Long requestInitiationTime;
    private final RequestType requestType;
    private final String requestUrl;
    private final int responseCode;
    private final Map<String, String> responseHeaders;

    public enum RequestType {
        CONTENT_CARDS_SYNC,
        NEWS_FEED_SYNC,
        OTHER
    }

    public BrazeNetworkFailureEvent(l00 brazeRequest, w00 httpConnectorResult) {
        t.i(brazeRequest, "brazeRequest");
        t.i(httpConnectorResult, "httpConnectorResult");
        this.brazeRequest = brazeRequest;
        this.httpConnectorResult = httpConnectorResult;
        this.responseCode = httpConnectorResult.b();
        this.responseHeaders = httpConnectorResult.c();
        tg tgVar = (tg) brazeRequest;
        this.requestInitiationTime = tgVar.d();
        this.requestUrl = tgVar.e().a();
        RequestType requestType = brazeRequest instanceof mn ? RequestType.CONTENT_CARDS_SYNC : ((brazeRequest instanceof cp) && ((cp) brazeRequest).f().b()) ? RequestType.NEWS_FEED_SYNC : RequestType.OTHER;
        this.requestType = requestType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrazeNetworkFailureEvent)) {
            return false;
        }
        BrazeNetworkFailureEvent brazeNetworkFailureEvent = (BrazeNetworkFailureEvent) obj;
        return t.d(this.brazeRequest, brazeNetworkFailureEvent.brazeRequest) && t.d(this.httpConnectorResult, brazeNetworkFailureEvent.httpConnectorResult);
    }

    public int hashCode() {
        return this.httpConnectorResult.hashCode() + (this.brazeRequest.hashCode() * 31);
    }

    public String toString() {
        return "BrazeNetworkFailureEvent(brazeRequest=" + this.brazeRequest + ", httpConnectorResult=" + this.httpConnectorResult + ')';
    }
}
