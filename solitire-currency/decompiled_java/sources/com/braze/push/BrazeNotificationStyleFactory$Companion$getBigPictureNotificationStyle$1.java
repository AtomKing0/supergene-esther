package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$1 extends v implements a<String> {
    final /* synthetic */ String $imageUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$1(String str) {
        super(0);
        this.$imageUrl = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Failed to download image bitmap for big picture notification style. Url: " + this.$imageUrl;
    }
}
