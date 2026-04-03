package com.onetrust.otpublishers.headless.UI.TVUI.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f22239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONArray f22240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22241k = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f22243m;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f22245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f22246d;

        public b(View view) {
            super(view);
            this.f22244b = (TextView) view.findViewById(p6.d.S5);
            this.f22245c = (TextView) view.findViewById(p6.d.O5);
            this.f22246d = (LinearLayout) view.findViewById(p6.d.Q5);
        }
    }

    public g(@NonNull FragmentActivity fragmentActivity, @NonNull JSONArray jSONArray, @NonNull a aVar) {
        this.f22240j = jSONArray;
        this.f22239i = aVar;
        this.f22243m = new com.onetrust.otpublishers.headless.Internal.Preferences.g(fragmentActivity).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(JSONObject jSONObject, b bVar, com.onetrust.otpublishers.headless.UI.UIProperty.q qVar, View view, boolean z10) {
        if (!z10) {
            bVar.f22246d.setBackgroundColor(Color.parseColor(qVar.f22794a));
            bVar.f22244b.setTextColor(Color.parseColor(qVar.f22795b));
            bVar.f22245c.setTextColor(Color.parseColor(qVar.f22795b));
            return;
        }
        a aVar = this.f22239i;
        int adapterPosition = bVar.getAdapterPosition();
        com.onetrust.otpublishers.headless.UI.TVUI.fragments.q qVar2 = (com.onetrust.otpublishers.headless.UI.TVUI.fragments.q) aVar;
        qVar2.a(jSONObject);
        if (adapterPosition != -1) {
            g gVar = qVar2.f22627s;
            if (adapterPosition != gVar.f22242l) {
                gVar.f22242l = adapterPosition;
                qVar2.f22628t = false;
            }
        }
        bVar.f22246d.setBackgroundColor(Color.parseColor(qVar.f22796c));
        bVar.f22244b.setTextColor(Color.parseColor(qVar.f22797d));
        bVar.f22245c.setTextColor(Color.parseColor(qVar.f22797d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(b bVar, com.onetrust.otpublishers.headless.UI.UIProperty.q qVar, int i10, View view, int i11, KeyEvent keyEvent) {
        View view2;
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i11, keyEvent) != 22) {
            if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i11, keyEvent) == 24) {
                ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.q) this.f22239i).f22627s.notifyDataSetChanged();
            }
            if (bVar.getAdapterPosition() == 0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i11, keyEvent) == 25) {
                bVar.f22246d.requestFocus();
                return true;
            }
            if (i10 != this.f22240j.length() - 1 || com.onetrust.otpublishers.headless.UI.Helper.i.a(i11, keyEvent) != 26) {
                return false;
            }
            com.onetrust.otpublishers.headless.UI.TVUI.fragments.q qVar2 = (com.onetrust.otpublishers.headless.UI.TVUI.fragments.q) this.f22239i;
            qVar2.f22628t = false;
            qVar2.f22613e.requestFocus();
            return true;
        }
        int adapterPosition = bVar.getAdapterPosition();
        this.f22242l = adapterPosition;
        com.onetrust.otpublishers.headless.UI.TVUI.fragments.q qVar3 = (com.onetrust.otpublishers.headless.UI.TVUI.fragments.q) this.f22239i;
        qVar3.f22628t = true;
        com.onetrust.otpublishers.headless.UI.TVUI.fragments.g gVar = qVar3.f22623o;
        if (gVar.f22557u.optBoolean("IS_PARTNERS_LINK")) {
            view2 = gVar.f22554r;
        } else if (gVar.C.getVisibility() == 0) {
            view2 = gVar.C;
        } else {
            if (gVar.D.getVisibility() != 0) {
                if (gVar.f22537b.getVisibility() == 0) {
                    view2 = gVar.f22537b;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("OT_FOCUSED_PC_LIST_ITEM", adapterPosition);
                qVar3.setArguments(bundle);
                bVar.f22246d.setBackgroundColor(Color.parseColor(qVar.f22798e));
                bVar.f22244b.setTextColor(Color.parseColor(qVar.f22799f));
                bVar.f22245c.setTextColor(Color.parseColor(qVar.f22799f));
                return true;
            }
            view2 = gVar.D;
        }
        view2.requestFocus();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("OT_FOCUSED_PC_LIST_ITEM", adapterPosition);
        qVar3.setArguments(bundle2);
        bVar.f22246d.setBackgroundColor(Color.parseColor(qVar.f22798e));
        bVar.f22244b.setTextColor(Color.parseColor(qVar.f22799f));
        bVar.f22245c.setTextColor(Color.parseColor(qVar.f22799f));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(final b bVar, final int i10) {
        StringBuilder sb;
        String str = "GroupNameOTT";
        try {
            final com.onetrust.otpublishers.headless.UI.UIProperty.q qVar = this.f22241k.f22370j.B;
            final JSONObject jSONObject = this.f22240j.getJSONObject(bVar.getAdapterPosition());
            bVar.f22244b.setTextColor(Color.parseColor(this.f22241k.f22370j.B.f22795b));
            bVar.f22246d.setBackgroundColor(Color.parseColor(qVar.f22794a));
            Context context = bVar.f22246d.getContext();
            TextView textView = bVar.f22244b;
            if (com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("GroupNameOTT"))) {
                str = "GroupName";
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.j(context, textView, jSONObject.optString(str));
            bVar.f22245c.setTextColor(Color.parseColor(this.f22241k.f22370j.B.f22795b));
            Context context2 = bVar.f22246d.getContext();
            JSONObject jSONObject2 = this.f22243m;
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar = this.f22241k;
            String strE = com.onetrust.otpublishers.headless.UI.Helper.l.e(context2, jSONObject2, jSONObject, cVar.f22366f, cVar.f22365e);
            if (com.onetrust.otpublishers.headless.Internal.c.q(strE)) {
                bVar.f22245c.setVisibility(8);
            } else {
                com.onetrust.otpublishers.headless.UI.Helper.l.j(bVar.f22246d.getContext(), bVar.f22245c, strE);
                bVar.f22245c.setVisibility(0);
            }
            bVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.e
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    this.f22231a.d(jSONObject, bVar, qVar, view, z10);
                }
            });
            bVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.f
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                    return this.f22235a.e(bVar, qVar, i10, view, i11, keyEvent);
                }
            });
        } catch (StringIndexOutOfBoundsException e10) {
            sb = new StringBuilder("TV PC: error in rendering groups due to corrupted data,  ");
            sb.append(e10);
            OTLogger.a("OneTrust", 6, sb.toString());
        } catch (JSONException e11) {
            sb = new StringBuilder("TV PC: error in rendering groups ");
            sb.append(e11.getMessage());
            OTLogger.a("OneTrust", 6, sb.toString());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22240j.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32886t, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        b bVar = (b) viewHolder;
        super.onViewAttachedToWindow(bVar);
        if (bVar.getAdapterPosition() == this.f22242l) {
            bVar.itemView.requestFocus();
        }
    }
}
