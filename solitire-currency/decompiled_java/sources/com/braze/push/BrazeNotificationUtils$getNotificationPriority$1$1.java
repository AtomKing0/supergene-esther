package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationUtils$getNotificationPriority$1$1 extends v implements a<String> {
    final /* synthetic */ Integer $notificationPriority;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeNotificationUtils$getNotificationPriority$1$1(Integer num) {
        super(0);
        this.$notificationPriority = num;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Received invalid notification priority " + this.$notificationPriority;
    }
}
