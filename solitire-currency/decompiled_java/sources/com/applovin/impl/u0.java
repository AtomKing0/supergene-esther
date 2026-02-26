package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.applovin.impl.p0;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.q0;
import com.applovin.impl.s0;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f7491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private q0 f7493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p0.c f7494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private q0 f7495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Dialog f7496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private p0.b f7497i = new p0.b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.applovin.impl.b f7498j = new a();

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if ((activity instanceof AppLovinWebViewActivity) || u0.this.f7495g == null) {
                return;
            }
            if (u0.this.f7496h != null) {
                u0 u0Var = u0.this;
                if (!com.applovin.impl.d.a(u0Var.a(u0Var.f7496h))) {
                    u0.this.f7496h.dismiss();
                }
                u0.this.f7496h = null;
            }
            q0 q0Var = u0.this.f7495g;
            u0.this.f7495g = null;
            u0 u0Var2 = u0.this;
            u0Var2.a(u0Var2.f7493e, q0Var, activity);
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s0 f7500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q0 f7501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f7502c;

        b(s0 s0Var, q0 q0Var, Activity activity) {
            this.f7500a = s0Var;
            this.f7501b = q0Var;
            this.f7502c = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            u0.this.f7495g = null;
            u0.this.f7496h = null;
            q0 q0VarA = u0.this.a(this.f7500a.a());
            if (q0VarA == null) {
                u0.this.a("Destination state for TOS/PP alert is null");
                return;
            }
            u0.this.a(this.f7501b, q0VarA, this.f7502c);
            if (q0VarA.c() != q0.b.ALERT) {
                dialogInterface.dismiss();
            }
        }
    }

    class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f7504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f7505b;

        c(Uri uri, Activity activity) {
            this.f7504a = uri;
            this.f7505b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            z6.a(this.f7504a, this.f7505b, u0.this.f7489a);
        }
    }

    class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f7507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f7508b;

        d(Uri uri, Activity activity) {
            this.f7507a = uri;
            this.f7508b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            z6.a(this.f7507a, this.f7508b, u0.this.f7489a);
        }
    }

    class e implements CmpServiceImpl.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q0 f7510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f7511b;

        e(q0 q0Var, Activity activity) {
            this.f7510a = q0Var;
            this.f7511b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            u0.this.f7497i.a(appLovinCmpError);
            u0.this.a(this.f7510a, this.f7511b, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    class f implements CmpServiceImpl.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q0 f7513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f7514b;

        f(q0 q0Var, Activity activity) {
            this.f7513a = q0Var;
            this.f7514b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            u0.this.f7497i.a(appLovinCmpError);
            u0.this.a(this.f7513a, this.f7514b, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    class g implements CmpServiceImpl.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q0 f7516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f7517b;

        g(q0 q0Var, Activity activity) {
            this.f7516a = q0Var;
            this.f7517b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.f
        public void a(AppLovinCmpError appLovinCmpError) {
            if (appLovinCmpError != null) {
                u0.this.f7497i.a(appLovinCmpError);
            } else {
                u0.this.f7497i.a(true);
            }
            u0.this.b(this.f7516a, this.f7517b);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q0 f7519a;

        h(q0 q0Var) {
            this.f7519a = q0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            u0 u0Var = u0.this;
            u0Var.a(u0Var.f7493e, this.f7519a, u0.this.f7489a.n0());
        }
    }

    public u0(com.applovin.impl.sdk.j jVar) {
        this.f7489a = jVar;
        this.f7490b = ((Integer) jVar.a(l4.f5645g6)).intValue();
    }

    private void c(final q0 q0Var, final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ce
            @Override // java.lang.Runnable
            public final void run() {
                this.f4977a.a(q0Var, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q0 q0Var, Activity activity) {
        a(q0Var, activity, (Boolean) null);
    }

    private void b() {
        this.f7491c = null;
        this.f7493e = null;
        this.f7489a.e().b(this.f7498j);
        p0.c cVar = this.f7494f;
        if (cVar != null) {
            cVar.a(this.f7497i);
            this.f7494f = null;
        }
        this.f7497i = new p0.b();
    }

    public void a(Activity activity, p0.c cVar) {
        a(q0.a.IS_AL_GDPR.b(), activity, cVar);
    }

    public void a(int i10, Activity activity, p0.c cVar) {
        if (this.f7491c != null) {
            this.f7489a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f7489a.I().a("ConsentFlowStateMachine", "Unable to start states: " + this.f7491c);
            }
            this.f7489a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f7489a.I().a("ConsentFlowStateMachine", "Consent flow already in progress for states: " + this.f7491c);
            }
            cVar.a(new p0.b(new o0(o0.f6447d, "Consent flow is already in progress.")));
            return;
        }
        List listA = v0.a(this.f7489a);
        this.f7491c = listA;
        this.f7492d = String.valueOf(listA);
        this.f7494f = cVar;
        q0 q0VarA = a(i10);
        this.f7489a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7489a.I().a("ConsentFlowStateMachine", "Starting consent flow with states: " + this.f7491c + "\nInitial state: " + q0VarA);
        }
        com.applovin.impl.sdk.j.a(activity).a(this.f7498j);
        a((q0) null, q0VarA, activity);
    }

    public boolean a() {
        return this.f7491c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q0 q0Var, Activity activity, Boolean bool) {
        a(q0Var, a(q0Var.a(bool)), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q0 q0Var, q0 q0Var2, Activity activity) {
        this.f7493e = q0Var;
        c(q0Var2, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(q0 q0Var, final Activity activity) {
        SpannableString spannableString;
        if (q0Var == null) {
            a("Consent flow state is null");
            return;
        }
        this.f7489a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7489a.I().a("ConsentFlowStateMachine", "Transitioning to state: " + q0Var);
        }
        if (q0Var.c() == q0.b.ALERT) {
            if (com.applovin.impl.d.a(activity)) {
                a(q0Var);
                return;
            }
            this.f7489a.B().trackEvent("cf_start");
            r0 r0Var = (r0) q0Var;
            this.f7495g = r0Var;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            for (s0 s0Var : r0Var.d()) {
                b bVar = new b(s0Var, q0Var, activity);
                if (s0Var.c() == s0.a.POSITIVE) {
                    builder.setPositiveButton(s0Var.d(), bVar);
                } else if (s0Var.c() == s0.a.NEGATIVE) {
                    builder.setNegativeButton(s0Var.d(), bVar);
                } else {
                    builder.setNeutralButton(s0Var.d(), bVar);
                }
            }
            String strF = r0Var.f();
            if (StringUtils.isValidString(strF)) {
                spannableString = new SpannableString(strF);
                String strA = com.applovin.impl.sdk.j.a(R.string.applovin_terms_of_service_text);
                String strA2 = com.applovin.impl.sdk.j.a(R.string.applovin_privacy_policy_text);
                if (StringUtils.containsAtLeastOneSubstring(strF, Arrays.asList(strA, strA2))) {
                    Uri uriH = this.f7489a.v().h();
                    if (uriH != null) {
                        StringUtils.addLinks(spannableString, Pattern.compile(strA), new c(uriH, activity), true);
                    }
                    StringUtils.addLinks(spannableString, Pattern.compile(strA2), new d(this.f7489a.v().f(), activity), true);
                }
            } else {
                spannableString = null;
            }
            final AlertDialog alertDialogCreate = builder.setTitle(spannableString).setMessage(r0Var.e()).create();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.applovin.impl.de
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.f5052a.a(alertDialogCreate, activity, dialogInterface);
                }
            });
            this.f7496h = alertDialogCreate;
            alertDialogCreate.show();
            this.f7497i.b(true);
            return;
        }
        if (q0Var.c() == q0.b.POST_ALERT) {
            if (this.f7489a.v().k() && this.f7489a.v().m()) {
                if (com.applovin.impl.d.a(activity)) {
                    a(q0Var);
                    return;
                } else {
                    this.f7489a.q().loadCmp(activity, new e(q0Var, activity));
                    return;
                }
            }
            a(q0Var, activity, Boolean.FALSE);
            return;
        }
        if (q0Var.c() == q0.b.EVENT) {
            t0 t0Var = (t0) q0Var;
            String strE = t0Var.e();
            Map<String, String> mapD = t0Var.d();
            if (mapD == null) {
                mapD = new HashMap<>(1);
            }
            mapD.put("flow_type", "unified");
            this.f7489a.B().trackEvent(strE, mapD);
            b(t0Var, activity);
            return;
        }
        if (q0Var.c() == q0.b.CMP_LOAD) {
            if (com.applovin.impl.d.a(activity)) {
                a(q0Var);
                return;
            } else if (this.f7489a.v().m()) {
                this.f7489a.q().preloadCmp(activity);
                a(q0Var, activity, Boolean.FALSE);
                return;
            } else {
                this.f7489a.q().loadCmp(activity, new f(q0Var, activity));
                return;
            }
        }
        if (q0Var.c() == q0.b.CMP_SHOW) {
            if (com.applovin.impl.d.a(activity)) {
                a(q0Var);
                return;
            }
            if (!this.f7489a.v().m()) {
                this.f7489a.B().trackEvent("cf_start");
            }
            this.f7489a.q().showCmp(activity, new g(q0Var, activity));
            return;
        }
        if (q0Var.c() == q0.b.DECISION) {
            q0.a aVarA = q0Var.a();
            if (aVarA == q0.a.IS_AL_GDPR) {
                a(q0Var, activity, Boolean.valueOf(this.f7489a.v().k()));
                return;
            }
            if (aVarA == q0.a.IS_ELIGIBLE_FOR_TERMS_AND_PRIVACY_POLICY_ALERT) {
                a(q0Var, activity, Boolean.valueOf((this.f7489a.s0() ^ true) || ((Boolean) this.f7489a.a(n4.f6393o, Boolean.FALSE)).booleanValue()));
                return;
            }
            if (aVarA == q0.a.HAS_TERMS_OF_SERVICE_URI) {
                a(q0Var, activity, Boolean.valueOf(this.f7489a.v().h() != null));
                return;
            }
            a("Invalid consent flow decision type: " + aVarA);
            return;
        }
        if (q0Var.c() == q0.b.REINIT) {
            b();
            return;
        }
        a("Invalid consent flow destination state: " + q0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, Activity activity, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null));
        textView.setLinkTextColor(textView.getCurrentTextColor());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMaxLines(this.f7490b);
        textView.setMinHeight(AppLovinSdkUtils.dpToPx(activity, 48));
    }

    private void a(q0 q0Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new h(q0Var), TimeUnit.SECONDS.toMillis(1L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        e1.a(str, new Object[0]);
        this.f7489a.A().a(y1.f7792l0, str, CollectionUtils.hashMap("details", "Last started states: " + this.f7492d + "\nLast successful state: " + this.f7493e));
        p0.b bVar = this.f7497i;
        if (bVar != null) {
            bVar.a(new o0(o0.f6448e, str));
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q0 a(int i10) {
        List<q0> list = this.f7491c;
        if (list == null) {
            return null;
        }
        for (q0 q0Var : list) {
            if (i10 == q0Var.b()) {
                return q0Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity a(Dialog dialog) {
        Context context = dialog.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        return null;
    }
}
