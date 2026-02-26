package com.braze.push;

import android.content.Intent;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePush$performWork$2 extends v implements a<String> {
    final /* synthetic */ Intent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handlePush$performWork$2(Intent intent) {
        super(0);
        this.$intent = intent;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Push action is null. Not handling intent: " + this.$intent;
    }
}
