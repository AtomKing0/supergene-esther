package com.ironsource;

import android.view.View;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.ironsource.cg;
import com.ironsource.v8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private cg f12268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private View f12269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private View f12270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private View f12271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private View f12272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private View f12273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private View f12274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private View f12275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private a f12276i;

    public interface a {
        void a(@NotNull fu fuVar);

        void a(@NotNull b bVar);
    }

    public enum b {
        Title("title"),
        Advertiser(v8.h.F0),
        Body("body"),
        Cta("cta"),
        Icon(v8.h.H0),
        Container(TtmlNode.RUBY_CONTAINER),
        PrivacyIcon(v8.h.J0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12285a;

        b(String str) {
            this.f12285a = str;
        }

        @NotNull
        public final String b() {
            return this.f12285a;
        }
    }

    public static final class c implements cg.a {
        c() {
        }

        @Override // com.ironsource.cg.a
        public void a(@NotNull fu viewVisibilityParams) {
            kotlin.jvm.internal.t.i(viewVisibilityParams, "viewVisibilityParams");
            a aVarN = gg.this.n();
            if (aVarN != null) {
                aVarN.a(viewVisibilityParams);
            }
        }
    }

    public gg(@NotNull cg containerView, @Nullable View view, @Nullable View view2, @Nullable View view3, @Nullable View view4, @Nullable View view5, @Nullable View view6, @NotNull View privacyIconView) {
        kotlin.jvm.internal.t.i(containerView, "containerView");
        kotlin.jvm.internal.t.i(privacyIconView, "privacyIconView");
        this.f12268a = containerView;
        this.f12269b = view;
        this.f12270c = view2;
        this.f12271d = view3;
        this.f12272e = view4;
        this.f12273f = view5;
        this.f12274g = view6;
        this.f12275h = privacyIconView;
        r();
        s();
    }

    private final void r() {
        a(this, this.f12269b, b.Title);
        a(this, this.f12270c, b.Advertiser);
        a(this, this.f12272e, b.Body);
        a(this, this.f12274g, b.Cta);
        a(this, this.f12271d, b.Icon);
        a(this, this.f12268a, b.Container);
        a(this, this.f12275h, b.PrivacyIcon);
    }

    private final void s() {
        this.f12268a.setListener$mediationsdk_release(new c());
    }

    @NotNull
    public final cg a() {
        return this.f12268a;
    }

    @Nullable
    public final View c() {
        return this.f12270c;
    }

    @Nullable
    public final View d() {
        return this.f12271d;
    }

    @Nullable
    public final View e() {
        return this.f12272e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gg)) {
            return false;
        }
        gg ggVar = (gg) obj;
        return kotlin.jvm.internal.t.d(this.f12268a, ggVar.f12268a) && kotlin.jvm.internal.t.d(this.f12269b, ggVar.f12269b) && kotlin.jvm.internal.t.d(this.f12270c, ggVar.f12270c) && kotlin.jvm.internal.t.d(this.f12271d, ggVar.f12271d) && kotlin.jvm.internal.t.d(this.f12272e, ggVar.f12272e) && kotlin.jvm.internal.t.d(this.f12273f, ggVar.f12273f) && kotlin.jvm.internal.t.d(this.f12274g, ggVar.f12274g) && kotlin.jvm.internal.t.d(this.f12275h, ggVar.f12275h);
    }

    @Nullable
    public final View f() {
        return this.f12273f;
    }

    @Nullable
    public final View g() {
        return this.f12274g;
    }

    @NotNull
    public final View h() {
        return this.f12275h;
    }

    public int hashCode() {
        int iHashCode = this.f12268a.hashCode() * 31;
        View view = this.f12269b;
        int iHashCode2 = (iHashCode + (view == null ? 0 : view.hashCode())) * 31;
        View view2 = this.f12270c;
        int iHashCode3 = (iHashCode2 + (view2 == null ? 0 : view2.hashCode())) * 31;
        View view3 = this.f12271d;
        int iHashCode4 = (iHashCode3 + (view3 == null ? 0 : view3.hashCode())) * 31;
        View view4 = this.f12272e;
        int iHashCode5 = (iHashCode4 + (view4 == null ? 0 : view4.hashCode())) * 31;
        View view5 = this.f12273f;
        int iHashCode6 = (iHashCode5 + (view5 == null ? 0 : view5.hashCode())) * 31;
        View view6 = this.f12274g;
        return ((iHashCode6 + (view6 != null ? view6.hashCode() : 0)) * 31) + this.f12275h.hashCode();
    }

    @Nullable
    public final View i() {
        return this.f12270c;
    }

    @Nullable
    public final View j() {
        return this.f12272e;
    }

    @NotNull
    public final cg k() {
        return this.f12268a;
    }

    @Nullable
    public final View l() {
        return this.f12274g;
    }

    @Nullable
    public final View m() {
        return this.f12271d;
    }

    @Nullable
    public final a n() {
        return this.f12276i;
    }

    @Nullable
    public final View o() {
        return this.f12273f;
    }

    @NotNull
    public final View p() {
        return this.f12275h;
    }

    @Nullable
    public final View q() {
        return this.f12269b;
    }

    @NotNull
    public final JSONObject t() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("title", this.f12269b != null).put(v8.h.F0, this.f12270c != null).put("body", this.f12272e != null).put("cta", this.f12274g != null).put(v8.h.I0, this.f12273f != null).put(v8.h.H0, this.f12271d != null);
        kotlin.jvm.internal.t.h(jSONObjectPut, "JSONObject()\n        .pu…\"icon\", iconView != null)");
        return jSONObjectPut;
    }

    @NotNull
    public String toString() {
        return "ISNNativeAdViewHolder(containerView=" + this.f12268a + ", titleView=" + this.f12269b + ", advertiserView=" + this.f12270c + ", iconView=" + this.f12271d + ", bodyView=" + this.f12272e + ", mediaView=" + this.f12273f + ", ctaView=" + this.f12274g + ", privacyIconView=" + this.f12275h + ')';
    }

    public /* synthetic */ gg(cg cgVar, View view, View view2, View view3, View view4, View view5, View view6, View view7, int i10, kotlin.jvm.internal.k kVar) {
        this(cgVar, (i10 & 2) != 0 ? null : view, (i10 & 4) != 0 ? null : view2, (i10 & 8) != 0 ? null : view3, (i10 & 16) != 0 ? null : view4, (i10 & 32) != 0 ? null : view5, (i10 & 64) != 0 ? null : view6, view7);
    }

    @NotNull
    public final gg a(@NotNull cg containerView, @Nullable View view, @Nullable View view2, @Nullable View view3, @Nullable View view4, @Nullable View view5, @Nullable View view6, @NotNull View privacyIconView) {
        kotlin.jvm.internal.t.i(containerView, "containerView");
        kotlin.jvm.internal.t.i(privacyIconView, "privacyIconView");
        return new gg(containerView, view, view2, view3, view4, view5, view6, privacyIconView);
    }

    @Nullable
    public final View b() {
        return this.f12269b;
    }

    public final void c(@Nullable View view) {
        this.f12274g = view;
    }

    public final void d(@Nullable View view) {
        this.f12271d = view;
    }

    public final void e(@Nullable View view) {
        this.f12273f = view;
    }

    public final void f(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "<set-?>");
        this.f12275h = view;
    }

    public final void g(@Nullable View view) {
        this.f12269b = view;
    }

    public final void b(@Nullable View view) {
        this.f12272e = view;
    }

    public final void a(@Nullable View view) {
        this.f12270c = view;
    }

    public final void a(@NotNull cg cgVar) {
        kotlin.jvm.internal.t.i(cgVar, "<set-?>");
        this.f12268a = cgVar;
    }

    public final void a(@Nullable a aVar) {
        this.f12276i = aVar;
    }

    private static final void a(final gg ggVar, View view, final b bVar) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.ironsource.jw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    gg.a(this.f12787a, bVar, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gg this$0, b viewName, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(viewName, "$viewName");
        a aVar = this$0.f12276i;
        if (aVar != null) {
            aVar.a(viewName);
        }
    }
}
