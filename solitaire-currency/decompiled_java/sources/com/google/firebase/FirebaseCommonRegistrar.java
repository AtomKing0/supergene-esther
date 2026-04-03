package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import f6.e;
import f6.h;
import java.util.ArrayList;
import java.util.List;
import l5.c;
import u5.f;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? TtmlNode.TEXT_EMPHASIS_AUTO : (Build.VERSION.SDK_INT < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? i(installerPackageName) : "";
    }

    private static String i(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f6.c.b());
        arrayList.add(f.g());
        arrayList.add(h.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(h.b("fire-core", "20.4.3"));
        arrayList.add(h.b("device-name", i(Build.PRODUCT)));
        arrayList.add(h.b("device-model", i(Build.DEVICE)));
        arrayList.add(h.b("device-brand", i(Build.BRAND)));
        arrayList.add(h.c("android-target-sdk", new h.a() { // from class: i5.f
            @Override // f6.h.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.e((Context) obj);
            }
        }));
        arrayList.add(h.c("android-min-sdk", new h.a() { // from class: i5.g
            @Override // f6.h.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.f((Context) obj);
            }
        }));
        arrayList.add(h.c("android-platform", new h.a() { // from class: i5.h
            @Override // f6.h.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.g((Context) obj);
            }
        }));
        arrayList.add(h.c("android-installer", new h.a() { // from class: i5.i
            @Override // f6.h.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.h((Context) obj);
            }
        }));
        String strA = e.a();
        if (strA != null) {
            arrayList.add(h.b("kotlin", strA));
        }
        return arrayList;
    }
}
