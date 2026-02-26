package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationStyleFactory$Companion$getStoryStyle$1 extends v implements a<String> {
    public static final BrazeNotificationStyleFactory$Companion$getStoryStyle$1 INSTANCE = new BrazeNotificationStyleFactory$Companion$getStoryStyle$1();

    BrazeNotificationStyleFactory$Companion$getStoryStyle$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Push story page cannot render without a context";
    }
}
