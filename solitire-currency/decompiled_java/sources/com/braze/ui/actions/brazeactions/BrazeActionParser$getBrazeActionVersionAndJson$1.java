package com.braze.ui.actions.brazeactions;

import android.net.Uri;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionParser$getBrazeActionVersionAndJson$1 extends v implements a<String> {
    final /* synthetic */ Uri $this_getBrazeActionVersionAndJson;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeActionParser$getBrazeActionVersionAndJson$1(Uri uri) {
        super(0);
        this.$this_getBrazeActionVersionAndJson = uri;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Failed to parse version and encoded action from uri: " + this.$this_getBrazeActionVersionAndJson;
    }
}
