package com.onetrust.otpublishers.headless.UI.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.UI.adapter.p0;
import com.onetrust.otpublishers.headless.UI.fragment.r2;
import com.onetrust.otpublishers.headless.UI.fragment.s2;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class p0 extends ListAdapter<com.onetrust.otpublishers.headless.UI.DataModels.i, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.DataModels.l f23101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final OTConfiguration f23102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f23103k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final h9.p<String, Boolean, v8.k0> f23104l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final h9.l<String, v8.k0> f23105m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LayoutInflater f23106n;

    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final com.onetrust.otpublishers.headless.databinding.d f23107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final com.onetrust.otpublishers.headless.UI.DataModels.l f23108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final OTConfiguration f23109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f23110e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public final h9.p<String, Boolean, v8.k0> f23111f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        public final h9.l<String, v8.k0> f23112g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull com.onetrust.otpublishers.headless.databinding.d binding, @NotNull com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, @Nullable OTConfiguration oTConfiguration, boolean z10, @NotNull h9.p<? super String, ? super Boolean, v8.k0> onItemToggleCheckedChange, @NotNull h9.l<? super String, v8.k0> onItemClicked) {
            super(binding.a());
            kotlin.jvm.internal.t.i(binding, "binding");
            kotlin.jvm.internal.t.i(vendorListData, "vendorListData");
            kotlin.jvm.internal.t.i(onItemToggleCheckedChange, "onItemToggleCheckedChange");
            kotlin.jvm.internal.t.i(onItemClicked, "onItemClicked");
            this.f23107b = binding;
            this.f23108c = vendorListData;
            this.f23109d = oTConfiguration;
            this.f23110e = z10;
            this.f23111f = onItemToggleCheckedChange;
            this.f23112g = onItemClicked;
        }

        public static final void c(a this$0, com.onetrust.otpublishers.headless.UI.DataModels.i iVar, View view) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            this$0.f23112g.invoke(iVar.f22114a);
        }

        public static final void d(a this$0, com.onetrust.otpublishers.headless.UI.DataModels.i item, CompoundButton compoundButton, boolean z10) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(item, "$item");
            this$0.f23111f.mo4invoke(item.f22114a, Boolean.valueOf(z10));
            this$0.e(z10);
        }

        public final void a(final com.onetrust.otpublishers.headless.UI.DataModels.i iVar) {
            SwitchCompat switchCompat = this.f23107b.f23740c;
            switchCompat.setOnCheckedChangeListener(null);
            int iOrdinal = iVar.f22116c.ordinal();
            if (iOrdinal == 0) {
                switchCompat.setChecked(true);
                e(true);
            } else if (iOrdinal == 1) {
                switchCompat.setChecked(false);
                e(false);
            } else if (iOrdinal == 2) {
                kotlin.jvm.internal.t.h(switchCompat, "");
                switchCompat.setVisibility(8);
            } else if (iOrdinal == 3) {
                switchCompat.setChecked(true);
                e(true);
                switchCompat.setEnabled(false);
                switchCompat.setAlpha(0.5f);
            }
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.o0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    p0.a.d(this.f23091a, iVar, compoundButton, z10);
                }
            });
            switchCompat.setContentDescription(this.f23108c.f22138q);
        }

        public final void b(@Nullable final com.onetrust.otpublishers.headless.UI.DataModels.i iVar, boolean z10) {
            com.onetrust.otpublishers.headless.databinding.d dVar = this.f23107b;
            RelativeLayout vlItems = dVar.f23744g;
            kotlin.jvm.internal.t.h(vlItems, "vlItems");
            boolean z11 = !z10;
            vlItems.setVisibility(z11 ? 0 : 8);
            View view3 = dVar.f23742e;
            kotlin.jvm.internal.t.h(view3, "view3");
            view3.setVisibility(z11 ? 0 : 8);
            SwitchCompat switchButton = dVar.f23740c;
            kotlin.jvm.internal.t.h(switchButton, "switchButton");
            switchButton.setVisibility(!z10 && this.f23110e ? 0 : 8);
            TextView viewPoweredByLogo = dVar.f23743f;
            kotlin.jvm.internal.t.h(viewPoweredByLogo, "viewPoweredByLogo");
            viewPoweredByLogo.setVisibility(z10 ? 0 : 8);
            if (z10 || iVar == null) {
                TextView textView = this.f23107b.f23743f;
                com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.f23108c.f22143v;
                if (xVar == null || !xVar.f22857i) {
                    kotlin.jvm.internal.t.h(textView, "");
                    textView.setVisibility(8);
                    return;
                }
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = xVar.f22860l;
                kotlin.jvm.internal.t.h(cVar, "vendorListData.otPCUIPro…leDescriptionTextProperty");
                textView.setTextColor(Color.parseColor(cVar.f22722c));
                kotlin.jvm.internal.t.h(textView, "");
                com.onetrust.otpublishers.headless.UI.extensions.m.h(textView, cVar.f22720a.f22783b);
                com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
                kotlin.jvm.internal.t.h(lVar, "descriptionTextProperty.fontProperty");
                com.onetrust.otpublishers.headless.UI.extensions.m.d(textView, lVar, this.f23109d);
                textView.setTextAlignment(com.onetrust.otpublishers.headless.Internal.Helper.k.e(textView.getContext()) ? 6 : 4);
                return;
            }
            ImageView gvShowMore = dVar.f23739b;
            kotlin.jvm.internal.t.h(gvShowMore, "gvShowMore");
            gvShowMore.setVisibility(0);
            dVar.f23741d.setText(iVar.f22115b);
            dVar.f23741d.setLabelFor(p6.d.f32680e5);
            dVar.f23744g.setOnClickListener(null);
            dVar.f23744g.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.n0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p0.a.c(this.f23085a, iVar, view);
                }
            });
            com.onetrust.otpublishers.headless.databinding.d dVar2 = this.f23107b;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23108c.f22132k;
            TextView vendorName = dVar2.f23741d;
            OTConfiguration oTConfiguration = this.f23109d;
            kotlin.jvm.internal.t.h(vendorName, "vendorName");
            com.onetrust.otpublishers.headless.UI.extensions.m.b(vendorName, cVar2, null, oTConfiguration, false, 2);
            ImageView gvShowMore2 = dVar2.f23739b;
            kotlin.jvm.internal.t.h(gvShowMore2, "gvShowMore");
            String str = this.f23108c.f22144w;
            kotlin.jvm.internal.t.i(gvShowMore2, "<this>");
            if (!(str == null || str.length() == 0)) {
                gvShowMore2.setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
            }
            View view32 = dVar2.f23742e;
            kotlin.jvm.internal.t.h(view32, "view3");
            com.onetrust.otpublishers.headless.UI.extensions.n.a(this.f23108c.f22126e, view32);
            a(iVar);
        }

        public final void e(boolean z10) {
            SwitchCompat switchCompat = this.f23107b.f23740c;
            String str = z10 ? this.f23108c.f22128g : this.f23108c.f22129h;
            kotlin.jvm.internal.t.h(switchCompat, "");
            com.onetrust.otpublishers.headless.UI.extensions.k.a(switchCompat, this.f23108c.f22127f, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(@NotNull com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, @Nullable OTConfiguration oTConfiguration, boolean z10, @NotNull r2 onItemToggleCheckedChange, @NotNull s2 onItemClicked) {
        super(new k0());
        kotlin.jvm.internal.t.i(vendorListData, "vendorListData");
        kotlin.jvm.internal.t.i(onItemToggleCheckedChange, "onItemToggleCheckedChange");
        kotlin.jvm.internal.t.i(onItemClicked, "onItemClicked");
        this.f23101i = vendorListData;
        this.f23102j = oTConfiguration;
        this.f23103k = z10;
        this.f23104l = onItemToggleCheckedChange;
        this.f23105m = onItemClicked;
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        kotlin.jvm.internal.t.i(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(recyclerView.getContext());
        kotlin.jvm.internal.t.h(layoutInflaterFrom, "from(recyclerView.context)");
        this.f23106n = layoutInflaterFrom;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        a holder = (a) viewHolder;
        kotlin.jvm.internal.t.i(holder, "holder");
        List<com.onetrust.otpublishers.headless.UI.DataModels.i> currentList = getCurrentList();
        kotlin.jvm.internal.t.h(currentList, "currentList");
        holder.b((com.onetrust.otpublishers.headless.UI.DataModels.i) kotlin.collections.d0.l0(currentList, i10), i10 == getItemCount() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.t.i(parent, "parent");
        LayoutInflater layoutInflater = this.f23106n;
        if (layoutInflater == null) {
            kotlin.jvm.internal.t.A("inflater");
            layoutInflater = null;
        }
        com.onetrust.otpublishers.headless.databinding.d dVarB = com.onetrust.otpublishers.headless.databinding.d.b(layoutInflater, parent);
        kotlin.jvm.internal.t.h(dVarB, "inflate(inflater, parent, false)");
        return new a(dVarB, this.f23101i, this.f23102j, this.f23103k, this.f23104l, this.f23105m);
    }
}
