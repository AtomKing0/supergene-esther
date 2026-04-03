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
import androidx.viewbinding.ViewBindings;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.UI.adapter.i0;
import com.onetrust.otpublishers.headless.UI.fragment.n2;
import com.onetrust.otpublishers.headless.UI.fragment.o2;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 extends ListAdapter<com.onetrust.otpublishers.headless.UI.DataModels.i, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.DataModels.l f22983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final OTConfiguration f22984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final h9.p<String, Boolean, v8.k0> f22985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final h9.l<String, v8.k0> f22986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LayoutInflater f22987m;

    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final com.onetrust.otpublishers.headless.databinding.g f22988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final com.onetrust.otpublishers.headless.UI.DataModels.l f22989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final OTConfiguration f22990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public final h9.p<String, Boolean, v8.k0> f22991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public final h9.l<String, v8.k0> f22992f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull com.onetrust.otpublishers.headless.databinding.g binding, @NotNull com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, @Nullable OTConfiguration oTConfiguration, @NotNull h9.p<? super String, ? super Boolean, v8.k0> onItemToggleCheckedChange, @NotNull h9.l<? super String, v8.k0> onItemClicked) {
            super(binding.a());
            kotlin.jvm.internal.t.i(binding, "binding");
            kotlin.jvm.internal.t.i(vendorListData, "vendorListData");
            kotlin.jvm.internal.t.i(onItemToggleCheckedChange, "onItemToggleCheckedChange");
            kotlin.jvm.internal.t.i(onItemClicked, "onItemClicked");
            this.f22988b = binding;
            this.f22989c = vendorListData;
            this.f22990d = oTConfiguration;
            this.f22991e = onItemToggleCheckedChange;
            this.f22992f = onItemClicked;
        }

        public static final void c(a this$0, com.onetrust.otpublishers.headless.UI.DataModels.i iVar, View view) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            this$0.f22992f.invoke(iVar.f22114a);
        }

        public static final void d(a this$0, com.onetrust.otpublishers.headless.UI.DataModels.i item, CompoundButton compoundButton, boolean z10) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(item, "$item");
            this$0.f22991e.mo4invoke(item.f22114a, Boolean.valueOf(z10));
            this$0.e(z10);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(final com.onetrust.otpublishers.headless.UI.DataModels.i r5) {
            /*
                r4 = this;
                com.onetrust.otpublishers.headless.databinding.g r0 = r4.f22988b
                androidx.appcompat.widget.SwitchCompat r0 = r0.f23766d
                r1 = 0
                r0.setOnCheckedChangeListener(r1)
                com.onetrust.otpublishers.headless.UI.DataModels.k r1 = r5.f22116c
                int r1 = r1.ordinal()
                r2 = 1
                if (r1 == 0) goto L2d
                if (r1 == r2) goto L25
                r3 = 2
                if (r1 == r3) goto L1a
                r3 = 3
                if (r1 == r3) goto L2d
                goto L33
            L1a:
                java.lang.String r1 = ""
                kotlin.jvm.internal.t.h(r0, r1)
                r1 = 8
                r0.setVisibility(r1)
                goto L33
            L25:
                r1 = 0
                r0.setChecked(r1)
                r4.e(r1)
                goto L33
            L2d:
                r0.setChecked(r2)
                r4.e(r2)
            L33:
                com.onetrust.otpublishers.headless.UI.adapter.h0 r1 = new com.onetrust.otpublishers.headless.UI.adapter.h0
                r1.<init>()
                r0.setOnCheckedChangeListener(r1)
                com.onetrust.otpublishers.headless.UI.DataModels.l r5 = r4.f22989c
                java.lang.String r5 = r5.f22138q
                r0.setContentDescription(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.adapter.i0.a.a(com.onetrust.otpublishers.headless.UI.DataModels.i):void");
        }

        public final void b(@Nullable final com.onetrust.otpublishers.headless.UI.DataModels.i iVar, boolean z10) {
            com.onetrust.otpublishers.headless.databinding.g gVar = this.f22988b;
            RelativeLayout vlItems = gVar.f23770h;
            kotlin.jvm.internal.t.h(vlItems, "vlItems");
            boolean z11 = !z10;
            vlItems.setVisibility(z11 ? 0 : 8);
            View view3 = gVar.f23768f;
            kotlin.jvm.internal.t.h(view3, "view3");
            view3.setVisibility(z11 ? 0 : 8);
            SwitchCompat switchButton = gVar.f23766d;
            kotlin.jvm.internal.t.h(switchButton, "switchButton");
            switchButton.setVisibility(z11 ? 0 : 8);
            SwitchCompat legitIntSwitchButton = gVar.f23764b;
            kotlin.jvm.internal.t.h(legitIntSwitchButton, "legitIntSwitchButton");
            legitIntSwitchButton.setVisibility(z11 ? 0 : 8);
            TextView viewPoweredByLogo = gVar.f23769g;
            kotlin.jvm.internal.t.h(viewPoweredByLogo, "viewPoweredByLogo");
            viewPoweredByLogo.setVisibility(z10 ? 0 : 8);
            if (z10 || iVar == null) {
                TextView textView = this.f22988b.f23769g;
                com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.f22989c.f22143v;
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
                com.onetrust.otpublishers.headless.UI.extensions.m.d(textView, lVar, this.f22990d);
                textView.setTextAlignment(com.onetrust.otpublishers.headless.Internal.Helper.k.e(textView.getContext()) ? 6 : 4);
                return;
            }
            gVar.f23767e.setText(iVar.f22115b);
            gVar.f23767e.setLabelFor(p6.d.f32680e5);
            SwitchCompat legitIntSwitchButton2 = gVar.f23764b;
            kotlin.jvm.internal.t.h(legitIntSwitchButton2, "legitIntSwitchButton");
            legitIntSwitchButton2.setVisibility(8);
            gVar.f23770h.setOnClickListener(null);
            gVar.f23770h.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.a.c(this.f22974a, iVar, view);
                }
            });
            com.onetrust.otpublishers.headless.databinding.g gVar2 = this.f22988b;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f22989c.f22132k;
            TextView vendorName = gVar2.f23767e;
            OTConfiguration oTConfiguration = this.f22990d;
            kotlin.jvm.internal.t.h(vendorName, "vendorName");
            com.onetrust.otpublishers.headless.UI.extensions.m.b(vendorName, cVar2, null, oTConfiguration, false, 2);
            ImageView showMore = gVar2.f23765c;
            kotlin.jvm.internal.t.h(showMore, "showMore");
            String str = this.f22989c.f22144w;
            kotlin.jvm.internal.t.i(showMore, "<this>");
            if (!(str == null || str.length() == 0)) {
                showMore.setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
            }
            View view32 = gVar2.f23768f;
            kotlin.jvm.internal.t.h(view32, "view3");
            com.onetrust.otpublishers.headless.UI.extensions.n.a(this.f22989c.f22126e, view32);
            a(iVar);
        }

        public final void e(boolean z10) {
            SwitchCompat switchCompat = this.f22988b.f23766d;
            String str = z10 ? this.f22989c.f22128g : this.f22989c.f22129h;
            kotlin.jvm.internal.t.h(switchCompat, "");
            com.onetrust.otpublishers.headless.UI.extensions.k.a(switchCompat, this.f22989c.f22127f, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(@NotNull com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, @Nullable OTConfiguration oTConfiguration, @NotNull n2 onItemToggleCheckedChange, @NotNull o2 onItemClicked) {
        super(new k0());
        kotlin.jvm.internal.t.i(vendorListData, "vendorListData");
        kotlin.jvm.internal.t.i(onItemToggleCheckedChange, "onItemToggleCheckedChange");
        kotlin.jvm.internal.t.i(onItemClicked, "onItemClicked");
        this.f22983i = vendorListData;
        this.f22984j = oTConfiguration;
        this.f22985k = onItemToggleCheckedChange;
        this.f22986l = onItemClicked;
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getCurrentList().size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        kotlin.jvm.internal.t.i(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(recyclerView.getContext());
        kotlin.jvm.internal.t.h(layoutInflaterFrom, "from(recyclerView.context)");
        this.f22987m = layoutInflaterFrom;
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
        View viewFindChildViewById;
        kotlin.jvm.internal.t.i(parent, "parent");
        LayoutInflater layoutInflater = this.f22987m;
        if (layoutInflater == null) {
            kotlin.jvm.internal.t.A("inflater");
            layoutInflater = null;
        }
        View viewInflate = layoutInflater.inflate(p6.e.Y, parent, false);
        int i11 = p6.d.f32838w2;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewInflate, i11);
        if (switchCompat != null) {
            i11 = p6.d.U4;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, i11);
            if (imageView != null) {
                i11 = p6.d.f32680e5;
                SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(viewInflate, i11);
                if (switchCompat2 != null) {
                    i11 = p6.d.W6;
                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i11);
                    if (textView != null) {
                        i11 = p6.d.f32691f7;
                        if (((TextView) ViewBindings.findChildViewById(viewInflate, i11)) != null && (viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, (i11 = p6.d.f32727j7))) != null) {
                            i11 = p6.d.f32808s7;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, i11);
                            if (textView2 != null) {
                                i11 = p6.d.f32817t7;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, i11);
                                if (relativeLayout != null) {
                                    com.onetrust.otpublishers.headless.databinding.g gVar = new com.onetrust.otpublishers.headless.databinding.g((RelativeLayout) viewInflate, switchCompat, imageView, switchCompat2, textView, viewFindChildViewById, textView2, relativeLayout);
                                    kotlin.jvm.internal.t.h(gVar, "inflate(inflater, parent, false)");
                                    return new a(gVar, this.f22983i, this.f22984j, this.f22985k, this.f22986l);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
    }
}
