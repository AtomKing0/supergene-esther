package com.king.amp.sa;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.king.amp.sa.r;
import com.king.usdk.localnotification.NotificationSchedulerKeys;

/* JADX INFO: compiled from: InteractiveAd.java */
/* JADX INFO: loaded from: classes4.dex */
public class i1 implements r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f16780a = "AbmInteractiveAds";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static i1 f16781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f16782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static InteractiveAdActivity f16783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private static AbmMediaPlayer f16784e;

    public static synchronized i1 e() {
        if (f16781b == null) {
            f16781b = new i1();
        }
        return f16781b;
    }

    public static void o(Context context) {
        f16782c = context;
    }

    @Override // com.king.amp.sa.r.a
    public void a(String str) {
        Log.d(f16780a, "Javascript onCtaClick called with URL: " + str);
        g(str);
    }

    public void b(@NonNull String str) {
        InteractiveAdActivity interactiveAdActivity;
        if (f16781b == null || (interactiveAdActivity = f16783d) == null) {
            return;
        }
        interactiveAdActivity.L(str);
    }

    @Override // com.king.amp.sa.r.a
    public void c(String str) {
        Log.d(f16780a, "Javascript onOpen called with URL: " + str);
        g(str);
    }

    @Override // com.king.amp.sa.r.a
    public void d(String str) {
        Log.d(f16780a, "Javascript onEngagementEvent called with: " + str);
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        adProviderNameValuePairs.add(NotificationCompat.CATEGORY_EVENT, str);
        k(AbmAdPlayer.USER_ACTION_ENGAGEMENT, s1.d(adProviderNameValuePairs));
    }

    @Override // com.king.amp.sa.r.a
    public void f(String str) {
        Log.d(f16780a, "Javascript onCriticalError called with: " + str);
        i(6, str);
        InteractiveAdActivity interactiveAdActivity = f16783d;
        if (interactiveAdActivity != null) {
            interactiveAdActivity.finish();
        }
    }

    public void g(String str) {
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        adProviderNameValuePairs.add("url", str);
        k("open_url", s1.d(adProviderNameValuePairs));
    }

    public void h(int i10, @NonNull String str) {
        AbmMediaPlayer abmMediaPlayer = f16784e;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.onPlayerDismissed(i10, str);
        }
    }

    public void i(int i10, String str) {
        AbmMediaPlayer abmMediaPlayer = f16784e;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.onPlayerDismissed(i10, str);
        }
    }

    public void j() {
        AbmMediaPlayer abmMediaPlayer = f16784e;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.onPlayerAppeared();
        }
    }

    public void k(@NonNull String str, s1<AdProviderNameValuePairs> s1Var) {
        AbmMediaPlayer abmMediaPlayer = f16784e;
        if (abmMediaPlayer == null) {
            return;
        }
        abmMediaPlayer.onPlayerEvent(str, s1Var);
    }

    public void l(int i10, float f10) {
        AbmMediaPlayer abmMediaPlayer = f16784e;
        if (abmMediaPlayer == null) {
            return;
        }
        abmMediaPlayer.onPlayerProgressV1(i10, f10);
    }

    @Override // com.king.amp.sa.r.a
    public void m() {
        Log.d(f16780a, "Javascript onReward called");
        k(AbmAdPlayer.USER_ACTION_REWARD, s1.a());
        InteractiveAdActivity interactiveAdActivity = f16783d;
        if (interactiveAdActivity != null) {
            interactiveAdActivity.K();
        }
    }

    public void n(InteractiveAdActivity interactiveAdActivity) {
        f16783d = interactiveAdActivity;
    }

    @Override // com.king.amp.sa.r.a
    public void onClose() {
        Log.d(f16780a, "Javascript onClose called");
        k("close", s1.a());
    }

    public void p(@NonNull String str, @NonNull long j10, @NonNull String str2) {
        if (f16784e == null) {
            f16784e = AbmMediaPlayer.getInstance();
        }
        if (f16782c == null) {
            Log.e(f16780a, "context is null");
            return;
        }
        if (str.isEmpty() || str2.isEmpty()) {
            i(2, "Invalid mediaPath and layoutConfig");
            return;
        }
        Intent intent = new Intent(f16782c, (Class<?>) InteractiveAdActivity.class);
        intent.putExtra(NotificationSchedulerKeys.KEY_MEDIA_PATH, str);
        intent.putExtra("layout_configuration", str2);
        if (j10 == 0) {
            j10 = 30;
        }
        intent.putExtra("duration_sec", j10);
        intent.setFlags(268435456);
        f16782c.startActivity(intent);
    }
}
