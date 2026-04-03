package com.onetrust.otpublishers.headless.UI.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.UI.adapter.r;
import com.onetrust.otpublishers.headless.UI.fragment.d1;
import com.onetrust.otpublishers.headless.UI.fragment.e1;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class r extends ListAdapter<com.onetrust.otpublishers.headless.UI.DataModels.f, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.DataModels.h f23117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final OTConfiguration f23118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f23119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f23120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final String f23121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public final h9.p<String, Boolean, v8.k0> f23122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final h9.l<String, Boolean> f23123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f23124p;

    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final com.onetrust.otpublishers.headless.databinding.e f23125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final com.onetrust.otpublishers.headless.UI.DataModels.h f23126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final OTConfiguration f23127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f23128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f23129f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final String f23130g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        public final h9.p<String, Boolean, v8.k0> f23131h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NotNull
        public final h9.l<String, Boolean> f23132i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull com.onetrust.otpublishers.headless.databinding.e binding, @NotNull com.onetrust.otpublishers.headless.UI.DataModels.h sdkListData, @Nullable OTConfiguration oTConfiguration, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull h9.p<? super String, ? super Boolean, v8.k0> onItemCheckedChange, @NotNull h9.l<? super String, Boolean> isAlwaysActiveGroup) {
            super(binding.a());
            kotlin.jvm.internal.t.i(binding, "binding");
            kotlin.jvm.internal.t.i(sdkListData, "sdkListData");
            kotlin.jvm.internal.t.i(onItemCheckedChange, "onItemCheckedChange");
            kotlin.jvm.internal.t.i(isAlwaysActiveGroup, "isAlwaysActiveGroup");
            this.f23125b = binding;
            this.f23126c = sdkListData;
            this.f23127d = oTConfiguration;
            this.f23128e = str;
            this.f23129f = str2;
            this.f23130g = str3;
            this.f23131h = onItemCheckedChange;
            this.f23132i = isAlwaysActiveGroup;
        }

        public static final void c(a this$0, com.onetrust.otpublishers.headless.UI.DataModels.f item, CompoundButton compoundButton, boolean z10) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(item, "$item");
            this$0.f23131h.mo4invoke(item.f22090a, Boolean.valueOf(z10));
            SwitchCompat switchCompat = this$0.f23125b.f23750f;
            String str = z10 ? this$0.f23126c.f22104g : this$0.f23126c.f22105h;
            kotlin.jvm.internal.t.h(switchCompat, "");
            com.onetrust.otpublishers.headless.UI.extensions.k.a(switchCompat, this$0.f23126c.f22106i, str);
        }

        public final void a(final com.onetrust.otpublishers.headless.UI.DataModels.f fVar) {
            com.onetrust.otpublishers.headless.databinding.e eVar = this.f23125b;
            eVar.f23750f.setOnCheckedChangeListener(null);
            eVar.f23750f.setContentDescription(this.f23126c.f22107j);
            eVar.f23750f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.q
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    r.a.c(this.f23113a, fVar, compoundButton, z10);
                }
            });
        }

        public final void b(@Nullable com.onetrust.otpublishers.headless.UI.DataModels.f fVar, boolean z10) {
            boolean z11;
            boolean z12;
            com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
            SwitchCompat switchButton;
            String str;
            String str2;
            com.onetrust.otpublishers.headless.databinding.e eVar = this.f23125b;
            RelativeLayout itemLayout = eVar.f23747c;
            kotlin.jvm.internal.t.h(itemLayout, "itemLayout");
            boolean z13 = !z10;
            itemLayout.setVisibility(z13 ? 0 : 8);
            TextView viewPoweredByLogo = eVar.f23752h;
            kotlin.jvm.internal.t.h(viewPoweredByLogo, "viewPoweredByLogo");
            viewPoweredByLogo.setVisibility(z10 ? 0 : 8);
            String str3 = "";
            if (z10 || fVar == null) {
                SwitchCompat switchButton2 = eVar.f23750f;
                kotlin.jvm.internal.t.h(switchButton2, "switchButton");
                switchButton2.setVisibility(z13 ? 0 : 8);
                View view3 = eVar.f23751g;
                kotlin.jvm.internal.t.h(view3, "view3");
                view3.setVisibility(z13 ? 0 : 8);
                TextView textView = this.f23125b.f23752h;
                com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.f23126c.f22113p;
                if (xVar == null || !xVar.f22857i) {
                    kotlin.jvm.internal.t.h(textView, "");
                    textView.setVisibility(8);
                    return;
                }
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = xVar.f22860l;
                kotlin.jvm.internal.t.h(cVar, "sdkListData.otPCUIProper…leDescriptionTextProperty");
                textView.setTextColor(Color.parseColor(cVar.f22722c));
                kotlin.jvm.internal.t.h(textView, "");
                com.onetrust.otpublishers.headless.UI.extensions.m.h(textView, cVar.f22720a.f22783b);
                com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
                kotlin.jvm.internal.t.h(lVar, "descriptionTextProperty.fontProperty");
                com.onetrust.otpublishers.headless.UI.extensions.m.d(textView, lVar, this.f23127d);
                textView.setTextAlignment(com.onetrust.otpublishers.headless.Internal.Helper.k.e(textView.getContext()) ? 6 : 4);
                return;
            }
            TextView textView2 = this.f23125b.f23749e;
            textView2.setText(fVar.f22091b);
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23126c.f22108k;
            OTConfiguration oTConfiguration = this.f23127d;
            kotlin.jvm.internal.t.h(textView2, "");
            com.onetrust.otpublishers.headless.UI.extensions.m.b(textView2, cVar2, null, oTConfiguration, false, 2);
            TextView textView3 = this.f23125b.f23748d;
            kotlin.jvm.internal.t.h(textView3, "");
            String str4 = fVar.f22092c;
            if ((str4 == null || str4.length() == 0) || !this.f23126c.f22098a || kotlin.jvm.internal.t.d("null", fVar.f22092c)) {
                z11 = false;
            } else {
                com.onetrust.otpublishers.headless.UI.extensions.m.f(textView3, fVar.f22092c);
                z11 = true;
            }
            textView3.setVisibility(z11 ? 0 : 8);
            com.onetrust.otpublishers.headless.UI.extensions.m.b(textView3, this.f23126c.f22109l, null, this.f23127d, false, 2);
            a(fVar);
            eVar.f23749e.setLabelFor(p6.d.f32680e5);
            View view32 = eVar.f23751g;
            kotlin.jvm.internal.t.h(view32, "view3");
            com.onetrust.otpublishers.headless.UI.extensions.n.a(this.f23126c.f22103f, view32);
            SwitchCompat switchButton3 = eVar.f23750f;
            kotlin.jvm.internal.t.h(switchButton3, "switchButton");
            switchButton3.setVisibility(0);
            if (!Boolean.parseBoolean(this.f23128e)) {
                SwitchCompat switchButton4 = eVar.f23750f;
                kotlin.jvm.internal.t.h(switchButton4, "switchButton");
                switchButton4.setVisibility(8);
                TextView alwaysActiveTextSdk = eVar.f23746b;
                kotlin.jvm.internal.t.h(alwaysActiveTextSdk, "alwaysActiveTextSdk");
                alwaysActiveTextSdk.setVisibility(8);
                return;
            }
            com.onetrust.otpublishers.headless.databinding.e eVar2 = this.f23125b;
            Context context = eVar2.f23745a.getContext();
            new JSONObject();
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            String str5 = null;
            if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context)) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z12 = true;
            } else {
                z12 = false;
                hVar = null;
            }
            if (z12) {
                sharedPreferences = hVar;
            }
            new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
            String str6 = fVar.f22090a;
            String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
            if (string.isEmpty()) {
                OTLogger.a("SdkListHelper", 3, "Empty sdkMap found");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (jSONObject.get(next).toString().contains(str6)) {
                            str3 = next;
                        }
                    }
                } catch (JSONException e10) {
                    com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while fetching groupId by sdkId : "), "SdkListHelper", 6);
                }
                str5 = str3;
            }
            if (str5 == null) {
                return;
            }
            kotlin.jvm.internal.t.h(str5, "SdkListHelper(root.conte…d(item.id) ?: return@with");
            if (this.f23132i.invoke(str5).booleanValue()) {
                SwitchCompat switchButton5 = eVar2.f23750f;
                kotlin.jvm.internal.t.h(switchButton5, "switchButton");
                switchButton5.setVisibility(8);
                TextView alwaysActiveTextSdk2 = eVar2.f23746b;
                kotlin.jvm.internal.t.h(alwaysActiveTextSdk2, "alwaysActiveTextSdk");
                alwaysActiveTextSdk2.setVisibility(0);
                eVar2.f23746b.setText(this.f23129f);
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = this.f23126c.f22108k;
                TextView alwaysActiveTextSdk3 = eVar2.f23746b;
                OTConfiguration oTConfiguration2 = this.f23127d;
                kotlin.jvm.internal.t.h(alwaysActiveTextSdk3, "alwaysActiveTextSdk");
                com.onetrust.otpublishers.headless.UI.extensions.m.b(alwaysActiveTextSdk3, cVar3, null, oTConfiguration2, false, 2);
                String str7 = this.f23130g;
                if (((str7 == null || str7.length() == 0) ? 1 : 0) == 0) {
                    eVar2.f23746b.setTextColor(Color.parseColor(this.f23130g));
                    return;
                }
                return;
            }
            TextView alwaysActiveTextSdk4 = eVar2.f23746b;
            kotlin.jvm.internal.t.h(alwaysActiveTextSdk4, "alwaysActiveTextSdk");
            alwaysActiveTextSdk4.setVisibility(8);
            int iOrdinal = fVar.f22093d.ordinal();
            if (iOrdinal == 0) {
                eVar2.f23750f.setChecked(true);
                switchButton = eVar2.f23750f;
                kotlin.jvm.internal.t.h(switchButton, "switchButton");
                com.onetrust.otpublishers.headless.UI.DataModels.h hVar2 = this.f23126c;
                str = hVar2.f22106i;
                str2 = hVar2.f22104g;
            } else {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        return;
                    }
                    SwitchCompat switchButton6 = eVar2.f23750f;
                    kotlin.jvm.internal.t.h(switchButton6, "switchButton");
                    switchButton6.setVisibility(8);
                    return;
                }
                eVar2.f23750f.setChecked(false);
                switchButton = eVar2.f23750f;
                kotlin.jvm.internal.t.h(switchButton, "switchButton");
                com.onetrust.otpublishers.headless.UI.DataModels.h hVar3 = this.f23126c;
                str = hVar3.f22106i;
                str2 = hVar3.f22105h;
            }
            com.onetrust.otpublishers.headless.UI.extensions.k.a(switchButton, str, str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull com.onetrust.otpublishers.headless.UI.DataModels.h sdkListData, @Nullable OTConfiguration oTConfiguration, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull d1 onItemCheckedChange, @NotNull e1 isAlwaysActiveGroup) {
        super(new s());
        kotlin.jvm.internal.t.i(sdkListData, "sdkListData");
        kotlin.jvm.internal.t.i(onItemCheckedChange, "onItemCheckedChange");
        kotlin.jvm.internal.t.i(isAlwaysActiveGroup, "isAlwaysActiveGroup");
        this.f23117i = sdkListData;
        this.f23118j = oTConfiguration;
        this.f23119k = str;
        this.f23120l = str2;
        this.f23121m = str3;
        this.f23122n = onItemCheckedChange;
        this.f23123o = isAlwaysActiveGroup;
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
        this.f23124p = layoutInflaterFrom;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        a holder = (a) viewHolder;
        kotlin.jvm.internal.t.i(holder, "holder");
        List<com.onetrust.otpublishers.headless.UI.DataModels.f> currentList = getCurrentList();
        kotlin.jvm.internal.t.h(currentList, "currentList");
        holder.b((com.onetrust.otpublishers.headless.UI.DataModels.f) kotlin.collections.d0.l0(currentList, i10), i10 == getItemCount() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i10) {
        View viewFindChildViewById;
        kotlin.jvm.internal.t.i(parent, "parent");
        LayoutInflater layoutInflater = this.f23124p;
        if (layoutInflater == null) {
            kotlin.jvm.internal.t.A("inflater");
            layoutInflater = null;
        }
        View viewInflate = layoutInflater.inflate(p6.e.D, parent, false);
        int i11 = p6.d.J;
        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i11);
        if (textView != null) {
            i11 = p6.d.f32794r2;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, i11);
            if (relativeLayout != null) {
                i11 = p6.d.f32750m3;
                if (((FrameLayout) ViewBindings.findChildViewById(viewInflate, i11)) != null) {
                    i11 = p6.d.f32864z4;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, i11);
                    if (textView2 != null) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate;
                        i11 = p6.d.I4;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, i11);
                        if (textView3 != null) {
                            i11 = p6.d.f32680e5;
                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewInflate, i11);
                            if (switchCompat != null && (viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, (i11 = p6.d.f32727j7))) != null) {
                                i11 = p6.d.f32808s7;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, i11);
                                if (textView4 != null) {
                                    com.onetrust.otpublishers.headless.databinding.e eVar = new com.onetrust.otpublishers.headless.databinding.e(relativeLayout2, textView, relativeLayout, textView2, textView3, switchCompat, viewFindChildViewById, textView4);
                                    kotlin.jvm.internal.t.h(eVar, "inflate(inflater, parent, false)");
                                    return new a(eVar, this.f23117i, this.f23118j, this.f23119k, this.f23120l, this.f23121m, this.f23122n, this.f23123o);
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
