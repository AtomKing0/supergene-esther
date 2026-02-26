package com.onetrust.otpublishers.headless.UI.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends RecyclerView.Adapter<C0486a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTConfiguration f22891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f22893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c0 f22894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f22895m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f22896n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.mobiledatautils.d f22897o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final JSONArray f22898p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f22899q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c0 f22900r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f22901s = OTVendorListMode.GENERAL;

    /* JADX INFO: renamed from: com.onetrust.otpublishers.headless.UI.adapter.a$a, reason: collision with other inner class name */
    public static class C0486a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f22903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f22904d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f22905e;

        public C0486a(View view) {
            super(view);
            this.f22902b = (TextView) view.findViewById(p6.d.P6);
            this.f22903c = (TextView) view.findViewById(p6.d.K1);
            this.f22904d = (TextView) view.findViewById(p6.d.R1);
            this.f22905e = (TextView) view.findViewById(p6.d.f32808s7);
        }
    }

    public a(@NonNull Context context, @NonNull JSONArray jSONArray, @NonNull String str, @Nullable com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var, @Nullable OTConfiguration oTConfiguration, @Nullable String str2, int i10, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var2, @Nullable String str3, @NonNull com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar) {
        this.f22896n = context;
        this.f22898p = jSONArray;
        this.f22899q = str;
        this.f22900r = c0Var;
        this.f22891i = oTConfiguration;
        this.f22892j = str2;
        this.f22893k = i10;
        this.f22894l = c0Var2;
        this.f22895m = str3;
        this.f22897o = dVar;
    }

    public final void a(@NonNull C0486a c0486a) {
        Typeface otTypeFaceMap;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f22900r.f22732g;
        TextView textView = c0486a.f22902b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22720a.f22783b)) {
            textView.setTextSize(Float.parseFloat(cVar.f22720a.f22783b));
        }
        com.onetrust.otpublishers.headless.UI.Helper.l.q(c0486a.f22902b, this.f22900r.f22732g.f22721b);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = this.f22900r.f22732g.f22720a;
        TextView textView2 = c0486a.f22902b;
        OTConfiguration oTConfiguration = this.f22891i;
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
        return this.f22898p.length() + 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0194 A[Catch: Exception -> 0x01a6, TryCatch #0 {Exception -> 0x01a6, blocks: (B:3:0x0006, B:5:0x0012, B:8:0x002f, B:12:0x003e, B:14:0x0065, B:16:0x0069, B:17:0x0077, B:18:0x007a, B:20:0x007e, B:22:0x0085, B:24:0x009c, B:27:0x00c9, B:29:0x00cf, B:35:0x00f3, B:52:0x018a, B:54:0x0194, B:30:0x00d3, B:32:0x00e1, B:34:0x00f0, B:33:0x00e8, B:36:0x0106, B:56:0x01a2, B:38:0x010c, B:40:0x0123, B:43:0x014f, B:45:0x0155, B:51:0x0179, B:46:0x0159, B:48:0x0167, B:50:0x0176, B:49:0x016e, B:55:0x01a0), top: B:61:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder r8, int r9) {
        /*
            Method dump skipped, instruction units count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.adapter.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new C0486a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32877k, viewGroup, false));
    }
}
