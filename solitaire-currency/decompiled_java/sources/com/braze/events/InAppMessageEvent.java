package com.braze.events;

import bo.app.g10;
import bo.app.k10;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class InAppMessageEvent {
    private final IInAppMessage inAppMessage;
    private final k10 triggerAction;
    private final g10 triggerEvent;
    private final String userId;

    public InAppMessageEvent(g10 triggerEvent, k10 triggerAction, IInAppMessage inAppMessage, String str) {
        t.i(triggerEvent, "triggerEvent");
        t.i(triggerAction, "triggerAction");
        t.i(inAppMessage, "inAppMessage");
        this.triggerEvent = triggerEvent;
        this.triggerAction = triggerAction;
        this.inAppMessage = inAppMessage;
        this.userId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InAppMessageEvent)) {
            return false;
        }
        InAppMessageEvent inAppMessageEvent = (InAppMessageEvent) obj;
        return t.d(this.triggerEvent, inAppMessageEvent.triggerEvent) && t.d(this.triggerAction, inAppMessageEvent.triggerAction) && t.d(this.inAppMessage, inAppMessageEvent.inAppMessage) && t.d(this.userId, inAppMessageEvent.userId);
    }

    public final IInAppMessage getInAppMessage() {
        return this.inAppMessage;
    }

    public final k10 getTriggerAction() {
        return this.triggerAction;
    }

    public final g10 getTriggerEvent() {
        return this.triggerEvent;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iHashCode = (this.inAppMessage.hashCode() + ((this.triggerAction.hashCode() + (this.triggerEvent.hashCode() * 31)) * 31)) * 31;
        String str = this.userId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return JsonUtils.getPrettyPrintedString(this.inAppMessage.forJsonPut());
    }
}
