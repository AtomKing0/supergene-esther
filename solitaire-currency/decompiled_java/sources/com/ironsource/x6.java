package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.AdSize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class x6 implements au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final uk f16137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final AdSize f16138b;

    static final class a extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16139a = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.a("Load task config is null");
        }
    }

    static final class b extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16140a = new b();

        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.l();
        }
    }

    public x6(@Nullable uk ukVar, @Nullable AdSize adSize) {
        this.f16137a = ukVar;
        this.f16138b = adSize;
    }

    @Override // com.ironsource.au
    public void a() {
        a(this.f16137a != null, a.f16139a);
        a(this.f16138b != null, b.f16140a);
    }

    @Override // com.ironsource.au
    public /* synthetic */ void a(boolean z10, h9.a aVar) {
        av.a(this, z10, aVar);
    }
}
