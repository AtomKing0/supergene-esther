package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.q;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface h extends q {

    public static abstract class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final String f13466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f13467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f13468c;

        public a(@Nullable String str, @Nullable String str2, boolean z10) {
            this.f13466a = str;
            this.f13467b = str2;
            this.f13468c = z10;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.q
        @Nullable
        public abstract IronSourceError a();

        @Override // com.ironsource.mediationsdk.demandOnly.h
        @Nullable
        public String b() {
            return this.f13467b;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h
        @Nullable
        public String c() {
            return this.f13466a;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h
        public boolean d() {
            return this.f13468c;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final String f13469d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private final Activity f13470e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private final ISDemandOnlyBannerLayout f13471f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String adFormat, @Nullable Activity activity, @Nullable String str, @Nullable ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, @Nullable String str2, boolean z10) {
            super(str, str2, z10);
            t.i(adFormat, "adFormat");
            this.f13469d = adFormat;
            this.f13470e = activity;
            this.f13471f = iSDemandOnlyBannerLayout;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h.a, com.ironsource.mediationsdk.demandOnly.q
        @Nullable
        public IronSourceError a() {
            IronSourceError ironSourceErrorA = new q.a(this.f13469d).a(this);
            if (ironSourceErrorA != null) {
                return ironSourceErrorA;
            }
            return null;
        }

        @Nullable
        public final Activity f() {
            return this.f13470e;
        }

        @Nullable
        public final ISDemandOnlyBannerLayout g() {
            return this.f13471f;
        }

        public /* synthetic */ b(String str, Activity activity, String str2, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str3, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
            this(str, activity, str2, iSDemandOnlyBannerLayout, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? false : z10);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private String f13472a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Activity f13473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f13474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f13475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private String f13476e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private ISDemandOnlyBannerLayout f13477f;

        @NotNull
        public final b a() {
            return new b(this.f13472a, this.f13473b, this.f13474c, this.f13477f, this.f13476e, this.f13475d);
        }

        @NotNull
        public final c b(@Nullable String str) {
            this.f13474c = str;
            return this;
        }

        @NotNull
        public final c a(@Nullable Activity activity) {
            this.f13473b = activity;
            return this;
        }

        @NotNull
        public final d b() {
            return new d(this.f13472a, this.f13473b, this.f13474c, this.f13476e, this.f13475d);
        }

        @NotNull
        public final c a(@Nullable Activity activity, @Nullable Activity activity2) {
            if (activity == null) {
                activity = activity2;
            }
            this.f13473b = activity;
            return this;
        }

        @NotNull
        public final c a(@NotNull IronSource.AD_UNIT adFormat) {
            t.i(adFormat, "adFormat");
            String string = adFormat.toString();
            t.h(string, "adFormat.toString()");
            this.f13472a = string;
            return this;
        }

        @NotNull
        public final c a(@Nullable ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
            this.f13477f = iSDemandOnlyBannerLayout;
            return this;
        }

        @NotNull
        public final c a(@Nullable String str) {
            this.f13476e = str;
            return this;
        }

        @NotNull
        public final c a(boolean z10) {
            this.f13475d = z10;
            return this;
        }
    }

    public static final class d extends a implements com.ironsource.k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final String f13478d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private final Activity f13479e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull String adFormat, @Nullable Activity activity, @Nullable String str, @Nullable String str2, boolean z10) {
            super(str, str2, z10);
            t.i(adFormat, "adFormat");
            this.f13478d = adFormat;
            this.f13479e = activity;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h.a, com.ironsource.mediationsdk.demandOnly.q
        @Nullable
        public IronSourceError a() {
            IronSourceError ironSourceErrorA = new q.b(this.f13478d).a(this);
            if (ironSourceErrorA != null) {
                return ironSourceErrorA;
            }
            return null;
        }

        @Override // com.ironsource.k
        @Nullable
        public Activity e() {
            return this.f13479e;
        }

        public /* synthetic */ d(String str, Activity activity, String str2, String str3, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
            this(str, activity, str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? false : z10);
        }
    }

    @Nullable
    String b();

    @Nullable
    String c();

    boolean d();
}
