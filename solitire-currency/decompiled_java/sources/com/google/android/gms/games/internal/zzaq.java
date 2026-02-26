package com.google.android.gms.games.internal;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.games_v2.zzez;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaq implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, zzd {
    private final zzak zza;
    private final com.google.android.gms.internal.games_v2.zzam zzb;

    @Nullable
    private WeakReference zzc;
    private boolean zzd = false;

    private zzaq(zzak zzakVar, int i10) {
        this.zza = zzakVar;
        this.zzb = new com.google.android.gms.internal.games_v2.zzam(i10, null);
    }

    public static zzaq zzd(zzak zzakVar, int i10) {
        return new zzaq(zzakVar, i10);
    }

    @TargetApi(17)
    private final void zzh(View view) {
        Display display;
        int displayId = -1;
        if (PlatformVersion.isAtLeastJellyBeanMR1() && (display = view.getDisplay()) != null) {
            displayId = display.getDisplayId();
        }
        IBinder windowToken = view.getWindowToken();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        com.google.android.gms.internal.games_v2.zzam zzamVar = this.zzb;
        zzamVar.zzc = displayId;
        zzamVar.zza = windowToken;
        int i10 = iArr[0];
        zzamVar.zzd = i10;
        int i11 = iArr[1];
        zzamVar.zze = i11;
        zzamVar.zzf = i10 + width;
        zzamVar.zzg = i11 + height;
        if (this.zzd) {
            zzg();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        zzh(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        zzh(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zza.zzs();
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // com.google.android.gms.games.internal.zzd
    public final void zza(Activity activity) {
        View decorView;
        try {
            decorView = activity.findViewById(R.id.content);
        } catch (IllegalStateException unused) {
            decorView = null;
        }
        if (decorView == null && (decorView = activity.getWindow().getDecorView()) == null) {
            zzez.zzg("PopupManager", "Failed to bind to: ".concat(String.valueOf(activity)));
        } else {
            zzez.zzf("PopupManager", "Binding to: ".concat(String.valueOf(activity)));
            zzf(decorView);
        }
    }

    public final Bundle zzb() {
        return this.zzb.zza();
    }

    @Nullable
    public final IBinder zzc() {
        return this.zzb.zza;
    }

    public final com.google.android.gms.internal.games_v2.zzam zze() {
        return this.zzb;
    }

    @TargetApi(16)
    public final void zzf(View view) {
        this.zza.zzs();
        WeakReference weakReference = this.zzc;
        if (weakReference != null) {
            View decorView = (View) weakReference.get();
            Context context = this.zza.getContext();
            if (decorView == null && (context instanceof Activity)) {
                decorView = ((Activity) context).getWindow().getDecorView();
            }
            if (decorView != null) {
                decorView.removeOnAttachStateChangeListener(this);
                ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
                if (PlatformVersion.isAtLeastJellyBean()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
        this.zzc = null;
        Context context2 = this.zza.getContext();
        if (view == null && (context2 instanceof Activity)) {
            Activity activity = (Activity) context2;
            try {
                view = activity.findViewById(R.id.content);
            } catch (IllegalStateException unused) {
            }
            if (view == null) {
                view = activity.getWindow().getDecorView();
            }
            zzez.zzg("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if (view == null) {
            zzez.zzc("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
            return;
        }
        zzh(view);
        this.zzc = new WeakReference(view);
        view.addOnAttachStateChangeListener(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final void zzg() {
        boolean z10;
        com.google.android.gms.internal.games_v2.zzam zzamVar = this.zzb;
        IBinder iBinder = zzamVar.zza;
        if (iBinder != null) {
            this.zza.zzQ(iBinder, zzamVar.zza());
            z10 = false;
        } else {
            z10 = true;
        }
        this.zzd = z10;
    }
}
