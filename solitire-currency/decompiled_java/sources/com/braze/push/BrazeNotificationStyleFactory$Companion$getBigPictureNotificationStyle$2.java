package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$2 extends v implements a<String> {
    public static final BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$2 INSTANCE = new BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$2();

    BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$2() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Failed to scale image bitmap, using original.";
    }
}
