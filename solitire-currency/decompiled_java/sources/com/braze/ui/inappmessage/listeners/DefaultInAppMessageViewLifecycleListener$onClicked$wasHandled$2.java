package com.braze.ui.inappmessage.listeners;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
/* JADX INFO: loaded from: classes2.dex */
final class DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$2 extends v implements a<String> {
    public static final DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$2 INSTANCE = new DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$2();

    DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$2() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Using non-deprecated onInAppMessageClicked(inAppMessage)";
    }
}
