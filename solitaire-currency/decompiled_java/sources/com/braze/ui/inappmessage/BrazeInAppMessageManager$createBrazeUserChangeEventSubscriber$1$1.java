package com.braze.ui.inappmessage;

import com.braze.events.BrazeUserChangeEvent;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$1 extends v implements a<String> {
    final /* synthetic */ BrazeUserChangeEvent $event;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$1(BrazeUserChangeEvent brazeUserChangeEvent) {
        super(0);
        this.$event = brazeUserChangeEvent;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "InAppMessage manager handling new current user id: '" + this.$event + '\'';
    }
}
