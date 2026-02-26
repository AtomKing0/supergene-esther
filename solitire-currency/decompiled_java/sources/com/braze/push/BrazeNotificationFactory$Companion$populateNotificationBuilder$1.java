package com.braze.push;

import com.braze.models.push.BrazeNotificationPayload;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationFactory$Companion$populateNotificationBuilder$1 extends v implements a<String> {
    final /* synthetic */ BrazeNotificationPayload $payload;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeNotificationFactory$Companion$populateNotificationBuilder$1(BrazeNotificationPayload brazeNotificationPayload) {
        super(0);
        this.$payload = brazeNotificationPayload;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Using BrazeNotificationPayload: " + this.$payload;
    }
}
