package com.braze.ui.inappmessage.views;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageBaseView$Companion$getAppropriateImageUrl$1 extends v implements h9.a<String> {
    final /* synthetic */ String $localImagePath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppMessageBaseView$Companion$getAppropriateImageUrl$1(String str) {
        super(0);
        this.$localImagePath = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Local bitmap file does not exist. Using remote url instead. Local path: " + this.$localImagePath;
    }
}
