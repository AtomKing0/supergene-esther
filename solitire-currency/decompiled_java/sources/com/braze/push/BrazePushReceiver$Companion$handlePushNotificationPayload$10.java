package com.braze.push;

import com.braze.models.push.BrazeNotificationPayload;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePushNotificationPayload$10 extends v implements a<String> {
    final /* synthetic */ BrazeNotificationPayload $payload;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handlePushNotificationPayload$10(BrazeNotificationPayload brazeNotificationPayload) {
        super(0);
        this.$payload = brazeNotificationPayload;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Creating notification with payload:\n" + this.$payload;
    }
}
