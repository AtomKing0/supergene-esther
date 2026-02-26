package com.onetrust.otpublishers.headless.UI.TVUI.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f22212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONArray f22213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f22214k;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RelativeLayout f22216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f22217d;

        public a(View view) {
            super(view);
            this.f22215b = (TextView) view.findViewById(p6.d.f32758n2);
            this.f22216c = (RelativeLayout) view.findViewById(p6.d.f32740l2);
            this.f22217d = view.findViewById(p6.d.f32767o2);
        }
    }

    public d(@NonNull Context context, @NonNull JSONArray jSONArray, @NonNull String str) {
        this.f22212i = context;
        this.f22213j = jSONArray;
        this.f22214k = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22213j.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        a aVar = (a) viewHolder;
        aVar.setIsRecyclable(false);
        if (i10 == 0) {
            try {
                aVar.f22217d.setVisibility(8);
            } catch (Exception e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while rendering purpose items in Vendor detail screen "), "OneTrust", 6);
                return;
            }
        }
        aVar.f22216c.setVisibility(0);
        com.onetrust.otpublishers.headless.UI.Helper.l.j(this.f22212i, aVar.f22215b, this.f22213j.getString(i10));
        aVar.f22215b.setTextColor(Color.parseColor(this.f22214k));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32881o, viewGroup, false));
    }
}
