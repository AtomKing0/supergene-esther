package com.braze.ui.inappmessage;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class DefaultInAppMessageViewWrapper$Companion$resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto$1 extends v implements a<String> {
    public static final DefaultInAppMessageViewWrapper$Companion$resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto$1 INSTANCE = new DefaultInAppMessageViewWrapper$Companion$resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto$1();

    DefaultInAppMessageViewWrapper$Companion$resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "In-app message ViewGroup was null. Not resetting in-app message accessibility for exclusive mode.";
    }
}
