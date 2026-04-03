package com.onetrust.otpublishers.headless.UI.TVUI.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONObject f22252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f22253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONArray f22254k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f22255l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OTPublishersHeadlessSDK f22256m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f22259p = "OTPCSubGroupTVAdapter";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.TVUI.datautils.b f22257n = com.onetrust.otpublishers.headless.UI.TVUI.datautils.b.a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22258o = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();

    public interface a {
        void a();

        void a(JSONObject jSONObject);
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f22261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f22262d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f22263e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f22264f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final LinearLayout f22265g;

        public b(View view) {
            super(view);
            this.f22261c = (TextView) view.findViewById(p6.d.S5);
            this.f22262d = (TextView) view.findViewById(p6.d.f32762n6);
            this.f22263e = (TextView) view.findViewById(p6.d.M);
            this.f22260b = (TextView) view.findViewById(p6.d.f32650b2);
            this.f22264f = (ImageView) view.findViewById(p6.d.W1);
            this.f22265g = (LinearLayout) view.findViewById(p6.d.Q5);
        }
    }

    public j(@NonNull JSONArray jSONArray, @NonNull Context context, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK, a aVar, @NonNull JSONObject jSONObject) {
        this.f22255l = context;
        this.f22254k = jSONArray;
        this.f22256m = oTPublishersHeadlessSDK;
        this.f22253j = aVar;
        this.f22252i = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar, String str, View view, boolean z10) {
        String strM;
        if (z10) {
            com.onetrust.otpublishers.headless.UI.UIProperty.q qVar = this.f22258o.f22370j.B;
            strM = qVar.f22797d;
            str = qVar.f22796c;
        } else {
            strM = this.f22258o.m();
        }
        e(bVar, strM, str);
    }

    @RequiresApi(api = 21)
    public static void e(@NonNull b bVar, @NonNull String str, @NonNull String str2) {
        bVar.f22265g.setBackgroundColor(Color.parseColor(str2));
        bVar.f22261c.setTextColor(Color.parseColor(str));
        bVar.f22262d.setTextColor(Color.parseColor(str));
        bVar.f22260b.setTextColor(Color.parseColor(str));
        bVar.f22263e.setTextColor(Color.parseColor(str));
        bVar.f22264f.getDrawable().setTint(Color.parseColor(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(b bVar, View view, int i10, KeyEvent keyEvent) {
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 22 || com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            try {
                this.f22253j.a(this.f22254k.getJSONObject(bVar.getAdapterPosition()));
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error in navigating to subgroups : "), "OneTrust", 6);
            }
        }
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 24) {
            return false;
        }
        this.f22253j.a();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[Catch: JSONException -> 0x00f0, TryCatch #0 {JSONException -> 0x00f0, blocks: (B:3:0x0002, B:5:0x002e, B:7:0x0036, B:13:0x0044, B:15:0x004c, B:22:0x005b, B:28:0x0084, B:32:0x009f, B:34:0x00c4, B:36:0x00cd, B:35:0x00c9, B:23:0x0066, B:27:0x007c, B:26:0x007a), top: B:42:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a A[Catch: JSONException -> 0x00f0, TryCatch #0 {JSONException -> 0x00f0, blocks: (B:3:0x0002, B:5:0x002e, B:7:0x0036, B:13:0x0044, B:15:0x004c, B:22:0x005b, B:28:0x0084, B:32:0x009f, B:34:0x00c4, B:36:0x00cd, B:35:0x00c9, B:23:0x0066, B:27:0x007c, B:26:0x007a), top: B:42:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4 A[Catch: JSONException -> 0x00f0, TryCatch #0 {JSONException -> 0x00f0, blocks: (B:3:0x0002, B:5:0x002e, B:7:0x0036, B:13:0x0044, B:15:0x004c, B:22:0x005b, B:28:0x0084, B:32:0x009f, B:34:0x00c4, B:36:0x00cd, B:35:0x00c9, B:23:0x0066, B:27:0x007c, B:26:0x007a), top: B:42:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c9 A[Catch: JSONException -> 0x00f0, TryCatch #0 {JSONException -> 0x00f0, blocks: (B:3:0x0002, B:5:0x002e, B:7:0x0036, B:13:0x0044, B:15:0x004c, B:22:0x005b, B:28:0x0084, B:32:0x009f, B:34:0x00c4, B:36:0x00cd, B:35:0x00c9, B:23:0x0066, B:27:0x007c, B:26:0x007a), top: B:42:0x0002 }] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @androidx.annotation.RequiresApi(api = 21)
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(@androidx.annotation.NonNull final com.onetrust.otpublishers.headless.UI.TVUI.adapter.j.b r8, int r9) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.adapter.j.onBindViewHolder(com.onetrust.otpublishers.headless.UI.TVUI.adapter.j$b, int):void");
    }

    public final void f(@NonNull b bVar, @NonNull JSONObject jSONObject) {
        try {
            Context context = this.f22255l;
            JSONObject jSONObject2 = this.f22252i;
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar = this.f22258o;
            String strE = com.onetrust.otpublishers.headless.UI.Helper.l.e(context, jSONObject2, jSONObject, cVar.f22366f, cVar.f22365e);
            if (com.onetrust.otpublishers.headless.Internal.c.q(strE)) {
                bVar.f22262d.setVisibility(8);
            } else {
                bVar.f22262d.setText(strE);
                bVar.f22262d.setVisibility(0);
            }
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error on displaying vendor count on TV pc details page. Error = "), this.f22259p, 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        JSONArray jSONArray = this.f22254k;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(this.f22255l).inflate(p6.e.f32884r, viewGroup, false));
    }
}
