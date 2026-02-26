package com.onetrust.otpublishers.headless.UI.TVUI.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class q extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f22287q = Pattern.compile("([a-f]).*");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f22288r = Pattern.compile("([g-l]).*");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f22289s = Pattern.compile("([m-r]).*");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f22290t = Pattern.compile("([s-z]).*");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f22291i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f22294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f22296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<String> f22297o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f22298p;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22293k = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONArray f22292j = com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a().e();

    public class a implements Comparator<JSONObject> {
        @Override // java.util.Comparator
        public final int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            String lowerCase;
            JSONObject jSONObject3 = jSONObject2;
            String lowerCase2 = "";
            try {
                String string = jSONObject.getString("Name");
                Locale locale = Locale.ENGLISH;
                lowerCase = string.toLowerCase(locale);
                try {
                    lowerCase2 = jSONObject3.getString("Name").toLowerCase(locale);
                } catch (JSONException e10) {
                    e = e10;
                    com.onetrust.otpublishers.headless.Internal.Helper.n.a(e, new StringBuilder("error while sorting VL json object lists,err : "), "TVSdkList", 6);
                }
            } catch (JSONException e11) {
                e = e11;
                lowerCase = "";
            }
            return lowerCase.compareTo(lowerCase2);
        }
    }

    public interface b {
    }

    public static class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinearLayout f22300c;

        public c(View view) {
            super(view);
            this.f22299b = (TextView) view.findViewById(p6.d.S5);
            this.f22300c = (LinearLayout) view.findViewById(p6.d.Q5);
        }
    }

    public q(@NonNull Context context, @NonNull b bVar, @Nullable List<String> list) {
        this.f22294l = new ArrayList();
        this.f22291i = bVar;
        this.f22294l = list;
        this.f22298p = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(JSONObject jSONObject, c cVar, View view, boolean z10) {
        if (!z10) {
            cVar.f22299b.setTextColor(Color.parseColor(this.f22293k.f22370j.B.f22795b));
            cVar.f22300c.setBackgroundColor(Color.parseColor(this.f22293k.f22370j.B.f22794a));
            return;
        }
        com.onetrust.otpublishers.headless.UI.TVUI.fragments.u uVar = (com.onetrust.otpublishers.headless.UI.TVUI.fragments.u) this.f22291i;
        uVar.B = false;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = uVar.A;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = uVar.f22688z;
        com.onetrust.otpublishers.headless.UI.TVUI.fragments.r rVar = new com.onetrust.otpublishers.headless.UI.TVUI.fragments.r();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_DETAIL_FRAGMENT);
        rVar.setArguments(bundle);
        rVar.f22645p = uVar;
        rVar.f22641l = jSONObject;
        rVar.f22650u = aVar;
        rVar.f22651v = oTPublishersHeadlessSDK;
        uVar.f22677o = rVar;
        uVar.t(rVar);
        cVar.f22299b.setTextColor(Color.parseColor(this.f22293k.f22370j.B.f22797d));
        cVar.f22300c.setBackgroundColor(Color.parseColor(this.f22293k.f22370j.B.f22796c));
        if (cVar.getAdapterPosition() == -1 || cVar.getAdapterPosition() == this.f22295m) {
            return;
        }
        this.f22295m = cVar.getAdapterPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(c cVar, View view, int i10, KeyEvent keyEvent) {
        Button button;
        View view2;
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 22) {
            if (cVar.getAdapterPosition() != 0 || com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 25) {
                return false;
            }
            com.onetrust.otpublishers.headless.UI.TVUI.fragments.u uVar = (com.onetrust.otpublishers.headless.UI.TVUI.fragments.u) this.f22291i;
            if (uVar.f22687y.equals("A_F")) {
                button = uVar.f22681s;
            } else if (uVar.f22687y.equals("G_L")) {
                button = uVar.f22682t;
            } else {
                if (!uVar.f22687y.equals("M_R")) {
                    if (uVar.f22687y.equals("S_Z")) {
                        button = uVar.f22684v;
                    }
                    return true;
                }
                button = uVar.f22683u;
            }
            button.requestFocus();
            return true;
        }
        this.f22295m = cVar.getAdapterPosition();
        com.onetrust.otpublishers.headless.UI.TVUI.fragments.u uVar2 = (com.onetrust.otpublishers.headless.UI.TVUI.fragments.u) this.f22291i;
        uVar2.B = true;
        com.onetrust.otpublishers.headless.UI.TVUI.fragments.r rVar = uVar2.f22677o;
        if (rVar.f22636g.getVisibility() != 0) {
            rVar.f22633d.setFocusableInTouchMode(true);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(rVar.f22633d.getText().toString())) {
                view2 = rVar.f22633d;
            }
            uVar2.f22680r.clearFocus();
            uVar2.f22679q.clearFocus();
            uVar2.f22678p.clearFocus();
            cVar.f22299b.setTextColor(Color.parseColor(this.f22293k.f22370j.B.f22799f));
            cVar.f22300c.setBackgroundColor(Color.parseColor(this.f22293k.f22370j.B.f22798e));
            return true;
        }
        view2 = rVar.f22636g;
        view2.requestFocus();
        uVar2.f22680r.clearFocus();
        uVar2.f22679q.clearFocus();
        uVar2.f22678p.clearFocus();
        cVar.f22299b.setTextColor(Color.parseColor(this.f22293k.f22370j.B.f22799f));
        cVar.f22300c.setBackgroundColor(Color.parseColor(this.f22293k.f22370j.B.f22798e));
        return true;
    }

    public final List<JSONObject> c() {
        Context context = this.f22298p;
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
        new com.onetrust.otpublishers.headless.Internal.Models.d(context);
        JSONArray jSONArrayA = com.onetrust.otpublishers.headless.Internal.Helper.t.a(this.f22294l, this.f22292j);
        this.f22296n = new ArrayList();
        if (this.f22297o == null) {
            this.f22297o = new ArrayList<>();
        }
        if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayA)) {
            OTLogger.a("TVSdkList", 6, "setSDKListData: Empty data found for SDKs");
            return null;
        }
        for (int i10 = 0; i10 < jSONArrayA.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArrayA.getJSONObject(i10);
                if (this.f22297o.isEmpty()) {
                    this.f22296n.add(jSONObject);
                } else {
                    e(this.f22296n, jSONObject);
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.n.a(e10, new StringBuilder("error while constructing SDK List json object lists,err : "), "TVSdkList", 6);
            }
        }
        Collections.sort(this.f22296n, new a());
        return this.f22296n;
    }

    public final void d(@NonNull final c cVar) {
        JSONException e10;
        JSONObject jSONObject;
        int adapterPosition = cVar.getAdapterPosition();
        OTLogger.a("TVSdkList", 2, "filtered sdks count " + this.f22296n.size());
        final JSONObject jSONObject2 = new JSONObject();
        if (this.f22296n != null) {
            try {
                cVar.setIsRecyclable(false);
                jSONObject = (JSONObject) this.f22296n.get(adapterPosition);
                try {
                    com.onetrust.otpublishers.headless.UI.Helper.l.j(cVar.f22300c.getContext(), cVar.f22299b, jSONObject.getString("Name"));
                } catch (JSONException e11) {
                    e10 = e11;
                    com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("exception thrown when rendering SDKs, err : "), "OneTrust", 6);
                }
            } catch (JSONException e12) {
                e10 = e12;
                jSONObject = jSONObject2;
            }
            jSONObject2 = jSONObject;
        }
        cVar.f22299b.setTextColor(Color.parseColor(this.f22293k.f22370j.B.f22795b));
        cVar.f22300c.setBackgroundColor(Color.parseColor(this.f22293k.f22370j.B.f22794a));
        cVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.o
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f22282a.f(jSONObject2, cVar, view, z10);
            }
        });
        cVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.p
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return this.f22285a.g(cVar, view, i10, keyEvent);
            }
        });
    }

    public final void e(@NonNull List<JSONObject> list, @NonNull JSONObject jSONObject) {
        String strTrim = jSONObject.getString("Name").toLowerCase(Locale.ENGLISH).trim();
        if (this.f22297o.contains("A_F") && f22287q.matcher(strTrim).matches()) {
            list.add(jSONObject);
        }
        if (this.f22297o.contains("G_L") && f22288r.matcher(strTrim).matches()) {
            list.add(jSONObject);
        }
        if (this.f22297o.contains("M_R") && f22289s.matcher(strTrim).matches()) {
            list.add(jSONObject);
        }
        if (this.f22297o.contains("S_Z") && f22290t.matcher(strTrim).matches()) {
            list.add(jSONObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22296n.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        d((c) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32886t, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        c cVar = (c) viewHolder;
        super.onViewAttachedToWindow(cVar);
        if (cVar.getAdapterPosition() == this.f22295m) {
            cVar.itemView.requestFocus();
        }
    }
}
