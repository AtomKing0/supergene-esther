package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.UI.adapter.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class h1 extends com.google.android.material.bottomsheet.b implements View.OnClickListener, v.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f23308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f23309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f23310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.adapter.v f23312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f23313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f23314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RelativeLayout f23315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f23317k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f23318l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<String> f23319m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.z f23320n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f23321o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OTConfiguration f23322p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.mobiledatautils.c f23323q;

    public interface a {
        void a(@NonNull List<String> list, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(DialogInterface dialogInterface) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
        this.f23311e = aVar;
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c cVar = this.f23323q;
        Context context = this.f23314h;
        cVar.getClass();
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.a(context, aVar);
        this.f23311e.setCancelable(false);
        this.f23311e.setCanceledOnTouchOutside(false);
        this.f23311e.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.g1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return this.f23304a.w(dialogInterface2, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean w(android.content.DialogInterface r2, int r3, android.view.KeyEvent r4) {
        /*
            r1 = this;
            r2 = 4
            r0 = 0
            if (r3 != r2) goto Lc
            int r2 = r4.getAction()
            r3 = 1
            if (r2 != r3) goto Lc
            goto Ld
        Lc:
            r3 = r0
        Ld:
            if (r3 == 0) goto L16
            java.util.List<java.lang.String> r2 = r1.f23318l
            r1.f23319m = r2
            r1.dismiss()
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.h1.w(android.content.DialogInterface, int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == p6.d.f32765o0) {
            this.f23317k.a(this.f23312f.f23152k, this.f23312f.f23152k.isEmpty());
            dismiss();
        } else if (id == p6.d.P2) {
            this.f23319m = this.f23318l;
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c cVar = this.f23323q;
        Context context = this.f23314h;
        com.google.android.material.bottomsheet.a aVar = this.f23311e;
        cVar.getClass();
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.a(context, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f23316j == null) {
            dismiss();
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferencesA = com.onetrust.otpublishers.headless.UI.fragment.a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferencesA.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = com.onetrust.otpublishers.headless.UI.fragment.a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                    str = string2;
                }
                if (!str.equals(OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN)) {
                    return;
                }
            }
            OTLogger.a("OneTrust", 3, "set theme to OT defined theme ");
            setStyle(0, p6.g.f32918a);
        }
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.f1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23298a.v(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        Typeface otTypeFaceMap2;
        Context context = getContext();
        this.f23314h = context;
        this.f23323q = new com.onetrust.otpublishers.headless.UI.mobiledatautils.c();
        int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(context, this.f23322p);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.f fVar = new com.onetrust.otpublishers.headless.UI.mobiledatautils.f();
        fVar.c(iA, this.f23314h, this.f23316j);
        this.f23320n = fVar.f23648a;
        Context context2 = this.f23314h;
        int i10 = p6.e.f32872f;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context2)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context2, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.f("OTSDKListFragment", this.f23314h, viewInflate);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(p6.d.D1);
        this.f23309c = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f23309c.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f23308b = (TextView) viewInflate.findViewById(p6.d.P2);
        this.f23315i = (RelativeLayout) viewInflate.findViewById(p6.d.H1);
        this.f23310d = (Button) viewInflate.findViewById(p6.d.f32765o0);
        this.f23313g = (RelativeLayout) viewInflate.findViewById(p6.d.C1);
        this.f23321o = viewInflate.findViewById(p6.d.f32709h7);
        this.f23310d.setOnClickListener(this);
        this.f23308b.setOnClickListener(this);
        JSONArray jSONArrayA = com.onetrust.otpublishers.headless.Internal.Helper.k.a(fVar.f23649b);
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < jSONArrayA.length(); i11++) {
            try {
                com.onetrust.otpublishers.headless.UI.mobiledatautils.f.d(i11, jSONArrayA, jSONArray, new JSONObject());
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error on parsing Categories list. Error msg = "), "OTSDKListFilter", 6);
            }
        }
        com.onetrust.otpublishers.headless.UI.adapter.v vVar = new com.onetrust.otpublishers.headless.UI.adapter.v(jSONArray, this.f23319m, this.f23322p, fVar, this);
        this.f23312f = vVar;
        this.f23309c.setAdapter(vVar);
        com.onetrust.otpublishers.headless.UI.UIProperty.z zVar = this.f23320n;
        if (zVar != null) {
            String str = zVar.f22876a;
            this.f23313g.setBackgroundColor(Color.parseColor(str));
            this.f23315i.setBackgroundColor(Color.parseColor(str));
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f23320n.f22886k;
            TextView textView = this.f23308b;
            textView.setText(cVar.f22724e);
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
            OTConfiguration oTConfiguration = this.f23322p;
            String str2 = lVar.f22785d;
            if (com.onetrust.otpublishers.headless.Internal.c.q(str2) || oTConfiguration == null || (otTypeFaceMap2 = oTConfiguration.getOtTypeFaceMap(str2)) == null) {
                int iA2 = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, lVar.f22784c);
                textView.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA2) : Typeface.create(textView.getTypeface(), iA2));
            } else {
                textView.setTypeface(otTypeFaceMap2);
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
                textView.setTextSize(Float.parseFloat(lVar.f22783b));
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c)) {
                textView.setTextColor(Color.parseColor(cVar.f22722c));
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22721b);
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = this.f23320n.f22888m;
            Button button = this.f23310d;
            button.setText(fVar2.a());
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar2 = fVar2.f22758a;
            OTConfiguration oTConfiguration2 = this.f23322p;
            String str3 = lVar2.f22785d;
            if (com.onetrust.otpublishers.headless.Internal.c.q(str3) || oTConfiguration2 == null || (otTypeFaceMap = oTConfiguration2.getOtTypeFaceMap(str3)) == null) {
                int style = lVar2.f22784c;
                if (style == -1 && (typeface = button.getTypeface()) != null) {
                    style = typeface.getStyle();
                }
                button.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar2.f22782a) ? Typeface.create(lVar2.f22782a, style) : Typeface.create(button.getTypeface(), style));
            } else {
                button.setTypeface(otTypeFaceMap);
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar2.f22783b)) {
                button.setTextSize(Float.parseFloat(lVar2.f22783b));
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar2.c())) {
                button.setTextColor(Color.parseColor(fVar2.c()));
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.i(this.f23314h, button, fVar2, fVar2.f22759b, fVar2.f22761d);
            String str4 = this.f23320n.f22877b;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
                this.f23321o.setBackgroundColor(Color.parseColor(str4));
            }
        }
        return viewInflate;
    }
}
