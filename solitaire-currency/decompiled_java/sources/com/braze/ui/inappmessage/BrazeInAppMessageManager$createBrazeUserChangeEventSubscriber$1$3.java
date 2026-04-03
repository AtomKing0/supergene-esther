package com.braze.ui.inappmessage;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$3 extends v implements a<String> {
    final /* synthetic */ String $currentUserId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$3(String str) {
        super(0);
        this.$currentUserId = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Removing in-app messages not from user " + this.$currentUserId;
    }
}
