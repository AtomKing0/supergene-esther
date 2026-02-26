package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePushNotificationPayload$2 extends v implements a<String> {
    final /* synthetic */ int $totalDeleted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handlePushNotificationPayload$2(int i10) {
        super(0);
        this.$totalDeleted = i10;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Firebase messaging 'total_deleted' reports " + this.$totalDeleted + " messages.";
    }
}
