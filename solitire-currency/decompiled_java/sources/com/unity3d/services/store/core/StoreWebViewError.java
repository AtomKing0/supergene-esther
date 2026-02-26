package com.unity3d.services.store.core;

import com.unity3d.scar.adapter.common.m;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StoreWebViewError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StoreWebViewError extends m {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreWebViewError(@Nullable Enum<?> r22, @Nullable String str, @NotNull Object... errorArguments) {
        super(r22, str, Arrays.copyOf(errorArguments, errorArguments.length));
        t.i(errorArguments, "errorArguments");
    }

    @Override // com.unity3d.scar.adapter.common.m
    @NotNull
    public String getDomain() {
        return WebViewEventCategory.STORE.name();
    }
}
