package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.applovin.impl.sdk.ad.b;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f4692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f4695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f4696e;

    public a4(Activity activity) {
        this.f4692a = activity;
        int iC = z6.c(activity);
        this.f4694c = iC;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(activity);
        this.f4695d = zIsTablet;
        this.f4693b = a(iC, zIsTablet);
        this.f4696e = zIsTablet && 2 == a(activity);
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        int i10;
        if (!bVar.C0() || (i10 = this.f4693b) == -1) {
            a(bVar.a0());
        } else {
            a(i10);
        }
    }

    private int a(int i10, boolean z10) {
        if (z10 && this.f4696e) {
            if (i10 == 0) {
                return 0;
            }
            if (i10 == 1) {
                return 9;
            }
            if (i10 == 2) {
                return 8;
            }
            return i10 == 3 ? 1 : -1;
        }
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 9;
        }
        return i10 == 3 ? 8 : -1;
    }

    private void a(b.c cVar) {
        if (cVar == b.c.ACTIVITY_PORTRAIT) {
            if (this.f4695d && this.f4696e) {
                int i10 = this.f4694c;
                if (i10 != 1 && i10 != 3) {
                    a(1);
                    return;
                } else if (i10 == 1) {
                    a(9);
                    return;
                } else {
                    a(1);
                    return;
                }
            }
            int i11 = this.f4694c;
            if (i11 != 0 && i11 != 2) {
                a(1);
                return;
            } else {
                a(i11 != 0 ? 9 : 1);
                return;
            }
        }
        if (cVar == b.c.ACTIVITY_LANDSCAPE) {
            if (this.f4695d && this.f4696e) {
                int i12 = this.f4694c;
                if (i12 != 0 && i12 != 2) {
                    a(0);
                    return;
                } else {
                    a(i12 != 2 ? 0 : 8);
                    return;
                }
            }
            int i13 = this.f4694c;
            if (i13 != 1 && i13 != 3) {
                a(0);
            } else {
                a(i13 == 1 ? 0 : 8);
            }
        }
    }

    private static int a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    private void a(int i10) {
        try {
            this.f4692a.setRequestedOrientation(i10);
        } catch (Throwable unused) {
        }
    }
}
