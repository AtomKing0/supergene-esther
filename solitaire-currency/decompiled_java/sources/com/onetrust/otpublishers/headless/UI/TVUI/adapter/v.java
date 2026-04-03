package com.onetrust.otpublishers.headless.UI.TVUI.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class v extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONArray f22318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22319j;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22320b;

        public a(View view) {
            super(view);
            this.f22320b = (TextView) view.findViewById(p6.d.f32850x6);
        }
    }

    public v(@NonNull String str, @NonNull JSONArray jSONArray) {
        this.f22318i = jSONArray;
        this.f22319j = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22318i.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        a aVar = (a) viewHolder;
        aVar.setIsRecyclable(false);
        try {
            aVar.f22320b.setText(this.f22318i.getJSONObject(aVar.getAdapterPosition()).getString("name"));
            aVar.f22320b.setTextColor(Color.parseColor(this.f22319j));
            TextView textView = aVar.f22320b;
            String str = this.f22319j;
            for (Drawable drawable : textView.getCompoundDrawables()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN));
                }
            }
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while rendering purpose items in Vendor detail screen "), "OneTrust", 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.J, viewGroup, false));
    }
}
