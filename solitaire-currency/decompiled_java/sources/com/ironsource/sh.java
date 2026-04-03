package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class sh implements au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final uk f15312a;

    static final class a extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15313a = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.b("Load task config is null");
        }
    }

    public sh(@Nullable uk ukVar) {
        this.f15312a = ukVar;
    }

    @Override // com.ironsource.au
    public void a() {
        a(this.f15312a != null, a.f15313a);
    }

    @Override // com.ironsource.au
    public /* synthetic */ void a(boolean z10, h9.a aVar) {
        av.a(this, z10, aVar);
    }
}
