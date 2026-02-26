package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceAES;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class t9 implements br<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f15391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f15392b;

    public t9(@NotNull String encryptedResponse, @NotNull String descriptionKey) {
        kotlin.jvm.internal.t.i(encryptedResponse, "encryptedResponse");
        kotlin.jvm.internal.t.i(descriptionKey, "descriptionKey");
        this.f15391a = encryptedResponse;
        this.f15392b = descriptionKey;
    }

    @Override // com.ironsource.br
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a() {
        String value = IronSourceAES.decode(this.f15392b, this.f15391a);
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException("Decryption failed");
        }
        kotlin.jvm.internal.t.h(value, "value");
        return value;
    }
}
