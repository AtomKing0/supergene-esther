package com.ironsource.sdk.controller;

import android.content.Context;
import android.content.Intent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface k {

    public static final class a implements com.ironsource.g {
        @Override // com.ironsource.g
        @NotNull
        public Intent a() {
            return new Intent("android.intent.action.VIEW");
        }
    }

    public static final class b implements com.ironsource.h {
        @Override // com.ironsource.h
        @NotNull
        public Intent a(@NotNull Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            return new Intent(context, (Class<?>) OpenUrlActivity.class);
        }
    }
}
