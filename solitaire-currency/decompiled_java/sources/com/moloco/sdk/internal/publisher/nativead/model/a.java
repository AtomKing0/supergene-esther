package com.moloco.sdk.internal.publisher.nativead.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f18165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<AbstractC0316a> f18166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final c f18167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<String> f18168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<b> f18169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f18170f;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.a$a, reason: collision with other inner class name */
    @StabilityInferred(parameters = 0)
    public static abstract class AbstractC0316a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f18172b;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.a$a$a, reason: collision with other inner class name */
        @StabilityInferred(parameters = 0)
        public static final class C0317a extends AbstractC0316a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public final Integer f18173c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @Nullable
            public final Integer f18174d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @NotNull
            public final String f18175e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0317a(int i10, boolean z10, @Nullable Integer num, @Nullable Integer num2, @NotNull String value) {
                super(i10, z10, null);
                t.i(value, "value");
                this.f18173c = num;
                this.f18174d = num2;
                this.f18175e = value;
            }

            @NotNull
            public final String c() {
                return this.f18175e;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.a$a$b */
        @StabilityInferred(parameters = 0)
        public static final class b extends AbstractC0316a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public final Integer f18176c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @NotNull
            public final String f18177d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @Nullable
            public final Integer f18178e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @Nullable
            public final Integer f18179f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(int i10, boolean z10, @Nullable Integer num, @NotNull String url, @Nullable Integer num2, @Nullable Integer num3) {
                super(i10, z10, null);
                t.i(url, "url");
                this.f18176c = num;
                this.f18177d = url;
                this.f18178e = num2;
                this.f18179f = num3;
            }

            @NotNull
            public final String c() {
                return this.f18177d;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.a$a$c */
        @StabilityInferred(parameters = 0)
        public static final class c extends AbstractC0316a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @NotNull
            public final String f18180c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @Nullable
            public final Integer f18181d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(int i10, boolean z10, @NotNull String text, @Nullable Integer num) {
                super(i10, z10, null);
                t.i(text, "text");
                this.f18180c = text;
                this.f18181d = num;
            }

            @NotNull
            public final String c() {
                return this.f18180c;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.a$a$d */
        @StabilityInferred(parameters = 0)
        public static final class d extends AbstractC0316a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @NotNull
            public final String f18182c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(int i10, boolean z10, @NotNull String vastTag) {
                super(i10, z10, null);
                t.i(vastTag, "vastTag");
                this.f18182c = vastTag;
            }

            @NotNull
            public final String c() {
                return this.f18182c;
            }
        }

        public /* synthetic */ AbstractC0316a(int i10, boolean z10, k kVar) {
            this(i10, z10);
        }

        public final int a() {
            return this.f18171a;
        }

        public final boolean b() {
            return this.f18172b;
        }

        public AbstractC0316a(int i10, boolean z10) {
            this.f18171a = i10;
            this.f18172b = z10;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f18185c;

        public b(int i10, int i11, @Nullable String str) {
            this.f18183a = i10;
            this.f18184b = i11;
            this.f18185c = str;
        }

        public final int a() {
            return this.f18183a;
        }

        public final int b() {
            return this.f18184b;
        }

        @Nullable
        public final String c() {
            return this.f18185c;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final String f18186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final List<String> f18187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f18188c;

        public c(@NotNull String url, @NotNull List<String> clickTrackerUrls, @Nullable String str) {
            t.i(url, "url");
            t.i(clickTrackerUrls, "clickTrackerUrls");
            this.f18186a = url;
            this.f18187b = clickTrackerUrls;
            this.f18188c = str;
        }

        @NotNull
        public final List<String> a() {
            return this.f18187b;
        }

        @NotNull
        public final String b() {
            return this.f18186a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@Nullable String str, @NotNull List<? extends AbstractC0316a> assets, @Nullable c cVar, @NotNull List<String> impressionTrackerUrls, @NotNull List<b> eventTrackers, @Nullable String str2) {
        t.i(assets, "assets");
        t.i(impressionTrackerUrls, "impressionTrackerUrls");
        t.i(eventTrackers, "eventTrackers");
        this.f18165a = str;
        this.f18166b = assets;
        this.f18167c = cVar;
        this.f18168d = impressionTrackerUrls;
        this.f18169e = eventTrackers;
        this.f18170f = str2;
    }

    @NotNull
    public final List<AbstractC0316a> a() {
        return this.f18166b;
    }

    @NotNull
    public final List<b> b() {
        return this.f18169e;
    }

    @NotNull
    public final List<String> c() {
        return this.f18168d;
    }

    @Nullable
    public final c d() {
        return this.f18167c;
    }
}
