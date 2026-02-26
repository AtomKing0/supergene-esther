package com.ironsource;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private List<String> f15647a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private List<String> f15648b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private List<String> f15649c = new ArrayList();

    @Nullable
    public final List<String> a() {
        return this.f15649c;
    }

    @Nullable
    public final List<String> b() {
        return this.f15648b;
    }

    @Nullable
    public final List<String> c() {
        return this.f15647a;
    }

    public final void a(@Nullable List<String> list) {
        this.f15649c = list;
    }

    public final void b(@Nullable List<String> list) {
        this.f15648b = list;
    }

    public final void c(@Nullable List<String> list) {
        this.f15647a = list;
    }
}
