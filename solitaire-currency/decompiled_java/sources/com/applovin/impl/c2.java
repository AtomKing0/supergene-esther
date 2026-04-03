package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f4934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Activity f4935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlertDialog f4936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f4937d;

    public interface a {
        void a();

        void b();
    }

    public c2(Activity activity, com.applovin.impl.sdk.j jVar) {
        this.f4934a = jVar;
        this.f4935b = activity;
    }

    public void e() {
        this.f4935b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.t8
            @Override // java.lang.Runnable
            public final void run() {
                this.f7471a.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i10) {
        this.f4937d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        AlertDialog alertDialog = this.f4936c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f4936c = new AlertDialog.Builder(this.f4935b).setTitle((CharSequence) this.f4934a.a(l4.Z0)).setMessage((CharSequence) this.f4934a.a(l4.f5593a1)).setCancelable(false).setPositiveButton((CharSequence) this.f4934a.a(l4.f5608c1), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.r8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f6774a.a(dialogInterface, i10);
            }
        }).setNegativeButton((CharSequence) this.f4934a.a(l4.f5600b1), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.s8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f6834a.b(dialogInterface, i10);
            }
        }).show();
    }

    public void a(a aVar) {
        this.f4937d = aVar;
    }

    public void a() {
        this.f4935b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.u8
            @Override // java.lang.Runnable
            public final void run() {
                this.f7537a.c();
            }
        });
    }

    public boolean b() {
        AlertDialog alertDialog = this.f4936c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i10) {
        this.f4937d.b();
    }
}
