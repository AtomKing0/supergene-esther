package com.braze.ui.actions.brazeactions;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionParser$getBrazeActionVersionAndJson$json$1 extends v implements a<String> {
    final /* synthetic */ String $encodedAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeActionParser$getBrazeActionVersionAndJson$json$1(String str) {
        super(0);
        this.$encodedAction = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Failed to decode action into json. Action:\n'" + this.$encodedAction + '\'';
    }
}
