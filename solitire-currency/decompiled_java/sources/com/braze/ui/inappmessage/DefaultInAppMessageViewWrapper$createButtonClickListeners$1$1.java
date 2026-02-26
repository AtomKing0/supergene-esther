package com.braze.ui.inappmessage;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class DefaultInAppMessageViewWrapper$createButtonClickListeners$1$1 extends v implements a<String> {
    public static final DefaultInAppMessageViewWrapper$createButtonClickListeners$1$1 INSTANCE = new DefaultInAppMessageViewWrapper$createButtonClickListeners$1$1();

    DefaultInAppMessageViewWrapper$createButtonClickListeners$1$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Cannot create button click listener since this in-app message does not have message buttons.";
    }
}
