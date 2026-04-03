package com.ironsource;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class er implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Long f11990a;

    @Nullable
    public final Long a() {
        return this.f11990a;
    }

    public final void a(@Nullable Long l10) {
        this.f11990a = l10;
    }

    @Override // java.lang.Runnable
    public void run() {
    }
}
