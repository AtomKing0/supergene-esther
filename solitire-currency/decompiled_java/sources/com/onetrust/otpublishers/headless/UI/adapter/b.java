package com.onetrust.otpublishers.headless.UI.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTConfiguration f22908i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c0 f22911l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f22913n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.mobiledatautils.d f22914o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final JSONArray f22915p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f22916q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c0 f22917r;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22909j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f22910k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f22912m = "";

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RelativeLayout f22919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f22920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f22921e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f22922f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f22923g;

        public a(View view) {
            super(view);
            this.f22918b = (TextView) view.findViewById(p6.d.f32758n2);
            this.f22919c = (RelativeLayout) view.findViewById(p6.d.f32740l2);
            this.f22920d = view.findViewById(p6.d.f32767o2);
            this.f22921e = (TextView) view.findViewById(p6.d.K1);
            this.f22922f = (TextView) view.findViewById(p6.d.R1);
            this.f22923g = (TextView) view.findViewById(p6.d.f32808s7);
        }
    }

    public b(@NonNull Context context, @NonNull JSONArray jSONArray, @NonNull String str, @Nullable com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var, @Nullable OTConfiguration oTConfiguration, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var2, @NonNull com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar) {
        this.f22913n = context;
        this.f22915p = jSONArray;
        this.f22916q = str;
        this.f22917r = c0Var;
        this.f22908i = oTConfiguration;
        this.f22911l = c0Var2;
        this.f22914o = dVar;
    }

    public final void a(@NonNull a aVar) {
        Typeface otTypeFaceMap;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f22917r.f22732g;
        TextView textView = aVar.f22918b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22720a.f22783b)) {
            textView.setTextSize(Float.parseFloat(cVar.f22720a.f22783b));
        }
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f22918b, this.f22917r.f22732g.f22721b);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = this.f22917r.f22732g.f22720a;
        TextView textView2 = aVar.f22918b;
        OTConfiguration oTConfiguration = this.f22908i;
        String str = lVar.f22785d;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            textView2.setTypeface(otTypeFaceMap);
        } else {
            int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView2, lVar.f22784c);
            textView2.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA) : Typeface.create(textView2.getTypeface(), iA));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22915p.length() + 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x016e A[Catch: Exception -> 0x0180, TryCatch #0 {Exception -> 0x0180, blocks: (B:3:0x0006, B:5:0x0012, B:9:0x0031, B:10:0x0036, B:12:0x0058, B:14:0x005f, B:16:0x0076, B:19:0x00a3, B:21:0x00a9, B:27:0x00cd, B:44:0x0164, B:46:0x016e, B:22:0x00ad, B:24:0x00bb, B:26:0x00ca, B:25:0x00c2, B:28:0x00e0, B:48:0x017c, B:30:0x00e6, B:32:0x00fd, B:35:0x0129, B:37:0x012f, B:43:0x0153, B:38:0x0133, B:40:0x0141, B:42:0x0150, B:41:0x0148, B:47:0x017a), top: B:53:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder r5, int r6) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.adapter.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32880n, viewGroup, false));
    }
}
