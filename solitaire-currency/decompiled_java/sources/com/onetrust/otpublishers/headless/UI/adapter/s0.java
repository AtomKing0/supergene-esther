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
import com.onetrust.otpublishers.headless.UI.adapter.s0;
import com.onetrust.otpublishers.headless.UI.fragment.p2;
import com.onetrust.otpublishers.headless.UI.fragment.q2;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class s0 extends ListAdapter<com.onetrust.otpublishers.headless.UI.DataModels.i, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.DataModels.l f23135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final OTConfiguration f23136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final h9.p<String, Boolean, v8.k0> f23137k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final h9.l<String, v8.k0> f23138l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LayoutInflater f23139m;

    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final com.onetrust.otpublishers.headless.databinding.d f23140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final com.onetrust.otpublishers.headless.UI.DataModels.l f23141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final OTConfiguration f23142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public final h9.p<String, Boolean, v8.k0> f23143e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public final h9.l<String, v8.k0> f23144f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull com.onetrust.otpublishers.headless.databinding.d binding, @NotNull com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, @Nullable OTConfiguration oTConfiguration, @NotNull h9.p<? super String, ? super Boolean, v8.k0> onItemToggleCheckedChange, @NotNull h9.l<? super String, v8.k0> onItemClicked) {
            super(binding.a());
            kotlin.jvm.internal.t.i(binding, "binding");
            kotlin.jvm.internal.t.i(vendorListData, "vendorListData");
            kotlin.jvm.internal.t.i(onItemToggleCheckedChange, "onItemToggleCheckedChange");
            kotlin.jvm.internal.t.i(onItemClicked, "onItemClicked");
            this.f23140b = binding;
            this.f23141c = vendorListData;
            this.f23142d = oTConfiguration;
            this.f23143e = onItemToggleCheckedChange;
            this.f23144f = onItemClicked;
        }

        public static final void c(a this$0, com.onetrust.otpublishers.headless.UI.DataModels.i iVar, View view) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            this$0.f23144f.invoke(iVar.f22114a);
        }

        public static final void d(a this$0, com.onetrust.otpublishers.headless.UI.DataModels.i item, CompoundButton compoundButton, boolean z10) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(item, "$item");
            this$0.f23143e.mo4invoke(item.f22114a, Boolean.valueOf(z10));
            SwitchCompat switchCompat = this$0.f23140b.f23740c;
            String str = z10 ? this$0.f23141c.f22128g : this$0.f23141c.f22129h;
            kotlin.jvm.internal.t.h(switchCompat, "");
            com.onetrust.otpublishers.headless.UI.extensions.k.a(switchCompat, this$0.f23141c.f22127f, str);
        }

        public final void a(final com.onetrust.otpublishers.headless.UI.DataModels.i iVar) {
            SwitchCompat switchCompat;
            String str;
            SwitchCompat switchCompat2 = this.f23140b.f23740c;
            switchCompat2.setOnCheckedChangeListener(null);
            int iOrdinal = iVar.f22116c.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    switchCompat2.setChecked(false);
                    switchCompat = this.f23140b.f23740c;
                    str = this.f23141c.f22129h;
                }
                switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.r0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                        s0.a.d(this.f23133a, iVar, compoundButton, z10);
                    }
                });
                switchCompat2.setContentDescription(this.f23141c.f22138q);
            }
            switchCompat2.setChecked(true);
            switchCompat = this.f23140b.f23740c;
            str = this.f23141c.f22128g;
            kotlin.jvm.internal.t.h(switchCompat, "");
            com.onetrust.otpublishers.headless.UI.extensions.k.a(switchCompat, this.f23141c.f22127f, str);
            switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.r0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    s0.a.d(this.f23133a, iVar, compoundButton, z10);
                }
            });
            switchCompat2.setContentDescription(this.f23141c.f22138q);
        }

        public final void b(@Nullable final com.onetrust.otpublishers.headless.UI.DataModels.i iVar, boolean z10) {
            com.onetrust.otpublishers.headless.databinding.d dVar = this.f23140b;
            RelativeLayout vlItems = dVar.f23744g;
            kotlin.jvm.internal.t.h(vlItems, "vlItems");
            boolean z11 = !z10;
            vlItems.setVisibility(z11 ? 0 : 8);
            View view3 = dVar.f23742e;
            kotlin.jvm.internal.t.h(view3, "view3");
            view3.setVisibility(z11 ? 0 : 8);
            SwitchCompat switchButton = dVar.f23740c;
            kotlin.jvm.internal.t.h(switchButton, "switchButton");
            switchButton.setVisibility(z11 ? 0 : 8);
            TextView viewPoweredByLogo = dVar.f23743f;
            kotlin.jvm.internal.t.h(viewPoweredByLogo, "viewPoweredByLogo");
            viewPoweredByLogo.setVisibility(z10 ? 0 : 8);
            if (z10 || iVar == null) {
                TextView textView = this.f23140b.f23743f;
                com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.f23141c.f22143v;
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
                com.onetrust.otpublishers.headless.UI.extensions.m.d(textView, lVar, this.f23142d);
                textView.setTextAlignment(com.onetrust.otpublishers.headless.Internal.Helper.k.e(textView.getContext()) ? 6 : 4);
                return;
            }
            ImageView gvShowMore = dVar.f23739b;
            kotlin.jvm.internal.t.h(gvShowMore, "gvShowMore");
            gvShowMore.setVisibility(0);
            dVar.f23741d.setText(iVar.f22115b);
            dVar.f23741d.setLabelFor(p6.d.f32680e5);
            dVar.f23744g.setOnClickListener(null);
            dVar.f23744g.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s0.a.c(this.f23115a, iVar, view);
                }
            });
            com.onetrust.otpublishers.headless.databinding.d dVar2 = this.f23140b;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23141c.f22132k;
            TextView vendorName = dVar2.f23741d;
            OTConfiguration oTConfiguration = this.f23142d;
            kotlin.jvm.internal.t.h(vendorName, "vendorName");
            com.onetrust.otpublishers.headless.UI.extensions.m.b(vendorName, cVar2, null, oTConfiguration, false, 2);
            ImageView gvShowMore2 = dVar2.f23739b;
            kotlin.jvm.internal.t.h(gvShowMore2, "gvShowMore");
            String str = this.f23141c.f22144w;
            kotlin.jvm.internal.t.i(gvShowMore2, "<this>");
            if (!(str == null || str.length() == 0)) {
                gvShowMore2.setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
            }
            View view32 = dVar2.f23742e;
            kotlin.jvm.internal.t.h(view32, "view3");
            com.onetrust.otpublishers.headless.UI.extensions.n.a(this.f23141c.f22126e, view32);
            a(iVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(@NotNull com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, @Nullable OTConfiguration oTConfiguration, @NotNull p2 onItemToggleCheckedChange, @NotNull q2 onItemClicked) {
        super(new k0());
        kotlin.jvm.internal.t.i(vendorListData, "vendorListData");
        kotlin.jvm.internal.t.i(onItemToggleCheckedChange, "onItemToggleCheckedChange");
        kotlin.jvm.internal.t.i(onItemClicked, "onItemClicked");
        this.f23135i = vendorListData;
        this.f23136j = oTConfiguration;
        this.f23137k = onItemToggleCheckedChange;
        this.f23138l = onItemClicked;
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
        this.f23139m = layoutInflaterFrom;
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
        LayoutInflater layoutInflater = this.f23139m;
        if (layoutInflater == null) {
            kotlin.jvm.internal.t.A("inflater");
            layoutInflater = null;
        }
        com.onetrust.otpublishers.headless.databinding.d dVarB = com.onetrust.otpublishers.headless.databinding.d.b(layoutInflater, parent);
        kotlin.jvm.internal.t.h(dVarB, "inflate(inflater, parent, false)");
        return new a(dVarB, this.f23135i, this.f23136j, this.f23137k, this.f23138l);
    }
}
