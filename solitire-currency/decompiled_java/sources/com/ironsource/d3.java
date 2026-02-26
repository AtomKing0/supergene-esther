package com.ironsource;

import com.ironsource.f3;
import com.ironsource.mediationsdk.IronSource;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class d3 implements e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f11745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f11746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f11749f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f11750a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f11751b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11752c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11753d = 1;

        private a() {
        }
    }

    public d3(@NotNull String version, @NotNull String instanceId, @NotNull IronSource.AD_UNIT adFormat, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.t.i(version, "version");
        kotlin.jvm.internal.t.i(instanceId, "instanceId");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        this.f11744a = version;
        this.f11745b = instanceId;
        this.f11746c = adFormat;
        this.f11747d = z10;
        this.f11748e = z11;
        this.f11749f = z12;
    }

    @Override // com.ironsource.e3
    @NotNull
    public ArrayList<g3> a() {
        ArrayList<g3> arrayList = new ArrayList<>();
        arrayList.add(new f3.v(this.f11744a));
        arrayList.add(new f3.x(this.f11745b));
        arrayList.add(new f3.a(this.f11746c));
        if (this.f11747d) {
            arrayList.add(new f3.p(1));
        }
        if (this.f11748e) {
            arrayList.add(new f3.e(1));
        }
        if (this.f11749f) {
            arrayList.add(new f3.o(1));
        }
        return arrayList;
    }

    public /* synthetic */ d3(String str, String str2, IronSource.AD_UNIT ad_unit, boolean z10, boolean z11, boolean z12, int i10, kotlin.jvm.internal.k kVar) {
        this(str, str2, ad_unit, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? true : z11, (i10 & 32) != 0 ? true : z12);
    }
}
