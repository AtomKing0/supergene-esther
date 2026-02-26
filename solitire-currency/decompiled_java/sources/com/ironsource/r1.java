package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f14620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<NetworkSettings> f14621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final lj f14622c;

    /* JADX WARN: Multi-variable type inference failed */
    public r1(@Nullable String str, @NotNull List<? extends NetworkSettings> providerList, @NotNull lj publisherDataHolder) {
        kotlin.jvm.internal.t.i(providerList, "providerList");
        kotlin.jvm.internal.t.i(publisherDataHolder, "publisherDataHolder");
        this.f14620a = str;
        this.f14621b = providerList;
        this.f14622c = publisherDataHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r1 a(r1 r1Var, String str, List list, lj ljVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = r1Var.f14620a;
        }
        if ((i10 & 2) != 0) {
            list = r1Var.f14621b;
        }
        if ((i10 & 4) != 0) {
            ljVar = r1Var.f14622c;
        }
        return r1Var.a(str, list, ljVar);
    }

    @NotNull
    public final List<NetworkSettings> b() {
        return this.f14621b;
    }

    @NotNull
    public final lj c() {
        return this.f14622c;
    }

    @NotNull
    public final List<NetworkSettings> d() {
        return this.f14621b;
    }

    @NotNull
    public final lj e() {
        return this.f14622c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return kotlin.jvm.internal.t.d(this.f14620a, r1Var.f14620a) && kotlin.jvm.internal.t.d(this.f14621b, r1Var.f14621b) && kotlin.jvm.internal.t.d(this.f14622c, r1Var.f14622c);
    }

    @Nullable
    public final String f() {
        return this.f14620a;
    }

    public int hashCode() {
        String str = this.f14620a;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.f14621b.hashCode()) * 31) + this.f14622c.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdUnitCommonData(userId=" + this.f14620a + ", providerList=" + this.f14621b + ", publisherDataHolder=" + this.f14622c + ')';
    }

    @NotNull
    public final r1 a(@Nullable String str, @NotNull List<? extends NetworkSettings> providerList, @NotNull lj publisherDataHolder) {
        kotlin.jvm.internal.t.i(providerList, "providerList");
        kotlin.jvm.internal.t.i(publisherDataHolder, "publisherDataHolder");
        return new r1(str, providerList, publisherDataHolder);
    }

    @Nullable
    public final String a() {
        return this.f14620a;
    }
}
