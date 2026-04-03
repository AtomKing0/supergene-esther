package com.moloco.sdk.internal.publisher.nativead.model;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.publisher.nativead.model.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final a.AbstractC0316a f18189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18191c;

    @StabilityInferred(parameters = 0)
    public static final class a extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final String f18192d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull a.AbstractC0316a.C0317a originAsset) {
            super(originAsset, null);
            t.i(originAsset, "originAsset");
            this.f18192d = originAsset.c();
        }

        @NotNull
        public final String b() {
            return this.f18192d;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.b$b, reason: collision with other inner class name */
    @StabilityInferred(parameters = 0)
    public static final class C0318b extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final Uri f18193d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0318b(@NotNull a.AbstractC0316a.b originAsset, @NotNull Uri precachedAssetUri) {
            super(originAsset, null);
            t.i(originAsset, "originAsset");
            t.i(precachedAssetUri, "precachedAssetUri");
            this.f18193d = precachedAssetUri;
        }

        @NotNull
        public final Uri b() {
            return this.f18193d;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final String f18194d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull a.AbstractC0316a.c originAsset) {
            super(originAsset, null);
            t.i(originAsset, "originAsset");
            this.f18194d = originAsset.c();
        }

        @NotNull
        public final String b() {
            return this.f18194d;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class d extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a f18195d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull a.AbstractC0316a.d originAsset, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a vastAd) {
            super(originAsset, null);
            t.i(originAsset, "originAsset");
            t.i(vastAd, "vastAd");
            this.f18195d = vastAd;
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a b() {
            return this.f18195d;
        }
    }

    public /* synthetic */ b(a.AbstractC0316a abstractC0316a, k kVar) {
        this(abstractC0316a);
    }

    @NotNull
    public final a.AbstractC0316a a() {
        return this.f18189a;
    }

    public b(a.AbstractC0316a abstractC0316a) {
        this.f18189a = abstractC0316a;
        this.f18190b = abstractC0316a.a();
        this.f18191c = abstractC0316a.b();
    }
}
