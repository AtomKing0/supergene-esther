package com.ironsource;

import com.ironsource.pg;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class us implements pg, pg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private ts f15620a;

    @Override // com.ironsource.pg
    @Nullable
    public ts a() {
        return this.f15620a;
    }

    @Override // com.ironsource.pg.a
    public void a(@Nullable ts tsVar) {
        this.f15620a = tsVar;
    }
}
